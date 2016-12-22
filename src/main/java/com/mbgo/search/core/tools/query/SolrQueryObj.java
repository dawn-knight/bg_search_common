package com.mbgo.search.core.tools.query;

import java.util.ArrayList;
import java.util.List;

/**
 * solr的条件拼接类
 * @author HQ01U8435
 *
 */
public class SolrQueryObj {

	private String fieldName;
	private List<QueryPairs> queryOr;
	private List<QueryPairs> queryAnd;
	private boolean isYinhao = false;
	
	public boolean isYinhao() {
		return isYinhao;
	}

	public void setYinhao(boolean isYinhao) {
		this.isYinhao = isYinhao;
	}

	public SolrQueryObj() {
		queryOr = new ArrayList<QueryPairs>(0);
		queryAnd = new ArrayList<QueryPairs>(0);
	}
	public SolrQueryObj(boolean isYinhao) {
		queryOr = new ArrayList<QueryPairs>(0);
		queryAnd = new ArrayList<QueryPairs>(0);
		this.isYinhao = isYinhao;
	}

	public void pushPrefixOr(String k, String v) {
		queryOr.add(new QueryPairs(k, v + "*"));
	}
	
	public void pushPrefixAnd(String k, String v) {
		queryAnd.add(new QueryPairs(k, v + "*"));
	}

	public void pushOr(String k, String v) {
		if(isYinhao) {
			queryOr.add(new QueryPairs(k, "\""+v+"\""));
		}else{
			queryOr.add(new QueryPairs(k, v));
		}
	}
	public void pushAnd(String k, String v) {
		if(isYinhao){
			queryAnd.add(new QueryPairs(k, "\""+v+"\""));
		}else{
			queryAnd.add(new QueryPairs(k, v));
		}
	}
	
	public String build(List<QueryPairs> ps, String or) {
		StringBuilder sb = new StringBuilder("");
		for(int i = 0, len = ps.size(); i < len; i ++) {
			QueryPairs p = ps.get(i);
			if(len > 1) {
				sb.append("(");
			}
			String k = p.getKey();
			if(k != null && !"".equalsIgnoreCase(k)) {
				sb.append(k).append(":");
			}
			sb.append(p.getVal());
			
			if(len > 1) {
				sb.append(")");
			}
			if(i < len - 1) {
				sb.append(or);
			}
		}
		return sb.toString();
	}
	
	@Override
	public String toString() {
		String queryOrStr = build(queryOr, "OR");
		String queryAndStr = build(queryAnd, "AND");
		String rs = "";
		if(queryOrStr.length() > 0) {
			if(queryAndStr.length() > 0) {
				rs += "(" + queryOrStr + ")AND(" + queryAndStr + ")";
			}else{
				rs += queryOrStr;
			}
		}else{
			rs += queryAndStr;
		}
		return rs;
	}
	
	public static void main(String[] args) {
		String word = "休闲裤";
		SolrQueryObj obj = new SolrQueryObj(true);
		obj.pushPrefixOr("key1", word);
		obj.pushOr("key2", word);
		obj.pushOr("key3", word);
		obj.pushPrefixAnd("key4", word);
		System.out.println(obj);
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
}
