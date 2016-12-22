package com.mbgo.search.core.tools.spell;

import java.util.ArrayList;
import java.util.List;

import com.mbgo.search.autokey.py.AnalyzerYunmu;
import com.mbgo.search.autokey.py.Pinyin;
import com.mbgo.search.autokey.py.Py;

/** 
 * @author 吴健  (HQ01U8435)	Email : wujian@metersbonwe.com 
 * @version 创建时间：2012-11-29 上午11:23:09 
 */
public class SpellCheckerUtil {
	private final static AnalyzerYunmu yunmu = new AnalyzerYunmu();

	/**
	 * 拆解汉子，获得建立n-gram算法所需的关键字片段
	 * @param word 关键字
	 * @input 美特斯邦威
	 * @return 
	 * [gram2:美特, start2:美特, gram2:特斯, gram2:斯邦, gram2:邦威, end2:邦威, gram3:美特斯, start3:美特斯, gram3:特斯邦, gram3:斯邦威, end3:斯邦威]
	 */
	public static List<CheckerBean> getNGrams(String word) {
		int len = 0;
		List<CheckerBean> rs = new ArrayList<CheckerBean>(0);
		
		word = word.replaceAll("\\s+", "");
		len = word.length();
		
		int ng1 = getMin(len);
		int ng2 = getMax(len);
		
		for (int ng = ng1; ng <= ng2; ng++) {
			String key = "gram" + ng;
			String end = null;
			
			for (int i = 0; i < len - ng + 1; i++) {
				String gram = word.substring(i, i + ng);
				rs.add(new CheckerBean(key, gram));
				if (i == 0) {
					rs.add(new CheckerBean("start" + ng, gram));
				}
				end = gram;
			}
			if (end != null) {
	        	rs.add(new CheckerBean("end" + ng, end));
	      	}
	    }
		return rs;
	}
	
	/**
	 * 拆解汉字对应的拼音
	 * @param word 关键字
	 * @input 美特斯邦威
	 * @return [start_:m, start_m:ei, key_0:m, key_m_0:ei, key_1:t, key_t_1:e, key_2:s, key_s_2:i, key_3:b, key_b_3:ang, key_4:w, key_w_4:ei, end_:w, end_w:ei]
	 */
	public static List<CheckerBean> getPinyins(String word) {
		List<CheckerBean> rs = new ArrayList<CheckerBean>(0);
		
		word = word.replaceAll("\\s+", " ");
		word = Pinyin.getPinyin(word, "", true);
		
		List<Py> pys = yunmu.process(word);
		
		int len = pys.size();
		Py py = null;
		String key= "";
		String value = "";
		
		for(int i = 0; i < len; i ++) {
			py = pys.get(i);
			key = py.getShmu();	//声母
			value = py.getYumu();	//韵母
			
			if(value.length() < 1) {
				value = "_";
			}
			
			if(key.length() < 1) {
				key = i + "";
			}
			
			//start
			if(i == 0) {
				rs.add(new CheckerBean("start_", key, true));
				rs.add(new CheckerBean("start_" + key, value));
			}

			rs.add(new CheckerBean("key_" + i, key, true));
			rs.add(new CheckerBean("key_" + key + "_" + i, value));
			
		}
		if(py != null) {
			rs.add(new CheckerBean("end_", key, true));
			rs.add(new CheckerBean("end_" + key, value));
		}
		return rs;
	}

	public static int getMin(int l) {
		if (l > 5) {
			return 3;
		}
		if (l == 5) {
			return 2;
		}
		return 1;
	}
	public static int getMax(int l) {
		if (l > 5) {
			return 4;
		}
		if (l == 5) {
			return 3;
		}
		return 2;
	}
	
	/**
	 * 汉字的拼音长度
	 * @param w
	 * @return
	 */
	public static int getWordPinyinLen(String w) {
		
		return yunmu.process(Pinyin.getPinyin(w)).size();
	}
	
	public static void main(String[] args) {
		System.out.println(getPinyins("mtsbw"));
		System.out.println(getPinyins("美特斯邦威"));
		System.out.println(getNGrams("美特斯邦威"));
		System.out.println("mc包".length());
	}
}
