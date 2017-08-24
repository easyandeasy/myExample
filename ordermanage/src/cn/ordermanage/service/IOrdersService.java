package cn.ordermanage.service;

import java.util.List;

import cn.ordermanage.entity.Orders;

/**
 * 订单业务接口类
 * @author tang
 *
 */
public interface IOrdersService {

	public void save(Orders orders);
	
	public Orders findById(int id);
	
	public List<Orders> findOrders(int id);
}
