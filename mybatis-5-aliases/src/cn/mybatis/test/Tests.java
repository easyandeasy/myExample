package cn.mybatis.test;

import java.util.List;
import java.util.Map;

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
	public void test01() {
		Users u = new Users("tang5",18,99);
		System.out.println("娣诲姞鍓嶏細users= "+ u);
		user.insertUserCacheId(u);
		System.out.println("娣诲姞鍚庯細users= "+ u);
		
	}
	@Test
	public void test02() {
		user.deleteUserById(16);
	}
	
	@Test
	public void test03() {
		Users u = new Users("",111,23);
		u.setId(13);
		user.updateUser(u);
	}
	
	@Test
	public void test04() {
		List<Users> users = user.selectAllUsers();
		for (Users u : users) {
			System.out.println(u);
		}
	}
	
	@Test
	public void test05() {
		Map<String, Object> map = user.selectAllUsersByMap();
		System.out.println(map.get("寮犱笁"));
	}
	
	
	@Test
	public void test06() {
		Users users = user.selectUsersById(13);
		System.out.println(users);
	}
	
	@Test
	public void test07() {
		List<Users> users = user.selectUsersByName("");
		for (Users u : users) {
			System.out.println(u);
		}
	}
}
