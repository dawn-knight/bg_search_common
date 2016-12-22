package com.mbgo.search.core.tools.keyword.intfc;


/** 
 * @author 吴健  (HQ01U8435)	Email : wujian@metersbonwe.com 
 * @version 创建时间：2012-6-18 下午4:06:51 
 */
public abstract class AbstractHandler {

	protected int regLen = 0;
	
	protected String regex;
	
	protected String handlerId;
	
	public AbstractHandler() {
	}

	public abstract boolean isReturn(String word);
}
