package com.jstl.jdbc.dao;

import java.util.List;

import com.eight.entity.Product;

/**
 * 查询所有商品信息
 * @author tang
 *
 */
public interface IProductDao {

	public List<Product> selectProductAll();
}
