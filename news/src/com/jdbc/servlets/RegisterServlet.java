package com.jdbc.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jdbc.service.IUserService;
import com.jdbc.serviceImpl.UserServiceImpl;

public class RegisterServlet extends HttpServlet {

	IUserService service = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		String name = req.getParameter("userName");
		PrintWriter out = resp.getWriter();
		boolean flag = service.queryByName(name);
		if(flag){
			out.print("<font color='red'>用户名已存在!</font>");
		}else{
			out.print("<font color='blue'>可以使用</font>");
		}
		out.flush();
		out.close();
	}

	
}
