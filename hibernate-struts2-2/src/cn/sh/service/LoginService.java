package cn.sh.service;

import cn.sh.bean.User;

public interface LoginService {

	boolean isLogin(User user);

	boolean addUser(User user);

}
