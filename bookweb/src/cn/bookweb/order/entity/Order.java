package cn.bookweb.order.entity;

import java.util.ArrayList;
import java.util.List;

import cn.bookweb.book.buycar.entity.Buycar;

/**
 * 订单表实体类
 * @author Happy
 *
 */
public class Order {
	
	private int oid;//订单序号
	private String onumber;//订单编号
	private String ordertime;//下单时间
	private double total;	//价格
	private int ostatus;	//订单状态
	private int aid;	//订单对应地址表的地址id
	private int uid;	//订单所属主人id
	
	private List<ImageSmall> litsImage=new ArrayList<ImageSmall>();
	
	public List<ImageSmall> getLitsImage() {
		return litsImage;
	}
	public void setLitsImage(List<ImageSmall> litsImage) {
		this.litsImage = litsImage;
	}
	private List<Buycar> buycarList;
	
	private List<OrderInfo> buycarOrderInfoList;
	
	public List<OrderInfo> getBuycarOrderInfoList() {
		return buycarOrderInfoList;
	}
	public void setBuycarOrderInfoList(List<OrderInfo> buycarOrderInfoList) {
		this.buycarOrderInfoList = buycarOrderInfoList;
	}
	public List<Buycar> getOrderInfoList() {
		return buycarList;
	}
	public void setOrderInfoList(List<Buycar> BuycarList) {
		BuycarList = buycarList;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getOnumber() {
		return onumber;
	}
	public void setOnumber(String onumber) {
		this.onumber = onumber;
	}
	public String getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getOstatus() {
		return ostatus;
	}
	public void setOstatus(int ostatus) {
		this.ostatus = ostatus;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
}
