package cn.hibernate.beans;

public class Students {

	private Integer sid;
	private String sname;
	private String sclass;
	
	public String getSclass() {
		return sclass;
	}
	public void setSclass(String sclass) {
		this.sclass = sclass;
	}
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
	public Students() {
	}
	public Students(String sname) {
		this.sname = sname;
	}
	
}
