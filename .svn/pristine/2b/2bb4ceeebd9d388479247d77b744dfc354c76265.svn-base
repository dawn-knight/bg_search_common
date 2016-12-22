/*
 * 2014-9-24 下午4:07:16 吴健 HQ01U8435
 */

package com.mbgo.search.core.bean.query;

import org.apache.commons.lang.StringUtils;

import com.mbgo.search.constant.ChannelConst;
import com.mbgo.search.core.tools.keyword.ParamBean;
import com.mbgo.search.core.tools.keyword.QueryWordConvertResult;
import com.mbgo.search.core.tools.keyword.QueryWordConvertor;
import com.mbgo.search.util.AutokeyConvernt;
import com.mbgo.search.util.FormatUtil;
import com.mbgo.search.util.bean.WordBean;

public class ProductQuery {

  /**
   * 渠道编码 HQ01S116:邦购 默认邦购
   */
  private String channelCode = ChannelConst.DEFAULT_BANGGO_CHANNEL_CODE;
  /** 来源应用id，默认为1，邦购网（渠道）仅仅针对单品 */
  private int appId = 1;
  /**
   * 用户等级
   */
  private int userLevel = 0;
  private int pageNo;
  private int pageSize;
  private String word; // 关键字
  private String productId; // 商品编码
  private String color; // 色系
  private String brand; // 品牌
  private String storeId; // 店铺id
  private String cid; // 分类id
  private int stock = -1; // 库存
  private String sizeCode;
  private String tags;
  private String themeCode;
  private String beautyCode;
  // 价格区间筛选，上限
  private float prmax;
  // 价格区间筛选，下限
  private float prmin;
  // 折扣区间
  private float disMin;
  private float disMax;

  // 高亮
  private String highlightPre = "<strong class='red'>";
  private String highlightLast = "</strong>";

  private WordBean wordBean;

  private int searchType = 1;

  private boolean isAndFirst = true;

  // 排序字段
  private int sortFieldNum = 0;
  // 排序方式
  private int sortType = 0;

  private String attrValue;

  private String promotionId;

  private int maxDiscount = 1000;
  private int minDiscount = -1;

  public String getChannelCode() {
    return channelCode;
  }

  public void setChannelCode(String channelCode) {
    this.channelCode = channelCode;
  }

  public String getBeautyCode() {
    return beautyCode;
  }

  public void setBeautyCode(String beautyCode) {
    this.beautyCode = beautyCode;
  }

  public int getMaxDiscount() {
    return maxDiscount;
  }

  public void setMaxDiscount(int maxDiscount) {
    this.maxDiscount = maxDiscount;
  }

  public String getPromotionId() {
    return promotionId;
  }

  public void setPromotionId(String promotionId) {
    this.promotionId = promotionId;
  }

  public int getSearchType() {
    return searchType;
  }

  public void setSearchType(int searchType) {
    this.searchType = searchType;
  }

  public int getAppId() {
    return appId;
  }

  public void setAppId(int appId) {
    this.appId = appId;
  }

  public int getUserLevel() {
    return userLevel;
  }

  public void setUserLevel(int userLevel) {
    this.userLevel = userLevel;
  }

  private QueryWordConvertResult convertResult = new QueryWordConvertResult();

  public QueryWordConvertResult getConvertResult() {
    return convertResult;
  }

  public void setConvertResult(QueryWordConvertResult convertResult) {
    this.convertResult = convertResult;
  }

  public ProductQuery(String word, String priceRange, String discountRange) {
    this.word = word;

    // 解析价格区间参数
    setPriceRange(priceRange);
    // 解析打折参数
    setDiscountRange(discountRange);
  }

  public void init() {
    wordBean = AutokeyConvernt.findQueryWordBean(word);

    convertResult = QueryWordConvertor.convert(wordBean.getWordAsString());

    convertResult.setNotWord(wordBean.getNotWords());

    wordBean.setNewWord(convertResult.getNewWord());

    String newCids = convertResult.getCateIds();
    if (StringUtils.isBlank(cid) && StringUtils.isNotBlank(newCids)) {
      cid = newCids;
    }

    ParamBean brandBean = convertResult.getBrand();
    if (StringUtils.isBlank(brand) && brandBean != null) {
      brand = brandBean.getCode();
      if (StringUtils.isNotBlank(brand)) {
        brand = brand.toUpperCase();
      }
    }

    ParamBean colorBean = convertResult.getColor();
    if (StringUtils.isBlank(color) && colorBean != null) {
      color = colorBean.getCode();
    }

    ParamBean shopBean = convertResult.getShop();
    if (StringUtils.isBlank(storeId) && shopBean != null) {
      storeId = shopBean.getCode();
    }
  }

  private void setPriceRange(String p) {
    if (StringUtils.isNotBlank(p)) {
      Range range = new Range(p);
      prmax = range.getMaxVal();
      prmin = range.getMinVal();
    }
  }

  private void setDiscountRange(String dis) {
    if (StringUtils.isNotBlank(dis)) {
      Range range = new Range(dis);
      disMax = range.getMaxVal();
      disMin = range.getMinVal();
    }

  }

  public int getPageNo() {
    return pageNo;
  }

  public void setPageNo(int pageNo) {
    this.pageNo = pageNo;
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    if (pageSize > 200 || pageSize < 1) {
      return;
    }
    this.pageSize = pageSize;
  }

  public String getWord() {
    return word;
  }

  public void setWord(String word) {
    this.word = word;
  }

  public String getAttrValue() {
    return attrValue;
  }

  public void setAttrValue(String attrValue) {
    this.attrValue = attrValue;
  }

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getStoreId() {
    return storeId;
  }

  public void setStoreId(String storeId) {
    this.storeId = storeId;
  }

  public boolean hasWord() {
    return StringUtils.isNotBlank(word) && convertResult.hasKeyword();
  }

  public WordBean getWordBean() {
    return wordBean;
  }

  public void setWordBean(WordBean wordBean) {
    this.wordBean = wordBean;
  }

  public String getCid() {
    return cid;
  }

  public void setCid(String cid) {
    this.cid = cid;
  }

  public float getPrmax() {
    return prmax;
  }

  public void setPrmax(float prmax) {
    this.prmax = prmax;
  }

  public float getPrmin() {
    return prmin;
  }

  public void setPrmin(float prmin) {
    this.prmin = prmin;
  }

  public float getDisMin() {
    return disMin;
  }

  public void setDisMin(float disMin) {
    this.disMin = disMin;
  }

  public float getDisMax() {
    return disMax;
  }

  public void setDisMax(float disMax) {
    this.disMax = disMax;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  public String getSizeCode() {
    return sizeCode;
  }

  public void setSizeCode(String sizeCode) {
    this.sizeCode = sizeCode;
  }

  public String getTags() {
    return tags;
  }

  public void setTags(String tags) {
    this.tags = tags;
  }

  public String getHighlightPre() {
    return highlightPre;
  }

  public void setHighlightPre(String highlightPre) {
    this.highlightPre = highlightPre;
  }

  public String getHighlightLast() {
    return highlightLast;
  }

  public void setHighlightLast(String highlightLast) {
    this.highlightLast = highlightLast;
  }

  public String getThemeCode() {
    return themeCode;
  }

  public void setThemeCode(String themeCode) {
    this.themeCode = themeCode;
  }

  public String redisKey() {

    StringBuilder sb = new StringBuilder("");
    // private int pageNo;
    sb.append(pageNo).append("_");
    // private int pageSize;
    sb.append(pageSize).append("_");
    // private String word; //关键字
    sb.append(word).append("_");
    // private String productId; //商品编码
    sb.append(productId).append("_");
    // private String color; //色系
    sb.append(color).append("_");
    // private String brand; //品牌
    sb.append(brand).append("_");
    // private String storeId; //店铺id
    sb.append(storeId).append("_");
    // private String cid; //分类id
    sb.append(cid).append("_");
    // private int stock = -1; //库存
    sb.append(stock).append("_");
    // private String sizeCode;
    sb.append(sizeCode).append("_");
    // private String tags;
    sb.append(tags).append("_");
    // //价格区间筛选，上限
    //
    // // private WordBean wordBean;
    // sb.append(pageNo).append("_");
    //
    // private int searchType = 1;
    sb.append(searchType).append("_");
    sb.append(attrValue).append("_");
    return sb.toString();
  }

  public boolean isAndFirst() {
    return isAndFirst;
  }

  public void setAndFirst(boolean isAndFirst) {
    this.isAndFirst = isAndFirst;
  }

  public int getSortFieldNum() {
    return sortFieldNum;
  }

  public void setSortFieldNum(int sortFieldNum) {
    this.sortFieldNum = sortFieldNum;
  }

  public int getSortType() {
    return sortType;
  }

  public void setSortType(int sortType) {
    this.sortType = sortType;
  }

  public boolean isSort() {
    return sortFieldNum > 0 && sortFieldNum < 8 && sortFieldNum != 0;
  }

  public int getMinDiscount() {
    return minDiscount;
  }

  public void setMinDiscount(int minDiscount) {
    this.minDiscount = minDiscount;
  }

}

class Range {

  private float minVal;
  private float maxVal;
  private String str;

  public Range(String range) {
    str = range;
    int index1 = str.indexOf("[");
    int index2 = str.indexOf("-");
    int index3 = str.indexOf("]");
    try {
      String min = str.substring(index1 + 1, index2).replaceAll("[^\\d|\\.]", "");
      String max = str.substring(index2 + 1, index3 > 0 ? index3 : str.length()).replaceAll(
          "[^\\d|\\.]", "");
      float pmax = FormatUtil.getFloat(max, -1f);
      float pmin = FormatUtil.getFloat(min, -1f);
      maxVal = Math.max(pmax, pmin);
      minVal = Math.min(pmax, pmin);

      if (maxVal > 0 && minVal < 0) {
        minVal = 0;
      }

    } catch (Exception e) {
      minVal = maxVal = -1f;
    }
  }

  public float getMinVal() {
    return minVal;
  }

  public void setMinVal(float minVal) {
    this.minVal = minVal;
  }

  public float getMaxVal() {
    return maxVal;
  }

  public void setMaxVal(float maxVal) {
    this.maxVal = maxVal;
  }

  public String getStr() {
    return str;
  }

  public void setStr(String str) {
    this.str = str;
  }

}