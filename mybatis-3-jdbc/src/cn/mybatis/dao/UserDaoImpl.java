package cn.mybatis.dao;

import org.apache.ibatis.session.SqlSession;

import cn.mybatis.beans.Users;
import cn.mybatis.utils.MybatisUtil;

public class UserDaoImpl implements IUserDao {

	private SqlSession sqlSession;

	@Override
	public void inserUser(Users users) {
		try {
			sqlSession = MybatisUtil.getSqlSession();
			//4.相关操作
			sqlSession.insert("insertUsers", users);
			//提交
			sqlSession.commit();
		} finally {
			if(sqlSession != null) {//关闭sqlSession的同时就是用回滚
				sqlSession.close();
			}
		}
		
	}

}
