/*
* 2015-1-15 下午3:06:14
* 吴健 HQ01U8435
*/

package com.mbgo.search.core.filter;

import java.util.ArrayList;
import java.util.List;

public class CategoryAttibute {

	private String cateId;
	private List<AttributeSoter> attrs = new ArrayList<AttributeSoter>();
	public CategoryAttibute() {
	}
	public String getCateId() {
		return cateId;
	}
	public void setCateId(String cateId) {
		this.cateId = cateId;
	}
	public List<AttributeSoter> getAttrs() {
		return attrs;
	}
	public void setAttrs(List<AttributeSoter> attrs) {
		this.attrs = attrs;
	}
	
}
