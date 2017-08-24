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


/**
 * 初始化订单的信息控制器
 * @author tang
 *
 */
public class OrderInfoServlet extends HttpServlet {


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
		List<Orders> orders = null;
		PageUtil page = null;
		if(index == null || index == ""){//判断获取到的当前页是否为空
			index = "1";
		}
		if(onumber==null){
			if(ostatus == null || ostatus==""){//判断类型是否为空
				ostatus = "0";
			}
			int count = service.queryOrderInfoCountSQL(Integer.parseInt(ostatus));//查询类型的总条数
			page = new PageUtil(Integer.parseInt(index),count,3);//分页对象
			if(ostatus.equals("0")){
				orders = service.queryOrderInfoAllSQL(page);//查询所有类型订单的信息
			}else{
				orders = service.queryOrderInfoSQL(Integer.parseInt(ostatus),page);//查询指定类型的信息
			}
		}else{
			int count = service.queryOrderInfoByLikeCountSQL(onumber);
			page = new PageUtil(Integer.parseInt(index),count,3);//分页对象
			orders = service.queryOrderInfoByLikeSQL(onumber, page);
		}
		String orderisempty = "noempty";
		if(orders.size()==0){//判断查询出的集合是否有值
			orderisempty = "empry";
		}
		request.getSession().setAttribute("orderindex", index);//将当前页存储到会话中
		request.getSession().setAttribute("orderpage", page);//将分页对象存储到会话中	
		request.getSession().setAttribute("ostatus", ostatus);//将查询的类型存储到会话中
		request.getSession().setAttribute("orders", orders);//将查询到的席间集合存储到会话中
		request.getSession().setAttribute("isempty", orderisempty);//将查询到的订单信息是否有值 存储到会话中
		request.getSession().setAttribute("onumber", onumber);//将订单编号存储到会话中
		out.println("<script type='text/javascript'>  location.href='jsp/after/ordermanage.jsp'  </script>");	
	}
	
}






























/*
 * 
 * 
//out.println("<div class=\"orderinfos\"><div class=\"ordertop1\"><input type=\"checkbox\" />&nbsp;&nbsp;"+order.getOrdertime()+"&nbsp;&nbsp;"+order.getOnumber()+"</div><div class=\"orderinfo1\"><div class=\"orderinfo1\"><li class=\"images\" ><img src=\"../../"+order.getImagesmall()+"\" width=\"80px\" height=\"80px\"/></li><li class=\"bnames\">"+order.getBname()+"</li><li class=\"price\">￥"+order.getBprice()+"</li><li class=\"num\">"+order.getNum()+"</li><li class=\"shiprice\"><strong>￥"+order.getTotal()+"</strong></li><li class=\"status\">"+status+"</li><li class=\"chaozuo\"><a href=\"#\" >删除</a><br/><br/><a href=\"#\" >详情</a></li></div></div></div>	");
//out.println("<c:if test=\"${isempty eq 'noempty'}\"><div class=\"orderspage\" align=\"right\">当前页:["+page.getNow()+"/"+page.getCount()+"}]&nbsp;&nbsp;<c:if test=\"${orderpage.now>1 }\"><a href=\"../../OrderInfoServlet?orderindex=${orderpage.first }&ostatus=${ostatus}\" target=\"mainFrame\">首页</a>&nbsp;&nbsp;<a href=\"../../OrderInfoServlet?orderindex=${orderpage.back }&ostatus=${ostatus}\" target=\"mainFrame\">上一页</a>&nbsp;&nbsp;</c:if><c:if test=\"${orderpage.now<orderpage.count }\"><a href=\"../../OrderInfoServlet?orderindex=${orderpage.next }&ostatus=${ostatus}\" target=\"mainFrame\">下一页</a>&nbsp;&nbsp;<a href=\"../../OrderInfoServlet?orderindex=${orderpage.last }&ostatus=${ostatus}\" target=\"mainFrame\">未页</a>&nbsp;&nbsp;</c:if>	</div></c:if><c:if test=\"${isempty eq 'empty' }\"></c:if>");
//System.out.println(index + " " + ostatus + " " + orderisempty + " " + orders.size() + " " + count +" " + page.getCount() + " " + page.getPageSize());
<c:if test=\"${isempty eq 'noempty'}\"><div class=\"orderspage\" align=\"right\">当前页:[${orderpage.now }/${orderpage.count }]&nbsp;&nbsp;<c:if test=\"${orderpage.now>1 }\"><a href=\"../../OrderInfoServlet?orderindex=${orderpage.first }&ostatus=${ostatus}\" target=\"mainFrame\">首页</a>&nbsp;&nbsp;<a href=\"../../OrderInfoServlet?orderindex=${orderpage.back }&ostatus=${ostatus}\" target=\"mainFrame\">上一页</a>&nbsp;&nbsp;</c:if><c:if test=\"${orderpage.now<orderpage.count }\"><a href=\"../../OrderInfoServlet?orderindex=${orderpage.next }&ostatus=${ostatus}\" target=\"mainFrame\">下一页</a>&nbsp;&nbsp;<a href=\"../../OrderInfoServlet?orderindex=${orderpage.last }&ostatus=${ostatus}\" target=\"mainFrame\">未页</a>&nbsp;&nbsp;</c:if>	</div></c:if><c:if test=\"${isempty eq 'empty' }\"></c:if>
*/