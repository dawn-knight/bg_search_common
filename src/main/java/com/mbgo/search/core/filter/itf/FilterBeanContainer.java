/*
* 2014-10-13 下午2:34:07
* 吴健 HQ01U8435
*/

package com.mbgo.search.core.filter.itf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class FilterBeanContainer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7810187727341038654L;
	private String code;
	private String name;
	private List<FilterBean> values = new ArrayList<FilterBean>();
	private int sortIndex = 0;
	private String min = "";
	private String max = "";
	private FilterBeanContainer(String code, String name, List<FilterBean> list) {
		this.code = code;
		this.name = name;
		this.values = list;
	}
	private FilterBeanContainer(String code, String name, List<FilterBean> list, int sortIndex) {
		this.code = code;
		this.name = name;
		this.values = list;
		this.sortIndex = sortIndex;
	}
	
	private FilterBeanContainer(String code, String name, List<FilterBean> list, int sortIndex, String min, String max) {
		this.code = code;
		this.name = name;
		this.values = list;
		this.sortIndex = sortIndex;
		this.min = min;
		this.max = max;
	}
	
	public static FilterBeanContainer createFilter(String code, String name, FilterCaculater caculater) {
		if(StringUtils.isBlank(code)) {
			return null;
		}
		List<FilterBean> list = caculater.execute();
		if(list == null || list.size() < 1) {
			return null;
		}
		return new FilterBeanContainer(code, name, list);
	}

	public static FilterBeanContainer createFilter(String code, String name, FilterCaculater caculater, int sortIndex) {
		if(StringUtils.isBlank(code)) {
			return null;
		}
		List<FilterBean> list = caculater.execute();
		if(list == null || list.size() < 1) {
			return null;
		}
		return new FilterBeanContainer(code, name, list, sortIndex);
	}
	
	public static FilterBeanContainer createFilter(String code, String name, FilterCaculater caculater, int sortIndex, String min, String max) {
		if(StringUtils.isBlank(code)) {
			return null;
		}
		List<FilterBean> list = caculater.execute();
		if(list == null || list.size() < 1) {
			return null;
		}
		return new FilterBeanContainer(code, name, list, sortIndex, min, max);
	}
	
	public String getCode() {
		return code;
	}
	public String getName() {
		return name;
	}
	public List<FilterBean> getValues() {
		return values;
	}
	public int getSortIndex() {
		return sortIndex;
	}
	public void setSortIndex(int sortIndex) {
		this.sortIndex = sortIndex;
	}
	public String getMin() {
		return min;
	}
	public String getMax() {
		return max;
	}
}
