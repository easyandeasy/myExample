package com.bookweb.buybook.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bookweb.book.buycar.service.BuycarService;
import cn.bookweb.book.buycar.serviceimpl.IBuycarServiceImpl;
import cn.bookweb.book.entity.Book;
import cn.bookweb.rundom.util.CommonUtil;
import cn.bookweb.user.entity.User;
import cn.bookweb.user.service.IUserService;
import cn.bookweb.user.serviceimpl.UserServiceImpl;

@SuppressWarnings("serial")
public class BuycarUserOrderServlet extends HttpServlet {
	
	private IUserService iuser = new UserServiceImpl();
	private BuycarService buycar = new IBuycarServiceImpl();


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String unickName=request.getParameter("name");
		
		if(unickName==""){
			out.print("<script type='text/javascript'>var f=confirm('亲，你还没有登录，点击确定前往登录~~');if(f==true){location.href='/bookweb/jsp/before/login.jsp'}else{location.href='/bookweb/jsp/before/shopping-head.jsp'};</script>");
		}else{
			User users =(User)request.getSession().getAttribute("userSession");
			
			//获取用户id
			User user = new User();
			user.setUname(users.getUname());
			Book book = new Book();
			CommonUtil comm= new CommonUtil();
			String uuid=comm.uuid();
			//获取用户id
			int uid=iuser.queryUserNameId(user);

			//获取图书id
			int bid=0;

			bid=Integer.parseInt(request.getParameter("bid"));

			user.setUid(uid);
			book.setBid(bid);

			if(uid!=0){
				//判断用户加入购物车是否存在该书如果存在则加数量
				if(buycar.queryUseBookRowCountBuycar(bid,uid)==bid){
					int sums=buycar.queryUserBookBuycarNumbertity(bid,uid);
					++sums;
					buycar.replaceUserBookBuycar(sums,bid,uid);
				}else{
					//执行添加购物车
					buycar.addUserBookBuycar(uuid,1,book,user);
				}
				
				//获取用户购物车总数量
				int buycarCount = buycar.queryUserBookCountBuycar(uid);
				
				request.getSession().setAttribute("userBuycarCount",buycarCount);
				request.getRequestDispatcher("/jsp/before/shopping-order.jsp").forward(request,response);
			}
		}
		out.flush();
		out.close();
	}
}
