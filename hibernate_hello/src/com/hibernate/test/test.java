package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.hibernate.entity.User;


/**
 * 测试类
 * @author tang
 *
 */
public class test {

	public static void main(String[] args) {
		/*
		 * 1.新建Configuration对象
		 * 2.通过Configuration创建SessionFactory对象
		 * 3.通过SessionFactory得到Session
		 * 4.通过sesion对象得到Transaction对象
		 * 5.保存数据
		 * 6.提交事物
		 * 7.关闭session
		 * */
		
		// 1 新建Configuration对象
		Configuration cfg = new Configuration().configure();
		// 2 通过Configuration创建SessionFactory对象
		// 在hibernate3.x 中是这种写法
		//SessionFactory sf = cfg.buildSessionFactory();
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		SessionFactory sf = cfg.buildSessionFactory(sr);
		// 3 通过SessionFactory得到Session
		Session session = sf.openSession();
		// 4 通过sesion对象得到Transaction对象
		Transaction ts = session.beginTransaction();
		// 5 保存数据
		User user = new User();
		user.setUname("小明");
		user.setUpwd("123456");
		user.setUemail("397900806@qq.com");
		session.save(user);//将user对象存储到session中
		// 6 提交事物
		ts.commit();
		// 7 关闭session
		session.close();
	}
}
