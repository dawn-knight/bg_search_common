package com.mbgo.search.core.filter.category;

import java.util.ArrayList;
import java.util.List;

public class OneCategory {

	 private List<Crumbs> subs = new ArrayList<Crumbs>(0);
	    public OneCategory() {
			super();
		}

		public List<Crumbs> getSubs() {
			return subs;
		}


		public void setSubs(List<Crumbs> parents) {
			this.subs = parents;
		}


		public void addSubs(Crumbs s) {
			this.subs.add(s);
		}
}
