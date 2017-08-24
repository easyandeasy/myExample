package com.ognl.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

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
		System.out.println("123");
		return SUCCESS;
	}
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
