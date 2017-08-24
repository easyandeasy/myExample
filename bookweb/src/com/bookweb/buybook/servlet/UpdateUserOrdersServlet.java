package com.bookweb.buybook.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bookweb.book.buycar.service.BuycarService;
import cn.bookweb.book.buycar.serviceimpl.IBuycarServiceImpl;
import cn.bookweb.order.entity.Order;
import cn.bookweb.user.service.IUserService;
import cn.bookweb.user.serviceimpl.UserServiceImpl;

@SuppressWarnings("serial")
public class UpdateUserOrdersServlet extends HttpServlet {
	
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
		//获取当前操作的订单号
		String onumber = request.getParameter("onumber");
		//获取当前用户昵称
		String unickName = request.getParameter("unickName");
		//获取需要修改的状态类型
		String ostatus = request.getParameter("ostatus");
		//将状态类型转换为int型
		int ostatu = Integer.parseInt(ostatus);
		
		//根据昵称查询用户id
		int uid = iuser.queryUserId(unickName);
		
		buycar.replaceOrderInfo(ostatu,onumber,uid);
		
		List<Order> listMyOrderAllInfo = buycar.queryOrderAndImageSamll(uid);
		
		request.getSession().setAttribute("listMyOrderAllInfo",listMyOrderAllInfo);
		
		response.sendRedirect("/bookweb/jsp/before/usercenter.jsp");
	}

}
