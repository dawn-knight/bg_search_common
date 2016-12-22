package com.mbgo.search.core.tools.keyword;

import com.mbgo.search.core.tools.keyword.analyze.Analyzer;
import com.mbgo.search.util.AutokeyConvernt;
import com.mbgo.search.util.bean.WordBean;




public class QueryWordConvertor {
	/**
	 * 关键字自动补全，商品简单信息
	 */
	private static Analyzer analyzer = null;
	
	public static Analyzer getAnalyzer() {
		if(analyzer == null) {
			analyzer = new Analyzer();
		}
		return analyzer;
	}

	public static void testAdd(String t, String t2) {
		getAnalyzer().loadExternalWord(t, t2);
	}
	/**
	 * 关键字转换
	 * @param word
	 * @return
	 */
	public static QueryWordConvertResult convert(String word) {
		QueryWordConvertResult qrs = new QueryWordConvertResult();
		qrs.setNewWord(word);
		if(word == null || word.isEmpty()) {
			return qrs;
		}
		try {
			return getAnalyzer().replace1(word, true);
		} catch (Exception e) {
			return qrs;
		}
	}
	
//	static {
//
//		QueryWordConvertor.testAdd("童鞋", "童 鞋");
//		QueryWordConvertor.testAdd("衬衫", "$CID:9,19,37,29");
//		QueryWordConvertor.testAdd("包]", "$CID:53,112,177,215");
//		QueryWordConvertor.testAdd("[女]", "$CID:53,112,177,215");
//		QueryWordConvertor.testAdd("美邦", "$BRAND:mb");
//		QueryWordConvertor.testAdd("mb", "$BRAND:mb;$SHOP:HQ01S116");
//		QueryWordConvertor.testAdd("美特斯邦威", "$BRAND:mb");
//		QueryWordConvertor.testAdd("美邦", "$BRAND:mb");
//		QueryWordConvertor.testAdd("浅杏", "$COLOR:9");
//		QueryWordConvertor.testAdd("深杏", "$COLOR:8");
//		QueryWordConvertor.testAdd("杏", "$COLOR:9");
//		QueryWordConvertor.testAdd("杏色", "$COLOR:9");
//		QueryWordConvertor.testAdd("[织", "针织");
//		QueryWordConvertor.testAdd("1折", "一折");
//		QueryWordConvertor.testAdd("黄色", "$COLOR:5");
//		QueryWordConvertor.testAdd("包]", "$CID:11,22,53");
//	}
	
	public static void main(String[] args) {
		
		QueryWordConvertor.testAdd("童鞋", "童 鞋");
		QueryWordConvertor.testAdd("衬衫", "$CID:9,19,37,29");
		QueryWordConvertor.testAdd("[包]", "$CID:53,112,177,215");
		QueryWordConvertor.testAdd("[女]", "$CID:53,112,177,215");
		QueryWordConvertor.testAdd("美邦", "$BRAND:mb");
		QueryWordConvertor.testAdd("mb", "$BRAND:mb;$SHOP:001");
		QueryWordConvertor.testAdd("美特斯邦威", "$BRAND:mb");
		QueryWordConvertor.testAdd("美邦", "$BRAND:mb");
		QueryWordConvertor.testAdd("浅杏", "$COLOR:9");
		QueryWordConvertor.testAdd("深杏", "$COLOR:8");
		QueryWordConvertor.testAdd("杏", "$COLOR:9");
		QueryWordConvertor.testAdd("杏色", "$COLOR:9");
		QueryWordConvertor.testAdd("[织", "针织");
		QueryWordConvertor.testAdd("裤]", "裤");
		QueryWordConvertor.testAdd("牛仔裤", "牛仔 裤");
		QueryWordConvertor.testAdd("黄色", "$COLOR:5");
//		QueryWordConvertor.testAdd("包]", "$CID:11,22,53");

		long b = System.currentTimeMillis();
		//男  美特斯邦威  杏色 包包 深杏
//		QueryWordConvertResult qrs = QueryWordConvertor.convert("mB包包浅杏 包邮");
		String w = "-红色 mb 衬衫";//挎包 黄色 
//		String w = "100000034";//挎包 黄色 
		WordBean wb = AutokeyConvernt.findQueryWordBean(w);
		System.out.println("not word : " + wb.getNotWords());
		System.out.println("word : " + wb.getWordAsString());
		
		QueryWordConvertResult qrs = QueryWordConvertor.convert(wb.getWordAsString());
		System.out.println("new word : " + wb.getWords());
		System.out.println("关键字：" + qrs.getNewWord());
		System.out.println("分类：" + qrs.getCateIds());
		System.out.println("品牌：" + qrs.getBrand());
		System.out.println("颜色：" + qrs.getColor());
		System.out.println("店铺：" + qrs.getShop());
		System.out.println("cost : " + (System.currentTimeMillis() - b));
		
//		System.out.println(QueryWordConvertor.convert("牛仔裤").getNewWord());
//		System.out.println(QueryWordConvertor.convert("牛仔裤").getNewWord());
//		System.out.println(QueryWordConvertor.convert("织裤"));
//		System.out.println(QueryWordConvertor.convert("牛仔包邮"));
//		System.out.println(QueryWordConvertor.convert("包-红色"));
//		System.out.println(QueryWordConvertor.convert("背包"));
//		System.out.println(QueryWordConvertor.convert("针织裤"));
//		System.out.println(QueryWordConvertor.convert("休闲裤").getNewWord());
	}

}
