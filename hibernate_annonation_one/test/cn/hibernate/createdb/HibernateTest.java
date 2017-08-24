package cn.hibernate.createdb;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import cn.hibernate.entity.Book;
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
		Book b = new Book();
		b.setName("青支志");
		b.setPrice(52.5);
		b.setPuDate(new Date());
		b.setAuthor("刘青");
		HibernateUtil.save(b);
	}
	
	@Test
	public void test() throws Exception {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			Book b = (Book)session.get(Book.class, 1);
			System.out.println(b.getName() + "\t" + b.getPrice());
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
