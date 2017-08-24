package cn.sh.dao;

import cn.sh.bean.User;

public interface LoginDao {

	Object isLogin(User user);

	Object insertUser(User user);

}
