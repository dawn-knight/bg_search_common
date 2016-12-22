package com.mbgo.search.util.bean;
/** 
 * @author 吴健  (HQ01U8435)	Email : wujian@metersbonwe.com 
 * @version 创建时间：2013-6-13 下午4:10:50 
 */
public class Range {

	private int left = -1;
	private int right = -1;
	private int count = 0;
	public Range() {
	}
	public Range(int left, int right) {
		super();
		this.left = left;
		this.right = right;
	}
	public Range(String pin, long c) {
		super();
		this.count = (int) c;
		int sp = pin.indexOf("-");
		this.left = Integer.parseInt(pin.substring(0, sp));
		this.right = Integer.parseInt(pin.substring(sp + 1));
	}
	public int getLeft() {
		return left;
	}
	public void setLeft(int left) {
		this.left = left;
	}
	public int getRight() {
		return right;
	}
	public void setRight(int right) {
		this.right = right;
	}
	public String toString() {
		return left + "-" + right;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + left;
		result = prime * result + right;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Range other = (Range) obj;
		if (left != other.left)
			return false;
		if (right != other.right)
			return false;
		return true;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Range merge(Range no) {
		if(no == null || no.left == -1 || no.right == -1) {
			return this;
		}
		Range r = new Range();
		r.setLeft(Math.min(this.left, no.left));
		r.setRight(Math.max(this.right, no.right));
		r.setCount(this.count + no.count);
		return r;
	}
	public boolean isValidate() {
		return left >= 0 && right > 0 && count > 0;
	}
}
