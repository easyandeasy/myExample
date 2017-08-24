package cn.springmvc.beans;

public class Student {

	private Integer age;
	private String name;
	
	
	public Student( String name,Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Student() {
		super();
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [age=" + age + ", name=" + name + "]";
	}
}