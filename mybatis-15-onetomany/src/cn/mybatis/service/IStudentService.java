package cn.mybatis.service;

import java.util.List;
import java.util.Map;

import cn.mybatis.beans.Classs;
import cn.mybatis.beans.Student;

public interface IStudentService {
	
	public List<Student> queryStudent();
	
	public List<Student> queryStudentClass();

	public List<Map> queryStudentClassMap();

	public List<Classs> queryClassStudent();
}
