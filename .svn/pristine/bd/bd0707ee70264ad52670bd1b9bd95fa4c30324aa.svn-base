/*
* 2014-10-15 上午10:23:15
* 吴健 HQ01U8435
*/

package com.mbgo.search.core.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheUtil {

	@SuppressWarnings("unchecked")
	public static <K extends Object,V extends CacheBean> Map<K, V> createMap(K k, List<V> cacheBeans) {
		Map<K, V> rs = new HashMap<K, V>();
		try {
			if(cacheBeans != null && cacheBeans.size() > 0) {
				for(V b : cacheBeans) {
					rs.put((K)b.key(), b);
				}
			}
		} catch (Exception e) {
		}
		return rs;
	}
}
