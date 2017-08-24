package cn.validate.entity;

import java.sql.Date;

/**
 * 实体类
 * @author tang
 *
 */
public class User {
	
	private String name;
	private String pwd;
	private String email;
	private int age;
	private Date dates;
	private String card;
	private String phone;
	
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
	public Date getDates() {
		return dates;
	}
	public void setDate(Date dates) {
		this.dates = dates;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
}
