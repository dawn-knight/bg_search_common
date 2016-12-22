/*
* 2014-9-10 下午5:09:34
* 吴健 HQ01U8435
*/

package com.mbgo.search.core.tools.keyword.analyze;


public class TestAna {

	private String src;
	private Node node;
	
	private boolean prevEnd = false;
	private boolean nextEnd = false;
	
	public boolean isPrevEnd() {
		return prevEnd;
	}
	public void setPrevEnd(boolean prevEnd) {
		this.prevEnd = prevEnd;
	}
	public boolean isNextEnd() {
		return nextEnd;
	}
	public void setNextEnd(boolean nextEnd) {
		this.nextEnd = nextEnd;
	}
	public Node getNode() {
		return node;
	}
	public void setNode(Node node) {
		this.node = node;
	}
	public TestAna() {
	}

	public TestAna(String src) {
		this.src = src;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	@Override
	public String toString() {
		return "TestAna [src=" + src + ", prevEnd=" + prevEnd
				+ ", nextEnd=" + nextEnd + ", node=" + node + "]";
	}
	
}
