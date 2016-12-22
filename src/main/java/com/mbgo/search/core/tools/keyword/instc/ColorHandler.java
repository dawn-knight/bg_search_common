package com.mbgo.search.core.tools.keyword.instc;

import java.util.regex.Pattern;

import com.mbgo.search.core.tools.keyword.ParamBean;
import com.mbgo.search.core.tools.keyword.QueryWordConvertResult;
import com.mbgo.search.core.tools.keyword.intfc.DefaultHandler;
import com.mbgo.search.core.tools.keyword.intfc.IConvertorHandler;

/** 
 * @author 吴健  (HQ01U8435)	Email : wujian@metersbonwe.com 
 * @version 创建时间：2012-6-18 下午4:38:11 
 */
public class ColorHandler extends DefaultHandler implements IConvertorHandler {

	public ColorHandler() {
		super("COLOR", "color");
	}

	public boolean deal(String old, String word, QueryWordConvertResult qwr) {
		if(isReturn(word)) {
			return false;
		}
		if(Pattern.matches(regex, word)) {
			ParamBean pb = new ParamBean();
			pb.setCode(word.substring(regLen));
			pb.setWord(old);
			qwr.setColor(pb);
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
