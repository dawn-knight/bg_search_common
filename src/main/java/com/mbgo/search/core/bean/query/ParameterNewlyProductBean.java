package com.mbgo.search.core.bean.query;

import java.io.Serializable;

public class ParameterNewlyProductBean implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 6714648016108180864L;
  /**
   * 品牌码集合，多值，以，分隔
   */
  private String brandCode;
  /**
   * 返回商品数量，默认为5
   */
  private String recordSize = "5";
  /**
   * 显示最近多少天的上架商品，默认3周，即21天
   */
  private String timeInterval = "21";

  public String getBrandCode() {
    return brandCode;
  }

  public void setBrandCode(String brandCode) {
    this.brandCode = brandCode;
  }

  public String getRecordSize() {
    return recordSize;
  }

  public void setRecordSize(String recordSize) {
    this.recordSize = recordSize;
  }

  public String getTimeInterval() {
    return timeInterval;
  }

  public void setTimeInterval(String timeInterval) {
    this.timeInterval = timeInterval;
  }

}
