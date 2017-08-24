package cn.ordermanage.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import cn.hibernate.dao.HibernateDao;
import cn.hibernate.util.HibernateUtils;
import cn.ordermanage.dao.IOrderItemsDao;
import cn.ordermanage.entity.OrderItems;

/**
 * 订单明细实现类
 * @author tang
 *
 */
public class OrderItemsDaoImpl extends HibernateDao implements IOrderItemsDao{

	public void save(OrderItems transientInstance) {
		HibernateUtils.save(transientInstance);
	}

	public void deleteById(int id) {
		
	}

	public OrderItems findById(int id) {
		return (OrderItems)getSession().get(OrderItems.class, id);
	}
	
	public List<OrderItems> select(int id) {
		return getSession().createQuery("from OrderItems o where o.orders_id=:id").setParameter("id", id).list();
	}

}
