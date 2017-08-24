package cn.hibernate.beans;

import java.util.Date;

public class Students {

	private Integer sid;
	private String sname;
	
	
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
	public Students(Integer sid,String sname) {
		this.sid = sid;
		this.sname = sname;
	}
	public Students() {}
	
}
