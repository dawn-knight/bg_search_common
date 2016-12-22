package com.mbgo.search.core.tools.keyword.instc;

import com.mbgo.search.core.tools.keyword.QueryWordConvertResult;
import com.mbgo.search.core.tools.keyword.intfc.DefaultHandler;
import com.mbgo.search.core.tools.keyword.intfc.IConvertorHandler;

/** 
 * @author 吴健  (HQ01U8435)	Email : wujian@metersbonwe.com 
 * @version 创建时间：2012-6-19 上午10:10:17 
 */
public class NullHandler extends DefaultHandler implements IConvertorHandler {

	public NullHandler(String defaultRegex, String id) {
		super(defaultRegex, id);
	}

	public NullHandler() {
		super("", "");
	}

	public boolean deal(String old, String word, QueryWordConvertResult qwr) {
		return false;
	}

	public String ID() {
		return null;
	}

	public boolean isReserved() {
		return true;
	}

}
