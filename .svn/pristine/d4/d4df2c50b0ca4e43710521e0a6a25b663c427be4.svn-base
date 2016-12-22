package com.mbgo.search.core.tools.keyword.analyze;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.mbgo.search.core.tools.keyword.QueryWordConvertResult;
import com.mbgo.search.core.tools.keyword.instc.BrandHandler;
import com.mbgo.search.core.tools.keyword.instc.CategoryHandler;
import com.mbgo.search.core.tools.keyword.instc.ColorHandler;
import com.mbgo.search.core.tools.keyword.instc.NullHandler;
import com.mbgo.search.core.tools.keyword.instc.ShopHandler;
import com.mbgo.search.core.tools.keyword.intfc.IConvertorHandler;

public class Analyzer {

	//词库树根节点
	private Node _root;
	
	private List<IConvertorHandler> handlers;
	
	private Set<String> handlerIds;
	
	private IConvertorHandler matcher;
	
	private static IConvertorHandler NULL_HANDLER = new NullHandler();
	
	public Analyzer() {
		_root = new Node();
		loadExternalWord("-", "-");
		handlers = new ArrayList<IConvertorHandler>(2);
		handlerIds = new HashSet<String>(2);
		initHandlers();
	}
	public void initHandlers() {
		loadIConvertorHandler(new CategoryHandler());
		loadIConvertorHandler(new BrandHandler());
		loadIConvertorHandler(new ColorHandler());
		loadIConvertorHandler(new ShopHandler());
	}
	public void loadIConvertorHandler(IConvertorHandler handler) {
		if(!handlerIds.contains(handler.ID())) {
			handlers.add(handler);
			handlerIds.add(handler.ID());
		}
	}
	
	public boolean handleAll(String old, String word, QueryWordConvertResult qwr) {
		for(IConvertorHandler h : handlers) {
			if(h.deal(old, word, qwr)) {
				matcher = h;
				return true;
			}
		}
		matcher = NULL_HANDLER;
		return false;
	}

	public void loadExternal(String word) {
		String sameWord = word.split(":")[1];
		word = word.split(":")[0];
		loadExternalWord(word, sameWord);
	}
	
	public void loadExternalWord(String word, String sameWord) {
		if(word == null || sameWord == null) {
			return;
		}
		
		word = word.toLowerCase();
		Node temp = null;
		temp = _root;
		boolean noNext = false, noPrev = false;
		for(int i = 0; i < word.length(); i ++) {
			Character ch = word.charAt(i);
			if(ch == '[') {
				noPrev = true;
			} else if(ch == ']') {
				noNext = true;
				break;
			} else {
				//添加词库单字
				temp = temp.push(ch);
			}
		}
		temp.setNoNext(noNext);
		temp.setNoPrev(noPrev);
		temp.set_allowEnd(true);

		String[] vs = sameWord.split(";");
		int c = 0;
		for(String v : vs) {
			if(StringUtils.isNotBlank(v)) {
				c ++;
				if(c ++ > 1) {
					temp.addOthers(v);
				} else {
					temp.setWord(v);
				}
			}
		}
	}
	
	public QueryWordConvertResult replace(String test, boolean isMax) {
		if(test == null || test.length() < 1) {
			return new QueryWordConvertResult();
		}
		test = test.toLowerCase();
		int index = 0;
		int len = test.length();
		StringBuilder afterReplace = new StringBuilder("");
		QueryWordConvertResult qrs = new QueryWordConvertResult();
		String sameWord = "";
		
		//匹配词库单字过程中，当前匹配点
		Node current = null;
		Node lastNotNullNode = null;
		
		//最后跳出时的node节点是否是词尾
		boolean lastAllow = false;
		boolean noNext = false;
		boolean noPrev = false;
		boolean hasNextCharSpace = false;
		int nextCharIndex = 0;
		while(index < len) {
			String _temp = "";
			//当前单字
			Character ch = test.charAt(index);
			nextCharIndex = index + 1;

			hasNextCharSpace = isCharSpaceOrEnd(nextCharIndex, len, test);
			
			//每次重新匹配都从根节点开始
			current = _root.get(ch);
			if(current == null) {
				afterReplace.append(String.valueOf(ch));
			}
			for(;current != null;) {
				//若匹配到，则保存当前单字
				_temp += current.get_selfChar();
				lastAllow = current.is_allowEnd();
				noNext = current.isNoNext();
				noPrev = current.isNoPrev();
				//如果是词尾，而且 不是最大分词，则保存结果，继续分词
				if(lastAllow && !isMax) {
					int otherIndex = -1;
					sameWord = current.getWord();
					do {
						otherIndex ++;
						if(sameWord != null) {
							if(handleAll(_temp, sameWord, qrs) && matcher.isReserved()) {
								afterReplace.append("" + _temp);
							} else if(hasNextCharSpace && matcher.isReserved()) {
								afterReplace.append(" " + sameWord + " ");
							}
						}
						
					} while (current.hasOthers(otherIndex) && (sameWord = current.getOther(otherIndex)) != null);
				}
				index ++;
				lastNotNullNode = current;
				if(index >= len){
					//超出边界
					break;
				}
				//移动到下一个单字节点
				ch = test.charAt(index);
				current = current.get(ch);
				
				//若为空，则回退
				if(current == null) {
					index --;
					break;
				}
				
				nextCharIndex = index + 1;
				hasNextCharSpace = isCharSpaceOrEnd(nextCharIndex, len, test);
			}
			//最短匹配词长度必须大于一
			if(_temp.length() >= 1){
				if(lastNotNullNode != null) {
					sameWord = lastNotNullNode.getWord();
				}
				if(isMax && ( (noNext && !hasNextCharSpace) || (noPrev && !isSpacePrev(index, test)))) {
					afterReplace.append(_temp);
				}
				//如果 是最大分词，而且是词尾，则保存结果
				//非最大分词，结果在上面保存
				else if((!noNext || hasNextCharSpace) && isMax && lastAllow && sameWord != null && !sameWord.isEmpty()){
					int otherIndex = -1;
					do {
						otherIndex ++;

						if(handleAll(_temp, sameWord, qrs) && matcher.isReserved()) {
							afterReplace.append("" + _temp);
						} else if(matcher.isReserved()) {
							afterReplace.append(" " + sameWord + " ");
						}
						
					} while (lastNotNullNode != null && lastNotNullNode.hasOthers(otherIndex) && (sameWord = lastNotNullNode.getOther(otherIndex)) != null);
				}
			} else {
				afterReplace.append(_temp);
			}
			index ++;
		}
		qrs.setNewWord(afterReplace.toString().replaceAll("\\s+", " ").trim());
		return qrs;
	}
	
	private boolean isSpacePrev(int index, String s) {
		int ni = 0;
		if(index == s.length()) {
			ni = index - 2;
		} else {
			ni = index - 1;
		}
		if(ni < 0) {
			return true;
		}
		char t = s.charAt(ni);
		return t == ' ' || t == '-';
	}
	
	private boolean isCharSpaceOrEnd(int charIndex, int sLen, String s) {
		if(charIndex >= sLen || s.charAt(charIndex) == ' '){
			return true;
		} else {
			return false;
		}
	}

	public Node get_root() {
		return _root;
	}

	public void set_root(Node _root) {
		this._root = _root;
	}
	
	
	public QueryWordConvertResult replace1(String test, boolean isMax) {
		if(StringUtils.isBlank(test)) {
			return new QueryWordConvertResult();
		}
		test = test.trim();
		test = test.toLowerCase();
		int index = 0;
		int len = test.length();
		StringBuilder afterReplace = new StringBuilder("");
		QueryWordConvertResult qrs = new QueryWordConvertResult();
		
		//匹配词库单字过程中，当前匹配点
		Node current = null;
		Node lastNoteNull = null;
		
		//最后跳出时的node节点是否是词尾
		boolean lastAllow = false;
		
		List<TestAna> tas = new ArrayList<TestAna>();

		boolean hasNextCharSpace = false;
		while(index < len) {
			String _temp = "";
			//当前单字
			Character ch = test.charAt(index);
			
			hasNextCharSpace = isCharSpaceOrEnd(index + 1, len, test);

			//每次重新匹配都从根节点开始
			current = _root.get(ch);
			if(current == null && ch.toString().length() >= 1) {
				TestAna ta = new TestAna();
				ta.setSrc(ch.toString());
				tas.add(ta);
			}
			for(;current != null;) {
				//若匹配到，则保存当前单字
				_temp += current.get_selfChar();
				lastAllow = current.is_allowEnd();
				//如果是词尾，而且 不是最大分词，则保存结果，继续分词
				if(lastAllow && !isMax) {
					TestAna ta = new TestAna();
					ta.setSrc(_temp);
					ta.setNode(current);
					ta.setNextEnd(hasNextCharSpace);
					ta.setPrevEnd(isSpacePrev(index, test));
					tas.add(ta);
				}
				lastNoteNull = current;
				index ++;
				if(index >= len){
					//超出边界
					break;
				}
				//移动到下一个单字节点
				ch = test.charAt(index);
				current = current.get(ch);
				
				//若为空，则回退
				if(current == null) {
					index --;
					break;
				}
			}
			if(lastAllow && isMax && lastNoteNull != null && _temp.length() >= 1) {
				TestAna ta = new TestAna();
				ta.setSrc(_temp);
				ta.setNode(lastNoteNull);
				ta.setNextEnd(hasNextCharSpace);
				ta.setPrevEnd(isSpacePrev(index, test));
				tas.add(ta);
			} else {
				TestAna ta = new TestAna();
				ta.setSrc(_temp);
				ta.setNode(null);
				ta.setNextEnd(hasNextCharSpace);
				ta.setPrevEnd(isSpacePrev(index, test));
				tas.add(ta);
			}
			//最短匹配词长度必须大于一
			index ++;
		}
		
		for(TestAna ta : tas) {
//			System.out.println(ta);
			if(ta.getNode() == null) {
				afterReplace.append(ta.getSrc());
			} else {
				//handleAll(_temp, sameWord, qrs) && matcher.isReserved()
				Node n = ta.getNode();
				
				boolean rulePrev = n.isNoPrev(), ruleNext = n.isNoNext();
				//转换器规定，是否允许前置，后置]表示不允许后置；[表示不允许前置
				//A:当设置了不允许后置，才检查TestAna是否有后续关键字，两者不一致，则continue
				//B:当设置了不允许前置，才检查TestAna是否有前置关键字，两者不一致，则continue
				//A B 有一者定义了，但是不满足，则conitnue
				if((rulePrev && ta.isPrevEnd() != rulePrev) || (ruleNext && ta.isNextEnd() != ruleNext)) {
					afterReplace.append(ta.getSrc());
					continue;
				}
				
				String src = ta.getSrc();
				List<String> all = n.cloneOthers();
				all.add(n.getWord());
				
				for(String s : all) {
					if(handleAll(src, s, qrs) && matcher.isReserved()) {
						afterReplace.append("" + src);
					} else if(matcher.isReserved()){
						afterReplace.append(" " + s);
					}
				}
			}
		}
		
		qrs.setNewWord(afterReplace.toString().replaceAll("\\s+", " ").trim());
		return qrs;
	}
}
