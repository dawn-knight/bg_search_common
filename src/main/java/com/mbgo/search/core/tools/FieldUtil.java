/*
 * 2014-9-24 下午2:05:52 吴健 HQ01U8435
 */

package com.mbgo.search.core.tools;

public class FieldUtil {

  /** 商品UUID */
  public static final String PRODUCT_UUID = "product_uuid";
  /** 渠道号 */
  public static final String CHANNEL_CODE = "channel_code";
  /** 首次上架时间 */
  public static final String FIRST_ON_SELL_DATA = "first_on_sell_data";
  /** 上架时间 */
  public static final String ON_SALE_DATE = "on_sale_date";
  /** 关键字 */
  public static final String KEYWORD = "keyword";
  /** 卖家ID（店铺，包括自营）关联seller_info表store_id字段 */
  public static final String STORE_ID = "store_id";
  /** 卖家店铺名称 */
  public static final String STORE_NAME = "store_name";
  /** 商品品牌code */
  public static final String BRAND_CODE = "brand_code";
  /** 商品品牌name */
  public static final String BRAND_NAME = "brand_name";
  final static public String BRAND_MAPPING = "brand_mapping";
  /** 店铺内商品货号 或 编码,可作唯一标示（由商家自填） */
  public static final String PRODUCT_CODE = "product_code";
  /** 商品ID */
  public static final String PRODUCT_ID = "product_id";
  /** 商品名称、标题 */
  public static final String PRODUCT_NAME = "product_name";
  /** 市场价 */
  public static final String MARKET_PRICE = "market_price";
  /** 销售价 */
  public static final String SALES_PRICE = "sales_price";

  /** PC端促销价格 */
  public static final String PC_PROMOTION_PRICE = "pc_promotion_price";
  /** APP端促销价格 */
  public static final String APP_PROMOTION_PRICE = "app_promotion_price";
  /** WAP端促销价格 */
  public static final String WAP_PROMOTION_PRICE = "wap_promotion_price";
  /** 微信端促销价格 */
  public static final String WECHAT_PROMOTION_PRICE = "wechat_promotion_price";

  /** 库存 */
  public static final String STOCK = "stock";

  /**
   * 无库存标识
   */
  public static final String OUTOFSTOCK = "out_of_stock";

  /** 企业内部SKU（平台的SKU规则） */
  public static final String BARCODE = "bar_code";
  /** 店铺内商品SKU */
  public static final String PRODUCT_SKU = "product_sku";

  /** 规格价格—颜色、尺寸价格 */
  public static final String SPEC_PRICE = "spec_price";
  /** 更新时间 */
  public static final String UPDATE_TIME = "update_time";
  /** 图片地址 */
  public static final String IMAGE_URL = "img_url";
  /** 上架时间 */
  public static final String CREATE_TIME = "create_time";
  /** 满意度 */
  public static final String GSI_RANK = "gsi_rank";
  /** 销量 */
  public static final String SALE_COUNT = "sale_count";
  /** 商品属性值code，多值字段，动态字段 attribute_* */
  public static final String ATTRIBUTE_VALUE_CODE_M = "attribute_";

  /** 商品映射属性值code，多值字段，动态字段 series_attribute_* */
  public static final String ATTRIBUTE_SERIES_VALUE_CODE_M = "attribute_series_";

  final static public String ATTRIBUTE_KEY_CODE_NAME_MAPPING = "akey_code_name_mapping";
  final static public String ATTRIBUTE_VALUE_CODE_NAME_MAPPING = "avalue_code_name_mapping";

  final static public String ATTRIBUTE_SERIES_VALUE_CODE_NAME_MAPPING = "avalue_series_code_name_mapping";

  /** 商品分类ID，多值字段（_M） */
  public static final String CATEGORY_ID_M = "category_id";

  /** 商品颜色码 */
  public static final String COLOR_CODE_ID = "color_code_id";

  /** 商品颜色色系 */
  public static final String COLOR_SERIES = "color_series";

  final static public String COLOR_SYSTEM_MAPPING = "color_system_mapping";

  public static final String COLOR_INFO = "color_info";

  /** 商品尺寸code，多值字段（_M） */
  public static final String SIZE_CODE_M = "size_code";

  /** 商品颜色色系 */
  public static final String SIZE_SERIES = "size_series";

  /** 商品尺寸code，多值字段（_M），表示该尺寸有库存值 TODO */
  public static final String SIZE_CODE_M_STOCK = "size_code_stock";
  public static final String SIZE_MAPPING = "size_mapping";

  public static final String SIZE_SERIES_MAPPING = "size_series_mapping";

  /** 商品参加的主题code，多值字段（_M） */
  public static final String THEME_CODE_M = "theme_code";
  /** 商品主题的排序字段，动态字段；theme_code_ + 主题代码 */
  public static final String THEME_ORDER_PREFIX = "theme_order_";

  /** 商品参加的门店闪购code，多值字段（_M） */
  public static final String BEAUTY_CODE_M = "beauty_code";
  /** 门店闪购的排序字段，动态字段；beauty_code_ + 闪购代码 */
  public static final String BEAUTY_ORDER_PREFIX = "beauty_order_";

  /** "价格"乘以"库存"，由大到小排序 */
  public static final String PRICE_AND_STOCK = "theme_order_priceAndStock";

  /** 商品标签内容，多值字段（_M） */
  public static final String PRODUCT_TAG = "tag";
  /** 商品标签显示内容，单值字段 */
  public static final String PRODUCT_DISPLAY_TAG = "display_tag";

  public static final String DATA_VERSION = "data_version_timestamp";

  /** PC端促销id */
  public static final String PC_PROMOTION_IDS = "pc_promotion_id";
  /** APP端促销id */
  public static final String APP_PROMOTION_IDS = "app_promotion_id";
  /** WAP端促销id */
  public static final String WAP_PROMOTION_IDS = "wap_promotion_id";
  /** 微信端促销id */
  public static final String WECHAT_PROMOTION_IDS = "wechat_promotion_id";

  public static final String PROMOTION_NAME = "promotion_name";
  public static final String PRODUCT_INFO = "product_info";

  /** 商品分类ID，多值字段（_M） */
  public static final String CATEGORY_NAME = "category_name";

  /**
   * 动态价格段
   */
  public static final String DYN_PRICE_INTERVAL = "dyn_price_interval";

  /**
   * 折扣
   */
  public static final String DISCOUNT = "discount";

  public static final String METERSBONWE = "keyword";

  public static class AUTOKEY {

    public static final String SHOW = "autokey_key_show";
    public static final String INDEX = "autokey_key_index";
    public static final String PINYING = "autokey_pinyin";
    public static final String PINYING2 = "autokey_pinyin_2";
    public static final String SHENGMU = "autokey_shengmu";
    public static final String COUNT = "autokey_count";
    public static final String SORT = "autokey_sort";
    public static final String CATE_SEARCH = "autokey_cate_search";
    public static final String ANALYZE = "autokey_key_analyze";
  }

  public static class KEYWORD_DIC {

    public static final String KEY = "industry_key";

    public static final String KEY_NOT = "industry_key_not";

    public static final String WEIGHING = "industry_weighing";
  }

  public static void main(String[] args) {
    System.out.println(Integer.MAX_VALUE);
  }
}
