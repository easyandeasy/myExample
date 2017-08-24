package cn.spring.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {

	public void insertAccount(String aname, double money) {
		String sql = "insert into account(aname,money) values(?,?)";
		this.getJdbcTemplate().update(sql , aname,money);
	}

	public void updateAccount(String aname, double money,boolean isBuy) {
		String sql = "update account set money=money+? where aname=?";
		if(isBuy) {
			sql = "update account set money=money-? where aname=?";
		}
		this.getJdbcTemplate().update(sql,money,aname);
	}

}
