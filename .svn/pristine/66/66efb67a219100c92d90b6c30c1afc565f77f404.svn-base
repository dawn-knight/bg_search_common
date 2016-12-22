/*
* 2014-9-20 上午10:58:56
* 吴健 HQ01U8435
*/

package com.mbgo.search.core.filter.category;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.mbgo.search.util.ResourceReader;

public class CategoryTools {

	public static List<Category> getCategorys() {
		List<Category> result = new ArrayList<Category>(0);
		ResourceReader reader = new ResourceReader(new File("G:/mbsearch/doc/cate_data.txt"));
		try {
			reader.load();
			String line = null;
			
			while((line = reader.readLine()) != null) {
				result.add(new Category(line));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public static Map<Integer, Category> createCategoryMapper(List<Category> list) {
		Map<Integer, Category> result = new HashMap<Integer, Category>(list.size());
		Map<Integer, Category> data = new HashMap<Integer, Category>(0);

		for(Category c : list) {
			c.setLevel(1);
			data.put(c.getCateId(), c);
		}
		
		Category pcat = new Category("0,虚拟类,0");
		
//		result.put(0, new Category("0,虚拟类,0"));
		result.put(0, pcat);
		for(Category c : list) {
			Integer cid = c.getCateId();
			Integer pid = c.getParentId();
			//父类
			Category temp = result.get(pid);
			if(temp == null) {
				temp = findParentAndSet(result, data, pid);
				if(temp == null) {
					continue;
				}
			} 
			c.setLevel(temp.getLevel() + 1);
			temp.addSub(c);
			if(result.get(cid) == null) {
				result.put(cid, c);
			}
		}
		sortCategory(pcat);
		return result;
	}
	
	private static void sortCategory(Category c) {
		if(c.hasSubs()) {
			for(Category csub : c.getSubs()) {
				sortCategory(csub);
			}
			sortCategories(c.getSubs());
		}
	}
	
	private static void sortCategories(List<Category> list) {
		if(CollectionUtils.isNotEmpty(list)) {
			Collections.sort(list, new Comparator<Category>() {

				@Override
				public int compare(Category o1, Category o2) {
					return Integer.valueOf(o1.getSort()).compareTo(Integer.valueOf(o2.getSort()));
				}
				
			});
		}
	}
	
	public static Category findParentAndSet(Map<Integer, Category> rs, Map<Integer, Category> data, int pid) {
		Category temp = data.get(pid);
		if(temp == null) {
			return null;
		}
		int npid = temp.getParentId();
		if(rs.containsKey(npid)) {
			Category tempP = rs.get(npid);
			temp.setLevel(tempP.getLevel() + 1);
//			tempP.addSub(temp);
			return temp;
		} else {
			Category ntemp = findParentAndSet(rs, data, npid);
			if(ntemp != null) {
				rs.put(ntemp.getCateId(), ntemp);
				temp.setLevel(ntemp.getLevel() + 1);
				ntemp.addSub(temp);
			}
			return temp;
		}
		
	}
	
	public static void showCate(Category c, String s) {
		if(c == null) {
			System.out.println("null category exception!");
			return;
		}
		System.out.println(s + "" + c.getParentId()+"——["+c.getLevel()+"]"+c.getCateName()+"【"+c.getCateId()+"】");
		List<Category> subs = c.getSubs();
		if(subs != null && subs.size() > 0) {
			for(Category sub : subs) {
				showCate(sub, s + "\t");
			}
			System.out.println(s + "**********************************************************************************************");
		}
	}
	
}
