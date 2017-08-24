package cn.mybatisspringmvc.service;
import java.util.List;
import java.util.Map;

import cn.mybatisspringmvc.beans.Student;

public interface IStudentService {

	List<Student> queryStudentInfo();

	boolean addStudentInfo(Student stu);

	boolean addUpdateInfo(Student stu);

	List<Student> queryStudentInfoPage(Map map);

	int queryStudentInfoCount();
}
