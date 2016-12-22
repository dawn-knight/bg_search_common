/*
 * 2014-10-11 下午4:03:45 吴健 HQ01U8435
 */

package com.mbgo.search.core.bean.query;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

import com.mbgo.search.constant.ChannelConst;
import com.mbgo.search.util.FormatUtil;

/**
 * 搜索接口参数类<br />
 * 【商品查询接口：http://ip:port/MBgoSearchSrv/search/qg.do】【结果对象：{@link ProductQueryResult}】<br />
 * 【筛选器查询接口：http://ip:port/MBgoSearchSrv/search/qf.do】【结果对象：
 * {@link com.mbgo.search.core.filter.FilterData}】<br />
 * 参考：{@link com.mbgo.search.controller.SearchController} <br />
 * <br />
 * 【关键字自动补全接口：http://ip:port/MBgoSearchSrv/keyword/autokey.do】<br />
 * 【关键字拼写检查接口：您是不是在找：http://ip:port/MBgoSearchSrv/keyword/spell.do】<br />
 * 【相关关键字查询接口：相关搜索：http://ip:port/MBgoSearchSrv/keyword/alsolike.do】<br />
 * 【热门关键字列表接口：http://ip:port/MBgoSearchSrv/keyword/hotword.do】<br />
 * 参考：{@link com.mbgo.search.controller.KeywordController}
 */
public class ApiParameter implements Serializable {

  /**
	 * 
	 */
  private static final long serialVersionUID = 1L;
  /**
   * 渠道编码 HQ01S116:邦购 默认邦购
   */
  private String channelCode = ChannelConst.DEFAULT_BANGGO_CHANNEL_CODE;
  // private String channelCode;

  /** 来源应用id，默认为1，邦购网（渠道）仅仅针对单品 */
  private int appId = 1;
  /**
   * 用户等级
   */
  private int userLevel = 0;

  /**
   * 页码，数值型，任何非正整数都当作1，默认值1
   */
  private String pageNo;
  /**
   * 每页记录数，数值型，范围1-200，默认40
   */
  private String pageSize;
  /**
   * 查询关键字
   */
  private String word; // 关键字
  /**
   * 商品编码，平台唯一编码
   */
  private String productId; // 商品编码
  /**
   * 色系code，【多值】
   */
  private String color; // 色系
  /**
   * 品牌code，【多值】
   */
  private String brand; // 品牌
  /**
   * 店铺id
   */
  private String storeId; // 店铺id
  /**
   * 分类id，【多值】
   */
  private String cid; // 分类id

  private String themeCode; // 主题code

  private String beautyCode; // 门店闪购code
  /**
   * 自定义价格段，例：[1-199]
   */
  private String priceRange;
  /**
   * 自定义折扣段，例：[3-6]，三到六折
   */
  private String discountRange;
  private String maxDiscount;
  private String minDiscount;
  /**
   * 查询最低库存值
   */
  private String stock = "-1"; // 库存
  /**
   * 尺寸code，【多值】
   */
  private String sizeCode;
  /**
   * 标签
   */
  private String tags;
  /**
   * 搜索类型，1：款式商品搜索，2：颜色商品搜索
   */
  private String searchType = "1";// 搜索类型：款式，颜色
  /**
   * 多值参数条件优先级，1：且优先；0：或优先
   */
  private String andFirst = "1";

  /**
   * 排序字段，取值如下，1：价格price，2：总销量saleCount，3：上市日期marketDate，4：周销量weekSaleCount，5：满意度saticsfaction
   */
  private String sortField = "";

  /**
   * 排序类型，1：升序；-1：降序
   */
  private String sortType;

  /**
   * AND attr=attrKey1:v1,v2;attrKey2:v1,v2;... OR attr=attrKey1:v1|v2;attrKey2:v1|v2;...
   */
  private String attr;

  private String promotionId;

  public String getPromotionId() {
    return promotionId;
  }

  public void setPromotionId(String promotionId) {
    this.promotionId = promotionId;
  }

  public ApiParameter() {

  }

  public String getChannelCode() {
    return channelCode;
  }

  public void setChannelCode(String channelCode) {
    this.channelCode = channelCode;
  }

  public String getPageNo() {
    return pageNo;
  }

  public void setPageNo(String pageNo) {
    this.pageNo = pageNo;
  }

  public String getPageSize() {
    return pageSize;
  }

  public void setPageSize(String pageSize) {
    this.pageSize = pageSize;
  }

  public String getWord() {
    return word;
  }

  public void setWord(String word) {
    this.word = word;
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

  public String getCid() {
    return cid;
  }

  public void setCid(String cid) {
    this.cid = cid;
  }

  public String getPriceRange() {
    return priceRange;
  }

  public void setPriceRange(String priceRange) {
    this.priceRange = priceRange;
  }

  public String getDiscountRange() {
    return discountRange;
  }

  public void setDiscountRange(String discountRange) {
    this.discountRange = discountRange;
  }

  public String getStock() {
    return stock;
  }

  public void setStock(String stock) {
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

  public ProductQuery toProductQuery() {
    ProductQuery pq = new ProductQuery(word, priceRange, discountRange);
    pq.setChannelCode(channelCode);
    pq.setAppId(appId);
    pq.setUserLevel(userLevel);
    // private int pageNo;
    pq.setPageNo(FormatUtil.getInt(pageNo, 1));
    // private int pageSize;
    pq.setPageSize(FormatUtil.getInt(pageSize, 40));
    // private String productId; //商品编码
    pq.setProductId(productId);
    // private String color; //色系
    pq.setColor(color);
    // private String brand; //品牌
    if (StringUtils.isNotBlank(brand)) {
      pq.setBrand(brand.toUpperCase());
    }
    // private String storeId; //店铺id
    pq.setStoreId(storeId);
    // private String cid; //分类id
    pq.setCid(cid);
    // private int stock = -1; //库存
    pq.setStock(FormatUtil.getInt(stock, -1));
    // private String sizeCode;
    pq.setSizeCode(sizeCode);
    // private String tags;
    pq.setTags(tags);
    pq.setPromotionId(promotionId);
    pq.setSearchType(FormatUtil.getInt(searchType, 1));
    pq.setAndFirst(StringUtils.isNotBlank(andFirst) && andFirst.equalsIgnoreCase("1"));
    pq.setThemeCode(themeCode);
    pq.setBeautyCode(beautyCode);
    pq.setAttrValue(attr);
    if (isSort()) {
      pq.setSortFieldNum(FormatUtil.getInt(sortField, 0));
      pq.setSortType(FormatUtil.getInt(sortType, 0));
    }

    pq.setMaxDiscount(FormatUtil.getInt(maxDiscount, 1000));
    pq.setMinDiscount(FormatUtil.getInt(minDiscount, -1));

    pq.init();
    return pq;
  }

  public String getMinDiscount() {
    return minDiscount;
  }

  public void setMinDiscount(String minDiscount) {
    this.minDiscount = minDiscount;
  }

  public String getSearchType() {
    return searchType;
  }

  public void setSearchType(String searchType) {
    this.searchType = searchType;
  }

  public String getAndFirst() {
    return andFirst;
  }

  public void setAndFirst(String andFirst) {
    this.andFirst = andFirst;
  }

  public String getSortField() {
    return sortField;
  }

  public void setSortField(String sortField) {
    this.sortField = sortField;
  }

  public String getSortType() {
    return sortType;
  }

  public void setSortType(String sortType) {
    this.sortType = sortType;
  }

  public boolean isSort() {
    return StringUtils.isNotBlank(sortField) && StringUtils.isNotBlank(sortType);
  }

  public String getThemeCode() {
    return themeCode;
  }

  public void setThemeCode(String themeCode) {
    this.themeCode = themeCode;
  }

  public String getBeautyCode() {
    return beautyCode;
  }

  public void setBeautyCode(String beautyCode) {
    this.beautyCode = beautyCode;
  }

  public String getAttr() {
    return attr;
  }

  public void setAttr(String attr) {
    this.attr = attr;
  }

  public String getMaxDiscount() {
    return maxDiscount;
  }

  public void setMaxDiscount(String maxDiscount) {
    this.maxDiscount = maxDiscount;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("ApiParameter [pageNo=").append(pageNo).append(", pageSize=").append(pageSize)
        .append(", word=").append(word).append(", productId=").append(productId).append(", color=")
        .append(color).append(", brand=").append(brand).append(", storeId=").append(storeId)
        .append(", cid=").append(cid).append(", themeCode=").append(themeCode)
        .append(", priceRange=").append(priceRange).append(", discountRange=")
        .append(discountRange).append(", maxDiscount=").append(maxDiscount)
        .append(", minDiscount=").append(minDiscount).append(", stock=").append(stock)
        .append(", sizeCode=").append(sizeCode).append(", tags=").append(tags)
        .append(", searchType=").append(searchType).append(", andFirst=").append(andFirst)
        .append(", sortField=").append(sortField).append(", sortType=").append(sortType)
        .append(", attr=").append(attr).append(", promotionId=").append(promotionId)
        .append(", appId=").append(appId)
        .append(", userLevel=").append(userLevel).append("]");
    return builder.toString();
  }
}
