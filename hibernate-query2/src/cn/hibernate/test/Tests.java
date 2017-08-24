package cn.hibernate.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.jdbc.Work;
import org.junit.Test;

import cn.hibernate.beans.Student;
import cn.hibernate.util.HibernateUtil;

public class Tests {

	private Session session;
	private Transaction tx;

	@Test
	public void test01() {
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			Student stu = new Student("tang");
			Student stu1 = new Student("jing");
			Student stu2 = new Student("admin");
			Student stu3 = new Student("jack");
			
			session.save(stu);
			session.save(stu1);
			session.save(stu2);
			session.save(stu3);
			
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
			tx = session.beginTransaction();
			Work work = new Work(){
				@Override
				public void execute(Connection conn) throws SQLException {
					
					String sql = "update Student set name = ? where id < ?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, "abc");
					ps.setInt(2, 6);
					ps.executeUpdate();
				}
			};
			session.doWork(work);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	@Test
	public void test03() {
		try {
			session = HibernateUtil.getSession();
			Object count = session.createQuery("select id from Student s where id = 1").uniqueResult();
			System.out.println(count.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}
}
