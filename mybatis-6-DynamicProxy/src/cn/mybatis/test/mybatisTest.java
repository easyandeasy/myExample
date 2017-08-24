package cn.mybatis.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.mybatis.beans.Users;
import cn.mybatis.dao.IUserDao;
import cn.mybatis.utils.MybatisUtil;

public class mybatisTest {
	
	private IUserDao dao;
	private SqlSession sqlSession;

	@Before
	public void before() {
		sqlSession = MybatisUtil.getSqlSession();
		dao = sqlSession.getMapper(IUserDao.class);
	}
	
	@After
	public void after() {
		if(sqlSession != null) {
			sqlSession.close();
		}
	}

	@Test
	public void test01() {
		Users u = new Users("tang5",18,99);
		System.out.println("娣诲姞鍓嶏細users= "+ u);
		dao.insertUserCacheId(u);
		System.out.println("娣诲姞鍚庯細users= "+ u);
		sqlSession.commit();
	}
	@Test
	public void test02() {
		dao.deleteUserById(16);
		sqlSession.commit();
	}
	
	@Test
	public void test03() {
		Users u = new Users("淇敼鍚�",111,23);
		u.setId(13);
		dao.updateUser(u);
		sqlSession.commit();
	}
	
	@Test
	public void test04() {
		List<Users> users = dao.selectAllUsers();
		for (Users u : users) {
			System.out.println(u);
		}
		sqlSession.commit();
	}
	
	/*璇ユ柟娉曟煡璇㈡湁闂
	@Test
	public void test05() {
		Map<String, Object> map = dao.selectAllUsersByMap();
		System.out.println(map.get("寮犱笁"));
		sqlSession.commit();
	}
	*/
	
	@Test
	public void test06() {
		Users users = dao.selectUsersById(13);
		System.out.println(users);
		sqlSession.commit();
	}
	
	@Test
	public void test07() {
		List<Users> users = dao.selectUsersByName("张");
		for (Users u : users) {
			System.out.println(u);
		}
		sqlSession.commit();
	}
}

