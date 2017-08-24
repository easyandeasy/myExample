package cn.ssh.service;

import javax.annotation.Resource;
import javax.xml.ws.ServiceMode;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ssh.beans.User;

//@Controller(value="testService")
@Service	// 该注解用于业务层
public class TestService {

	@Resource
	private SessionFactory sessionFactory;
	
	@Transactional
	public void saveUser(){
		Session session = sessionFactory.getCurrentSession();
		User user = new User();
		user.setName("lucy");
		user.setPwd("lucy");
		session.save(user);
		//int a = 1 / 0;//测试事物
		session.save(user);
	}
}
