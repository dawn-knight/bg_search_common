/*
* 2014-12-8 下午4:03:09
* 吴健 HQ01U8435
*/

package com.mbgo.search.core.bean.index;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

public class PromotionInfo implements Serializable {

	private static final long serialVersionUID = 638192237481079114L;
	private int promotionId;
	private String promotionName;
	public PromotionInfo() {
	}
	public PromotionInfo(String line) {
		if(StringUtils.isNotBlank(line)) {
			String[] idName = line.split(":");
			if(idName.length == 2 && StringUtils.isNumeric(idName[0])) {
				this.promotionId = Integer.parseInt(idName[0]);
				this.promotionName = idName[1];
			}
		}
	}
	public int getPromotionId() {
		return promotionId;
	}
	public void setPromotionId(int promotionId) {
		this.promotionId = promotionId;
	}
	public String getPromotionName() {
		return promotionName;
	}
	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}
	public String info() {
		return this.promotionId + ": " + this.promotionName;
	}
}
