package cn.ordermanage.serviceimpl;

import java.util.List;

import cn.ordermanage.dao.IOrdersDao;
import cn.ordermanage.daoimpl.OrdersDaoImpl;
import cn.ordermanage.entity.Orders;
import cn.ordermanage.service.IOrdersService;

/**
 * 订单业务实现类
 * @author tang
 *
 */
public class OrdersServiceImpl implements IOrdersService{

	IOrdersDao dao = new OrdersDaoImpl();
	public void save(Orders orders) {
		 dao.save(orders);
	}

	public Orders findById(int id) {
		return dao.findById(id);
	}

	public List<Orders> findOrders(int id) {
		return dao.findOrder(id);
	}
}
