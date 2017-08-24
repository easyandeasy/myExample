package cn.bookweb.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bookweb.admin.entity.Admin;
import cn.bookweb.admin.service.IAdminService;
import cn.bookweb.admin.serviceimpl.AdminServiceImpl;

/**
 * 管理员的个人信息显示控制器
 * @author tang
 *
 */
public class AdminInfoServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		IAdminService admins = new AdminServiceImpl();
		String adminid = (String)request.getSession().getAttribute("adminid");//获取管理员编号
		List<Admin> admin = admins.queryAdminAllInfo();//获取所有管理员信息
		Admin nowadmin = new Admin();//创建一个新的管理员对象
		if(adminid != null){//判断管理员编号是否为空
			for(Admin a : admin){//遍历所有管理员信息
				if(a.getAdminid()==Integer.parseInt(adminid)){//查找当前管理员信息
					nowadmin = a;//将查找到的管理员信息存储到新的对象中
					break;
				}
			}
		}
		request.getSession().setAttribute("admin", nowadmin);//将当前管理员信息存储到会话中
		out.println("<script type='text/javascript' > location.href='jsp/after/manages.jsp'; </script>");
	}

}
