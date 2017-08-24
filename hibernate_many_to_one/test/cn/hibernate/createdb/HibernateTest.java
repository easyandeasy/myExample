package cn.hibernate.createdb;

import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import cn.hibernate.entity.Grade;
import cn.hibernate.entity.Student;
import cn.hibernate.util.HibernateUitl;

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
			session = HibernateUitl.getSession();
			tx = session.beginTransaction();
			
			Grade g = new Grade();
			Student s = new Student();
			g.setName("一年级");
			session.save(g);
			s.setName("小张");
			s.setAge(21);
			s.setGrade(g);
			session.save(s);
			g.setName("二年级");
			session.save(g);
			s.setName("小李");
			s.setAge(23);
			s.setGrade(g);
			session.save(s);
			tx.commit();
		} catch (Exception e) {
			if(tx != null)
				tx.rollback();
			e.printStackTrace();
			throw e;
		}finally{
			HibernateUitl.closeSession();
		}
	}
	
	@Test
	public void test() throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUitl.getSession();
			tx = session.beginTransaction();
			Student stu = (Student)session.get(Student.class, 1);//获取学生对象
			System.out.println(stu.getName()+"======="+stu.getGrade().getName());
		
			tx.commit();
		} catch (Exception e) {
			if(tx != null)
				tx.rollback();
			e.printStackTrace();
			throw e;
		}finally{
			HibernateUitl.closeSession();
		}
	}
}
