package cn.mybatis.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import cn.mybatis.beans.Classs;
import cn.mybatis.beans.Student;
import cn.mybatis.dao.IStudentDao;
import cn.mybatis.utils.MybatisUtil;
import cn.mybatis.service.IStudentService;

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
	 * 鏌ヨ瀛︾敓鍜岀彮绾ф墍鏈変俊鎭�
	 */
	public List<Student> queryStudentClass() {
		List<Student> stus = dao.selectStudentClass();
		return stus;
	}

	/**
	 * 浣跨敤Map闆嗗悎杩涜鏌ヨ
	 */
	public List<Map> queryStudentClassMap() {
		List<Map> map = dao.selectStudentClassMap();
		return map;
	}

	
	/**
	 * 浣跨敤涓�澶�鏌ヨ瀛︾敓鍜岀彮绾ф墍鏈変俊鎭�
	 */
	public List<Classs> queryClassStudent() {
		List<Classs> clss = dao.selectClassStudent();
		return clss;
	}

}
