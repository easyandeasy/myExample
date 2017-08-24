package cn.ssm.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import cn.ssm.beans.Student;

public interface IStudentDao {

	@Insert("insert into Student(name,age) values(#{name},#{age})")
	void insertStudent(Student student);

}
