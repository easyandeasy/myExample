package cn.mybatis.test;

import org.junit.Before;
import org.junit.Test;

import cn.mybatis.beans.Users;
import cn.mybatis.dao.IUserDao;
import cn.mybatis.dao.UserDaoImpl;

public class Tests {
	
	private IUserDao user;

	@Before
	public void before() {
		user = new UserDaoImpl();
	}

	@Test
	public void testInsert() {
		Users u = new Users("tang4",18,99);
		user.inserUser(u);
	}
}
