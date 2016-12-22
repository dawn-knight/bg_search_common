package com.mbgo.search.core.tools.query;

/**
 * 条件键值对
 * @author HQ01U8435
 *
 */
public class QueryPairs {
	private String key;
	private String val;
	public QueryPairs(String k, String v) {
		key = k;
		val = v;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getVal() {
		return val;
	}
	public void setVal(String val) {
		this.val = val;
	}
}
