package cn.mybatis.beans;

import java.util.Set;

//课目表
public class Cource {

	private Integer cid;
	private String cname;
	private Set<Student> students;
	
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
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
	@Override
	public String toString() {
		return "Cource [cid=" + cid + ", cname=" + cname +  "]";
	}
	
}
