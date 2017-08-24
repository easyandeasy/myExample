package cn.spring.beans;


public class Account {

	private Integer aid;
	private String aname;//
	private double money;//
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public Account(String aname, double money) {
		super();
		this.aname = aname;
		this.money = money;
	}
	public Account() {
		super();
	}
	@Override
	public String toString() {
		return "Account [aid=" + aid + ", aname=" + aname + ", money=" + money + "]";
	}
	
}
