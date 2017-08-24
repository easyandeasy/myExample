package cn.mybatis.dao;

import java.util.List;
import java.util.Map;

import cn.mybatis.beans.Student;

public interface IStudentDao {
	
	/**
	 * 查询学生所有信息
	 * @return
	 */
	public List<Student> selectStudent();

	/**
	 * 使用多对多方式查询学生信息
	 */
	public List<Student> selectStudentStuSourse();

	public List<Map> selectStudentSourseMap();
	
}
