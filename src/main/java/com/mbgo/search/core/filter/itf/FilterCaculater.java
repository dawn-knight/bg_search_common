/*
 * 2014-9-22 上午10:47:38
 * 吴健 HQ01U8435
 */

package com.mbgo.search.core.filter.itf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class FilterCaculater implements FilterInterface {

	@Override
	public boolean isSortedByCount() {
		return false;
	}

	public List<FilterBean> execute() {
		@SuppressWarnings("unchecked")
		List<FilterBeanConvertor> convertors = (List<FilterBeanConvertor>) getConvertor();
		List<FilterBean> result = new ArrayList<FilterBean>();
		for (FilterBeanConvertor c : convertors) {
			if (c.isValidate()) {
				result.add(c.toFilterBean());
			}
		}
		if (isSortedByCount()) {
			Collections.sort(result, new Comparator<FilterBean>() {
				@Override
				public int compare(FilterBean o1, FilterBean o2) {
					return Long.valueOf(o2.getCount()).compareTo(Long.valueOf(o1.getCount()));
				}

			});
		}
		return result;

	}
}
