package cn.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Test;

import cn.mybatis.beans.Minister;
import cn.mybatis.dao.IMinisterDao;
import cn.mybatis.utils.MybatisUtil;

public class mybatisTest {
	
	private IMinisterDao dao;
	private SqlSession sqlSession;

	public void before() {
		sqlSession = MybatisUtil.getSqlSession();
		dao = (IMinisterDao) sqlSession.getMapper(IMinisterDao.class);
	}
	
	@After
	public void after() {
		if(sqlSession != null) {
			sqlSession.close();
		}
	}
	
	//使用多表连接查询《多对一》
	@Test
	public void test01() {
		Minister m = dao.selectMinisterById(2);
		System.out.println(m);
	}
	
	
	//使用多表单独查询《多对一》
	@Test
	public void test02() {
		Minister m = dao.selectMinisterById2(4);
		System.out.println(m);
	}
}

