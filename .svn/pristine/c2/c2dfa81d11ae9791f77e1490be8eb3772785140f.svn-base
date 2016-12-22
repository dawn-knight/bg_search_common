/*
* 2014-9-24 下午3:42:24
* 吴健 HQ01U8435
*/

package com.mbgo.search.core.bean.index;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 颜色商品信息
 */
public class ColorProduct implements Serializable {

	private static final long serialVersionUID = 2757755531191617834L;
	private String colorCodeId;
	private String imgUrl;
	/**
   * 色系name
   */
	private String colorSeriesName;
	/**
   * 色系code
   */
	private String colorSeriesCode;
	/**
	 * 颜色code
	 */
	private String colorCode;
	/**
	 * 颜色名称
	 */
	private String colorName;
	
	private int stock;
	
	//自身的状态；初始下架
	private int cpStatus = 0;
	public void setAllStatus() {
		//有一个尺寸上架，则该颜色上架
		for(SizeInfo si : sizeList) {
			if(si.getSizeStatus() == 1){
				cpStatus = 1;
				//上架
				break;
			} 
		}
	}
	
	public int getCpStatus() {
		return cpStatus;
	}
	public void setCpStatus(int cpStatus) {
		this.cpStatus = cpStatus;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

	private List<SizeInfo> sizeList = new ArrayList<SizeInfo>();
	public ColorProduct() {
		
	}
	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	public String getColorCode() {
		return colorCode;
	}
	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}
	public String getColorCodeId() {
		return colorCodeId;
	}

	public void setColorCodeId(String colorCodeId) {
		this.colorCodeId = colorCodeId;
	}

	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	
  public String getColorSeriesName() {
    return colorSeriesName;
  }

  
  public void setColorSeriesName(String colorSeriesName) {
    this.colorSeriesName = colorSeriesName;
  }

  
  public String getColorSeriesCode() {
    return colorSeriesCode;
  }

  
  public void setColorSeriesCode(String colorSeriesCode) {
    this.colorSeriesCode = colorSeriesCode;
  }

  public List<SizeInfo> getSizeList() {
		return sizeList;
	}
	public void setSizeList(List<SizeInfo> sizeList) {
		this.sizeList = sizeList;
	}
	
	public void copyFrom(ColorProduct p) {

//		private String imgUrl;
		this.imgUrl = p.getImgUrl();
//		private String colorCode;
		this.colorCode = p.getColorCode();
//		private String colorName;
		this.colorName = p.getColorName();
		
		this.sizeList = p.getSizeList();
		
		this.colorSeriesCode = p.getColorSeriesCode();
		
		this.colorSeriesName = p.getColorSeriesName();
		
		this.stock = p.getStock();
		
		this.cpStatus = p.getCpStatus();
	}
	
	public boolean hasSizeInfo() {
		return sizeList != null && sizeList.size() > 0;
	}
	
}
