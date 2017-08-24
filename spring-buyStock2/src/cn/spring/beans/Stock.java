package cn.spring.beans;


public class Stock {

	private Integer sid;
	private String sname;//
	private int amount;//
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Stock() {
		super();
	}
	public Stock(String sname, int amount) {
		super();
		this.sname = sname;
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Stock [sid=" + sid + ", sname=" + sname + ", amount=" + amount + "]";
	}
	
}
