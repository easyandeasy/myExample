package cn.hibernate.test;

import java.util.List;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.hibernate.beans.Students;
import cn.hibernate.util.HibernateUtil;

public class Tests {

	private Session session;
	
	@Before
	public void before() {
		session = HibernateUtil.getSession();
	}
	
	@After
	public void after() {
		HibernateUtil.closeSession();
	}
	@Test
	public void test01() {
		//ԭsql����ѯ һ�����ص��Ƕ�������
		String sql = "select * from students";
		List<Object[]> list = session.createSQLQuery(sql).list();
		for (Object[] objects : list) {
			System.out.println(objects[0] + "\t" + objects[1]);
		}
	}
	
	@Test
	public void save() {
		session.beginTransaction();
		Students stu = new Students("����");
		session.save(stu);
		session.beginTransaction().commit();
	}
	
	
	//��һ�ַ�ʽ��ѯ
	@Test
	public void test02() {
		
		//����������ѯ��HQL
		List<Students> hql = session.getNamedQuery("hqlQueryStudent").list();
		//List<Students> hql = session.createQuery("from Students").list();
		for (Students stu : hql) {
			System.out.println(stu.getSid() + " \t " + stu.getSname());
		}
		System.out.println("===============================================");
		
		//ע��������ѯ��SQL
		List<Students> sql = session.getNamedQuery("sqlQueryStudent").list();
		for (Students obj : sql) {
			System.out.println(obj.getSid() + " \t " + obj.getSname());
		}
	}
	
	//�ڶ��ַ�ʽ��ѯ
	@Test
	public void test03() {
		
		//����������ѯ��HQL
		List<Students> hql = session.getNamedQuery("hqlQueryStudents").list();
		for (Students stu : hql) {
			System.out.println(stu.getSid() + " \t " + stu.getSname());
		}
		System.out.println("===============================================");
		
		//ע��������ѯ��SQL
		List<Object[]> sql = session.getNamedQuery("sqlQueryStudents").list();
		for (Object[] obj : sql) {
			System.out.println(obj[0] + " \t " + obj[1]);
		}
	}
}
