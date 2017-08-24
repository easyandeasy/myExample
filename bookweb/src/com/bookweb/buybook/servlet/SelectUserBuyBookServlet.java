package com.bookweb.buybook.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bookweb.book.buycar.entity.Buycar;
import cn.bookweb.book.buycar.service.BuycarService;
import cn.bookweb.book.buycar.serviceimpl.IBuycarServiceImpl;
import cn.bookweb.order.entity.Order;
import cn.bookweb.user.entity.User;
import cn.bookweb.user.service.IUserService;
import cn.bookweb.user.serviceimpl.UserServiceImpl;
/**
 * 获取用户购物车，订单详细表 控制器
 * @author Happy
 *
 */
@SuppressWarnings("serial")
public class SelectUserBuyBookServlet extends HttpServlet {

	private BuycarService buycar = new IBuycarServiceImpl();
	private IUserService iuser = new UserServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//设置用户请求编码
		request.setCharacterEncoding("utf-8");
		//设置响应编码
		response.setContentType("text/html;charset=utf-8");
		//获取用户传过来的昵称
		String unickName=request.getParameter("unickname");
		//调取业务逻辑层根据昵称查询id
		PrintWriter out = response.getWriter();
		//获取当前用户登录名
		
		if(unickName!="" || unickName!=null){
			User users =(User)request.getSession().getAttribute("userSession");
			//创建用户实例
			User user = new User();
			int uid = 0;
			if(users != null){
				user.setUname(users.getUname());
				uid=iuser.queryUserNameId(user);
				user.setUid(uid);
			}
			
			/**
			 * 查询当前用户购物车
			 */
			List<Buycar> list = new ArrayList<Buycar>();
			list=buycar.queryUserBookBuycar(user,list);
			request.getSession().setAttribute("buycarUserBook",list);
			
			List<Order> listMyOrderAllInfo = buycar.queryOrderAndImageSamll(uid);
			
			request.getSession().setAttribute("listMyOrderAllInfo",listMyOrderAllInfo);
			request.getRequestDispatcher("/jsp/before/usercenter.jsp").forward(request,response);
		}else{
			out.print("<script type='text/javascript'>var f=confirm('亲，你还没有登录，点击确定前往登录~~');if(f==true){location.href='/bookweb/jsp/before/login.jsp'}else{location.href='/bookweb/jsp/before/shopping-head.jsp'};</script>");
		}
	}
}
