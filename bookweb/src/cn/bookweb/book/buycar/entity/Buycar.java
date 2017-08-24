package cn.bookweb.book.buycar.entity;
/**
 * 购物车实体类
 * @author Happy
 *
 */
public class Buycar {
	private String bname;//图书名称
	private double price;//图书价格
	private String imagesmall;//图书图片
	private String numbertity;//图书数量
	private int uid;//用户编号
	private int bid;//图书编号
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImagesmall() {
		return imagesmall;
	}
	public void setImagesmall(String imagesmall) {
		this.imagesmall = imagesmall;
	}
	public String getNumbertity() {
		return numbertity;
	}
	public void setNumbertity(String numbertity) {
		this.numbertity = numbertity;
	}
}
