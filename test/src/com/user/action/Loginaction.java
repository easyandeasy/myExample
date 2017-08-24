package com.user.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class Loginaction extends ActionSupport {

	private static final String CURRENT_USER = "CURRENT_USER";
	private String name;
	private String pwd;
	
	public String execute() {
		System.out.println("1");
		if("aa".equals(name) && "aa".equals(pwd)){
			Map<String,Object> session = null;
			session = ActionContext.getContext().getSession();
			if(session.containsKey(CURRENT_USER)){
				session.remove(CURRENT_USER);
			}
			
			session.put(CURRENT_USER, name);
			return "success";
		}else{
			return "error";
		}
	}

	@Override
	public void validate() {
		if(name==null){
			addFieldError("name", "用户名不能为空！");
		}
		
		if(pwd==null){
			addFieldError("pwd", "密码不能为空！");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
