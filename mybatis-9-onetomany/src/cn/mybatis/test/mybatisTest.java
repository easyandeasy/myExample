package cn.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.mybatis.beans.Country;
import cn.mybatis.beans.Minister;
import cn.mybatis.dao.ICountryDao;
import cn.mybatis.utils.MybatisUtil;

public class mybatisTest {
	
	private ICountryDao dao;
	private SqlSession sqlSession;

	@Before
	public void before() {
		sqlSession = MybatisUtil.getSqlSession();
		dao = sqlSession.getMapper(ICountryDao.class);
	}
	
	@After
	public void after() {
		if(sqlSession != null) {
			sqlSession.close();
		}
	}
	
	//使用多表连接查询《一对多》
	@Test
	public void test01() {
		Country c = dao.selectCountryById(2);
		System.out.println(c);
	}
	
	
	//使用多表单独查询《一对多》
	@Test
	public void test02() {
		Country c = dao.selectCountryById2(2);
		System.out.println(c);
	}
}

