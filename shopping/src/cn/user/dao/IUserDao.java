package cn.user.dao;

import java.util.List;

import cn.book.entity.User;

/**
 * 用户数据访问层
 * @author tang
 *
 */
public interface IUserDao {

	/**
	 * 查询用户是否存在
	 * @return
	 */
	public int queryIsUser(String name , String pwd );
	
	/**
	 * 查询用户所有信息
	 * @return
	 */
	public List<User> queryUserAllInfo();
}
