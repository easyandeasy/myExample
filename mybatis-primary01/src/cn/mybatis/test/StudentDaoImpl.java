package cn.mybatis.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.mybatis.beans.Student;
import cn.mybatis.dao.IStudentDao;
import cn.mybatis.util.MyBatisUtil;

public class StudentDaoImpl implements IStudentDao {

	private SqlSession session;

	
	public List<Student> selectStudentInfo() {
		List<Student> stu = null;
		try {
			session = MyBatisUtil.getSession();
			stu = session.selectList("selectStudentInfo");
		} finally {
			session.close();
		}
		return stu;
	}


	public boolean insertStudentInfo(Student stu) {
		session = MyBatisUtil.getSession();
		int count = session.insert("insertStudentInfo", stu);
		session.commit();
		return count>0?true:false;
	}


	public boolean deleteStudentInfo(int i) {
		session = MyBatisUtil.getSession();
		int count = session.insert("deleteStudentInfo", i);
		session.commit();
		return count>0?true:false;
	}


	public boolean updateStudentInfo(Student stu) {
		session = MyBatisUtil.getSession();
		int count = session.update("updateStudentInfo",stu);
		session.commit();
		return count > 0 ? true : false;
	}
}
