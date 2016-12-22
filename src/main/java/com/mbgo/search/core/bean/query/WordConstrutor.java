/*
* 2014-10-22 上午10:16:15
* 吴健 HQ01U8435
*/

package com.mbgo.search.core.bean.query;

/**
 * 关键字处理内容
 */
public class WordConstrutor {

	/**
	 * 原始关键字
	 */
	private String srcWord;
	/**
	 * 重组后关键字
	 */
	private String newWord;
	public WordConstrutor() {
		
	}
	public String getSrcWord() {
		return srcWord;
	}
	public void setSrcWord(String srcWord) {
		this.srcWord = srcWord;
	}
	public String getNewWord() {
		return newWord;
	}
	public void setNewWord(String newWord) {
		this.newWord = newWord;
	}
	public WordConstrutor(String srcWord) {
		super();
		this.srcWord = srcWord;
	}
	@Override
	public String toString() {
		return "WordConstrutor [srcWord=" + srcWord + ", newWord=" + newWord
				+ "]";
	}
}
