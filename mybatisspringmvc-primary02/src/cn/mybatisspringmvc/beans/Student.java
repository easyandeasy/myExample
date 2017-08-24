package cn.mybatisspringmvc.beans;

import java.util.Date;

public class Student {

	private Integer id;
	private String sname;
	private Date sbirth;
	private String sclass;
	private String saddress;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	public Date getSbirth() {
		return sbirth;
	}
	public void setSbirth(Date sbirth) {
		this.sbirth = sbirth;
	}
	public String getSclass() {
		return sclass;
	}
	public void setSclass(String sclass) {
		this.sclass = sclass;
	}
	
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	public Student() {
		super();
	}
	public Student(String sname, Date sbirth, String sclass, String saddress) {
		this.sname = sname;
		this.sbirth = sbirth;
		this.sclass = sclass;
		this.saddress = saddress;
	}
	public Student(int id,String sname, Date sbirth, String sclass, String saddress) {
		this.id = id ;
		this.sname = sname;
		this.sbirth = sbirth;
		this.sclass = sclass;
		this.saddress = saddress;
	}
}
