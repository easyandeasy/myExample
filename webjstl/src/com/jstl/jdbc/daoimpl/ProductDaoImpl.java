package com.jstl.jdbc.daoimpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.eight.entity.Product;
import com.jdbc.baseDao.BaseDao;
import com.jstl.jdbc.dao.IProductDao;

public class ProductDaoImpl extends BaseDao implements IProductDao {
	
	public static void main(String[] args){
		IProductDao dao = new ProductDaoImpl();
		List<Product> product = dao.selectProductAll();
		for(Product p : product){
			System.out.print(p.getName());
		}
	}

	public List<Product> selectProductAll(){
		List<Product> list = new ArrayList();
		String sql = "SELECT pid,pname,pdizi,pmoney FROM product";
		rs = executeQuerySQL(sql, null);
		try {
			while(rs.next()){
				Product pro = new Product();
				pro.setName(rs.getString("pname"));
				pro.setArea(rs.getString("pdizi"));
				pro.setPrice(rs.getDouble("pmoney"));
				list.add(pro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
