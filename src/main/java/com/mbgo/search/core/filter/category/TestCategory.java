/*
* 2014-9-22 下午2:46:33
* 吴健 HQ01U8435
*/

package com.mbgo.search.core.filter.category;

import java.util.List;

public class TestCategory {

	public static void main(String[] args) {
		List<Category> list = CategoryTools.getCategorys();
		
		System.out.println(list.size());
		long b = System.currentTimeMillis();
		CategoryCaculator categoryCaculator = new CategoryCaculator(list);

		Category current = categoryCaculator.getCurrentCategory();
		System.out.println(categoryCaculator.getParentIds(222));
		System.out.println("total cost : " + (System.currentTimeMillis() - b));
		System.out.println(current);
//		CategoryTools.showCate(current, "");
		
	}
}
