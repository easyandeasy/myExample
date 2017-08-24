package cn.ordermanage.service;

import java.util.List;

import cn.ordermanage.entity.Goods;

/**
 * 商品业务接口类
 * @author tang
 *
 */
public interface IGoodsService {
	
	public void save(Goods goods);

	public List<Goods> findAll();
	
	public Goods findById(int id);
}
