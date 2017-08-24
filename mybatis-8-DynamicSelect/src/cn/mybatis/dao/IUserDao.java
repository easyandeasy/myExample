package cn.mybatis.dao;

import java.util.List;
import java.util.Map;

import cn.mybatis.beans.Users;

public interface IUserDao {

	List<Users> selectUsersByIf(Users u);
	
	List<Users> selectUsersSelectOne(Users u);

	List<Users> selectUsersByWhere(Users u);

	List<Users> selectUsersByChoose(Users u);

	List<Users> selectUsersByForeach(int[] id);

	List<Users> selectUsersByForeachList1(List<Integer> list);

	List<Users> selectUsersByForeachList2(List<Users> list);
	
	void updateUsers(Users u);
}
