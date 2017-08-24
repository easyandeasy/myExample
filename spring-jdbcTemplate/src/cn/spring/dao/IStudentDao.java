package cn.spring.dao;

import java.util.List;

import cn.spring.beans.Student;

/**
 * ��ݷ��ʽӿ�
 * @author tang
 *
 */
public interface IStudentDao {
	
	public List<String> selectStudentByName();
	
	public String selectStudentNameById(int id);

	public Student selectStudentById(int id);
	
	public List<Student> selectStudentAll();
	
	public void insertStudent(Student student);
	
	public void deleteStudent(Student student);
	
	public void updateeStudent(Student student);
}
