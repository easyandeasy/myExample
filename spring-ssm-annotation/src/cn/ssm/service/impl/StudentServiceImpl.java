package cn.ssm.service.impl;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ssm.beans.Student;
import cn.ssm.dao.IStudentDao;
import cn.ssm.service.IStudentService;


@Service("studentService")
public class StudentServiceImpl implements IStudentService {

	@Resource(name="IStudentDao")
	private IStudentDao dao ;
	
	public void setDao(IStudentDao dao) {
		this.dao = dao;
	}

	@Transactional
	public void addStudent(Student student) {
		dao.insertStudent(student);
	}
}
