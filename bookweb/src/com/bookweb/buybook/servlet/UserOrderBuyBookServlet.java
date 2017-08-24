package com.bookweb.buybook.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bookweb.book.buycar.entity.Buycar;
import cn.bookweb.book.buycar.service.BuycarService;
import cn.bookweb.book.buycar.serviceimpl.IBuycarServiceImpl;
import cn.bookweb.order.entity.Order;
import cn.bookweb.rundom.util.CommonUtil;
import cn.bookweb.user.dao.IUserDao;
import cn.bookweb.user.daoimpl.UserDaoImpl;
import cn.bookweb.user.entity.User;

@SuppressWarnings("serial")
public class UserOrderBuyBookServlet extends HttpServlet {

	private BuycarService buycar = new IBuycarServiceImpl();
	private IUserDao iuser = new UserDaoImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//处理请求编码，处理响应编码
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		//获取用户输入的地址
		String address=request.getParameter("address");
		address = new String(address.getBytes("ISO-8859-1"),"UTF-8");
		
		//获取当前用户名
		String unickName = request.getParameter("unickName");
		//获取用户购物车总金额
		String money = request.getParameter("total");
		double moneys = new Double(money).doubleValue();
		
		//获得随机数
		CommonUtil comm = new CommonUtil();
		String roundom = comm.uuid();
		
		//获取当前时间
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowtime = date.format(new Date());
		
		//获取用户当前用户id
		int uid = iuser.selectUserId(unickName);
		
		User user = new User();
		user.setUid(iuser.selectUserId(unickName));
		
		List<Buycar> list = new ArrayList<Buycar>();
		list=buycar.queryUserBookBuycar(user, list);
		
		//得到用户发货地址的id
		int row =buycar.queryUserAidAddress(uid,address);
		
		Order order = new Order();
		order.setOrderInfoList(list);
		order.setAid(row);
		order.setOnumber(roundom);
		order.setOrdertime(nowtime);
		order.setTotal(moneys);
		order.setOstatus(1);
		order.setUid(iuser.selectUserId(unickName));
		
		//如果提交订单成功则删除购物当前用户购物车条目信息表中的数据
		if(row==0){
			out.print("<script type='text/javascript'>$('.errorAddressNull').text('您还没选择收货地址哦~');</script>");
			response.sendRedirect("/jsp/before/usercenter.jsp");
		}else{
			if(buycar.addUserSubmitOrderBook(order,order.getOnumber(),list)){
				buycar.removeUserBuycarBook(uid);
				//存储当前用户提交订单生成的订单号，存储当前用户提交订单的总金额，存储当前用户提交订单的收货地址
				out.print("<script type='text/javascript'>$('.orderid').text('"+roundom+"'); $('#money').text('"+moneys+"'); $('.address').text('"+address+"'); </script>");
			}
		}
		//errorAddressNull","您还没选择收货地址哦~"
	}
}
