package com.jdbc.serviceImpl;

import com.jdbc.entity.Users;
import com.jdbc.service.IUserService;
import com.jdbc.topicsdaoImpl.UserDaoImpl;
import com.jdbc.userdao.IUserDao;

/**
 * 用户业务实现类类
 * @author tang
 *
 */
public class UserServiceImpl implements IUserService{

	IUserDao dao = new UserDaoImpl(); 
	/**
	 * 查询用户 信息
	 * @param user
	 * @return
	 */
	public boolean selectQuerySQl(Users user){
		boolean flag = false;
		Users users = dao.excuteQuerySQl(user);
		if(users==null)return flag;
		if(users.getApwd().equals(user.getApwd())){
			flag = true;
		}
		return flag;
	}
	
	/**
	 * 查找用户名是否存在
	 * @param name 用户名
	 * @return 如果存在返回true，否则返回false
	 */
	public boolean queryByName(String name){
		return dao.findByName(name)>0?true:false;
	}
}
