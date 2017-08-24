package cn.mybatis.dao;

import java.util.List;
import java.util.Map;

import cn.mybatis.beans.Users;

public interface IUserDao {

	List<Users> selectUsersByNameAndAge(Map<String , Object> map);
}
