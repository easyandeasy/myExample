package cn.spring.service;

import java.util.List;

import cn.spring.beans.Student;

/**
 * ҵ���߼��ӿ�
 * @author tang
 *
 */
public interface IStudentService {
	

	public Student queryStudentById(int id);
	
	public List<Student> queryStudentAll();
	
	public void addStudent(Student student);
	
	public void removeStudent(Student student);
	
	public void replaceStudent(Student student);
}
