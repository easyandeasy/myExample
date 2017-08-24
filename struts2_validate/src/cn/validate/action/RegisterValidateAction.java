package cn.validate.action;

import cn.validate.entity.User;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterValidateAction extends ActionSupport{//RegisterValidateAction-validation.xml
	private User user;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private String repwd; 
	
    public String getRepwd() {
		return repwd;
	}

	public void setRepwd(String repwd) {
		this.repwd = repwd;
	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
    
  
}
