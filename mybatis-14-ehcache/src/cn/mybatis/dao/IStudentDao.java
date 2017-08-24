package cn.mybatis.dao;

import cn.mybatis.beans.Student;

//学生接口类
public interface IStudentDao {

	Student selectStudentById(int i);
}
