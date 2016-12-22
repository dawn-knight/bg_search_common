package com.mbgo.search.util;

import java.util.regex.Pattern;

/**
 * 过滤类
 * @author HQ01U8435
 *
 */
public class KeywordFilter {

	private static Pattern pattern = Pattern.compile("[0-9]+|[a-z]+|[A-Z]+"); 

	/**
	 * 根据关键字过滤 你要找的是不是
	 * @param word
	 * @param key
	 * @return true表示要过滤
	 */
	public static boolean filterAlsoLike(String word, String key) {
		try {
			if(key == null) {
				return true;
			}
			if(pattern.matcher(key).matches() || key.trim().length() < 3) {
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}
	
	/**
	 * 过滤不合法的基础信息
	 * @param value
	 * @return
	 */
	public static boolean filterStringData(String value) {
		try {
			if(value == null || "".equalsIgnoreCase(value.trim()) || "-".equalsIgnoreCase(value)) {
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}
}

