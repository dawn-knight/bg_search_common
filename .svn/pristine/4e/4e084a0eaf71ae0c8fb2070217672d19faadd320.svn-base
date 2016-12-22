/*
* 2014-10-10 下午2:46:43
* 吴健 HQ01U8435
*/

package com.mbgo.search.core.filter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.mbgo.search.core.bean.query.WordConstrutor;
import com.mbgo.search.core.filter.category.Category;
import com.mbgo.search.core.filter.category.CategoryCrumbs;
import com.mbgo.search.core.filter.category.OneCategory;
import com.mbgo.search.core.filter.itf.FilterBeanContainer;
import com.mbgo.search.core.tools.keyword.ParamBean;

/**
 * 筛选器查询接口结果对象
 */
public class FilterData implements Serializable {
	
	private static final long serialVersionUID = -6757570017449414077L;

	/**
	 * 结果总数
	 */
	private long total;

	/**
	 * 筛选器内容
	 */
	private List<FilterBeanContainer> subFilters = new ArrayList<FilterBeanContainer>();
	
	/**
	 * 结果集当前分类，根据结果集计算得出
	 */
	private Category currentCategory = new Category();
	private CategoryCrumbs parentCategory = new CategoryCrumbs();
	private OneCategory oneCategory = new OneCategory();
	/**
	 * 关键字处理内容；当按照关键字搜索无结果时，需要重组关键字，重组后的关键字内容存放在这个对象中
	 */
	private WordConstrutor construtor = new WordConstrutor();

	/**
	 * 关键字中的品牌信息
	 */
	private ParamBean brand;

	/**
	 * 关键字中的颜色信息
	 */
	private ParamBean color;

	/**
	 * 关键字中的店铺信息
	 */
	private ParamBean store;
	
	public FilterData() {
	}
	public List<FilterBeanContainer> getSubFilters() {
		return subFilters;
	}

	public void setSubFilters(List<FilterBeanContainer> subFilters) {
		this.subFilters = subFilters;
	}

	public Category getCurrentCategory() {
		return currentCategory;
	}
	public void setCurrentCategory(Category currentCategory) {
		this.currentCategory = currentCategory;
	}
	
	
	public CategoryCrumbs getParentCategory() {
		return parentCategory;
	}
	public void setParentCategory(CategoryCrumbs parentCategory) {
		this.parentCategory = parentCategory;
	}
	
	public OneCategory getOneCategory() {
		return oneCategory;
	}
	public void setOneCategory(OneCategory oneCategory) {
		this.oneCategory = oneCategory;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public void addSubFilter(FilterBeanContainer filterBeanContainer) {
		if(filterBeanContainer != null) {
			this.subFilters.add(filterBeanContainer);
		}
	}
	public void setSrcWord(String sw) {
		construtor.setSrcWord(sw);
	}
	public void setNewWord(String nw) {
		construtor.setNewWord(nw);
	}
	public WordConstrutor getConstrutor() {
		return construtor;
	}
	public void setConstrutor(WordConstrutor construtor) {
		this.construtor = construtor;
	}
	public ParamBean getBrand() {
		return brand;
	}
	public void setBrand(ParamBean brand) {
		this.brand = brand;
	}
	public ParamBean getColor() {
		return color;
	}
	public void setColor(ParamBean color) {
		this.color = color;
	}
	public ParamBean getStore() {
		return store;
	}
	public void setStore(ParamBean store) {
		this.store = store;
	}
	public void sortFilters(FilterContainerSorter sorter) {
		if(subFilters != null && subFilters.size() > 0) {
//			for(FilterBeanContainer filter : subFilters) {
//				Collections.sort(filter.getValues(), new Comparator<FilterBean>() {
//					public int compare(FilterBean o1, FilterBean o2) {
////						if(o1.getSortIndex() > o2.getSortIndex()) {
////							return -1;
////						}
////						return 1;
//						return Integer.valueOf(o1.getSortIndex()).compareTo(Integer.valueOf(o2.getSortIndex()));
//					}
//				});
//			}
			if(sorter != null) {
				List<FilterBeanContainer> temp = new ArrayList<FilterBeanContainer>();
				for(FilterBeanContainer container : subFilters) {
					String code = container.getCode();
					int sort = sorter.getSort(code);
					if(sort < 1) {
						continue;
					}
					container.setSortIndex(sort);
					temp.add(container);
				}
				subFilters = temp;
			}
			Collections.sort(subFilters, new Comparator<FilterBeanContainer>() {
				public int compare(FilterBeanContainer o1,
						FilterBeanContainer o2) {
					if(o1.getSortIndex() > o2.getSortIndex()) {
						return -1;
					} else {
						return 1;
					}
				}
			});
		}
	}
}
