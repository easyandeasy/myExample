package com.ognl.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.file.entity.User;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author tang
 *
 */
public class OgnlAction extends ActionSupport implements SessionAware {
	
	Map<String, Object> session = null;
	public String execute() {
		Map<String,String> map = new HashMap<String,String>();
		map.put("cn", "中国");
		map.put("hk", "香港");
		session.put("map", map);
		List<User> list = new ArrayList<User>();
		list.add(new User(1,"小明","123456","xiao@qq.com"));
		list.add(new User(2,"张三","654321","zhang@qq.com"));
		list.add(new User(3,"李四","1234567","li@qq.com"));
		ServletActionContext.getRequest().setAttribute("list", list);
		ServletActionContext.getRequest().setAttribute("user", new User(1,"王五","123456","wang@qq.com"));
		return SUCCESS;
	}
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
