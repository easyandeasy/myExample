package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import com.hibernate.entity.User;


public class TestException {
	public static void main(String[] args) {
		Configuration cfg = null;
		SessionFactory sf = null;
		Session session = null;
		Transaction tx = null;
		try{
			cfg = new Configuration().configure();
			ServiceRegistry registry = new StandardServiceRegistryBuilder()
			  					.applySettings(cfg.getProperties())
			  					.build();
			sf = cfg.buildSessionFactory(registry);
			session = sf.openSession();
			tx = session.beginTransaction();
			User u  = (User)session.get(User.class, 2);
			System.out.println("name="+u.getUname());
			tx.commit();
		}catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
			if(session!=null&&session.isOpen())
			session.close();
		}
	}
}
