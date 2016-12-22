/*
* 2014-9-10 下午3:31:14
* 吴健 HQ01U8435
*/

package com.mbgo.search.core.tools.keyword.instc;

import java.util.regex.Pattern;

import com.mbgo.search.core.tools.keyword.ParamBean;
import com.mbgo.search.core.tools.keyword.QueryWordConvertResult;
import com.mbgo.search.core.tools.keyword.intfc.DefaultHandler;
import com.mbgo.search.core.tools.keyword.intfc.IConvertorHandler;

/**
 * 店铺关键字解析
 * @author 吴健 HQ01U8435
 *
 */
public class ShopHandler extends DefaultHandler implements IConvertorHandler  {
	public ShopHandler() {
		super("SHOP", "shop");
	}
	public boolean deal(String old, String word, QueryWordConvertResult qwr) {
		if(isReturn(word)) {
			return false;
		}
		if(Pattern.matches(regex, word)) {
			ParamBean pb = new ParamBean();
			pb.setCode(word.substring(regLen));
			pb.setWord(old);
			qwr.setShop(pb);
			return true;
		}
		return false;
	}
	public String ID() {
		return handlerId;
	}
	public boolean isReserved() {
		return false;
	}
}
