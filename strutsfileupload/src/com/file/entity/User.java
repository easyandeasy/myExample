package com.file.entity;

/**
 * 用户类
 * @author tang
 *
 */
public class User {

	private int uid;
	private String uname;
	private String upwd;
	private String uemail;

	public User(int id ,String name,String pwd,String email) {
		this.uid = id;
		this.uname = name;
		this.upwd = pwd;
		this.uemail = email;
	}
	
	public String doSomeThing(String str) {
		return str;
	}

	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
}
