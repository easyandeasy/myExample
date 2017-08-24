package cn.ssm.service.impl;

import org.apache.ibatis.session.SqlSessionFactory;

import cn.ssm.beans.Student;
import cn.ssm.dao.IStudentDao;
import cn.ssm.service.IStudentService;

public class StudentServiceImpl implements IStudentService {

	
	private IStudentDao dao ;
	
	public void setDao(IStudentDao dao) {
		this.dao = dao;
	}

	@Override
	public void addStudent(Student student) {
		dao.insertStudent(student);
	}

}
