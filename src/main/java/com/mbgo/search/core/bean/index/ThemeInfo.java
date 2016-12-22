/*
* 2014-9-28 上午10:18:07
* 吴健 HQ01U8435
*/

package com.mbgo.search.core.bean.index;

import java.io.Serializable;

public class ThemeInfo implements Serializable {

	private static final long serialVersionUID = -4247969028929554228L;
	
	private String code;
	private String title;
	private Integer order;
	public ThemeInfo() {
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "ThemeInfo [code=" + code + ", title=" + title + ", order="
				+ order + "]";
	}
	
}
