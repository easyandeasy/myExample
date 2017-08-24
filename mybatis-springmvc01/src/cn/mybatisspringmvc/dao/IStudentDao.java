package cn.mybatisspringmvc.dao;

import java.util.List;

import cn.mybatisspringmvc.beans.Student;

public interface IStudentDao {
	public List<Student> selectStudentInfo();

	public boolean insertStudentInfo(Student stu);

	public boolean deleteStudentInfo(int i);
	
	boolean updateStudentInfo(Student stu);
}
