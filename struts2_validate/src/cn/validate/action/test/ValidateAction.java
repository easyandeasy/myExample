package cn.validate.action.test;

import java.sql.Date;

import com.opensymphony.xwork2.ActionSupport;

public class ValidateAction extends ActionSupport{
	private String uname;
	private String upwd;
	private int age;
	private Date birthday;
	private String uemail;

	public String execute() {
		System.out.println("execute()方法");
		return SUCCESS;
	}
	
	public String age(){
		System.out.println("age()方法");
		return SUCCESS;
	}
	
	public void validateAge() {
		System.out.println("validateAge()方法");
		if(age>150) {
			this.addActionError("年龄最大为150岁！");
		}else if(age<=0){
			this.addActionError("年龄必须大于0岁！");
		}
	}
	
	@Override
	public void validate() {
		System.out.println("validate()方法");
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	
}
