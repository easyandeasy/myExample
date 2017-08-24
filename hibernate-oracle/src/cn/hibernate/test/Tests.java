package cn.hibernate.test;

import java.util.List;

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
			tx = session.beginTransaction();
			Students stu = new Students("寮犱笁");
			Students stu1 = new Students("鐜嬩簲");
			Students stu2 = new Students("璧靛叚");
			Students stu3 = new Students("鐢颁竷");
			Students stu4 = new Students("鍒樺叓");
			
			session.save(stu1);
			session.save(stu2);
			session.save(stu3);
			session.save(stu4);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	// 浣跨敤鑱氬悎鍑芥暟杩涜鏌ヨ  count銆乻um銆乵in銆乵ax銆乤vg
	@Test
	public void test02() {
		try {
			session = HibernateUtil.getSession();
			//  count
			Object count = session.createQuery("select count(s.sid) from Students s").uniqueResult();
			System.out.println("鎬昏褰曚负鏄細"+ count);
			
			// sum
			Object sum = session.createQuery("select sum(s.sid) from Students s").uniqueResult();
			System.out.println("sid鐨勬�鍜屾槸锛"+ sum);
			
			// min
			Object min = session.createQuery("select min(s.sid) from Students s").uniqueResult();
			System.out.println("sid鐨勬渶灏忓�鏄細"+ min);
			
			// max
			Object max = session.createQuery("select max(s.sid) from Students s").uniqueResult();
			System.out.println("sid鐨勬渶澶у�鏄細"+ max);
			
			// avg
			Object avg = session.createQuery("select avg(s.sid) from Students s").uniqueResult();
			System.out.println("sid鐨勫钩鍧囧�鏄細"+ avg);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	// 浣跨敤鍒嗙粍杩涜鏌ヨ  group by
	@Test
	public void test03() {
		try {
			session = HibernateUtil.getSession();
			//  count
			List<Object[]> stu = session.createQuery("select s.sclass,count(s.sid) from Students s group by s.sclass").list();
			for (Object[] obj : stu) {
				System.out.println(obj[0] + "鐨勪汉鏁帮細" + obj[1]);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}
}
