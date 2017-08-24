package cn.hibernate.test;

import org.junit.Test;

import cn.hibernate.entity.Car2;
import cn.hibernate.entity.Carport2;
import cn.hibernate.util.HibernateUtil;

public class Tests {

	private Session session;
	private Transaction tx;

	@Test
	public void test01() {
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			Car2 car = new Car2("k123","中国品牌");
			Carport2 carport = new Carport2("湖南",200);
			car.setPort(carport);
			carport.setCar(car);
			session.save(carport);
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
			Car2 car = session.get(Car2.class, 2);
			System.out.println(car.getBrand());
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}
}
