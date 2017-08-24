package cn.ordermanage.serviceimpl;

import java.util.List;

import cn.ordermanage.dao.IGoodsDao;
import cn.ordermanage.daoimpl.GoodsDaoImpl;
import cn.ordermanage.entity.Goods;
import cn.ordermanage.service.IGoodsService;

/**
 * 商品业务实现类
 * @author tang
 *
 */
public class GoodsServiceImpl implements IGoodsService{
	
	IGoodsDao dao = new GoodsDaoImpl();
	

	public void save(Goods goods) {
		dao.save(goods);
	}

	public List<Goods> findAll() {
		return dao.findAll();
	}

	public Goods findById(int id) {
		return dao.findById(id);
	}
}
