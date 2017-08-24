package cn.ordermanage.dao;

import java.util.List;

import cn.ordermanage.entity.OrderItems;

/**
 * 订单明细接口类
 * @author tang
 *
 */
public interface IOrderItemsDao {

	public void save(OrderItems transientInstance);
	
	public void deleteById(int id);
	
	public OrderItems findById(int id);
	
	public List<OrderItems> select(int id);
}
