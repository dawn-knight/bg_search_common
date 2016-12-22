package com.mbgo.search.api.service;

import java.util.List;

import com.mbgo.search.core.bean.keyword.HotWordQuery;
import com.mbgo.search.core.bean.query.ApiParameter;
import com.mbgo.search.core.bean.query.ProductQueryResult;
import com.mbgo.search.core.bean.update.UpdateOption;
import com.mbgo.search.core.filter.FilterData;

public interface SearchApiService {

	/**
	 * 商品搜索，返回商品结果集
	 * @param apiParameter
	 * @return
	 */
	ProductQueryResult searchProduct(ApiParameter apiParameter);

	/**
	 * 商品搜索，返回筛选器
	 * @param apiParameter
	 * @return
	 */
	FilterData searchFilterData(ApiParameter apiParameter);
	
	/**
	 * 关键字自动补全
	 * @param word 用户输入关键字
	 * @return
	 */
	String queryAutokey(String word, int limit);
	
	/**
	 * 关键字拼写检查
	 * @param word 关键字
	 * @return
	 */
	String spellCheck(String word);
	
	/**
	 * 相似关键字建议
	 * @param word 关键字
	 * @param limit 字数限制
	 * @param len 总关键字半角长度的限制
	 * @return
	 */
	String alsoLike(String word, int limit, int len);
	
	/**
	 * 获得热搜关键字列表
	 * @param hq 参数
	 * @return
	 */
	List<String> hotSearchWord(HotWordQuery hq);
	
	/**
	 * 索引更新
	 * @param productId 商品id
	 * @param type 类型：update，delete
	 * @return
	 */
	int updateProductIndex(String productId, String type);
	
	/**
	 * 批量更新商品索引
	 * @param uos
	 * @return
	 */
	List<UpdateOption> updateProductIndexByList(List<UpdateOption> uos);
	
	/**
	 * 更新商品标签
	 * @param pids
	 * @return
	 */
	boolean updateProductTags(List<String> pids);
}
