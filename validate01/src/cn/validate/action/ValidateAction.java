package cn.validate.action;

import cn.validate.entity.User;

import com.opensymphony.xwork2.ActionSupport;



public class ValidateAction extends ActionSupport{

	private User user;
	private String repwd;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRepwd() {
		return repwd;
	}

	public void setRepwd(String repwd) {
		this.repwd = repwd;
	}
	
	@Override
	public String execute() {
		return SUCCESS;
	}



	/*private String name;
	private String pwd;
	private String email;
	private Date birth;
	private String card;
	private String phone;*/
	
/*	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Date getBirth() {
		return birth;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRepwd() {
		return repwd;
	}

	public void setRepwd(String repwd) {
		this.repwd = repwd;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
*/
}
