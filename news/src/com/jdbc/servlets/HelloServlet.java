package com.jdbc.servlets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print("你好！");
	}

	/**
	 * 构造方法
	 *//*
	public HelloServlet() {
		super();
	}

	*//**
	 * 用于释放资源
	 *//*
	public void destroy() {
		super.destroy(); 
		System.out.println("释放系统资源时，destroy()方法被调用！");
	}

	*//**
	 * 初始化方法
	 *//*
	public void init() throws ServletException {
		System.out.println("初始化时，init()方法被调用！");
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.service(request, response);
		System.out.println("service()方法被调用！");
	}*/

}
