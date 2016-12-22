package com.mbgo.search.util;

import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

/** 
 * @author 吴健  (HQ01U8435)	Email : wujian@metersbonwe.com 
 * @version 创建时间：2012-5-23 下午1:32:27 
 */
public interface StaticValue {
	public interface Regex {
		public static Pattern NUMBER = Pattern.compile("[\\d]+");
		public static Pattern NUMERIC = Pattern.compile("-?\\d+\\.?\\d*");
		public static Pattern NUMBER_LETTER = Pattern.compile("[\\d|\\w]+");
		public static Pattern ID_CARD_LAST = Pattern.compile("(\\d{6})[a-zA-Z]?$");
		

	}
	
	public interface DateFormat {
		public static SimpleDateFormat FORMAT_1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		public static SimpleDateFormat FORMAT_2 = new SimpleDateFormat("yyyy-MM-dd");
		public static SimpleDateFormat FORMAT_3 = new SimpleDateFormat("yyyyMMdd");
		public static SimpleDateFormat FORMAT_4 = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		public static SimpleDateFormat FORMAT_5 = new SimpleDateFormat("HHmmss");
	}
}
