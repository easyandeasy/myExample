package cn.user.daoimpl;

import java.sql.SQLException;
import java.util.List;

import cn.book.basedao.BaseDao;
import cn.book.entity.User;
import cn.user.dao.IUserDao;

/**
 * 用户数据访问层实现类
 * @author tang
 *
 */
public class UserDaoImpl extends BaseDao implements IUserDao {

	/**
	 * 查询用户是否存在
	 * @return
	 */
	@Override
	public int queryIsUser(String name , String pwd ){
		int row = 0 ;
		String sql = "select count(*) from admin where aname=? and apwd=?";
		Object[] obj = {name,pwd};
		rs = executeQuerySQL(sql, obj);
		try {
			while(rs.next()){
				row = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return row;
	}

	
	/**
	 * 查询用户所有信息
	 * @return
	 */
	public List<User> queryUserAllInfo(){
		
		return null;
	}
}
