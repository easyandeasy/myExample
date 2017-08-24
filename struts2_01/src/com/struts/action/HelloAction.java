package com.struts.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

@Namespace("/")
@ParentPackage("struts-default")
public class HelloAction {

	@Action(results={@Result(location="welcom.jsp")})
	public String execute() {
		System.out.println("hello struts2");
		return "success";
	}
}
