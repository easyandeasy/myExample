package cn.ordermanage.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * 订单类
 * @author tang
 *
 */
@Entity
@Table
public class Orders implements Serializable{

	@Id
	private int id;//订单号
	private String name;//收货人
	private String address;//收货地址
	private String dates;//订单创建时间
	@OneToMany(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn(name="orders_id")
	private List<OrderItems> orderitems = new ArrayList<OrderItems>();

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
	public String getDates() {
		return dates;
	}
	public void setDates(String dates) {
		this.dates = dates;
	}
}
