package cn.spring.action;

import java.util.List;

import cn.spring.beans.Student;
import cn.spring.service.IStudentService;

public class RegisterAction {

	private String name;
	private int age;
	private IStudentService service;
	
	public void setService(IStudentService service) {
		this.service = service;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String execute() {
		List<Student> stus = service.queryStudentAll();
		for (Student stu : stus) {
			System.out.println(stu.getId() + "\t" + stu.getName() + "\t" +stu.getAge());
			if(stu.getId()==5) {
				break;
			}
		}
		return "success";
	}
}
