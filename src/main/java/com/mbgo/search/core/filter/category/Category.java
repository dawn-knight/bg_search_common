/*
 * 2014-9-20 上午10:57:06 吴健 HQ01U8435
 */

package com.mbgo.search.core.filter.category;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.mbgo.search.core.cache.CacheBean;

public class Category implements CacheBean {

  /**
	 * 
	 */
  private static final long serialVersionUID = -3302347524953281547L;
  private int cateId;
  private int parentId;
  private String cateName;
  // 该分类包含的商品数量
  private long count = 0;
  // 类级
  private int level = 0;

  private int sort = 0;

  private String basicCateIds;

  private List<Category> subs = new ArrayList<Category>(0);
  private String siteSex;

  public List<Category> getSubs() {
    return subs;
  }

  public void setSubs(List<Category> subs) {
    this.subs = subs;
  }

  public void addSub(Category s) {
    this.subs.add(s);
  }

  public long getCount() {
    return count;
  }

  public void setCount(long count) {
    this.count = count;
  }

  public Category() {

  }

  public Category(int cateId) {
    this.cateId = cateId;
  }

  public Category(String cateId, long count) {
    this.cateId = Integer.parseInt(cateId);
    this.count = count;
  }

  public Category(int categoryId, String categoryName, int parentId, long count) {
    this.cateId = categoryId;
    this.cateName = categoryName;
    this.parentId = parentId;
    this.count = count;
  }

  public Category(Category another) {
    cateId = another.getCateId();
    cateName = another.getCateName();
    parentId = another.getParentId();
    count = another.getCount();
    sort = another.getSort();
    level = another.getLevel();
  }

  /**
   * test constructor
   * 
   * @param line
   */
  public Category(String line) {
    if (StringUtils.isNotBlank(line)) {
      String[] vals = line.split(",");
      if (vals.length == 3) {
        this.cateId = Integer.parseInt(vals[0]);
        this.parentId = Integer.parseInt(vals[2]);
        this.cateName = vals[1];
      }
    }
  }

  public String getCateName() {
    return cateName;
  }

  public void setCateName(String cateName) {
    this.cateName = cateName;
  }

  public int getCateId() {
    return cateId;
  }

  public void setCateId(int cateId) {
    this.cateId = cateId;
  }

  public int getParentId() {
    return parentId;
  }

  public void setParentId(int parentId) {
    this.parentId = parentId;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Category [cateId=").append(cateId)
        .append(", parentId=").append(parentId).append(", cateName=")
        .append(cateName).append(", count=").append(count)
        .append(", level=").append(level).append(", sort=")
        .append(sort).append(", basicCateIds=").append(basicCateIds)
        .append(", subs=").append(subs).append(", siteSex=")
        .append(siteSex).append("]");
    return builder.toString();
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public Object key() {
    return this.cateId;
  }

  public String getBasicCateIds() {
    return basicCateIds;
  }

  public void setBasicCateIds(String basicCateIds) {
    this.basicCateIds = basicCateIds;
  }

  public int getSort() {
    return sort;
  }

  public void setSort(int sort) {
    this.sort = sort;
  }

  public boolean hasSubs() {
    return CollectionUtils.isNotEmpty(subs);
  }

  public String getSiteSex() {
    return siteSex;
  }

  public void setSiteSex(String siteSex) {
    this.siteSex = siteSex;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + cateId;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (!(obj instanceof Category))
      return false;
    Category other = (Category) obj;
    if (cateId != other.cateId)
      return false;
    return true;
  }
}
