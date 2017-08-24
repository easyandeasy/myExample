package cn.mybatisspringmvc.service;
import java.util.List;

import cn.mybatisspringmvc.beans.Student;

public interface IStudentService {

	List<Student> queryStudentInfo();
}
