package cn.mybatis.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.mybatis.beans.NewsLabel;
import cn.mybatis.dao.INewsLabelDao;
import cn.mybatis.utils.MybatisUtil;

public class mybatisTest {
	
	private INewsLabelDao dao;
	private SqlSession sqlSession;

	@Before
	public void before() {
		sqlSession = MybatisUtil.getSqlSession();
		dao = sqlSession.getMapper(INewsLabelDao.class);
	}
	
	@After
	public void after() {
		if(sqlSession != null) {
			sqlSession.close();
		}
	}
	
	
	
	//根据id查询本身及其父栏目
	@Test
	public void test02() {
		NewsLabel newslabel = dao.selectNewsLabel(4);
		System.out.println(newslabel);
	}
}

