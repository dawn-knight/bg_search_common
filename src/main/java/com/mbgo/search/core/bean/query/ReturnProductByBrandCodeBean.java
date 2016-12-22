package com.mbgo.search.core.bean.query;

import java.io.Serializable;
import java.util.List;

import com.mbgo.search.core.bean.index.Product;

public class ReturnProductByBrandCodeBean implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 5507326744351806653L;
  /**
   * 品牌码
   */
  private String brandCode;
  /**
   * 结果总数
   */
  private long total;
  /**
   * 商品集合
   */
  private List<Product> productList;

  public String getBrandCode() {
    return brandCode;
  }

  public void setBrandCode(String brandCode) {
    this.brandCode = brandCode;
  }

  public long getTotal() {
    return total;
  }

  public void setTotal(long total) {
    this.total = total;
  }

  public List<Product> getProductList() {
    return productList;
  }

  public void setProductList(List<Product> productList) {
    this.productList = productList;
  }

}
