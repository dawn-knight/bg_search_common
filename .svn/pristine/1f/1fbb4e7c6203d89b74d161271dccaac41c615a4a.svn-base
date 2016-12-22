package com.mbgo.search.util;

import org.apache.commons.lang.StringUtils;

/** 
 * @author 吴健  (HQ01U8435)	Email : wujian@metersbonwe.com 
 * @version 创建时间：2012-5-23 下午1:31:52 
 */
public class FormatUtil {
	public static boolean isNotNull(String v) {
		return v != null && !v.trim().isEmpty() && StringUtils.isNotBlank(v);
	}

	public static boolean isNumber(String s) {
		if(!isNotNull(s))
			return false;
		return StaticValue.Regex.NUMBER.matcher(s).matches();
	}
	
	public static boolean isNumberOrLetter(String s) {
		if(!isNotNull(s))
			return false;
		return StaticValue.Regex.NUMBER_LETTER.matcher(s.replaceAll("\\s", "")).matches();
	}
	
	public static boolean isNumeric(String s) {
		if(!isNotNull(s))
			return false;
		return StaticValue.Regex.NUMERIC.matcher(s).matches();
	}
	
	public static Integer getInt(String v, int dft) {
		if(isNumeric(v)) {
			return Integer.parseInt(v);
		}
		return dft;
	}
	
	public static Float getFloat(String v, float dft) {
		if(isNumeric(v)) {
			return Float.parseFloat(v);
		}
		return dft;
	}

	public static Double getDbl(String v, Double dft) {
		if(isNumeric(v)) {
			return Double.parseDouble(v);
		}
		return dft;
	}
	
	public static Long getLong(String v, long dft) {
		if(isNumber(v)) {
			return Long.parseLong(v);
		}
		return dft;
	}
	
	public static Boolean getBoolean(String v, boolean dft) {
		if(isNotNull(v)) {
			if(v.equalsIgnoreCase("true")) {
				return true;
			}
			if(getInt(v, -1) > 0) {
				return true;
			}
		}
		return dft;
	}
	
	public static String getString(String s, String dft) {
		if(isNotNull(s)) {
			return s;
		}
		return dft;
	}
	
	public static Integer getIntFromBoolean(String v, int trueInt, int falseInt) {
		if(getBoolean(v, false)) {
			return trueInt;
		}
		return falseInt;
	}
	
	public static long valueAsDefault(long value, long min, long max, long dft) {
		return value >= min && value <= max ? value : dft;
	}
	public static int valueAsDefault(int value, int min, int max, int dft) {
		return value >= min && value <= max ? value : dft;
	}
	
	public static void main(String[] args) {
		System.out.println(getBoolean("true", false));
		
		System.out.println(getIntFromBoolean("true", 1, -1));
		
		System.out.println(isNumeric("-1"));
	}
}
