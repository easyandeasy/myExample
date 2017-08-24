package cn.ajax.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import cn.json.entiry.User;


public class AjaxAction {

	private User user;
	HttpServletResponse res = ServletActionContext.getResponse();
	HttpServletRequest request = ServletActionContext.getRequest();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public void isLogin() throws IOException {
		System.out.println(user.getName() + "-----" + user.getPwd());
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		if(user.getName().equals("aaa") && user.getPwd().equals("bbb")) {
			request.getSession().setAttribute("user", user);
			out.write(user.getName());
		} else {
			out.write("error");
		}
		out.flush();
		out.close();
	}
	
	public void queryJSON() throws IOException {
		System.out.println("123");
		PrintWriter out = res.getWriter();
		List<User> lists = new ArrayList<User>();
		lists.add(new User("小明", "21"));
		lists.add(new User("小李", "25"));
		lists.add(new User("小张", "29"));
		lists.add(new User(user.getName(), user.getPwd()));
		JSONArray json = JSONArray.fromObject(lists);
		System.out.println(json.toString());
		
		/*StringBuilder sb = new StringBuilder();
		sb.append("["); int i = 0; for (User user : lists) {
		System.out.println(user.getName());
		for (User users : lists) {
			sb.append("{name:'"+users.getName()+"',age:'"+users.getPwd()+"'}");
		}
		if((i+1)!=lists.size()) { sb.append(","); } i++; } sb.append("]");
		
		System.out.println(sb.toString());*/
		 
		out.println(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 退出
	 */
	public void outLogin() {
		request.getSession().removeAttribute("user");
		//System.out.println("我退出了");
	}
}
