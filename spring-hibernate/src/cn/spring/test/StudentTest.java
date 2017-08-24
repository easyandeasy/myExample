package cn.spring.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.spring.beans.Student;
import cn.spring.service.IStudentService;

public class StudentTest {

	private IStudentService service;

	@Before
	public void before() {
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = (IStudentService) ac.getBean("service");
	}

	@Test
	public void testAdd() {
		Student student = new Student("张三", 25);
		service.addStudent(student);
	}

	@Test
	public void testRemove() {
		Student student = new Student();
		student.setId(1);
		service.removeStudent(student);
	}
	
	@Test
	public void testReplace() {
		Student student = new Student("王五", 23);
		student.setId(2);
		service.replaceStudent(student);
	}
	
	

	@Test
	public void testStudentAll() {
		List<Student> student = service.queryStudentAll();
		System.out.println(student);
	}
	
	
	@Test
	public void testStudentById() {
		Student student = service.queryStudentById(2);
		System.out.println(student);
	}
}
