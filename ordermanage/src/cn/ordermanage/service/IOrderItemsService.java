package cn.ordermanage.service;

import java.util.List;

import cn.ordermanage.entity.OrderItems;

public interface IOrderItemsService {

	public void save(OrderItems orderitems);
	
	public List<OrderItems> select(int id);
}
