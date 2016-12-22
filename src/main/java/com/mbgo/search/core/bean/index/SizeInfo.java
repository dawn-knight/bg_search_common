/*
 * 2014-9-26 下午3:08:04 吴健 HQ01U8435
 */

package com.mbgo.search.core.bean.index;

import java.io.Serializable;

public class SizeInfo implements Serializable {

  private static final long serialVersionUID = -1751230565509178469L;
  private String sizeCode;
  private String sizeName;
  /**
   * 尺码系name
   */
  private String sizeSeriesName;
  /**
   * 尺码系code
   */
  private String sizeSeriesCode;
  private int stock = 0;
  private int sizeStatus;
  private String sku;

  public int getSizeStatus() {
    return sizeStatus;
  }

  public void setSizeStatus(int sizeStatus) {
    this.sizeStatus = sizeStatus;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  public SizeInfo() {}

  public String getSizeCode() {
    return sizeCode;
  }

  public void setSizeCode(String sizeCode) {
    this.sizeCode = sizeCode;
  }

  public String getSizeName() {
    return sizeName;
  }

  public void setSizeName(String sizeName) {
    this.sizeName = sizeName;
  }

  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }

  public String getSizeSeriesName() {
    return sizeSeriesName;
  }

  public void setSizeSeriesName(String sizeSeriesName) {
    this.sizeSeriesName = sizeSeriesName;
  }

  public String getSizeSeriesCode() {
    return sizeSeriesCode;
  }

  public void setSizeSeriesCode(String sizeSeriesCode) {
    this.sizeSeriesCode = sizeSeriesCode;
  }

  @Override
  public String toString() {
    return "SizeInfo [sizeCode=" + sizeCode + ", sizeName=" + sizeName
        + ", stock=" + stock + ", sizeStatus=" + sizeStatus + ", sku="
        + sku + "]";
  }
}
