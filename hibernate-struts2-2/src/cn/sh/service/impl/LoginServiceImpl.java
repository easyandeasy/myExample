package cn.sh.service.impl;

import cn.sh.bean.User;
import cn.sh.dao.LoginDao;
import cn.sh.dao.impl.LoginDaoImpl;
import cn.sh.service.LoginService;

public class LoginServiceImpl implements LoginService {

	LoginDao dao = new LoginDaoImpl();
	
	public boolean isLogin(User user) {
		return dao.isLogin(user) != null?true:false;
	}
	
	
	public boolean addUser(User user) {
		return dao.insertUser(user) != null?true:false;
	}

}
