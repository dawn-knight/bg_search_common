package com.mbgo.search.core.tools.keyword.intfc;
/** 
 * @author 吴健  (HQ01U8435)	Email : wujian@metersbonwe.com 
 * @version 创建时间：2012-6-18 下午4:08:38 
 */
public class DefaultHandler extends AbstractHandler {

	
	public DefaultHandler(String defaultRegex, String id) {
		regLen = defaultRegex.length() + 2;
		regex = "^\\$" + defaultRegex + "\\:.*";
		handlerId = id;
	}

	public boolean isReturn(String word) {
		if(word == null || word.isEmpty()) {
			return true;
		}
		return false;
	}

}
