package cn.mybatis.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	//多条件查询，第一种方法
		// 1.1使用Map进行封装条件（单个属性值）
	@Test
	public void test01() {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("sname", "张");
		map.put("sage", 23);
		List<Users> users = dao.selectUsersByNameAndAge(map);
		for (Users u : users) {
			System.out.println(u);
		}
	}
	//多条件查询，
	// 1.2:使用Map进行封装条件（单个属性值 、对象）
	@Test
	public void test02() {
		Users u = new Users("田七",22,95);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("sname", "张");
		map.put("sage", 23);
		map.put("u", u);
		List<Users> users = dao.selectUsersByNameAndAge(map);
		for (Users user : users) {
			System.out.println(user);
		}
	}
}

