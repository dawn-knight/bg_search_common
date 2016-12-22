package com.mbgo.search.core.bean.query;

import java.io.Serializable;
import java.util.List;

/**
 * 最近上架商品，按照update_time逆序排列
 * 
 * @author Administrator
 *
 */
public class ReturnNewlyProductBean implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 8843873228002147089L;
  /**
   * 结果总数
   */
  private long total;
  /**
   * 结果集具体商品信息列表
   */
  private List<ReturnProductByBrandCodeBean> returnProductByBrandCodeBeans;

  public long getTotal() {
    return total;
  }

  public void setTotal(long total) {
    this.total = total;
  }

  public List<ReturnProductByBrandCodeBean> getReturnProductByBrandCodeBeans() {
    return returnProductByBrandCodeBeans;
  }

  public void setReturnProductByBrandCodeBeans(
      List<ReturnProductByBrandCodeBean> returnProductByBrandCodeBeans) {
    this.returnProductByBrandCodeBeans = returnProductByBrandCodeBeans;
  }

}
