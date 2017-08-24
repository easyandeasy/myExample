package cn.ordermanage.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 订单明细类
 * @author tang
 *
 */
public class OrderItems implements Serializable{

	private int id;//订单明细编号
	private int amount = 1;//商品数量
	private int orders_id;
	private int goods_id;
	private Goods goods;//商品对象
	private Orders orders;//订单对象
	
	public OrderItems(int id, int amount, int orders_id, int goods_id) {
		this.id = id;
		this.amount = amount;
		this.orders_id = orders_id;
		this.goods_id = goods_id;
	}
	public OrderItems() {}
	
	
	public int getOrders_id() {
		return orders_id;
	}
	public void setOrders_id(int orders_id) {
		this.orders_id = orders_id;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}

	public Orders getOrders() {
		return orders;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
