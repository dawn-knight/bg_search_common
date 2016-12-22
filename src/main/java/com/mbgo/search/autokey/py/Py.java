package com.mbgo.search.autokey.py;


public class Py {

	private String shmu;
	private String yumu;
	
	public boolean hasShengMu() {
		return !"".equalsIgnoreCase(shmu);
	}
	
	public boolean hasYunMu() {
		return !"".equalsIgnoreCase(yumu);
	}
	
	public String getShengMuFromYunMu() {
		if(!hasYunMu()) {
			return null;
		}
		String rs = "";
		int len = yumu.length(), off = 1;
		String rsSM = "", rsYM = "";
		while(len - off >= 0) {
			String newYM = yumu.substring(0, len - off);
			String sm = yumu.substring(len - off);
			if(AnalyzerYunmu.SHENMU.contains(sm) && AnalyzerYunmu.YUNMU.contains(newYM)) {
				rsSM = sm;
				rsYM = newYM;
				off ++;
			}else if(off > 1){
				yumu = rsYM;
				return rsSM;
			} else {
				return null;
			}
		}
		return rs;
	}
	
	public Py() {
	}
	public Py(String s, String y) {
		shmu = s;
		yumu = y;
	}
	public String getShmu() {
		return shmu;
	}
	public void setShmu(String shmu) {
		this.shmu = shmu;
	}
	public String getYumu() {
		return yumu;
	}
	public void setYumu(String yumu) {
		this.yumu = yumu;
	}
	public String toString() {
		return shmu + yumu + " ";
	}
}
