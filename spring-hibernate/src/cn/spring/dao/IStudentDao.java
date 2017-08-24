package cn.spring.dao;

import java.util.List;
import cn.spring.beans.Student;

public interface IStudentDao {

	public Student selectStudentById(int id);

	public List<Student> selectStudentAll();

	public void insertStudent(Student student);

	public void deleteStudent(Student student);

	public void updateeStudent(Student student);
}
