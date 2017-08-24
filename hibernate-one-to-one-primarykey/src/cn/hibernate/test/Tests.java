package cn.hibernate.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.hibernate.entity.Archives3;
import cn.hibernate.entity.User3;
import cn.hibernate.util.HibernateUtil;

public class Tests {

	private Session session;
	private Transaction tx;

	@Test
	public void test01() {
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			User3 u = new User3("小杂","123456");
			Archives3 v = new Archives3("管理员","admin");
			u.setArchives(v);
			v.setUser(u);
			session.save(v);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	
	
	
	@Test
	public void test02() {
		try {
			session = HibernateUtil.getSession();
		/*	User3 user = session.get(User3.class, 2);
			System.out.println(user.getArchives().getAname());*/
			
			Archives3 a = session.get(Archives3.class, 2);
			System.out.println(a.getUser().getUname());
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}
}
