package com.mbgo.search.core.tools.keyword.instc;

import java.util.regex.Pattern;

import com.mbgo.search.core.tools.keyword.QueryWordConvertResult;
import com.mbgo.search.core.tools.keyword.intfc.DefaultHandler;
import com.mbgo.search.core.tools.keyword.intfc.IConvertorHandler;

/** 
 * @author 吴健  (HQ01U8435)	Email : wujian@metersbonwe.com 
 * @version 创建时间：2012-6-18 下午4:06:23 
 */
public class CategoryHandler extends DefaultHandler implements IConvertorHandler {
	
	public CategoryHandler() {
		super("CID", "category");
	}
	public boolean deal(String old, String word, QueryWordConvertResult qwr) {
		if(isReturn(word)) {
			return false;
		}
		
		if(Pattern.matches(regex, word)) {
			qwr.setCateIds(word.substring(regLen));
			return true;
		}
		return false;
	}

	public String ID() {
		return handlerId;
	}

	public boolean isReserved() {
		return true;
	}

}
