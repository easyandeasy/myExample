package cn.ordermanage.serviceimpl;

import java.util.List;

import org.hibernate.Query;

import cn.ordermanage.dao.IOrderItemsDao;
import cn.ordermanage.daoimpl.OrderItemsDaoImpl;
import cn.ordermanage.entity.OrderItems;
import cn.ordermanage.service.IOrderItemsService;

public class OrderItemsServiceImpl implements IOrderItemsService{

	IOrderItemsDao dao = new OrderItemsDaoImpl();
	
	public void save(OrderItems orderitems) {
		dao.save(orderitems);
	}
	
	public List<OrderItems> select(int id) {
		return dao.select(id);
	}
}
