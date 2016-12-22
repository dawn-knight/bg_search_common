package com.mbgo.search.core.bean.index;

import java.io.Serializable;


public class BeautyInfo implements Serializable{

  
  /**
   * 
   */
  private static final long serialVersionUID = 5509782383613776657L;
  private String code;
  private String title;
  private Integer order;
  public BeautyInfo() {
  }
  public String getCode() {
    return code;
  }
  public void setCode(String code) {
    this.code = code;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public Integer getOrder() {
    return order;
  }
  public void setOrder(Integer order) {
    this.order = order;
  }
  @Override
  public String toString() {
    return "beautyInfo [code=" + code + ", title=" + title + ", order="
        + order + "]";
  }
  
}
