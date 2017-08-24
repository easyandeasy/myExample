package cn.ordermanage.dao;

import java.util.List;

import cn.ordermanage.entity.Orders;

/**
 * 接口类
 * @author tang
 *
 */
public interface IOrdersDao {

	public void save(Orders transientInstance);
	
	public void deleteById(int id);
	
	public Orders findById(int id);
	
	public List<Orders> findOrder(int id);
}
