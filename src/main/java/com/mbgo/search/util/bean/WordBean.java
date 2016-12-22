/*
* 2014-9-10 下午3:01:50
* 吴健 HQ01U8435
*/

package com.mbgo.search.util.bean;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class WordBean {

	private List<String> words = new ArrayList<String>(0);
	private List<String> notWords = new ArrayList<String>(0);
	public WordBean() {
	}
	public List<String> getWords() {
		return words;
	}
	public void setWords(List<String> words) {
		this.words = words;
	}
	public List<String> getNotWords() {
		return notWords;
	}
	public void setNotWords(List<String> notWords) {
		this.notWords = notWords;
	}
	
	public String getWordAsString() {
		return listToString(words);
	}
	
	public void setNewWord(String w) {
		if(StringUtils.isNotBlank(w)) {
			words.clear();
			words.add(w);
		}
	}
	
	private String listToString(List<String> list) {
		StringBuilder sb = new StringBuilder();
		if(list != null) {
			for(String s : list) {
				sb.append(s).append(" ");
			}
		}
		return sb.toString();
	}
	
}
