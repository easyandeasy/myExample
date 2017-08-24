package cn.mybatis.beans;

import java.util.List;

//班级
public class Classs {

	private String cid;
	private String cname;
	private String department;
	private List<Student> stu;
		
	
	public List<Student> getStu() {
		return stu;
	}
	public void setStu(List<Student> stu) {
		this.stu = stu;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Classs() {
		super();
	}
	public Classs(String cname, String department) {
		super();
		this.cname = cname;
		this.department = department;
	}
	public Classs(String cid, String cname, String department) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.department = department;
	}

}
