package cn.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * hibernate工具类
 * @author tang
 *
 */
public class HibernateUitl {

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
		return factory.openSession();
	}
	
	public static void closeSession() {
		if(session != null && session.isOpen()){
			session.close();
		}
	}
}
