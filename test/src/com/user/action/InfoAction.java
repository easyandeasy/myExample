package com.user.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 判断是否登录 控制器
 * @author tang
 *
 */
public class InfoAction extends ActionSupport{

	@Override
	public String execute() throws Exception {
		System.out.println("2");
		return "success";
	}

	
}
