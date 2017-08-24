package cn.validate.action;

import java.sql.Date;

import com.opensymphony.xwork2.ActionSupport;



public class ValidateAction extends ActionSupport{

	
	private String name;
	private String pwd;
	private String repwd;

	private String email;
	private int age;
	private Date date;
	private String card;
	private String phone;
	
	public String getRepwd() {
		return repwd;
	}
	public void setRepwd(String repwd) {
		this.repwd = repwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println(name+"\t"+pwd+"\t"+email+"\t"+age+"\t"+date+"\t"+card+"\t"+phone);
		return SUCCESS;
	}
}
