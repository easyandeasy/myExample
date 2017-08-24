package cn.mybatis.dao;

import java.util.List;
import java.util.Map;

import cn.mybatis.beans.Users;

public interface IUserDao {

	void inserUser(Users users);
	void insertUserCacheId(Users user);
	
	void deleteUserById(int id);
	void updateUser(Users user);
	
	List<Users> selectAllUsers();
	Map<String,Object> selectAllUsersByMap();
	
	
	Users selectUsersById(int id);
	List<Users> selectUsersByName(String name);
}
