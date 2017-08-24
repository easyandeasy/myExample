package cn.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * hibernate工具类
 * @author tang
 *
 */
public class HibernateUtil {

	private static Configuration cfg = null;
	private static SessionFactory factory = null;
	private static Session session = null;
	
	static {
		cfg = new Configuration().configure();
		factory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(cfg.getProperties())
					.build());
	}
	
	public static Session getSession() {
		if(factory != null) {
			return factory.openSession();
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
		Session session = null;
		Transaction tx = null;
		try {
			session = getSession();
			tx = session.beginTransaction();
			session.save(obj);
			tx.commit();
			session.flush();//刷新缓存，从游离转换成持久
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
