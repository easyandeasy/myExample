package com.jdbc.service;

import com.jdbc.entity.Users;

/**
 * 用户业务接口类
 * @author tang
 *
 */
public interface IUserService {

	/**
	 * 查询用户 信息
	 * @param user
	 * @return
	 */
	public boolean selectQuerySQl(Users user);
	
	/**
	 * 查找用户名是否存在
	 * @param name 用户名
	 * @return 如果存在返回true，否则返回false
	 */
	public boolean queryByName(String name);
}
