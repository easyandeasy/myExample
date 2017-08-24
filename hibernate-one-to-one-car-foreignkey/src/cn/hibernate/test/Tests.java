package cn.hibernate.test;

import org.junit.Test;

import cn.hibernate.entity.Car;
import cn.hibernate.entity.Carport;
import cn.hibernate.util.HibernateUtil;

public class Tests {

	private Session session;
	private Transaction tx;

	@Test
	public void test01() {
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			Car c = new Car("123","其他");
			Carport p = new Carport("上海",200);
			c.setPort(p);
			p.setCar(c);
			session.save(c);
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
			Car car = session.get(Car.class, 1);
			System.out.println(car.getBrand());
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}
}
