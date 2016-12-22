package com.mbgo.search.autokey.py;

import java.util.List;

public class PinyinSplitTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String word = "nanzhuangchshandanaotiangong";
		String word = "danaotiangong牛仔裤";
		AnalyzerYunmu yunmu = new AnalyzerYunmu();
		long b = System.currentTimeMillis();
		word = Pinyin.getPinyin(word);
		List<Py> pys = yunmu.process(word);
		String s = "";
		for(Py py : pys) {
			System.out.println(py);
			s += py.getShmu() + py.getYumu() + "*";
		}
		System.out.println("analyze cost : "+(System.currentTimeMillis() - b));
		System.out.println(s);
	}

}
