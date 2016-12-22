/*
* 2014-9-20 上午11:30:24
* 吴健 HQ01U8435
*/

package com.mbgo.search.core.filter.category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class CategoryCaculator {

	//当前分类
	private Category currentCategory = null;

	/**
	 * 分类计算器构造函数，用于统计当前分类
	 * @param data
	 */
	public CategoryCaculator(List<Category> data) {
		super();
		if(data != null && data.size() > 0) {
			Map<Integer, Category> cates = CategoryTools.createCategoryMapper(data);
			currentCategory = pickCurrent(cates.get(0));
		}
	}
	

	public CategoryCaculator() {
		
	}
	
	//分类和父级分类的映射关系
	private Map<Integer, List<Integer>> cateParent = new HashMap<Integer, List<Integer>>(0);
	//分类和子分类的映射关系，所有子分类，包含子分类的子分类
	private Map<String, List<String>> cateSubs = new HashMap<String, List<String>>();
	//分类的父级分类，直接父级
	private Map<String, String> cateIdPId = new HashMap<String, String>();
	//分类的子分类，直接子分类
	private Map<String, List<String>> directSubs = new HashMap<String, List<String>>();
	
	/**
	 * 初始化分类计算器，用于计算分类的父类id集合；自分类id集合
	 * @param data
	 * @return
	 */
	public CategoryCaculator initParentCategorys(List<Category> data) {
		cateParent = getCategoryMapper(data, createSubToParentIdMap(data));
		initSubsCategorys(data);
		return this;
	}
	//初始化分类和其自分类的映射
	private CategoryCaculator initSubsCategorys(List<Category> data) {
		Map<String, List<String>> temp = new HashMap<String, List<String>>();
		if(data == null || data.size() < 1) {
			return this;
		}
		for(Category c : data) {
			List<String> old = temp.get(String.valueOf(c.getParentId()));
			if(old == null) {
				old = new ArrayList<String>();
				old.add(String.valueOf(c.getCateId()));
				temp.put(String.valueOf(c.getParentId()), old);
			} else {
				old.add(String.valueOf(c.getCateId()));
			}
		}


		Map<String, List<String>> rs = new HashMap<String, List<String>>();
		for(Map.Entry<String, List<String>> en : temp.entrySet()) {
			String pid = en.getKey();
			rs.put(pid, getSubs(pid, temp));
		}
		
		cateSubs = rs;
		return this;
	}
	
	private List<String> getSubs(String id, Map<String, List<String>> temp) {
		List<String> r = temp.get(id);
		if(r == null) {
			return new ArrayList<String>();
		}
		List<String> rs = new ArrayList<String>();
		for(String k : r) {
			rs.add(k);
			rs.addAll(getSubs(k, temp));
		}
		return rs;
	}
	
	public Map<Integer, Integer> createSubToParentIdMap(List<Category> data) {
		if(data == null || data.size() < 1) {
			return null;
		}

		Map<Integer, Integer> temp = new HashMap<Integer, Integer>();
		
		for(Category c : data) {
			temp.put(c.getCateId(), c.getParentId());
		}
		return temp;
	}
	
	/**
	 * 获得指定分类的直接子分类id
	 * @param pid
	 * @return
	 */
	public List<String> getDirectSubIds(String pid) {
		if(StringUtils.isBlank(pid)) {
			return new ArrayList<String>(0);
		}
		return directSubs.get(pid);
	}
	/**
	 * 获得指定分类的所有同级分类id集合，包含自己
	 * @param id
	 * @return
	 */
	public List<String> getSameLevelCids(String id) {
		return getDirectSubIds(cateIdPId.get(id));
	}
	/**
	 * 获得指定分类的父级分类
	 * @param id
	 * @return
	 */
	public List<Integer> getParentIds(Integer id) {
		return cateParent.get(id);
	}
	/**
	 * 获得指定分类的所有子分类
	 * @param id
	 * @return
	 */
	public List<String> getSubs(String id) {
		return cateSubs.get(id);
	}
	/**
	 * 获得指定id的父级分类，包含自己
	 * @param id
	 * @return
	 */
	public List<Integer> getAllCategoryId(Integer id) {
		List<Integer> rs = getParentIds(id);
		if(rs == null) {
			rs = new ArrayList<Integer>();
		}
		List<Integer> result = new ArrayList<Integer>();
		result.add(id);
		for(Integer r : rs) {
			result.add(r);
		}
		return result;
	}
	
	private Map<Integer, List<Integer>> getCategoryMapper(List<Category> data, Map<Integer, Integer> temp) {
		
		Map<Integer, List<Integer>> rs = new HashMap<Integer, List<Integer>>();
		if(temp == null) {
			return rs;
		}

		for(Category c : data) {
			int cid = c.getCateId();
			String cids = String.valueOf(cid);
			String pid = String.valueOf(c.getParentId());
			if(StringUtils.isNotBlank(pid)) {
				cateIdPId.put(cids, pid);
				List<String> directSub = directSubs.get(pid);
				if(directSub == null) {
					directSub = new ArrayList<String>();
					directSub.add(cids);
					directSubs.put(pid, directSub);
				} else {
					directSub.add(cids);
				}
			}
			
			rs.put(cid, getParentIds(cid, temp, new ArrayList<Integer>()));
		}
		
		return rs;
	}
	//获得父级分类
	private List<Integer> getParentIds(int cid, Map<Integer, Integer> temp, List<Integer> rs) {
		Integer pid = temp.get(cid);
		if(pid == null || pid < 1) {
			return rs;
		}
		rs.add(pid);
		return getParentIds(pid, temp, rs);
	}
	
	
	/**
	 * 获得当前分类
	 * @param cate
	 * @return
	 */
	private Category pickCurrent(Category cate) {
		List<Category> subs = cate.getSubs();
		int size = subs.size();
		if(size == 1) {
			Category sub = subs.get(0);
			if(sub.getCount() != cate.getCount()) {
				/*
				 * 分类只有一个子类时，有一种情况不能向下寻找当前分类：
				 * 如果分类下直接有归属商品时，也就是分类的统计量与子类的统计量不同时
				 * 此时直接返回该分类
				 */
				return cate;
			}
			return pickCurrent(sub);
		} else {
			return cate;
		}
	}

	public Category getCurrentCategory() {
		return currentCategory;
	}

	public void setCurrentCategory(Category currentCategory) {
		this.currentCategory = currentCategory;
	}
}
