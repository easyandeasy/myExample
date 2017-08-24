package cn.bookweb.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bookweb.admin.service.IAdminService;
import cn.bookweb.admin.serviceimpl.AdminServiceImpl;

/**
 * 查询用户名和身份证号是否存在控制器
 * @author tang
 *
 */
public class AdminIsExistServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String adminname = request.getParameter("forgetname");//用户名
		IAdminService service = new AdminServiceImpl();
		//判断用户名是否存在
		if(service.queryAdminName(adminname)==false){
			out.print("<font size='1' color='red'>用户名不存在！</font>");
		}
	}

}
