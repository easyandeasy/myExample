package cn.ajax.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import cn.ajax.basedao.BaseDao;
import cn.json.entiry.User;


public class AjaxAction extends BaseDao{

	private User user;
	HttpServletResponse res = ServletActionContext.getResponse();
	HttpServletRequest request = ServletActionContext.getRequest();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * 登录
	 * @throws IOException
	 */
	public void isLogin() throws IOException {
		System.out.println(user.getName() + "-----" + user.getAge());
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		if(user.getName().equals("aaa") && user.getAge()==123456) {
			request.getSession().setAttribute("user", user);
			out.write(user.getName());
		} else {
			out.write("error");
		}
		out.flush();
		out.close();
	}
	
	/**
	 * 查询信息
	 * @throws IOException
	 * @throws Exception 
	 */
	public void queryJSON() throws IOException, Exception {
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		List<User> lists = (List<User>)request.getSession().getAttribute("lists");
		if(lists==null) {
			lists = new ArrayList<User>();
			String sql = "select id,name,age from user";
			rs = executeQuerySQL(sql, null);
			while(rs.next()) {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setAge(rs.getInt("age"));
				lists.add(u);
			}
		}
		request.getSession().setAttribute("lists", lists);
		JSONArray json = JSONArray.fromObject(lists);
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 添加信息
	 * @throws IOException
	 */
	public void addInfo() throws IOException {
		List<User> oldLists = (List<User>)request.getSession().getAttribute("lists");
		res.setContentType("text/html;charset=utf-8");
		String sql = "insert into user(name,age) values(?,?)";
		Object[] obj = {user.getName(),user.getAge()};
		int i = Integer.parseInt(executeInsertBean(sql,obj).toString());
		PrintWriter out = res.getWriter();
		user.setId(i);
		oldLists.add(user);
		List<User> newLists = new ArrayList<User>();
		newLists.add(user);
		JSONArray json = JSONArray.fromObject(newLists);
		request.getSession().setAttribute("lists", oldLists);
		out.print(json);
		out.flush();
		out.close();
	}
	
	/**
	 * 删除信息
	 */
	public void deleteinfo() {
		List<User> oldLists = (List<User>)request.getSession().getAttribute("lists");
		for (User users : oldLists) {
			if(users.getId()==user.getId()) {
				user = users;
				String sql = "delete from user where id=?";
				Object[] obj = {user.getId()};
				executeUpdateSQL(sql, obj);
				break;
			}
		}
		oldLists.remove(user);
		request.getSession().setAttribute("lists", oldLists);
	}
	
	/**
	 * 退出
	 */
	public void outLogin() {
		request.getSession().removeAttribute("user");
		//System.out.println("我退出了");
	}
}









/*StringBuilder sb = new StringBuilder();
sb.append("["); int i = 0; 
for (User user : lists) {
	sb.append("{name:'"+user.getName()+"',age:'"+user.getPwd()+"'}");
	if((i+1)!=lists.size()) { 
		sb.append(","); 
	} 
	i++; 
} 
sb.append("]");*/
 