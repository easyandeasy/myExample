package cn.mybatis.beans;

import java.util.Set;

//学生表
public class Student {

	private Integer sid;
	private String sname;
	private Set<Cource> cources;
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
	public Set<Cource> getCources() {
		return cources;
	}
	public void setCources(Set<Cource> cources) {
		this.cources = cources;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", cources=" + cources + "]";
	}
}
