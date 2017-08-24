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
/**
 * 删除购物车控制器
 * @author Happy
 *
 */
@SuppressWarnings("serial")
public class DeleteUserBuycarServlet extends HttpServlet {
	
	private BuycarService buycar = new IBuycarServiceImpl();
	private IUserService iuser = new UserServiceImpl();

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		//设置用户请求编码
		request.setCharacterEncoding("utf-8");
		//设置响应编码
		response.setContentType("text/html;charset=utf-8");
		
		String unickName = request.getParameter("unickName");
		String ubid=request.getParameter("bid");
		
		int bbid = Integer.parseInt(ubid);
		
		//根据用户昵称查询id
		int uid = iuser.queryUserId(unickName);
		
		buycar.removeMyBuycar(uid,bbid);
		
		out.flush();
		out.close();
	}

}
