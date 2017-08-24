package cn.hibernate.test;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.hibernate.beans.Employee;
import cn.hibernate.beans.Project;
import cn.hibernate.utils.HibernateSessionFactory;

public class Tests {

	private Transaction tx;

	//保存
	@Test
	public void test01() {
		try {
			Session session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			// 创建两个员工
			Employee emp = new Employee("admin");
			Employee emp2 = new Employee("tang");
			// 两个项目
			Project pro1 = new Project("java");
			Project pro2 = new Project("ajax");

			emp.getProSet().add(pro1);
			emp.getProSet().add(pro2);
				
			session.save(emp);
			session.save(emp2);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}
	
	//删除、修改
	@Test
	public void test02() {
		try {
			Session session = HibernateSessionFactory.getSession();
			tx = session.beginTransaction();
			// 获取数据库中的一个员工
			Employee emp = (Employee) session.load(Employee.class, 1);
			//修改员工姓名
			emp.setEname("admin");
			
			//获取数据库中的一个项目
			Project pro = (Project) session.load(Project.class, 1);
			//将员工中的项目删除
			emp.getProSet().remove(pro);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}
	
	//查询
	@Test
	public void test03() {
		try {
			Session session = HibernateSessionFactory.getSession();
			// 获取数据库中的一个员工
			Employee emp = (Employee) session.load(Employee.class, 1);
			Set<Project> pro = emp.getProSet();
			Iterator<Project> it = pro.iterator();
			System.out.println("员工姓名： " +emp.getEname() + "，参加了以下项目：");
			while(it.hasNext()) {
				Project p = it.next();
				System.out.println(p.getPid() + "\t" + p.getPname());
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			HibernateSessionFactory.closeSession();
		}
	}
	
	
}
