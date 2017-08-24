package cn.hibernate.createdb;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import cn.hibernate.entity.Address;
import cn.hibernate.entity.Teacher;
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
			
			Address s = new Address();
			Teacher t = new Teacher();
			t.setName("张三");
			t.setAge(22);
			s.setAddr1("地址1");
			s.setAddr2("地址2");
			s.setAddr3("地址3");
			t.setAddress(s);
			session.save(t);
			
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
