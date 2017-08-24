package com.bookweb.buybook.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bookweb.user.entity.User;

public class BuycarStoreServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		User user = (User)request.getSession().getAttribute("userSession");
		if(user==null){
			out.print("<script type='text/javascript'>var f=confirm('亲，你还没有登录，点击确定前往登录~~');if(f==true){location.href='/bookweb/jsp/before/login.jsp'}else{location.href='/bookweb/jsp/before/shopping-head.jsp'};</script>");
		}else{
			response.sendRedirect("/bookweb/jsp/before/usercenter.jsp");
		}
		
		out.close();
		out.flush();
	}
}
