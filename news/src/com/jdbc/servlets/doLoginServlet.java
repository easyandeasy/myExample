package com.jdbc.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.entity.Users;
import com.jdbc.service.IUserService;
import com.jdbc.serviceImpl.UserServiceImpl;

/**
 * µÇÂ¼¿ØÖÆÆ÷
 * @author tang
 *
 */
public class doLoginServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String aname = request.getParameter("userName");
		String apwd = request.getParameter("pwd");
		IUserService users = new UserServiceImpl();
		Users user = new Users();
		user.setAname(aname);
		user.setApwd(apwd);
		boolean flag = users.selectQuerySQl(user);
		if(flag){
			request.getSession().setAttribute("name", aname);
			request.getRequestDispatcher("news/admin.jsp").forward(request, response);
		}else{
			PrintWriter out = response.getWriter();
			out.print("<script type='text/javascript'>"+"alert('µÇÂ¼Ê§°Ü£¡');"+"location.href='news/login.jsp';</script>");
	 	}
	}

}
