package cn.mybatis.beans;

import java.util.List;

public class Sourse {

	private Integer sourseid;
	private String soursename;
	private List<Student> students;
	public Integer getSourseid() {
		return sourseid;
	}
	public void setSourseid(Integer sourseid) {
		this.sourseid = sourseid;
	}
	
	public String getSoursename() {
		return soursename;
	}
	public void setSoursename(String soursename) {
		this.soursename = soursename;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}	
	
}
