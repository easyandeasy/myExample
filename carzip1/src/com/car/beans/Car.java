package com.car.beans;

public class Car {

	private Integer cid;
	private String ctype; 
	private String cname;
	private String ccolor;
	private double cprice;
	private String ccard;
	private Integer cstatus;
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCcolor() {
		return ccolor;
	}
	public void setCcolor(String ccolor) {
		this.ccolor = ccolor;
	}
	public double getCprice() {
		return cprice;
	}
	public void setCprice(double cprice) {
		this.cprice = cprice;
	}
	public String getCcard() {
		return ccard;
	}
	public void setCcard(String ccard) {
		this.ccard = ccard;
	}
	public Integer getCstatus() {
		return cstatus;
	}
	public void setCstatus(Integer cstatus) {
		this.cstatus = cstatus;
	}
	public Car(Integer cid, String ctype, String cname, String ccolor, double cprice, String ccard, Integer cstatus) {
		this.cid = cid;
		this.ctype = ctype;
		this.cname = cname;
		this.ccolor = ccolor;
		this.cprice = cprice;
		this.ccard = ccard;
		this.cstatus = cstatus;
	}
	public Car() {
		super();
	}
	
}
