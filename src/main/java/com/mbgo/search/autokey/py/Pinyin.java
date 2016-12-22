package com.mbgo.search.autokey.py;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;

/**
 * 汉字转拼音类
 * @author wjyuian
 *
 */
public class Pinyin {
	public static final Set<String> SHENMU_DBL = initShenMuDbl();
	public static final Set<String> SHENMU = initShenMu();
	public static final Set<String> YUNMU = initYuMu();
	private static AnalyzerYunmu yunmu = new AnalyzerYunmu();
	
	/**
	 * 
	 * 将汉字转成拼音，加上序号
	 * @param word AMPM男净色圆领长袖
	 * @param maxLen
	 * @return 1_a2_m3_p4_m5_nan6_jing7_se8_yuan9_ling10_chang11_xiu
	 */
	public static String convertString(String word, int maxLen) {
		return convertString(word, "", maxLen);
	}

	/**
	 * 
	 * 将汉字转成拼音，加上序号
	 * @param word 关键字：AMPM男净色圆领长袖
	 * @param maxLen 限制长度：-1不限制
	 * @param append 分隔符：""
	 * @return 结果：1_a2_m3_p4_m5_nan6_jing7_se8_yuan9_ling10_chang11_xiu
	 */
	public static String convertString(String word, String append, int maxLen) {
		word = Pinyin.getPinyin(word);
		List<Py> pys = yunmu.process(word);
		StringBuilder s = new StringBuilder("");
		int i = 1;
		if(pys == null || pys.size() < 1) {
			return word + append;
		}
		if(maxLen > 0 && pys.size() > maxLen) {
			return null;
		}
		for(Py py : pys) {
			s.append("_"+i + "_" + py.getShmu() + py.getYumu() + append);
			i ++;
		}
		return s.toString();
	}
	
	//初始化格式方式
	private static final HanyuPinyinOutputFormat format = getFormat();
	//多音字取值
	private static final String DUOYINZI = "长:chang;畜:xu;仔:zai;";
	
	private static HanyuPinyinOutputFormat getFormat(){
		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
		
		format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		format.setVCharType(HanyuPinyinVCharType.WITH_U_AND_COLON);
		
		return format;
	}
	
	private static Set<String> initShenMuDbl() {
		Set<String> sm = new HashSet<String>();
		sm.add("zh");
		sm.add("ch");
		sm.add("sh");
		return sm;
	}
	private static Set<String> initYuMu() {
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
	private static Set<String> initShenMu() {
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
	
	/**
	 * 获取拼音
	 * @param s
	 * @return
	 */
	public static String getPinyin(String s) {
		return getPinyin(s, "", false);
	}
	
	/**
	 * 获取拼音，空格分隔
	 * @param s
	 * @return
	 */
	public static String getPinyinSpaceSplit(String s) {
		return getPinyin(s, " ", false);
	}
	
	/**
	 * 获得汉字的声母
	 * @param s
	 * @return
	 */
	public static String getshengmu(String s) {
		return getshengmu(s, "");
	}

	/**
	 * 获得汉字的声母，空格分隔
	 * @param s
	 * @return
	 */
	public static String getshengmuSpaceSplit(String s) {
		return getshengmu(s, " ");
	}
	
	/**
	 * 获取字符串的全拼，非汉字不变
	 * @param s 关键字
	 * @param split 字符的分隔符
	 * @param isSpaceAllow 是否允许空格返回
	 * @return
	 */
	public static String getPinyin(String s, String split, boolean isSpaceAllow){
		String pyStr = "";
		if(s == null || "".equalsIgnoreCase(s)){
			return pyStr;
		}
		for (int i = 0; i < s.length(); i++) {
			try {
				char s_ = s.charAt(i);
				if(isSpaceAllow && s_ == 32) {
					pyStr += " ";
				}
				if(isNumOrLetter(s_)) {
					pyStr += String.valueOf(s_) + split;
					continue;
				}
				String[] cs;
				if(DUOYINZI.indexOf(String.valueOf(s_)) > -1){
					cs = new String[]{DUOYINZI.substring(DUOYINZI.indexOf(":", DUOYINZI.indexOf(s_))+1, DUOYINZI.indexOf(";", DUOYINZI.indexOf(s_)))};
				}else{
					cs = PinyinHelper.toHanyuPinyinStringArray(s_, format);
				}
				String rs = cs[0].replaceAll("u:", "v");
				pyStr += rs + split;
			} catch (Exception e) {
				
			}
		}
		return pyStr.toLowerCase().trim();
	}
	
	/**
	 * 获取字符串的声母字符串，非汉字不变
	 * @param s
	 * @return
	 */
	public static String getshengmu(String s, String split){
		String pyStr = "";
		if(s == null || "".equalsIgnoreCase(s)){
			return pyStr;
		}
		for (int i = 0; i < s.length(); i++) {
			try {
				char s_ = s.charAt(i);
				if(isNumOrLetter(s_)) {
					pyStr += String.valueOf(s_) + split;
					continue;
				}
				String[] cs;
				if(DUOYINZI.indexOf(String.valueOf(s_)) > -1){
					cs = new String[]{DUOYINZI.substring(DUOYINZI.indexOf(":", DUOYINZI.indexOf(s_))+1, DUOYINZI.indexOf(";", DUOYINZI.indexOf(s_)))};
				}else{
					cs = PinyinHelper.toHanyuPinyinStringArray(s.charAt(i), format);
				}
				String cs0 = cs[0].replaceAll("u:", "v");;
				if(cs0 != null && !"".equalsIgnoreCase(cs0)){
					pyStr += findShenmuFromPinyin(cs0) + split;
				}
			} catch (Exception e) {
				
			}
		}
		return pyStr.toLowerCase().trim();
	}
	
	public static String findShenmuFromPinyin(String s) {
		if(s == null || s.length() < 2) {
			return s;
		}
		String sm = s.substring(0, 2);
		if(SHENMU_DBL.contains(sm)) {
			return sm;
		}
		return s.substring(0, 1);
	}
	
	public static Py createPy(String s) {
		if(s == null || s.length() < 2) {
			return new Py(s, "");
		}
		String sm = s.substring(0, 2);
		if(SHENMU_DBL.contains(sm)) {
			return new Py(sm, s.substring(2, s.length()));
		}
		return new Py(s.substring(0, 1), s.substring(1, s.length()));
	}

	public static List<Py> getshengmuList(String s){
		if(s == null || "".equalsIgnoreCase(s)){
			return new ArrayList<Py>(0);
		}
		List<Py> rs = new ArrayList<Py>(s.length());
		for (int i = 0; i < s.length(); i++) {
			try {
				char s_ = s.charAt(i);
				if(isNumOrLetter(s_)) {
					rs.add(createPy(String.valueOf(s_).toLowerCase()));
					continue;
				}
				String[] cs;
				if(DUOYINZI.indexOf(String.valueOf(s_)) > -1){
					cs = new String[]{DUOYINZI.substring(DUOYINZI.indexOf(":", DUOYINZI.indexOf(s_))+1, DUOYINZI.indexOf(";", DUOYINZI.indexOf(s_)))};
				}else{
					cs = PinyinHelper.toHanyuPinyinStringArray(s.charAt(i), format);
				}
				String cs0 = cs[0].replaceAll("u:", "v");;
				if(cs0 != null && !"".equalsIgnoreCase(cs0)){
					rs.add(createPy(cs0));
				}
			} catch (Exception e) {
				
			}
		}
		return rs;
	}
	
	/**
	 * 判断字符是否是汉字
	 * @param c
	 * @return
	 */
	/**
	 * @param c
	 * @return
	 */
	private static boolean isNumOrLetter(char c) {
		int code = String.valueOf(c).codePointAt(0);
		if(code >= 48 && code <= 57 || (code >= 65 && code <= 90) || (code >= 97 && code <= 122)) {
			return true;
		}
		return false;
	}
	
	
	public static void main(String[] args) {
//		String t = "danaotiangong";
//		//207009
//
//		long b = System.currentTimeMillis();
//		System.out.println(splitPinyinString(t));
//		System.out.println(System.currentTimeMillis() - b);
//		test(t, 1, 3);
//		
//		System.out.println(convertString("男zhuchshan", "*"));
//		
//		System.out.println(getshengmuList("松d女装"));
//		
//		System.out.println(yunmu.process(t));
		System.out.println(getPinyin("羽绒服"));
		System.out.println(getshengmu("羽绒服"));
		System.out.println(yunmu.process("nanzhchenshan"));
		System.out.println(yunmu.process("nanzhuangchenshan"));
		System.out.println(yunmu.process("danaotiangong"));
		System.out.println(getPinyinSpaceSplit("AMPM男净色圆领长袖"));
		
		System.out.println(getshengmu("大闹t宫"));
		
		System.out.println(convertString("大闹", "*", -1));
		
		List<Py> pys = yunmu.process("nanzhuangchenshan");
		for(Py p : pys) {
			System.out.println(p.getShmu()+" "+p.getYumu());
		}
	}
	
}
