package cn.hibernate.createdb;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import cn.hibernate.entity.Score;
import cn.hibernate.entity.ScoreId;
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
			
			Score s = new Score();
			ScoreId sid = new ScoreId();
			sid.setStuId(2);
			sid.setSubjectId(6);
			s.setScoreId(sid);
			s.setResult(89);
			
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
}
