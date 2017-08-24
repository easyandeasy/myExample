package cn.hibernate.entity;

public class StudentInfo {
	private Integer sid;
	private String sname;
	private StudentHomeAddress shome;
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public StudentHomeAddress getShome() {
		return shome;
	}
	public void setShome(StudentHomeAddress shome) {
		this.shome = shome;
	}
	public StudentInfo(String sname) {
		super();
		this.sname = sname;
	}
	public StudentInfo() {
	}
	
}
