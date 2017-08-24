package cn.mybatisspringmvc.service;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.mybatisspringmvc.beans.Users;
import cn.mybatisspringmvc.dao.IUsersDao;
import cn.mybatisspringmvc.utils.MybatisUtil;

public class UsersServiceImpl implements IUsersService {

	private SqlSession session = MybatisUtil.getSqlSession();// 获取session对象
	private IUsersDao dao = session.getMapper(IUsersDao.class);// 获取动态Users代理对象（数据访问层对象）
/*
	@Before
	public void before() {
		System.out.println("IUsersDao");
		session = MybatisUtil.getSqlSession();// 获取session对象
		dao = session.getMapper(IUsersDao.class);// 获取动态Users代理对象（数据访问层对象）
	}

	@After
	public void after() {
		System.out.println("session.close();");
		if(session != null) {//判断sesion是否打开，为true，就关闭session
			session.close();
		}
	}
*/
	@Override
	public boolean isLogin(Users user) {
		int uid = dao.isLogin(user);
		System.out.println(uid);
		return uid > 0 ? true : false;
	}

	/*@Test
	public void test() {
		Users user = new Users(); 
		user.setUname("tang");
		user.setUpwd("tang");
		int uid = dao.isLogin(user);
		System.out.println(uid);
	}*/
}



