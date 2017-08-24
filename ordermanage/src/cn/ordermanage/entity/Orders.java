package cn.ordermanage.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * 订单类
 * @author tang
 *
 */
public class Orders implements Serializable{

	private int id;//订单号
	private String name;//收货人
	private String address;//收货地址
	private Date dates ;//订单创建时间
	
	private List<OrderItems> orderitems = new ArrayList<OrderItems>();
	

	public Orders() {}
	
	public Orders(int id, String name, String address, Date dates) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.dates = dates;
	}
	public Date getDates() {
		return dates;
	}
	public void setDates(Date dates) {
		this.dates = dates;
	}
	public List<OrderItems> getOrderitems() {
		return orderitems;
	}
	public void setOrderitems(List<OrderItems> orderitems) {
		this.orderitems = orderitems;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
