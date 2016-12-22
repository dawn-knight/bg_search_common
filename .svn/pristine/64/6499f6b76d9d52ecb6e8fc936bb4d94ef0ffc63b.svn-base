package com.mbgo.search.autokey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 关键字组合类
 * 排列组合概念中的组合
 * @author HQ01U8435
 *
 */
public class Assemble {

	public static <T> List<List<T>> get(List<T> src, List<List<T>> n) {
		List<List<T>> rs = new ArrayList<List<T>>();
		if(n == null || n.size() < 1){
			for(T s : src) {
				List<T> k = new ArrayList<T>();
				k.add(s);
				rs.add(k);
			}
		}else{
			for(List<T> o : n) {
				int index = src.indexOf(o.get(o.size() - 1));
				if(index >= src.size() - 1) {
					continue;
				}
				for(int i = index + 1; i < src.size(); i ++) {
					List<T> newList = new ArrayList<T>();
					newList.addAll(o);
					newList.add(src.get(i));
					rs.add(newList);
				}
			}
		}
		return rs;
	}
	public static <T> List<List<T>> get(List<T> src) {
		if(src == null || src.size() < 1){
			return new ArrayList<List<T>>(0);
		}
		List<List<T>> rs = new ArrayList<List<T>>();
		List<List<T>> temp = null;
		int len = src.size();
		do {
			temp = get(src, temp);
			rs.addAll(temp);
		} while(temp.get(0).size() <= len - 1);
		return rs;
	}
	
	public static int getWeigh(List<KeywordBean> r) {
		int w = 0;
		for(KeywordBean ind : r) {
			w += ind.getSort();
		}
		return w;
	}
	
	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<KeywordBean> r = new ArrayList<KeywordBean>();
		r.add(new KeywordBean("外套", 10));
		r.add(new KeywordBean("男装", 4));
		r.add(new KeywordBean("撒的发", 4));
		
		long b = System.currentTimeMillis();
		List<List<KeywordBean>> rs = get(r);
		Collections.sort(rs, new Comparator<List<KeywordBean>>(){
			public int compare(List<KeywordBean> o1, List<KeywordBean> o2) {
				return - getWeigh(o1) + getWeigh(o2);
			}
		});
		
		for(List<KeywordBean> ro : rs) {
			int w = 0;
			for(KeywordBean ind : ro) {
				System.out.print(ind.getWord() + "\t");
				w += ind.getSort();
			}
			System.out.print(w);
			System.out.println();
		}
		System.out.println("cost : " + (System.currentTimeMillis() - b));
	}
}
