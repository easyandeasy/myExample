package com.bookweb.buybook.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bookweb.book.buycar.service.BuycarService;
import cn.bookweb.book.buycar.serviceimpl.IBuycarServiceImpl;
import cn.bookweb.user.entity.User;
import cn.bookweb.user.service.IUserService;
import cn.bookweb.user.serviceimpl.UserServiceImpl;

public class BuycarCountServlet extends HttpServlet {

	private BuycarService buycar = new IBuycarServiceImpl();
	private IUserService iuser = new UserServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//设置响应编码
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		//获取当前用户登录名
		User users =(User)request.getSession().getAttribute("userSession");

		//创建用户实例
		if(users != null){
			User user = new User();
			user.setUname(users.getUname());
			int uid=iuser.queryUserNameId(user);
			user.setUid(uid);
			int count =buycar.queryUserBookCountBuycar(uid);
			request.getSession().setAttribute("userBuycarCount",count);
		}
		
		request.getRequestDispatcher("/jsp/before/shopping-head.jsp").forward(request, response);

		out.flush();
		out.close();
	}

}
