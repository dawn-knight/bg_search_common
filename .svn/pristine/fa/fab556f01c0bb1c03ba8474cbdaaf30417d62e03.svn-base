package com.mbgo.search.core.tools.keyword;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/** 
 * @author 吴健  (HQ01U8435)	Email : wujian@metersbonwe.com 
 * @version 创建时间：2012-4-23 上午9:41:14 
 */
public class QueryWordConvertResult {

	private String newWord;
	
	private List<String> notWord = new ArrayList<String>();
	
	private String cateIds = "";
	
	private ParamBean brand;
	
	private ParamBean color;

	private ParamBean shop;
	
	public QueryWordConvertResult() {
	}

	public ParamBean getShop() {
		return shop;
	}

	public void setShop(ParamBean shop) {
		this.shop = shop;
	}

	public String getNewWord() {
		return newWord;
	}

	public void setNewWord(String newWord) {
		this.newWord = newWord;
	}

	public String getCateIds() {
		return cateIds;
	}

	public void setCateIds(String cateIds) {
		this.cateIds = cateIds;
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

	public List<String> getNotWord() {
		return notWord;
	}

	public void setNotWord(List<String> notWord) {
		this.notWord = notWord;
	}

	public boolean hasKeyword() {
		return StringUtils.isNotBlank(newWord) || notWord.size() > 0;
	}

	@Override
	public String toString() {
		return "QueryWordConvertResult [newWord=" + newWord + ", notWord="
				+ notWord + ", cateIds=" + cateIds + ", brand=" + brand
				+ ", color=" + color + ", shop=" + shop + "]";
	}
	
}
