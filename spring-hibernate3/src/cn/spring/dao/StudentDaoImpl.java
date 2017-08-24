package cn.spring.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import cn.spring.beans.Student;

public class StudentDaoImpl implements IStudentDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Student selectStudentById(int id) {
		return sessionFactory.getCurrentSession().get(Student.class, id);
	}

	public List<Student> selectStudentAll() {
		String hql = "from Student";
		List<Student> student = (List<Student>)sessionFactory.getCurrentSession().createQuery(hql).list();
		return student;
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
