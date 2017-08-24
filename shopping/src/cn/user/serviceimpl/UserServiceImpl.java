package cn.user.serviceimpl;

import cn.user.dao.IUserDao;
import cn.user.daoimpl.UserDaoImpl;
import cn.user.service.IUserService;

/**
 * 用户业务逻辑层实现类
 * @author tang
 *
 */
public class UserServiceImpl implements IUserService {

	IUserDao dao = new UserDaoImpl();
	/**
	 * 判断用户是否存在
	 * @return
	 */
	public boolean selectIsUser(String name , String pwd){
		return dao.queryIsUser(name, pwd)>0?true:false;
	}
}
