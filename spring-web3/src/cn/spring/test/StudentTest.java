package cn.spring.test;

import org.junit.Before;
import java.util.List;

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
		Student student = new Student("李四", 24);
		Student student1 = new Student("王五", 25);
		Student student2 = new Student("张三", 23);
		service.addStudent(student);
		service.addStudent(student1);
		service.addStudent(student2);
	}

	@Test
	public void testRemove() {
		Student student = new Student();
		student.setId(1);
		service.removeStudent(student);
	}
	
	@Test
	public void testReplace() {
		Student student = new Student("赵六", 26);
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


