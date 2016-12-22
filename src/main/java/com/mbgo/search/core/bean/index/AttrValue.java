/*
 * 2014-12-2 下午3:55:26 吴健 HQ01U8435
 */

package com.mbgo.search.core.bean.index;

import java.io.Serializable;

public class AttrValue implements Serializable {

  private static final long serialVersionUID = 1L;
  private String key;
  private String keyName;
  private String code;
  private String name;
  private String seriesName;
  private String seriesCode;

  public AttrValue() {}

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getKeyName() {
    return keyName;
  }

  public void setKeyName(String keyName) {
    this.keyName = keyName;
  }

  public String getSeriesName() {
    return seriesName;
  }

  public void setSeriesName(String seriesName) {
    this.seriesName = seriesName;
  }

  public String getSeriesCode() {
    return seriesCode;
  }

  public void setSeriesCode(String seriesCode) {
    this.seriesCode = seriesCode;
  }

}
