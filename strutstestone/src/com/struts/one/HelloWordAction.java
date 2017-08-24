package com.struts.one;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWordAction extends ActionSupport {

	private String name = "";//输入的姓名
	private String message = "";//向用户显示的信息
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String execute() {
		this.setMessage("Hello\t"+this.getName()+"!");
		List list = new ArrayList();
		list.add("jack");
		list.add("rose");
		list.add("marry");
		System.out.println("123");
		return "success";
	}

	
}
