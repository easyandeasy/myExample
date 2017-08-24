package cn.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.mybatis.beans.Student;
import cn.mybatis.dao.IStudentDao;
import cn.mybatis.utils.MybatisUtil;

public class StudentTest {
	
	private IStudentDao dao;
	private SqlSession sqlSession;

	@Before
	public void before() {
		sqlSession = MybatisUtil.getSqlSession();
		dao = sqlSession.getMapper(IStudentDao.class);
	}
	
	@After
	public void after() {
		if(sqlSession != null) {
			sqlSession.close();
		}
	}
	
	@Test
	public void test02() {
		Student stu = dao.selectStudentById(2);
		System.out.println(stu);
		
		Student stu2 = dao.selectStudentById(2);
		System.out.println(stu2);
	}
}

