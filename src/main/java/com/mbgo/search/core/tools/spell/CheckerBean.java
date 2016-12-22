package com.mbgo.search.core.tools.spell;
/** 
 * @author 吴健  (HQ01U8435)	Email : wujian@metersbonwe.com 
 * @version 创建时间：2012-11-29 上午11:25:59 
 */
public class CheckerBean {

	private String key;
	private String value;
	//如果是isAnd=ture，则采用模糊匹配
	private boolean isAnd = false;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public CheckerBean(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}
	public CheckerBean(String key, String value, boolean isAnd) {
		super();
		this.key = key;
		this.value = value;
		this.isAnd = isAnd;
	}
	public String toString() {
		
		return key + ":" + value;
	}
	public boolean isAnd() {
		return isAnd;
	}
	public void setAnd(boolean isAnd) {
		this.isAnd = isAnd;
	}
	
}
