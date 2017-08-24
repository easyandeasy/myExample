package cn.bookweb.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bookweb.user.entity.UserStatus;

/**
 * 查询用户帐号状态控制器
 * @author tang
 *
 */
public class SelectUserStatusServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		List<UserStatus> list = new ArrayList<UserStatus>();
		UserStatus status = new UserStatus();
		status.setSid(1);
		status.setSname("已封");
		UserStatus status1 = new UserStatus();
		status1.setSid(2);
		status1.setSname("正常");
		UserStatus status2 = new UserStatus();
		status2.setSid(3);
		status2.setSname("未填完详细信息");
		list.add(status);
		list.add(status1);
		list.add(status2);
		
		
		request.getSession().setAttribute("userstatus", list);
		
		out.println("<script text='' > location.href='jsp/after/usermanage.jsp' </script>");
	}

}
