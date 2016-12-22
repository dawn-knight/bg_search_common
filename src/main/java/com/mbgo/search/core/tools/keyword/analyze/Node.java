package com.mbgo.search.core.tools.keyword.analyze;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

public class Node {

	private Character _selfChar;
	
	private boolean _allowEnd = false;
	
	private Map<Character, Node> _subNodes = new HashMap<Character, Node>(16, 0.95f);

	private String word;
	
	private List<String> others = new ArrayList<String>();
	
	private Set<String> othersFilter = new HashSet<String>();
	
	public boolean hasOthers(int index) {
		return others.size() > index;
	}
	
	public void addOthers(String word) {
		if(StringUtils.isNotBlank(word) && !othersFilter.contains(word)) {
			others.add(word);
			othersFilter.add(word);
		}
	}
	
	public String getOther(int index) {
		return others.get(index);
	}
	
	public List<String> cloneOthers() {
		List<String> rs = new ArrayList<String>();
		if(hasOthers(0)) {
			for(String s : others) {
				rs.add(s);
			}
		}
		return rs;
	}
	
	/**
	 * 是否允许未到词尾即可提取
	 * true ： 不可以从“包邮”中提取“包”，只能从“包 红色”中提取“包”
	 * false ： 可以从“包邮”中提取“包”
	 */
	private boolean noNext = false;
	private boolean noPrev = false;
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public Node() {
	}
	public Node(Character ch) {
		this._selfChar = ch;
	}

	public Character get_selfChar() {
		return _selfChar;
	}
	public void set_selfChar(Character char1) {
		_selfChar = char1;
	}
	public Map<Character, Node> get_subNodes() {
		return _subNodes;
	}
	public void set_subNodes(Map<Character, Node> nodes) {
		_subNodes = nodes;
	}
	public Node push(Character ch) {
		if(_subNodes.get(ch) == null) {
			_subNodes.put(ch, new Node(ch));
		}
		return _subNodes.get(ch);
	}
	
	public Node get(Character ch) {
		return _subNodes.get(ch);
	}
	public boolean is_allowEnd() {
		return _allowEnd;
	}
	public void set_allowEnd(boolean end) {
		_allowEnd = end;
	}
	public boolean isNoNext() {
		return noNext;
	}
	public void setNoNext(boolean noNext) {
		this.noNext = noNext;
	}
	public boolean isNoPrev() {
		return noPrev;
	}
	public void setNoPrev(boolean noPrev) {
		this.noPrev = noPrev;
	}

	@Override
	public String toString() {
		return "Node [_selfChar=" + _selfChar + ", _allowEnd=" + _allowEnd
				+ ", _subNodes=" + _subNodes + ", word=" + word + ", others="
				+ others + ", noNext=" + noNext + ", noPrev=" + noPrev + "]";
	}
	
}
