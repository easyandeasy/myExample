package cn.ordermanage.daoimpl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.hibernate.dao.HibernateDao;
import cn.hibernate.util.HibernateUtils;
import cn.ordermanage.dao.IOrdersDao;
import cn.ordermanage.entity.Orders;

/**
 * 订单实现类
 * @author tang
 *
 */
public class OrdersDaoImpl extends HibernateDao implements IOrdersDao {

	public void save(Orders transientInstance) {
		Session session = getSession();
		Transaction tx = session.beginTransaction();;
		try {
			session.save(transientInstance);
			tx.commit();
			session.flush();
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			e.printStackTrace();
			throw e;
		}finally{
			closeSession();
		}
	}

	public void deleteById(int id) {
		
	}

	public Orders findById(int id) {
		return (Orders)getSession().get(Orders.class, id);
	}
	
	public List<Orders> findOrder(int id) {
		return HibernateUtils.getSession().createQuery("from Orders o where o.id=:id").setParameter("id", id).list();
	}

}
