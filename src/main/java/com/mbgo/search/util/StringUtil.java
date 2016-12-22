/*
* 2014-9-10 下午2:34:59
* 吴健 HQ01U8435
*/

package com.mbgo.search.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public class StringUtil {
	private final static Pattern NUMBER_LETTERS = Pattern.compile("[\\d|\\w]+");
	private static final Pattern GOODS_SN_PATTERN = Pattern.compile("(\\d{6})", 0);
	public static final String DEFAULT_STATIC_KEYWORD = "banggo";

	/**
	 * 判断字符串是否是数字或者字母
	 * @param s
	 * @return
	 */
	public static boolean isNumberOrLetters(String s) {
		if(StringUtils.isBlank(s)) {
			return false;
		}
		return NUMBER_LETTERS.matcher(s.replaceAll("\\s", "")).matches();
	}
	
	/**
	 * 计算商品的折扣信息
	 * @param salePrice
	 * @param marketPrice
	 * @return
	 */
	public static double calculateDiscount(double salePrice, double marketPrice) {
		if(salePrice * marketPrice <= 0) {
			return 0;
		}
		double rs = salePrice / marketPrice * 10;
		int zhengshu = (int)rs;
		double xiaoshu = rs - zhengshu;
		if(xiaoshu <= 0) {
			return (double)zhengshu;
		} else if(xiaoshu <= 0.5) {
			return (double) zhengshu + 0.5f;
		} else {
			return zhengshu + 1.0f;
		}
	}
	private static final String[] DISCOUNT_STRING = new String[]{
		" ", " 一折 1折 壹折 ", " 二折 两折 2折 贰折 ", " 三折 仨折 3折 叁折 ", 
		" 四折 肆折 4折 ", " 五折 5折 伍折 半折 对折 ", " 六折 6折 陆折 ", " 7折 七折 柒折 ", 
		" 八折 8折 捌折 ", " 九折 9折 玖折 " 
	};
	public static String getDiscountName(double dis) {
		int index = (int)Math.ceil(dis);
		if(index >= 0 && index <= 9) {
			return DISCOUNT_STRING[index]+" 折扣 打折 折价 ";
		}
		return " ";
	}
	
	/**
	 * 半角长度
	 * @param word
	 * @return
	 */
	public static int lengthDBC(String word) {
		if(StringUtils.isBlank(word)) {
			return 0;
		}
		try {
			return word.getBytes("GB2312").length;
		} catch (Exception e) {
			return 0;
		}
	}
	
	private static Pattern pattern1 = Pattern.compile("[\\d|\\w]+");
	public static boolean isNumberAndLetter(String s) {
		return pattern1.matcher(s.replaceAll("\\s", "")).matches();
	}
	
	/**
	 * 字符串是否重复 ，按空格分词
	 * @param vals 
	 * @return
	 */
	private static boolean isRepeatSpliteBySpace(String[] vals) {
		Set<String> set = new HashSet<String>(vals.length);
		
		for(String v : vals) {
			if(v.trim().length() > 0) {
				if(!set.contains(v)) {
					set.add(v);
				} else {
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * 字符串是否单字重复
	 * @param s
	 * @return
	 */
	private static boolean isRepeatSingleWord(String s) {
		Set<Character> set = new HashSet<Character>(s.length());
		int repeatCount = 0;
		for(int i = 0, len = s.length(); i < len; i ++) {
			char ch = s.charAt(i);
			if(!set.contains(ch)) {
				set.add(ch);
			} else {
				repeatCount ++;
			}
		}
		
		return (float)repeatCount / (float)s.length() >= 0.2;
	}
	

	/**
	 * 对关键字进行简单的去重复
	 * “女 女装 衬衫” ---> “女装 衬衫”
	 * @param w
	 * @return
	 */
	public static String replaceSameWord(String w) {
		if(StringUtils.isBlank(w)) {
			return "";
		}
		try {
			String[] ws = w.split(" ");
			List<String> rs = Arrays.asList(ws);
			Collections.sort(rs, new Comparator<String>(){
				public int compare(String o1, String o2) {
					return o2.length() - o1.length();
				}
				
			});
			StringBuilder sb = new StringBuilder("");
			for(String s : rs) {
				if(s != null && !s.isEmpty() && sb.indexOf(s) < 0) {
					sb.append(s + " ");
				}
			}
			return sb.toString().trim();
		} catch (Exception e) {
			return w;
		}
	}
	
	/**
	 * 关键字是否有一定的重复性
	 * @param l
	 * @return
	 */
	public static boolean isRepeatMany(String l) {
		if(l == null) {
			return false;
		}
		String[] vals = l.split(" ");
		boolean rs = isRepeatSpliteBySpace(vals);
		if(rs) {
			return rs;
		}
		
		return isRepeatSingleWord(l);
	}
	
	/**
	 * 全角转半角
	 * @param input
	 * @return
	 */
	public static String toDBC(String input) {
		char[] c = input.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 12288) {
				c[i] = (char) 32;
				continue;
			}
			if (c[i] > 65280 && c[i] < 65375)
				c[i] = (char) (c[i] - 65248);
		}
		return new String(c);
	}
	
	public static List<String> pickString(String input) {
		List<String> rs = new ArrayList<String>(0);
		try {
			
			Matcher m = GOODS_SN_PATTERN.matcher(input);

			while(m.find()) {
				rs.add(m.group(1));
			}
			return rs;
		} catch (Exception e) {
			return rs;
		}
	}

//	patternSort.put(Pattern.compile("^(\\d{1,})\\/(\\d{1,})[a-zA-Z]+$", 0), 2);//150/76A
//	patternSort.put(Pattern.compile("(\\d{1,})\\/(\\d+)[-|或|和]", 0), 2);//上装90/52-下装90/50
//	patternSort.put(Pattern.compile("(\\d{1,})mm", 0), 1);//255mm
//	patternSort.put(Pattern.compile("(\\d{1,})cm", 0), 1);//90cm
//	patternSort.put(Pattern.compile("[a-z](\\d{1,})", 0), 1);//A75
//	patternSort.put(Pattern.compile("^(\\d{1,})$", 0), 1);//225
	public static void main(String[] args) {
		String t = "150/76A";
		try {
			
			Matcher m = Pattern.compile("^(\\d{1,})\\/(\\d{1,})[a-zA-Z]*$", 0).matcher(t);

			while(m.find()) {
				System.out.println(m.group(1));
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("11", "1");
		map.put("22", "1");
		map.put("33", "1");
		map.put("44", "1");
		map.put("55", "1");
		for(Map.Entry<String, String> en : map.entrySet()) {
			System.out.println(en.getKey());
		}
	}
}
