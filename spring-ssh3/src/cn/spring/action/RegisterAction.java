package cn.spring.action;


import cn.spring.beans.Student;
import cn.spring.service.IStudentService;

public class RegisterAction {

	private String name;
	private int age;
	private IStudentService studentService;
	
	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
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
		Student stu = studentService.queryStudentById(2);
		System.out.println(stu.getId() + "\t" + stu.getName() + "\t" +stu.getAge());
		return "success";
	}
}
