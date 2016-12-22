package com.mbgo.search.core.tools.keyword.intfc;

import com.mbgo.search.core.tools.keyword.QueryWordConvertResult;

/** 
 * @author 吴健  (HQ01U8435)	Email : wujian@metersbonwe.com 
 * @version 创建时间：2012-6-18 下午4:05:38 
 */
public interface IConvertorHandler {
	
	public boolean deal(String old, String word, QueryWordConvertResult qwr);
	
	public String ID();
	
	public boolean isReserved();
}
