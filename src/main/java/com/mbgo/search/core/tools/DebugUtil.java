/*
* 2014-10-19 下午4:07:45
* 吴健 HQ01U8435
*/

package com.mbgo.search.core.tools;

import java.util.HashMap;
import java.util.Map;

public class DebugUtil {

	private static Map<Integer, Long> TIME_MAP = new HashMap<Integer, Long>(0);
	private static Map<Integer, String> TIME_LOG = new HashMap<Integer, String>();
	
	public static void begin(Integer temp) {
		if(TIME_MAP.containsKey(temp)) {
		}
		TIME_MAP.put(temp, System.currentTimeMillis());
	}
	
	public static void end(Integer temp, String note) throws Exception {
		if(!TIME_MAP.containsKey(temp)) {
			throw new Exception("null key by " + temp + " exception.");
		}
		String rs = note + " cost : " + (System.currentTimeMillis() - TIME_MAP.get(temp));
		TIME_LOG.put(temp, rs);
		System.out.println(rs);
	}
	
	public static void showLog() {
		System.out.println("********************** time log ************************");
		for(Map.Entry<Integer, String> en : TIME_LOG.entrySet()) {
			System.out.println(en.getKey() + "|" + en.getValue());
		}
	}
	
	public static void clear() {
		System.out.println();
		TIME_MAP.clear();
		TIME_LOG.clear();
	}
}
