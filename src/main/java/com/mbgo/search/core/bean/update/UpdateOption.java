/*
* 2014-11-8 上午11:11:16
* 吴健 HQ01U8435
*/

package com.mbgo.search.core.bean.update;

public class UpdateOption {

	/**
	 * 产品id
	 */
	private String productId;
	/**
	 * 更新类型：update，delete
	 */
	private String type = "";
	
	private boolean isOk;
	
	public UpdateOption() {
		
	}

	public boolean isUpdate() {
		return type != null && type.equalsIgnoreCase("update");
	}
	public boolean isDelete() {
		return type != null && type.equalsIgnoreCase("delete");
	}

	public UpdateOption(String productId, String type) {
		super();
		this.productId = productId;
		this.type = type;
		this.isOk = false;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public static UpdateOption update(String pid) {
		return new UpdateOption(pid, "update");
	}
	public static UpdateOption delete(String pid) {
		return new UpdateOption(pid, "delete");
	}
	public UpdateOption failed() {
		this.isOk = false;
		return this;
	}
	public UpdateOption success() {
		this.isOk = true;
		return this;
	}

	@Override
	public String toString() {
		return "UpdateOption [productId=" + productId + ", type=" + type
				+ ", isOk=" + isOk + "]";
	}
}
