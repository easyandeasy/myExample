package cn.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import cn.ordermanage.entity.Goods;

/**
 * hibernate工具类
 * @author tang
 *
 */
public class HibernateUtils {

	private static Configuration cfg = null;
	private static SessionFactory factory = null;
	private static Session session = null;
	
	static {
		cfg = new Configuration().configure();
		factory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build());
	}
	
	public static Session getSession() {
		if(factory != null) {
			return session = factory.openSession();
		}else{
			factory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(cfg.getProperties())
					.build());
		}
		return session = factory.openSession();
	}
	
	public static void closeSession() {
		if(session != null && session.isOpen()){
			session.close();
		}
	}
	
	public static void save(Object obj) {
		Transaction tx = null;
		try {
			tx = getSession().beginTransaction();
			getSession().save(obj);
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			e.printStackTrace();
			throw e;
		}finally{
			closeSession();
		}
	}
	
}
