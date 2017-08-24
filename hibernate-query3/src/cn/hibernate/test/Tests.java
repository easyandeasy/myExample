package cn.hibernate.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.hibernate.beans.Students;
import cn.hibernate.util.HibernateUtil;

public class Tests {

	private Session session;
	private Transaction tx;

	@Test
	public void test01() {
		try {
			session = HibernateUtil.getSession();
			tx = session.getTransaction();
			
			Students stu = new Students();
			stu.setSname("张三");
			session.save(stu);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	//操作 Oracle数据库
	//聚合函数（count、sum、min、max、age）的使用
	@Test
	public void test02() {
		try {
			session = HibernateUtil.getSession();
			//count
			String hql = "select count(s.sid) from Student s";
			Long count = (Long) session.createQuery(hql).uniqueResult();
			System.out.println("学生的总人数据是：" + count);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}
}
