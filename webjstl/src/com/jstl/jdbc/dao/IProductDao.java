package com.jstl.jdbc.dao;

import java.util.List;

import com.eight.entity.Product;

/**
 * ��ѯ������Ʒ��Ϣ
 * @author tang
 *
 */
public interface IProductDao {

	public List<Product> selectProductAll();
}
