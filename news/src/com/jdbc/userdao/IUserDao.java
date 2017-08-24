package com.jdbc.userdao;

import com.jdbc.entity.Users;

/**
 * 用户数据访问实现类
 * @author tang
 *
 */
public interface IUserDao {

	/**
	 * 查询用户 信息
	 * @param user
	 * @return
	 */
	public Users excuteQuerySQl(Users user);
	
	/**
	 * 查找用户名是否存在
	 * @param name 用户名
	 * @return 返回受影响的行数
	 */
	public int findByName(String name);
}
