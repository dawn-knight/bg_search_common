package com.mbgo.search.autokey.py;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 汉字拼音分析器
 * @author 吴健 (HQ01U8435)
 *
 */
public class AnalyzerYunmu {

	public static final Set<String> SHENMU = initShenMu();
	public static final Set<String> YUNMU = initYuMu();
	//基础词库路径
	public static final String DICT_PATH = "/com/mbgo/search/autokey/py/yunmu.txt";
	//词库树根节点
	private Node _root;
	
	public AnalyzerYunmu() {
		_root = new Node();
		initDictMap();
	}
	public Node get_root() {
		return _root;
	}

	public void set_root(Node _root) {
		this._root = _root;
	}

	public void initDictMap() {
		try {
			initDictMap(AnalyzerYunmu.DICT_PATH);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Set<String> initShenMu() {
		String[] smArr = new String[]{"b","p","m","f","d","t","n","l",
				"g","k","h","j","q","x",
				"zh","ch","sh","r","z","c","s",
				"y","w"};
		Set<String> sm = new HashSet<String>();
		for(String sma : smArr) {
			sm.add(sma);
		}
		return sm;
	}
	public static Set<String> initYuMu() {
		String[] smArr = new String[]{"a","o","e","i","u","v","ai ","ei"," ui ","ao",
				"ou","iu","ie","ve","er","an","en","in","un","vn","ang","eng","ing","ong",
				"ia","iao","uo","uan","uang","ian","iang","iong", "van", "ve", "ua"
				};
		Set<String> sm = new HashSet<String>();
		for(String sma : smArr) {
			sm.add(sma);
		}
		return sm;
	}
	
	/**
	 * 初始化词库树
	 * @throws IOException
	 */
	public void initDictMap(String dicPath) throws IOException {
		InputStream is = null;
        InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			is = AnalyzerYunmu.class.getResourceAsStream(dicPath);
	        isr = new InputStreamReader(is, "utf-8");
			br = new BufferedReader(isr, 512);
			String line = null;
			while((line = br.readLine()) != null) {
				loadExternal(line);
			}
		} catch (IOException e) {
			throw e;
		} finally {
			if(br != null) {
				br.close();
			}
			if(isr != null) {
				isr.close();
			}
			if(is != null) {
				is.close();
			}
		}
	}
	
	public void loadExternal(String word) {
		Node temp = null;
		temp = _root;
		for(int i = 0; i < word.length(); i ++) {
			Character ch = word.charAt(i);
			//添加词库单字
			temp = temp.push(ch);
		}
		temp.set_allowEnd(true);
	}
	
	/**
	 * 将汉字拼音字符串拆解，以单个汉字为单位
	 * @param test 关键字
	 * @return
	 */
	public List<Py> process(String test) {
		boolean isMax = true;
		int index = 0;
		int len = test.length();
		List<Py> pys = new ArrayList<Py>(4);
		
		//匹配词库单字过程中，当前匹配点
		Node current = null;
		
		//最后跳出时的node节点是否是词尾
		boolean lastAllow = false;
		List<String> shm = new ArrayList<String>();
		while(index < len) {
			String _temp = "";
			//当前单字
			Character ch = test.charAt(index);
			//每次重新匹配都从根节点开始
			current = _root.get(ch);
			for(;current != null;) {
				//若匹配到，则保存当前单字
				_temp += current.get_selfChar();
				lastAllow = current.is_allowEnd();
				//如果是词尾，而且 不是最大分词，则保存结果，继续分词
				if(lastAllow && !isMax) {
//					System.out.println(index+"\t"+_temp);
				}
				index ++;
				if(index >= len){
					index --;
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
			//最短匹配词长度必须大于一
			if(_temp.length() >= 1){
				//如果 是最大分词，而且是词尾，则保存结果
				//非最大分词，结果在上面保存
				if(isMax && lastAllow){
					if(SHENMU.contains(_temp)) {
						shm.add(_temp);
					} else {
						if(shm.size() > 0) {
							String sm = shm.remove(shm.size() - 1);
							while(shm.size() > 0) {
								pys.add(new Py(shm.remove(0), ""));
							}
							pys.add(new Py(sm, _temp));
						} else {
							pys.add(new Py("", _temp));
						}
					}
				}else{
					//如果不是词尾，则回退
					index = index - (_temp.length() - 1);
				}
			}
			index ++;
		}
		while(shm.size() > 0) {
			pys.add(new Py(shm.remove(0), ""));
		}
		repair(pys);
		return pys;
	}
	
	public void repair(List<Py> pys) {
		if(pys == null || pys.size() < 2) {
			return;
		}
		Py current = null, prev = null;
		for(int i = 1, len = pys.size(); i < len; i ++) {
			prev = pys.get(i - 1);
			current = pys.get(i);
			if(!current.hasShengMu()) {//如果当前拼音组合没有声母，则尝试从上一个拼音组合中寻找
				String newSM = prev.getShengMuFromYunMu();
				if(newSM != null && !newSM.isEmpty()) {
					current.setShmu(newSM);
				}
			}
		}
	}
	
	public String splitPingyin(List<Py> pys) {
		StringBuilder sb = new StringBuilder("");
		for(Py py : pys) {
			sb.append(py).append(" ");
		}
		return sb.toString().trim();
	}
	
	public static void main(String[] args) {
		String t = "lafeizhuangzhongqiulihelfzzqlhputaojiuptjqitaqtqitaqt";
		
		t = Pinyin.getPinyin(t, "", true);
		System.out.println(t);
		
		AnalyzerYunmu yunmu = new AnalyzerYunmu();
		
		List<Py> pys = yunmu.process(t);
		System.out.println(pys);
		
		System.out.println(yunmu.splitPingyin(pys));
	}
}
