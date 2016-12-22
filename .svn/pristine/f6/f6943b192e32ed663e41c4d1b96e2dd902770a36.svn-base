/*
* 2014-9-10 下午2:24:34
* 吴健 HQ01U8435
*/

package com.mbgo.search.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.format.DateTimeFormat;

public class DateUtils {
	private static final String FULL_FORMAT_DATE_STRING = "yyyy-MM-dd HH:mm:ss";
	private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat(FULL_FORMAT_DATE_STRING);
	
	public static String formatLong(long millionSeconds) {
		Date date = new Date(millionSeconds);
		return SIMPLE_DATE_FORMAT.format(date);
	}
	public static String formatCurrent() {
		return SIMPLE_DATE_FORMAT.format(new Date());
	}
	
	public static long formateStringToLong(String fmt) {
		try {
			return DateTimeFormat.forPattern(FULL_FORMAT_DATE_STRING).
					parseDateTime(fmt).getMillis();
		} catch (Exception e) {
			e.printStackTrace();
			return System.currentTimeMillis();
		}
	}
	
	public static void main(String[] args) {
		System.out.println(formatLong(1411543637000l));
	}
}
