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
	
	//查询父栏目下所有的子栏目《不包含父栏目本身》
	@Test
	public void test01() {
		List<NewsLabel> children = dao.selectChildrenByParent(2);
		for (NewsLabel newsLabel : children) {
			System.out.println(newsLabel);
		}
	}
	
	
	//查询父栏目及其所有的子栏目《包含父栏目本身》
	@Test
	public void test02() {
		NewsLabel newslabel = dao.selectNewsLabel(2);
		System.out.println(newslabel);
	}
}

