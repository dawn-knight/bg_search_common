/*
* 2014-9-28 上午10:17:45
* 吴健 HQ01U8435
*/

package com.mbgo.search.core.bean.index;

import java.util.ArrayList;
import java.util.List;

public class ProductTheme {

	private String productId;
	private List<ThemeInfo> themes = new ArrayList<ThemeInfo>();
	public ProductTheme() {
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public List<ThemeInfo> getThemes() {
		return themes;
	}
	public void setThemes(List<ThemeInfo> themes) {
		this.themes = themes;
	}
}
