package cn.spring.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.spring.beans.Student;
import cn.spring.service.IStudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class StudentTest2 {

	@Autowired
	private IStudentService service;

	@Test
	public void testAdd() {
		Student student = new Student("’‘¡˘", 26);
		service.addStudent(student);
	}

	@Test
	public void testRemove() {
		Student student = new Student();
		student.setId(1);
		service.removeStudent(student);
	}
	
	@Test
	public void testStudentByName() {
		List<String> student = service.selectStudentByName();
		System.out.println(student);
	}
	
	@Test
	public void testStudentNameById() {
		String name = service.selectStudentNameById(2);
		System.out.println(name);
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
