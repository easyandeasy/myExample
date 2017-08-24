package cn.sh.dao.impl;

import java.util.List;

import org.junit.Test;

import cn.hibernate.util.HibernateUtil;
import cn.sh.bean.User;
import cn.sh.dao.LoginDao;

public class LoginDaoImpl implements LoginDao {


	public Object isLogin(User user) {
		String hql = "select id from User u where u.name = :name and u.pwd = :pwd";
		System.out.println(user.getName()+"\t"+user.getPwd());
		Object count = HibernateUtil.getSession().createQuery(hql).
				setParameter("name", user.getName()).
				setParameter("pwd", user.getPwd()).uniqueResult();
		return count;
	}
	
	@Test
	public void test() {
		String hql = "from User";
		System.out.println(HibernateUtil.getSession());
		User user = (User) HibernateUtil.getSession().get(User.class, 1);
		System.out.println(user);
	}

}


