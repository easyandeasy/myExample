package cn.mybatis.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import cn.mybatis.beans.Student;
import cn.mybatis.dao.IStudentDao;
import cn.mybatis.utils.MybatisUtil;

public class StudentServiceImpl implements IStudentService {

	private SqlSession session = MybatisUtil.getSqlSession();
	private IStudentDao dao = session.getMapper(IStudentDao.class);
	
	/**
	 * 鏌ヨ鎵�湁瀛︾敓淇℃伅
	 */
	public List<Student> queryStudent() {
		List<Student> stus = dao.selectStudent();
		return stus;
	}

	/**
	 * 浣跨敤澶氬澶氭柟寮忔煡璇㈠鐢熶俊鎭�
	 */
	public List<Student> queryStudentStuSourse() {
		List<Student> stus = dao.selectStudentStuSourse();
		return stus;
	}

	public List<Map> queryStudentSourseMap() {
		List<Map> map = dao.selectStudentSourseMap();
		return map;
	}

}
