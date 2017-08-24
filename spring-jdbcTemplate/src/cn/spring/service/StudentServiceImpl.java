package cn.spring.service;

import java.util.List;

import cn.spring.beans.Student;
import cn.spring.dao.IStudentDao;

/**
 * ҵ���߼�ʵ�ֲ�
 * @author tang
 *
 */
public class StudentServiceImpl implements IStudentService {

	private IStudentDao dao;

	public void setDao(IStudentDao dao) {
		this.dao = dao;
	}
	
	public List<String> selectStudentByName(){
		return dao.selectStudentByName();
	}
	
	public String selectStudentNameById(int id) {
		return dao.selectStudentNameById(id);
	}
	
	public Student queryStudentById(int id){
		return dao.selectStudentById(id);
	}

	public List<Student> queryStudentAll() {
		return dao.selectStudentAll();
	}

	public void addStudent(Student student) {
		dao.insertStudent(student);
	}

	public void removeStudent(Student student) {
		dao.deleteStudent(student);
	}

	public void replaceStudent(Student student) {
		dao.updateeStudent(student);
	}

}
