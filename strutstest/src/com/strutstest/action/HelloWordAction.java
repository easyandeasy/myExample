package com.strutstest.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;


//@Namespace("/")
//@ParentPackage("struts-default")
/*@Results(value={@Result(),@Result()})   定义全局视图*/
public class HelloWordAction extends ActionSupport  {
		// 用户输入的姓名
		private String name = "";
		// 向用户显示的信息
		private String message = "";
		
		//@Action(value="helloWord",results={@Result(location="helloWord.jsp")})
		public String execute() {
			// 根据用户输入的姓名,进行"Hello,XXXX!"的封装
			this.setMessage("Hello,"+this.getName()+"!");
			// 处理完毕,返回导航结果的逻辑名
			return "success";
		}
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

}
