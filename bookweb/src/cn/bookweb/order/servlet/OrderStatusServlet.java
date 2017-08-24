package cn.bookweb.order.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bookweb.order.service.IOrderService;
import cn.bookweb.order.serviceimpl.OrderServiceImpl;
import cn.bookweb.orders.entity.Orders;
import cn.bookweb.page.util.PageUtil;

public class OrderStatusServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		IOrderService service = new OrderServiceImpl();
		String ostatus = request.getParameter("status");//订单类型
		String index = request.getParameter("orderindex");//当前页
		String onumber = request.getParameter("onumber");//订单编号
		
		boolean flag = service.replaceOrderInfostatusSQL(3,onumber);
		
		int count = service.queryOrderInfoCountSQL(Integer.parseInt(ostatus));//查询类型的总条数
		PageUtil page = new PageUtil(Integer.parseInt(index),count,3);//分页对象
		List<Orders> orders = service.queryOrderInfoSQL(0,page);//查询指定类型的信息
		
		String orderisempty = "noempty";
		System.out.println(orders.size());
		if(orders.size()==0){//判断查询出的集合是否有值
			orderisempty = "empry";
		}
		request.getSession().setAttribute("orderindex", index);//将当前页存储到会话中
		request.getSession().setAttribute("orderpage", page);//将分页对象存储到会话中	
		request.getSession().setAttribute("ostatus", ostatus);//将查询的类型存储到会话中
		request.getSession().setAttribute("orders", orders);//将查询到的席间集合存储到会话中
		request.getSession().setAttribute("isempty", orderisempty);//将查询到的订单信息是否有值 存储到会话中
		out.println("<script type='text/javascript'> alert('发货成功'); location.href='jsp/after/ordermanage.jsp'  </script>");	
	}

}
