package cn.hibernate.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.hibernate.entity.StudentHomeAddress;
import cn.hibernate.entity.StudentInfo;
import cn.hibernate.util.HibernateUtil;

public class Tests {

	private Session session;
	private Transaction tx;

	@Test
	public void test01() {
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			StudentInfo info = new StudentInfo("小明");
			StudentHomeAddress home = new StudentHomeAddress();
			home.setShomeCity("宁波");
			home.setShomeProvince("浙江");
			home.setShomeZipCode("321000");
			home.setShomeStreet("科技园北路");
			info.setShome(home);
			home.setStudentInfo(info);
			session.save(info);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	
	
}
