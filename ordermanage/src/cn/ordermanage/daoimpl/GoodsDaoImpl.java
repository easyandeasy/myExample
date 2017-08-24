package cn.ordermanage.daoimpl;

import java.util.List;

import org.hibernate.Query;

import cn.hibernate.dao.HibernateDao;
import cn.ordermanage.dao.IGoodsDao;
import cn.ordermanage.entity.Goods;

import com.sun.org.apache.commons.logging.Log;
import com.sun.org.apache.commons.logging.LogFactory;

/**
 * 商品实现类
 * @author tang
 *
 */
public class GoodsDaoImpl extends HibernateDao implements IGoodsDao{

	private static final Log log = LogFactory.getLog(GoodsDaoImpl.class);
	
	public void save(Goods goods) {
		getSession().save(goods);
	}
	
	public Goods findById(int id) {
		try {
			Goods instance = (Goods)getSession().get(Goods.class, id);
			return instance;
		} catch (RuntimeException e) {
			log.error("get Goods failed", e);
			throw e;
		} finally {
			closeSession();
		}
	}
	
	
	public List<Goods> findAll() {
		try {
			String queryString = "from Goods";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException e) {
			log.error("find all Goods failed", e);
			throw e;
		} finally {
			closeSession();
		}
	}

	
}
