package cn.ordermanage.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import cn.ordermanage.entity.Goods;
import cn.ordermanage.entity.OrderItems;
import cn.ordermanage.entity.Orders;
import cn.ordermanage.service.IGoodsService;
import cn.ordermanage.service.IOrderItemsService;
import cn.ordermanage.service.IOrdersService;
import cn.ordermanage.serviceimpl.GoodsServiceImpl;
import cn.ordermanage.serviceimpl.OrderItemsServiceImpl;
import cn.ordermanage.serviceimpl.OrdersServiceImpl;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class OrdersAction extends ActionSupport {

	private List<Orders> orders;
	private Orders order;
	private String[] gidss;
	private String gids;
	private int orderid;
	private int[] amounts;
	private List<Goods> goods = new ArrayList<Goods>();
	private IGoodsService gs = new GoodsServiceImpl();
	private IOrdersService os = new OrdersServiceImpl();
	private IOrderItemsService ois = new OrderItemsServiceImpl();
	private double totalprice;
	private String message;

	public String preOrder() {
		if(gidss == null) this.setGidss(this.getGids().split(", "));
		for(String gid:gidss) {
			goods.add(gs.findById(Integer.parseInt(gid.toString())));
		}
		return SUCCESS;
	}

	/**
	 * 获取所有商品信息
	 * @return
	 */
	public String goods() {
		goods = gs.findAll();
		return SUCCESS;
	}

	public String order() {
		if(gidss == null || amounts == null ) return INPUT;
		if(gidss.length != amounts.length) return INPUT;
		if(order == null) return INPUT;
		
		int length = gidss.length;
		//设定订购商品的数量
		
		for(int i = 0 ;i<length;i++) {
			OrderItems oi = new OrderItems();
			Goods gd = gs.findById(Integer.parseInt(gidss[i]));
			goods.add(gd);
			oi.setAmount(amounts[i]);
			oi.setGoods_id(gd.getId());
			oi.setOrders_id(order.getId());
			oi.setOrders(order);
			oi.setGoods(gd);
			order.getOrderitems().add(oi);
		}
		order.setDates(new Date());//当前时间
		os.save(order);//添加订单
		//System.out.println(os);
		//System.out.println(order.getId()+"\t"+order.getAddress()+"\t"+order.getName()+"\t"+order.getDates());
		//获取订单的内容
		//order = os.findById(id);
		totalprice = this.getTatalPriceByOrders(order);
		return SUCCESS;
	}

	public double getTatalPriceByOrders(Orders order) {
		double total = 0.0;
		for(OrderItems oi:order.getOrderitems()) {
			total += oi.getAmount() * oi.getGoods().getPrice();
		}
		return total;
	}
	
	public String orderitems() {
		if(orderid == 0) return "input";
		List<Orders> list = os.findOrders(orderid);//os.findById(orderid);//查询订单
		for (Orders orders : list) {
			order = orders;
			System.out.println(orders.getName()+"\t"+orders.getAddress());
		}
		System.out.println(order.getOrderitems().size());
		/*if(order == null) return "input";
		List<OrderItems> items = ois.select();
		for (OrderItems o : items) {
			System.out.println(o.getAmount()+"------"+o.getGoods_id()+"------"+o.getOrders_id());
		}*/
		/*Iterator it = items.iterator();
		while(it.hasNext()) {
			OrderItems item = (OrderItems)it.next();
			goods.add(item.getGoods());
			amounts[item.getOrders().getId()-1] = item.getAmount();
		}*/
		return Action.SUCCESS;
	}

	public String[] getGidss() {
		return gidss;
	}

	public void setGidss(String[] gidss) {
		this.gidss = gidss;
	}

	public void setGids(String gids) {
		this.gids = gids;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public int getOrderid() {
		return orderid;
	}

	public String getGids() {
		return gids;
	}


	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int[] getAmounts() {
		return amounts;
	}

	public void setAmounts(int[] amounts) {
		this.amounts = amounts;
	}

	public List<Goods> getGoods() {
		return goods;
	}

	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}

	public IGoodsService getGs() {
		return gs;
	}

	public void setGs(IGoodsService gs) {
		this.gs = gs;
	}

	public IOrdersService getOs() {
		return os;
	}

	public void setOs(IOrdersService os) {
		this.os = os;
	}

	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


}
