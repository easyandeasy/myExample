package cn.spring.service;

import java.util.List;

import cn.spring.beans.Student;

/**
 * 业务逻辑接口
 * @author tang
 *
 */
public interface IStudentService {
	
	public List<String> selectStudentByName();
	
	public String selectStudentNameById(int id);

	public Student queryStudentById(int id);
	
	public List<Student> queryStudentAll();
	
	public void addStudent(Student student);
	
	public void removeStudent(Student student);
	
	public void replaceStudent(Student student);
}
