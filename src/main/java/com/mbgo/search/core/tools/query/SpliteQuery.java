package com.mbgo.search.core.tools.query;

/**
 * 搜索条件分析
 * 英文逗号“,”表示且，
 * 竖线“|”表示或
 * @author HQ01U8435
 *
 */
public class SpliteQuery {

	private String field;
	private String vals;
	private boolean isy = false;
	private float weigh = 0;
	public SpliteQuery(String f, String vs) {
		vals = vs;
		field = f;
	}
	public SpliteQuery(String f, String vs, float w) {
		weigh = w;
		vals = vs;
		field = f;
	}
	public SpliteQuery(String f, String vs, boolean isy) {
		vals = vs;
		field = f;
		this.isy = isy;
	}
	public String getVals() {
		return vals;
	}

	public void setVals(String vals) {
		this.vals = vals;
	}
	
	public String getQueryString(boolean isAndFirst) {
		if(isAndFirst) {
			return getAndFirst();
		}
		return getOrFirst();
	}

	public String getAndFirst() {
		String[] or = vals.split("[|]");
		SolrQueryObj o = new SolrQueryObj();
		String s = "";
		if(weigh > 0) {
			s = "^" + weigh;
		}
		for(int i = 0; i < or.length; i ++) {
			if(or[i].trim().isEmpty()) {
				continue;
			}
			String[] and = or[i].split("[,]");
			SolrQueryObj obj = new SolrQueryObj(isy);
			for (int j = 0; j < and.length; j++) {
				if(and[j].trim().isEmpty()) {
					continue;
				}
				obj.pushAnd(field, and[j]+s);
			}
			String os = obj.toString();
			o.pushOr("", os);
		}
		return "("+o.toString()+")";
	}

	public String getOrFirst() {
		String[] and = vals.split("[,]");
		SolrQueryObj o = new SolrQueryObj();
		String s = "";
		if(weigh > 0) {
			s = "^" + weigh;
		}
		for(int i = 0; i < and.length; i ++) {
			if(and[i].trim().isEmpty()) {
				continue;
			}
			String[] or = and[i].split("[|]");
			SolrQueryObj obj = new SolrQueryObj(isy);
			for (int j = 0; j < or.length; j++) {
				if(or[j].trim().isEmpty()) {
					continue;
				}
				obj.pushOr(field, or[j]+s);
			}
			String os = obj.toString();
			o.pushAnd("", os);
		}
		return "("+o.toString()+")";
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public float getWeigh() {
		return weigh;
	}
	public void setWeigh(float weigh) {
		this.weigh = weigh;
	}
	public static void main(String[] args) {
		String k = "cid";
		String v = "1|123,2,333";
		SpliteQuery query = new SpliteQuery(k, v);
//		query.setWeigh(5);
		
		System.out.println(query.getOrFirst());
		System.out.println(query.getAndFirst());
		System.out.println();
		v = "1,2,3,4";
		query = new SpliteQuery(k, v);
		System.out.println(query.getOrFirst());
		System.out.println(query.getAndFirst());
		System.out.println(query.getQueryString(true));
		System.out.println();
		
		v = "1|2|3|4";
		query = new SpliteQuery(k, v);
		System.out.println(query.getOrFirst());
		System.out.println(query.getAndFirst());
	}
}
