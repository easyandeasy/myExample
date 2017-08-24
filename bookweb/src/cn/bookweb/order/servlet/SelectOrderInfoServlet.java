package cn.bookweb.order.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bookweb.address.entity.Address;
import cn.bookweb.orders.entity.Orders;
import cn.bookweb.user.entity.User;
import cn.bookweb.user.service.IUserService;
import cn.bookweb.user.serviceimpl.UserServiceImpl;

/**
 * 查询指定订单信息控制器
 * @author tang
 *
 */
public class SelectOrderInfoServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		IUserService us = new UserServiceImpl();
		String onumber = request.getParameter("onumber");//获取订单编号
		Orders order = new Orders();//创建订单对象
		String uname = "";//用户名
		List<Orders> orders = (List<Orders>)request.getSession().getAttribute("orders");//获取订单信息集合
		for(Orders o : orders){//遍历订单集合
			if(o.getOnumber().equals(onumber)){//查找选择的订单
				order = o;
				break;
			}	
		}
		List<User> user = us.queryAllInfo();//获取所有用户名
		for(User u : user){//遍历用户
			if(u.getUid()==order.getUid()){//查找该订单对应的用户
				uname = u.getUname();
				break;
			}
		}
		Address address = us.queryAddressByAid(order.getAid());
		request.getSession().setAttribute("selectorder", order);//将选择的订单信息存储到会话中
		
		out.println("<script type='text/javascript'>  $(\"#onumbertext\").text(\""+order.getOnumber()+"\"); $(\"#bnametext\").text(\""+order.getBname()+"\"); $(\"#ordertimetext\").text(\""+order.getOrdertime()+"\"); $(\"#bpricetext\").text(\""+order.getBprice()+"\");  $(\"#totaltext\").text(\""+order.getTotal()+"\"); $(\"#ostatustext\").text(\""+order.getOstatus()+"\"); $(\"#icontexttext\").text(\""+order.getIcontext()+"\"); $(\"#numtext\").text(\""+order.getNum()+"\"); $(\"#uidtext\").text(\""+uname+"\"); $(\"#aidtext\").text(\""+address.getAddress()+"\"); </script>");
	}

}
