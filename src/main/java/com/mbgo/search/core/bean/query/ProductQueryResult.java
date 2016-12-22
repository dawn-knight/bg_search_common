/*
* 2014-10-9 下午4:54:25
* 吴健 HQ01U8435
*/

package com.mbgo.search.core.bean.query;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mbgo.search.core.bean.index.Product;
/**
 * 商品查询结果对象
 */
public class ProductQueryResult implements Serializable {

	private static final long serialVersionUID = -4064908743491080595L;
	/**
	 * 结果总数
	 */
	private long total;
	/**
	 * 结果集具体商品信息列表
	 */
	private List<Product> list = new ArrayList<Product>();
	
	/**
	 * 关键字处理内容；当按照关键字搜索无结果时，需要重组关键字，重组后的关键字内容存放在这个对象中
	 */
	private WordConstrutor construtor = new WordConstrutor();
	public ProductQueryResult() {
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<Product> getList() {
		return list;
	}
	public void setList(List<Product> list) {
		this.list = list;
	}
	public WordConstrutor getConstrutor() {
		return construtor;
	}
	public void setConstrutor(WordConstrutor construtor) {
		this.construtor = construtor;
	}
	public void setSrcWord(String sw) {
		construtor.setSrcWord(sw);
	}
	public void setNewWord(String nw) {
		construtor.setNewWord(nw);
	}
	public void setWords(ProductQuery pq) {
		setSrcWord(pq.getWord());
		setNewWord(pq.getWordBean().getWordAsString());
	}
}
