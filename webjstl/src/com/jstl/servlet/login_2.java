package com.jstl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eight.entity.User;


public class login_2 extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//用户名
		String userName = request.getParameter("userName");
		//密码
		String password = request.getParameter("password");
		//cmdStr
		String cmdStr = request.getParameter("cmdStr");
		
		if("post".equals(cmdStr)){
			if("admin".equals(userName) && "admin".equals(password)){
				//登录成功
				User user = new User();
				user.setUserName(userName);
				user.setPassword(password);
				user.setRole("aa");
				request.getSession().setAttribute("user", user);
			}else{
				request.setAttribute("errMsg", "用户名或密码不正确！");
			}
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
