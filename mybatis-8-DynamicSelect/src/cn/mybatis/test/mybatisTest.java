package cn.mybatis.test;

import java.util.ArrayList;
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
	
	//动态多条件查询，第一种方法《if》
		// 使用if标签进行查询
	@Test
	public void testIf() {
		//Users user = new Users("张",23,0);
		//Users user = new Users("张",0,0);
		//Users user = new Users("",23,0);
		Users user = new Users("",0,0);
		List<Users> users = dao.selectUsersByIf(user);
		for (Users u : users) {
			System.out.println(u);
		}
	}
	
	
	//动态多条件查询，第一种方法《if》SelectOne进行查询
	// 使用if标签进行查询
	@Test
	public void testSelectOne() {
		//Users user = new Users("张",23,0);
		//Users user = new Users("张",0,0);
		//Users user = new Users("",23,0);
		Users user = new Users();
		user.setId(1);
		List<Users> users = dao.selectUsersSelectOne(user);
		for (Users u : users) {
			System.out.println(u);
		}
	}
	//多条件查询，第二种方法《Where》
	// 使用where+if进行多条件查询
	@Test
	public void testWhere() {
		//Users u = new Users("张",22,95);
		//Users u = new Users("张",0,0);
		Users u = new Users("",23,0);
		//Users u = new Users("",0,0);
		List<Users> users = dao.selectUsersByWhere(u);
		for (Users user : users) {
			System.out.println(user);
		}
	}
	
	
	//多条件查询，第三种方法《Choose》
	// 使用Choose进行多条件查询
	@Test
	public void testChoose() {
		//Users u = new Users("张",22,95);
		//Users u = new Users("张",0,0);
		Users u = new Users("",23,0);
		//Users u = new Users("",0,0);
		List<Users> users = dao.selectUsersByChoose(u);
		for (Users user : users) {
			System.out.println(user);
		}
	}
	
	
	//多条件查询，第三种方法《Foreach》
	// 使用Foreach
	// 1）.遍历数组进行查询
	@Test
	public void testForeachArray() {
		int[] id = {1,3};
		List<Users> users = dao.selectUsersByForeach(id);
		for (Users user : users) {
			System.out.println(user);
		}
	}
	// 2）.遍历List<Integer> 进行查询
	@Test
	public void testForeachList1() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(3);
		List<Users> users = dao.selectUsersByForeachList1(list);
		for (Users user : users) {
			System.out.println(user);
		}
	}
	// 2）.遍历List<Users> 进行查询
	@Test
	public void testForeachList2() {
		Users user1 = new Users();
		user1.setId(1);
		
		Users user2 = new Users();
		user2.setId(3);
		
		List<Users> list = new ArrayList<Users>();
		list.add(user1);
		list.add(user2);
		
		List<Users> users = dao.selectUsersByForeachList2(list);
		for (Users user : users) {
			System.out.println(user);
		}
	}
	
	/* 使用 set动态多条件进行修改操作 */
	@Test
	public void testUpdate() {
		Users user = new Users();
		user.setId(1);
		user.setName("sbc");
		dao.updateUsers(user);
		sqlSession.commit();
	}
}

