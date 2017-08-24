package cn.hibernate.createdb;



import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import cn.hibernate.util.HibernateUitl;
import cn.ordermanage.entity.Goods;

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
			
			Goods g = new Goods();
			g.setPrice(108.0);
			g.setName("Java编程思想");
			g.setSpecification("本书赢得全球程序员的广泛赞誉");
			g.setManufcturer("机械工程出版社");
			
			Goods gg = new Goods();
			gg.setPrice(98.0);
			gg.setName("Java核心技术");
			gg.setSpecification("针对Java SE6平台进行了全面更新，涵盖Java语言核心内容");
			gg.setManufcturer("机械工程出版社");
			
			Goods ggg = new Goods();
			ggg.setPrice(68.0);
			ggg.setName("Java经典实例");
			ggg.setSpecification("本书对于Java开发人员而言是理想的“第二本书”讲述API比一般书籍要详细，非常适合扩大Java应用的知识面");
			ggg.setManufcturer("中国电力出版社");
			
			session.save(g);
			session.save(gg);
			session.save(ggg);
			
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
			Goods g = (Goods)session.get(Goods.class, 1);
			System.out.println(g.getName());
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
