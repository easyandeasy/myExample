package cn.ordermanage.dao;

import java.util.List;

import cn.ordermanage.entity.Goods;

/**
 * 商品接口类
 * @author tang
 *
 */
public interface IGoodsDao {
	
	public void save(Goods goods);

	public Goods findById(int id);
	
	public List<Goods> findAll();
}
