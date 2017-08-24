package cn.sh.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.sh.bean.User;
import cn.sh.dao.LoginDao;
import cn.sh.utils.HibernateSessionFactory;

public class LoginDaoImpl implements LoginDao {


	private Transaction tx;

	public Object isLogin(User user) {
		String hql = "select id from User u where u.name = :name and u.pwd = :pwd";
		System.out.println(user.getName() + "\t" + user.getPwd());
		Object count =  HibernateSessionFactory.getSession().createQuery(hql).
				setParameter("name", user.getName()).
				setParameter("pwd", user.getPwd()).uniqueResult();
		return count;
	}
	
	
	public Object insertUser(User user) {
		Session session = HibernateSessionFactory.getSession();
		Object count;
		try {
			tx = session.beginTransaction();
			count = session.save(user);
			tx.commit();
			return count;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			HibernateSessionFactory.closeSession();
		}
		return null;
	}
	
	@Test
	public void test() {
		System.out.println(insertUser(new User("jackq","123")));
	}


	public Object insertUser(String name, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

}
