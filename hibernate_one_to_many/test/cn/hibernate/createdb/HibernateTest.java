package cn.hibernate.createdb;

import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import cn.hibernate.entity.Grade;
import cn.hibernate.entity.Student;
import cn.hibernate.util.HibernateUtil;

/**
 * 创建表
 * @author tang
 *
 */
public class HibernateTest {

	@Test
	public void createDB() {
		Configuration cfg = new Configuration().configure();
		SchemaExport se = new SchemaExport(cfg);
		//第一个参数是否生成ddl脚本，第二个参数是否执行到数据库中
		se.create(true, true);
	}
	
	@Test
	public void sqlSave() throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			
			Grade g = new Grade();
			Student s = new Student();
			g.setName("一年级");
			session.save(g);
			s.setName("小张");
			s.setAge(21);
			g.getStudents().add(s);
			session.save(s);
			
			Grade g1 = new Grade();
			Student s1 = new Student();
			g1.setName("二年级");
			session.save(g1);
			s1.setName("小李");
			s1.setAge(23);
			g1.getStudents().add(s1);
			session.save(s1);
			tx.commit();
		} catch (Exception e) {
			if(tx != null)
				tx.rollback();
			e.printStackTrace();
			throw e;
		}finally{
			HibernateUtil.closeSession();
		}
	}
	
	@Test
	public void test() throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			Grade grade = (Grade)session.get(Grade.class, 1);//获取年级对象
			Iterator<Student> iter = grade.getStudents().iterator();
			System.out.println(grade.getName()+"的学生有：");
			for(;iter.hasNext();) {
				Student stu = iter.next();
				System.out.println(stu.getName());
			}
			tx.commit();
		} catch (Exception e) {
			if(tx != null)
				tx.rollback();
			e.printStackTrace();
			throw e;
		}finally{
			HibernateUtil.closeSession();
		}
	}
}
