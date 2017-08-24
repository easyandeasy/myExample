package cn.spring.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class StockDaoImpl extends JdbcDaoSupport implements IStockDao {

	public void insertStock(String sname, int amount) {
		String sql = "insert into stock(sname,amount) values(?,?)";
		this.getJdbcTemplate().update(sql , sname,amount);
	}

	public void updateStock(String sname, int amount,boolean isBuy) {
		String sql = "update stock set amount=amount-? where sname=?";
		if(isBuy) {
			sql = "update stock set amount=amount+? where sname=?";
		}
		this.getJdbcTemplate().update(sql,amount,sname);
	}

}
