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
		out.print("��ã�");
	}

	/**
	 * ���췽��
	 *//*
	public HelloServlet() {
		super();
	}

	*//**
	 * �����ͷ���Դ
	 *//*
	public void destroy() {
		super.destroy(); 
		System.out.println("�ͷ�ϵͳ��Դʱ��destroy()���������ã�");
	}

	*//**
	 * ��ʼ������
	 *//*
	public void init() throws ServletException {
		System.out.println("��ʼ��ʱ��init()���������ã�");
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.service(request, response);
		System.out.println("service()���������ã�");
	}*/

}
