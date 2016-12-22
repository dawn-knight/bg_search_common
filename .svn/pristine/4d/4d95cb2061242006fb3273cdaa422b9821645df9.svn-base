/*
 * 2014-9-24 下午3:42:03 吴健 HQ01U8435
 */

package com.mbgo.search.core.bean.index;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

/**
 * 商品内容
 */
public class Product implements Serializable {

  private static final long serialVersionUID = -3413018884261469841L;
  /** 商品UUID，channelCode+productId */
  private String productUuid;
  /** 渠道号 */
  private String channelCode = "HQ01S116";
  /** 首次上架时间 */
  private Date firstOnSellData;
  /** 上架时间 */
  private Date onSaleDate;
  /** 卖家ID（店铺，包括自营）关联seller_info表store_id字段 */
  private String storeId;

  /** 卖家店铺名称 */
  private String storeName;
  /** 商品品牌code */
  private String brandCode;
  /** 商品品牌name */
  private String brandName;
  /** 店铺内商品货号 或 编码,可作唯一标示（由商家自填） */
  private String productCode;
  /** 商品ID */
  private String productId;
  /** 商品名称、标题 */
  private String productName;
  /** 市场价 */
  private double marketPrice;
  /** 销售价 */
  private double salesPrice;
  /** 库存 */
  private int stock;
  /** 更新时间 */
  private Date updateTime;
  /** 图片地址 */
  private String imgUrl;
  /** 上架时间 */
  private Date createTime;
  /** 满意度 */
  private float gsiRank;
  /** 总销量 */
  private int saleCount;
  /** 周销量 */
  private int monthSaleCount;
  /** 商品分类ID，多值字段（_M） */
  private int categoryId;
  private String categoryName;
  private int pStatus;
  // /** 商品颜色码 */
  // /** 商品颜色色系 */
  // /** 商品尺寸code，多值字段（_M） */
  // /** 邦购商品参加的主题code，多值字段（_M） */
  private List<ThemeInfo> themes = new ArrayList<ThemeInfo>();
  // /** 非邦购商品参加的门店闪购code，多值字段（_M） */
  private List<BeautyInfo> beautys = new ArrayList<BeautyInfo>();

  /** 普通标签 商品标签内容，多值字段（_M） */
  private Set<String> tags = new LinkedHashSet<String>();

  // private List<String> tags = new ArrayList<String>();
  private String displayTag = null;

  private int displayTagSort = -1;

  /**
   * 颜色商品信息
   */
  private List<ColorProduct> colorProducts = new ArrayList<ColorProduct>(0);

  private List<Integer> allCategoryIds = new ArrayList<Integer>();

  private List<AttrValue> values = new ArrayList<AttrValue>();

  private List<PromotionInfo> promotionInfos = new ArrayList<PromotionInfo>();

  // private List<String> promotionIds = new ArrayList<String>();

  /** PC端促销id集合 */
  private List<String> pcPromotionIds;
  /** APP端促销id集合 */
  private List<String> appPromotionIds;
  /** WAP端促销id集合 */
  private List<String> wapPromotionIds;
  /** 微信端促销id集合 */
  private List<String> webchatPromotionIds;

  private String discount;

  /*
   * 编辑推荐、款式名称 2015-02-26
   */
  private String salePoint;
  private String goodsName;

  /** PC端促销价 */
  private double pcPromotionPrice;
  /** APP端促销价 */
  private double appPromotionPrice;
  /** WAP端促销价 */
  private double wapPromotionPrice;
  /** 微信端促销价 */
  private double webchatPromotionPrice;

  public Product(Date onSaleDate, String storeId, String storeName, String brandCode,
      String brandName, String productCode, String productId, String productName,
      double marketPrice, double salesPrice, int stock, Date updateTime, String imgUrl,
      Date createTime, float gsiRank, int saleCount, int categoryId, List<ThemeInfo> themes,
      Set<String> tags, List<PromotionInfo> promotionInfos, String categoryName) {
    super();
    this.onSaleDate = onSaleDate;
    this.storeId = storeId;
    this.storeName = storeName;
    this.brandCode = brandCode;
    this.brandName = brandName;
    this.productCode = productCode;
    this.productId = productId;
    this.productName = productName;
    this.marketPrice = marketPrice;
    this.salesPrice = salesPrice;
    this.stock = stock;
    this.updateTime = updateTime;
    this.imgUrl = imgUrl;
    this.createTime = createTime;
    this.gsiRank = gsiRank;
    this.saleCount = saleCount;
    this.categoryId = categoryId;
    this.themes = themes;
    this.tags = tags;
    this.promotionInfos = promotionInfos;
    this.categoryName = categoryName;
  }

  public List<BeautyInfo> getBeautys() {
    return beautys;
  }

  public void setBeautys(List<BeautyInfo> beautys) {
    this.beautys = beautys;
  }

  public String getChannelCode() {
    return channelCode;
  }

  public void setChannelCode(String channelCode) {
    this.channelCode = channelCode;
  }

  public String getProductUuid() {
    return productUuid;
  }

  public void setProductUuid(String productUuid) {
    this.productUuid = productUuid;
  }

  public int getDisplayTagSort() {
    return displayTagSort;
  }

  public void setDisplayTagSort(int displayTagSort) {
    this.displayTagSort = displayTagSort;
  }

  public Set<String> getTags() {
    return tags;
  }

  public void setTags(Set<String> tags) {
    this.tags = tags;
  }

  public List<Integer> getAllCategoryIds() {
    return allCategoryIds;
  }

  public void setAllCategoryIds(List<Integer> allCategoryIds) {
    this.allCategoryIds = allCategoryIds;
  }

  public Product() {

  }

  public List<PromotionInfo> getPromotionInfos() {
    return promotionInfos;
  }

  public String getDisplayTag() {
    return displayTag;
  }

  public void setDisplayTag(String displayTag) {
    this.displayTag = displayTag;
  }

  public void setPromotionInfos(List<PromotionInfo> promotionInfos) {
    this.promotionInfos = promotionInfos;
  }

  public String getStoreId() {
    return storeId;
  }

  public void setStoreId(String storeId) {
    this.storeId = storeId;
  }

  public String getStoreName() {
    return storeName;
  }

  public void setStoreName(String storeName) {
    this.storeName = storeName;
  }

  public String getBrandCode() {
    return brandCode;
  }

  public void setBrandCode(String brandCode) {
    this.brandCode = brandCode;
  }

  public String getBrandName() {
    return brandName;
  }

  public List<AttrValue> getValues() {
    return values;
  }

  public void setValues(List<AttrValue> values) {
    this.values = values;
  }

  public void setBrandName(String brandName) {
    this.brandName = brandName;
  }

  public String getProductCode() {
    return productCode;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public double getMarketPrice() {
    return marketPrice;
  }

  public void setMarketPrice(double marketPrice) {
    this.marketPrice = marketPrice;
  }

  public double getSalesPrice() {
    return salesPrice;
  }

  public void setSalesPrice(double salesPrice) {
    this.salesPrice = salesPrice;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  public String getImgUrl() {
    return imgUrl;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }

  public float getGsiRank() {
    return gsiRank;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public void setGsiRank(float gsiRank) {
    this.gsiRank = gsiRank;
  }

  public int getSaleCount() {
    return saleCount;
  }

  public void setSaleCount(int saleCount) {
    this.saleCount = saleCount;
  }

  public int getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(int categoryId) {
    this.categoryId = categoryId;
  }

  public List<ColorProduct> getColorProducts() {
    return colorProducts;
  }

  public void setColorProducts(List<ColorProduct> colorProducts) {
    this.colorProducts = colorProducts;
  }

  public List<ThemeInfo> getThemes() {
    return themes;
  }

  public void setThemes(List<ThemeInfo> themes) {
    this.themes = themes;
  }

  public int getMonthSaleCount() {
    return monthSaleCount;
  }

  public void setMonthSaleCount(int monthSaleCount) {
    this.monthSaleCount = monthSaleCount;
  }

  public boolean isValidate() {
    return colorProducts != null && colorProducts.size() > 0;
  }

  public int getpStatus() {
    return pStatus;
  }

  public void setpStatus(int pStatus) {
    this.pStatus = pStatus;
  }

  public Date getOnSaleDate() {
    return onSaleDate;
  }

  public void setOnSaleDate(Date onSaleDate) {
    this.onSaleDate = onSaleDate;
  }

  public Date getFirstOnSellData() {
    return firstOnSellData;
  }

  public void setFirstOnSellData(Date firstOnSellData) {
    this.firstOnSellData = firstOnSellData;
  }

  /**
   * 该商品是否需要关注上下架信息
   * 
   * @return
   */
  public void setNeedSeeStatus() {
    // 本身商品下架，则true
    if (isValidate()) {
      // 默认全部下架
      boolean isAllColorOff = true;
      for (ColorProduct cp : colorProducts) {
        cp.setAllStatus();
        if (cp.getCpStatus() == 1) {
          isAllColorOff = false;
        }
      }
      if (isAllColorOff) {
        this.pStatus = 0;
      }
    }
  }

  /**
   * 设置商品的上下架状态
   */
  public void setProductStatus() {
    setNeedSeeStatus();
  }

  /**
   * 获得所有尺寸信息
   * 
   * @return
   */
  public List<SizeInfo> getAllSizes() {
    List<SizeInfo> rs = new ArrayList<SizeInfo>();
    List<ColorProduct> cps = this.colorProducts;
    if (isValidate()) {
      for (ColorProduct cp : cps) {
        if (cp.hasSizeInfo()) {
          rs.addAll(cp.getSizeList());
        }
      }
    }
    return rs;
  }

  /**
   * 获取颜色商品的色码
   * 
   * @return
   */
  public Set<String> getAllColorCodes() {
    Set<String> rs = new HashSet<String>();
    List<ColorProduct> cps = this.colorProducts;
    if (isValidate()) {
      for (ColorProduct cp : cps) {
        String colorCode = cp.getColorCode();
        if (StringUtils.isNotBlank(colorCode)) {
          rs.add(colorCode);
        }
      }
    }
    return rs;
  }

  /**
   * 克隆商品信息
   * 
   * @param npid
   * @return
   */
  public Product clone(String npid) {

    String newProductId = npid == null ? productId : npid;
    Product p = new Product(onSaleDate, storeId, storeName, brandCode, brandName, productCode,
        newProductId, productName, marketPrice, salesPrice, stock, updateTime, imgUrl, createTime,
        gsiRank, monthSaleCount, categoryId, themes, tags, promotionInfos, categoryName);
    p.setValues(this.values);
    p.setpStatus(this.pStatus);
    p.setDiscount(this.discount);
    p.setSalePoint(this.salePoint);
    p.setGoodsName(this.goodsName);
    if (StringUtils.isNotBlank(npid)) {
      List<ColorProduct> cps = this.colorProducts;
      if (cps != null) {
        List<ColorProduct> temp = new ArrayList<ColorProduct>();
        for (ColorProduct cp : cps) {
          ColorProduct ncp = new ColorProduct();
          ncp.copyFrom(cp);
          ncp.setColorCodeId(npid + cp.getColorCode());
          temp.add(ncp);
        }
        p.setColorProducts(temp);
      }
    }

    return p;
  }

  /**
   * 设置库存信息
   */
  public void setStockInfo() {
    if (isValidate()) {
      int s = 0;
      for (ColorProduct cp : colorProducts) {
        s += cp.getStock();
      }
      setStock(s);
    }
  }

  /**
   * 获得颜色商品id
   * 
   * @return
   */
  public List<String> getAllCPids() {
    List<String> rs = new ArrayList<String>();
    if (isValidate()) {
      for (ColorProduct cp : colorProducts) {
        rs.add(cp.getColorCodeId());
      }
    }
    return rs;
  }

  public String getDiscount() {
    return discount;
  }

  public void setDiscount(String discount) {
    this.discount = discount;
  }

  public String getSalePoint() {
    return salePoint;
  }

  public void setSalePoint(String salePoint) {
    this.salePoint = salePoint;
  }

  public String getGoodsName() {
    return goodsName;
  }

  public void setGoodsName(String goodsName) {
    this.goodsName = goodsName;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  public List<String> getPcPromotionIds() {
    return pcPromotionIds;
  }

  public void setPcPromotionIds(List<String> pcPromotionIds) {
    this.pcPromotionIds = pcPromotionIds;
  }

  public List<String> getAppPromotionIds() {
    return appPromotionIds;
  }

  public void setAppPromotionIds(List<String> appPromotionIds) {
    this.appPromotionIds = appPromotionIds;
  }

  public List<String> getWapPromotionIds() {
    return wapPromotionIds;
  }

  public void setWapPromotionIds(List<String> wapPromotionIds) {
    this.wapPromotionIds = wapPromotionIds;
  }

  public List<String> getWebchatPromotionIds() {
    return webchatPromotionIds;
  }

  public void setWebchatPromotionIds(List<String> webchatPromotionIds) {
    this.webchatPromotionIds = webchatPromotionIds;
  }

  public double getPcPromotionPrice() {
    return pcPromotionPrice;
  }

  public void setPcPromotionPrice(double pcPromotionPrice) {
    this.pcPromotionPrice = pcPromotionPrice;
  }

  public double getAppPromotionPrice() {
    return appPromotionPrice;
  }

  public void setAppPromotionPrice(double appPromotionPrice) {
    this.appPromotionPrice = appPromotionPrice;
  }

  public double getWapPromotionPrice() {
    return wapPromotionPrice;
  }

  public void setWapPromotionPrice(double wapPromotionPrice) {
    this.wapPromotionPrice = wapPromotionPrice;
  }

  public double getWebchatPromotionPrice() {
    return webchatPromotionPrice;
  }

  public void setWebchatPromotionPrice(double webchatPromotionPrice) {
    this.webchatPromotionPrice = webchatPromotionPrice;
  }

}
