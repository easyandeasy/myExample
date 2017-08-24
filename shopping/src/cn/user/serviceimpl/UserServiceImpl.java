package cn.user.serviceimpl;

import cn.user.dao.IUserDao;
import cn.user.daoimpl.UserDaoImpl;
import cn.user.service.IUserService;

/**
 * �û�ҵ���߼���ʵ����
 * @author tang
 *
 */
public class UserServiceImpl implements IUserService {

	IUserDao dao = new UserDaoImpl();
	/**
	 * �ж��û��Ƿ����
	 * @return
	 */
	public boolean selectIsUser(String name , String pwd){
		return dao.queryIsUser(name, pwd)>0?true:false;
	}
}
