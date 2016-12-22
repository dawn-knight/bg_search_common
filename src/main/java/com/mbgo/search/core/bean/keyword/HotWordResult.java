/*
* 2014-10-28 下午3:49:16
* 吴健 HQ01U8435
*/

package com.mbgo.search.core.bean.keyword;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HotWordResult implements Serializable {

	private static final long serialVersionUID = 1481637887537597832L;
	private List<String> list = new ArrayList<String>();
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public HotWordResult(List<String> list) {
		super();
		this.list = list;
	}
}
