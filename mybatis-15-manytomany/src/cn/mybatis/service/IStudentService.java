package cn.mybatis.service;

import java.util.List;
import java.util.Map;

import cn.mybatis.beans.Student;

public interface IStudentService {
	
	public List<Student> queryStudent();

	/**
	 * 使用多对多方式查询学生信息
	 */
	public List<Student> queryStudentStuSourse();

	public List<Map> queryStudentSourseMap();
	
}
