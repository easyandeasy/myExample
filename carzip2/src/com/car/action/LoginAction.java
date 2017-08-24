package com.car.action;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{

	@Override
	public String execute(){
		System.out.println("=========================");
		return "success";
	}
}
