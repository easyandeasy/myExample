package cn.mybatis.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import cn.mybatis.beans.Users;
import cn.mybatis.utils.MybatisUtil;

public class UserDaoImpl implements IUserDao {

	private SqlSession sqlSession;

	@Override
	public void inserUser(Users users) {
		try {
			sqlSession = MybatisUtil.getSqlSession();
			sqlSession.insert("insertUsers", users);
			sqlSession.commit();
		} finally {
			if (sqlSession != null) {// 关闭sqlSession的同时就是用回滚
				sqlSession.close();
			}
		}

	}

	@Override
	public void insertUserCacheId(Users user) {
		try {
			sqlSession = MybatisUtil.getSqlSession();
			sqlSession.insert("insertUserCacheId", user);
			sqlSession.commit();
		} finally {
			if (sqlSession != null) {// 关闭sqlSession的同时就是用回滚
				sqlSession.close();
			}
		}
	}

	@Override
	public void deleteUserById(int id) {
		try {
			sqlSession = MybatisUtil.getSqlSession();
			sqlSession.insert("deleteUserById", id);
			sqlSession.commit();
		} finally {
			if (sqlSession != null) {// 关闭sqlSession的同时就是用回滚
				sqlSession.close();
			}
		}
	}

	@Override
	public void updateUser(Users user) {
		try {
			sqlSession = MybatisUtil.getSqlSession();
			sqlSession.insert("updateUser", user);
			sqlSession.commit();
		} finally {
			if (sqlSession != null) {// 关闭sqlSession的同时就是用回滚
				sqlSession.close();
			}
		}
	}

	@Override
	public List<Users> selectAllUsers() {
		List<Users> users = null;
		try {
			sqlSession = MybatisUtil.getSqlSession();
			users = sqlSession.selectList("selectAllUsers");
		} finally {
			if (sqlSession != null) {// 关闭sqlSession的同时就是用回滚
				sqlSession.close();
			}
		}
		return users;
	}

	@Override
	public Map<String, Object> selectAllUsersByMap() {
		Map<String,Object> map = null;
		try {
			sqlSession = MybatisUtil.getSqlSession();
			map = sqlSession.selectMap("selectAllUsers", "name");
		} finally {
			if (sqlSession != null) {// 关闭sqlSession的同时就是用回滚
				sqlSession.close();
			}
		}
		return map;
	}

	@Override
	public Users selectUsersById(int id) {
		Users user = null;
		try {
			sqlSession = MybatisUtil.getSqlSession();
			user = sqlSession.selectOne("selectUsersById", id);
		} finally {
			if (sqlSession != null) {// 关闭sqlSession的同时就是用回滚
				sqlSession.close();
			}
		}
		return user;
	}

	@Override
	public List<Users> selectUsersByName(String name) {
		List<Users> users = null;
		try {
			sqlSession = MybatisUtil.getSqlSession();
			users = sqlSession.selectList("selectUsersByName",name);
		} finally {
			if (sqlSession != null) {// 关闭sqlSession的同时就是用回滚
				sqlSession.close();
			}
		}
		return users;
	}

}
