package cn.hibernate.beans;

import java.util.Set;

public class Classs {

	private Integer cid;
	private String cname;
	private Set<Students> students;
	
	public Set<Students> getStudents() {
		return students;
	}
	public void setStudents(Set<Students> students) {
		this.students = students;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Classs(String cname) {
		super();
		this.cname = cname;
	}
	public Classs() {
	}
	@Override
	public String toString() {
		return "Classs [cid=" + cid + ", cname=" + cname + ", students=" + students + "]";
	}
}
