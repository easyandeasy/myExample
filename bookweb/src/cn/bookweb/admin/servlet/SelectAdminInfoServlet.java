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
import cn.bookweb.page.util.PageUtil;

/**
 * 查询管理员信息控制器
 * @author tang
 *
 */
public class SelectAdminInfoServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		IAdminService service = new AdminServiceImpl();
		
		String adminname = request.getParameter("adminname");//查询的名称
		String adminindex = request.getParameter("adminindex");//当前页
		if(adminindex == null || adminindex == ""){
			adminindex = "1";
		}
		int count = 0;
		if(adminname != null){
			count = service.queryAdminAllInfoByNameCount(adminname);
		}
		PageUtil page = new PageUtil(Integer.parseInt(adminindex),count,10);//该名称的总记录数
		List<Admin> admin = service.queryAdminAllInfoLike(adminname, page);//实例化业务层对象
		String userempty = "noempty";
		//System.out.println(user.size());
		if(admin.size()==0){//判断查询出的集合是否有值
			userempty = "empry";
		}
		
		request.getSession().setAttribute("admininfos", admin);//管理员信息集合存储到会话中
		request.getSession().setAttribute("adminpage", page);//将用户信息分页对象存储到会话中
		request.getSession().setAttribute("adminnamelike", adminname);//将按用户名查询的名称存储到会话中
		request.getSession().setAttribute("adminindex", adminindex);//将当前页存储到会话中
		request.getSession().setAttribute("adminempty", userempty);//将判断是否显示分页的字符串存储到会话中
		
		out.println("<script type='text/javascript' > location.href='jsp/after/updatemanages.jsp'; </script>");
		
	}

}
