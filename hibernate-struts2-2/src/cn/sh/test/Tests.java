package cn.sh.test;

import java.util.List;

import org.junit.Test;

import cn.sh.utils.HibernateSessionFactory;
import cn.sh.bean.User;

public class Tests {

	@Test
	public void test() {
		String hql = "from User";
		System.out.println(HibernateSessionFactory.getSession());
		List<User> list = HibernateSessionFactory.getSession().createQuery(hql).list();
		for (User user : list) {
			System.out.println(user);
		}
	}
}
