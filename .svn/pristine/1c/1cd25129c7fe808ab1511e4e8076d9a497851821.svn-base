/*
* 2015-1-15 下午1:37:12
* 吴健 HQ01U8435
*/

package com.mbgo.search.core.filter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class CategoryFilterSortManager {

	//每个分类下，属性排序信息
	private Map<String, FilterContainerSorter> categorySorter = new HashMap<String, FilterContainerSorter>();
	public CategoryFilterSortManager() {
	}
	
	public void init(List<CategoryAttibute> list) {
		if(list != null && list.size() > 0) {
			Map<String, FilterContainerSorter> temp = new HashMap<String, FilterContainerSorter>();
			for(CategoryAttibute ca : list) {
				String cid = ca.getCateId();
				temp.put(cid, new FilterContainerSorter(ca.getAttrs()));
			}
			categorySorter = temp;
		}
	}
	public Map<String, FilterContainerSorter> getCategorySorter() {
		return categorySorter;
	}
	public void setCategorySorter(Map<String, FilterContainerSorter> categorySorter) {
		this.categorySorter = categorySorter;
	}
	
	public FilterContainerSorter getCategorySorter(String cid) {
		if(StringUtils.isBlank(cid)) {
			return null;
		}
		return categorySorter.get(cid);
	}
	public FilterContainerSorter getCategorySorter(int cid) {
		return categorySorter.get(String.valueOf(cid));
	}
}
