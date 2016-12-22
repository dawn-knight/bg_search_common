/*
* 2014-9-22 上午10:44:31
* 吴健 HQ01U8435
*/

package com.mbgo.search.core.filter.itf;

import java.io.Serializable;

public class FilterBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7334329713432803996L;
	private String name;
	private String code;
	protected long count;
	private int sortIndex;
	public FilterBean(String name, String code, long count) {
		super();
		this.name = name;
		this.code = code;
		this.count = count;
	}
	
	public FilterBean(String name, String code, long count, int sortIndex) {
		super();
		this.name = name;
		this.code = code;
		this.count = count;
		this.sortIndex = sortIndex;
	}

	public FilterBean() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public void addCount(long c) {
		this.count += c;
	}
	@Override
	public String toString() {
		return "FilterBean [name=" + name + ", code=" + code + ", count="
				+ count + ", sortIndex=" + sortIndex + "]";
	}
	public int getSortIndex() {
		return sortIndex;
	}
	public void setSortIndex(int sortIndex) {
		this.sortIndex = sortIndex;
	}
}
