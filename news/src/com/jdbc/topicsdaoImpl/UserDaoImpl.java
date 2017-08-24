package com.jdbc.topicsdaoImpl;

import java.sql.SQLException;

import com.jdbc.baseDao.BaseDao;
import com.jdbc.entity.Users;
import com.jdbc.userdao.IUserDao;

public class UserDaoImpl extends BaseDao implements IUserDao {

	/*public static void main(String[] args){
		UserDaoImpl i = new UserDaoImpl();
		Users s = new Users();
		s.setAname("admi");
		Users u = i.excuteQuerySQl(s);
			System.out.println(u.getApwd());
	}*/
	/**
	 * 查询用户 信息
	 * @param user
	 * @return
	 */
	public Users excuteQuerySQl(Users user){
		Users users = null;
		String sql = "select aid,aname,apwd,acontext,astatus from admin where aname=?";
		Object[] obj = {user.getAname()};
		rs = executeQuerySQL(sql, obj);
		try {
			while(rs.next()){
				users = new Users();
				users.setAid(rs.getInt("aid"));
				users.setAname(rs.getString("aname"));
				users.setApwd(rs.getString("apwd"));
				users.setAcontext(rs.getString("acontext"));
				users.setAstatus(rs.getInt("astatus"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return users;
	}
	
	
	/**
	 * 查找用户名是否存在
	 * @param name 用户名
	 * @return 返回受影响的行数
	 */
	public int findByName(String name){
		int row = 0;
		String sql = "SELECT COUNT(*) FROM admin WHERE aname=?";
		Object[] obj = {name};
		rs = executeQuerySQL(sql, obj);
		try {
			if(rs.next()){
				row = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return row;
	}
}
