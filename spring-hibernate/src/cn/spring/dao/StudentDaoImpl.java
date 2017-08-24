package cn.spring.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import cn.spring.beans.Student;

public class StudentDaoImpl implements IStudentDao {
	private SessionFactory sessionFactory;

	public void setSession(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Student selectStudentById(int id) {
		return sessionFactory.getCurrentSession().get(Student.class,id);
	}

	public List<Student> selectStudentAll() {
		String hql = "from Student";
		return null;//sessionFactory.getCurrentSession().createQuery(hql).list();
	}

	public void insertStudent(Student student) {
		sessionFactory.getCurrentSession().save(student);
	}

	public void deleteStudent(Student student) {
		sessionFactory.getCurrentSession().delete(student);
	}

	public void updateeStudent(Student student) {
		sessionFactory.getCurrentSession().update(student);
	}
	
}
