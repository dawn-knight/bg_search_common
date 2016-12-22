/*
* 2015-1-15 下午1:35:43
* 吴健 HQ01U8435
*/

package com.mbgo.search.core.filter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * 某个分类下，属性排序信息
 * @author 吴健 HQ01U8435
 *
 */
public class FilterContainerSorter {

	private Map<String, Integer> sorter = new HashMap<String, Integer>();
	public FilterContainerSorter() {
	}
	public FilterContainerSorter(List<AttributeSoter> ass) {
		if(ass != null) {
			Map<String, Integer> temp = new HashMap<String, Integer>();
			for(AttributeSoter as : ass) {
				temp.put(as.getCode(), as.getSortIndex());
			}
			sorter = temp;
		}
	}
	public int getSort(String code) {
		if(StringUtils.isBlank(code)) {
			return 0;
		}
		code = code.toLowerCase();
		Integer rs = sorter.get(code);
		return rs == null ? -1 : rs;
	}
}
