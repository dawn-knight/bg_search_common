/*
 * 2014-10-28 下午3:25:29
 * 吴健 HQ01U8435
 */

package com.mbgo.search.core.bean.keyword;

/**
 * 热搜关键字查询条件
 */
public class HotWordQuery {
	/**
	 * 自定义筛选条件
	 */
	private Integer indexLevel;
	/**
	 * 渠道编码/商家编码
	 */
	private String channelId;
	/**
	 * 分类id
	 */
	private String categoryId;
	/**
	 * 数量限制
	 */
	private Integer limit = 10;

	/**
	 * 半角长度限制
	 */
	private Integer len = 10000;
	
	/**
	 * 是否走缓存
	 */
	private String isCache = "1";

	public HotWordQuery() {

	}

	public void init() {
		limit = limit > 0 && limit < 30 ? limit : 10;
	}
	
	public Integer getIndexLevel() {
		return indexLevel;
	}

	public void setIndexLevel(Integer indexLevel) {
		this.indexLevel = indexLevel;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getNum() {
		return limit;
	}

	public void setNum(Integer num) {
		this.limit = num;
	}

	public Integer getLen() {
		return len;
	}

	public void setLen(Integer len) {
		this.len = len;
	}

	public String getIsCache() {
		return isCache;
	}

	public void setIsCache(String isCache) {
		this.isCache = isCache;
	}

	public String redisKey() {
		return indexLevel + "_" + channelId + "_" + categoryId + "_" + limit + "_" + len;
	}
}
