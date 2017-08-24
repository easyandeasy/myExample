package cn.json.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import org.apache.struts2.ServletActionContext;
import cn.json.entiry.User;

public class JsonAction {

	private User user;

	private JSONArray root;
	HttpServletResponse res = ServletActionContext.getResponse();

	public void execute() throws IOException {
		StringBuilder sb = new StringBuilder();
		PrintWriter out = res.getWriter();
		/*List<User> lists = new ArrayList<User>();
		lists.add(new User("小明", "21"));
		lists.add(new User("小李", "25"));
		lists.add(new User("小张", "29"));*/
		System.out.println("123");
		System.out.println(user.getName());
		/*JSONArray json = JSONArray.fromObject(lists);
		System.out.println(json.toString());*/
		/*
		 * sb.append("["); int i = 0; for (User user : lists) {
		 * System.out.println(user.getName());
		 * sb.append("{name:'"+user.getName()+"',age:'"+user.getPwd()+"'}");
		 * if((i+1)!=lists.size()) { sb.append(","); } i++; } sb.append("]");
		 * System.out.println(sb.toString());
		 */
		//out.println(json.toString());
		out.flush();
		out.close();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public JSONArray getRoot() {
		return root;
	}

	public void setRoot(JSONArray root) {
		this.root = root;
	}

}
