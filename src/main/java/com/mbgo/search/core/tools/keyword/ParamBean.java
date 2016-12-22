/*
* 2014-9-10 下午3:34:14
* 吴健 HQ01U8435
*/

package com.mbgo.search.core.tools.keyword;

/**
 * 关键字转换对象
 * @author 吴健 HQ01U8435
 *
 */
public class ParamBean {

	//关键字中提取的特殊转换关键字
	private String word;
	//转换后的值
	private String code;
	public ParamBean() {
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "ParamBean [word=" + word + ", code=" + code + "]";
	}
}
