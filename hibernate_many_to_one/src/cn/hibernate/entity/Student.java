package cn.hibernate.entity;

import java.io.Serializable;

/**
 * 学生类
 * @author tang
 *
 */
public class Student implements Serializable{

	private int id;
	private String name;
	private int age;
	private Grade grade;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
