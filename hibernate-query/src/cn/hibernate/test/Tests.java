package cn.hibernate.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

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
	
	//浣跨敤JDBC API 杩涜鎵归噺鎿嶄綔
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
					ps.setInt(2, 5);
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
	
	
	//鎵归噺鎻掑叆鏁版嵁
	@Test
	public void test03() {
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			
			String hql = "insert into Student(name) select name || '鎵归噺鎻掑叆' from Student where id < :id ";
			int row = session.createQuery(hql).setParameter("id", 5).executeUpdate();
			System.out.println("鍙楀奖鍝嶇殑琛屾暟鎹槸" + row);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	
	//鎵归噺鏇存柊鏁版嵁
	@Test
	public void test04() {
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			
			String hql = "update Student set name = :name where id > :id";
			int row = session.createQuery(hql).setParameter("name", "鏇存柊鏁版嵁").setParameter("id", 5).executeUpdate();
			System.out.println("鍙楀奖鍝嶇殑琛屾暟鎹槸锛�"+ row);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	
	//鎵归噺鍒犻櫎鏁版嵁
	@Test
	public void test05() {
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			
			String hql = "delete Student where id > :id";
			int row = session.createQuery(hql).setParameter("id", 10).executeUpdate();
			System.out.println("鍙楀奖鍝嶇殑琛屾暟鎹槸锛" + row);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	
	
	//鎵归噺鏇存柊鏁版嵁
	@Test
	public void test06() {
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			/*
			String hql = "from Student where id > :id";
			List<Student> list = session.createQuery(hql).setParameter("id", 5).list();
			for (Student student : list) {
				System.out.println(student.getName());
			}
			*/
			String hql = "select count(id) from Student";
			Object count = session.createQuery(hql).uniqueResult();
			System.out.println(count);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
}
