package cn.mybatis.dao;

import java.util.List;
import java.util.Map;

import cn.mybatis.beans.Classs;
import cn.mybatis.beans.Student;

public interface IStudentDao {
	
	/**
	 * 查询学生所有信息
	 * @return
	 */
	public List<Student> selectStudent();
	
	
	/**
	 * 查询学生和班级所有信息
	 * @return
	 */
	public List<Student> selectStudentClass();


	/**
	 * 使用Map集合进行查询
	 */
	public List<Map> selectStudentClassMap();


	/**
	 * 使用一对多 查询学生和班级所有信息
	 */
	public List<Classs> selectClassStudent();
	
}
