package cn.hibernate.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 年级类
 * @author tang
 *
 */
public class Grade implements Serializable{
	private int id;
	private String name;
	private Set<Student> students = new HashSet<Student>();
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
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
}
