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
import cn.bookweb.book.entity.Book;
import cn.bookweb.book.service.IBookService;
import cn.bookweb.book.serviceimpl.BookServiceImpl;
import cn.bookweb.booktype.entity.BookType;
import cn.bookweb.booktype.service.IBookTypeService;
import cn.bookweb.booktype.serviceimpl.BookTypeServiceImpl;


/**
 * 管理员登录控制器
 * @author tang
 *
 */
public class AdminLoginServlet extends HttpServlet {

	IAdminService service = new AdminServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Admin admin = new Admin();//创建管理员对象
		//实现化业务层对象
		IBookTypeService servicet = new BookTypeServiceImpl();
		//实现化业务层对象
		//获取图书类型的集合
		List<BookType> booktype = servicet.queryBookTypeAllInfo();
		//将booktype信息存储到 session中
		request.getSession().setAttribute("booktype", booktype);//将集合存储到会话中
		String adminname = request.getParameter("adminname");//获取输入的用户名
		String adminpwd = request.getParameter("adminpwd");//获取输入的密码
		admin.setAdminname(adminname);//将用户名存储到对象中
		admin.setAdminpwd(adminpwd);//将密码存储到对象中
		int adminid = service.queryAdminLogin(admin);//调用业务层，判断用户是否存在
		if(adminid>0){//为御前则存在，否则不存在
			IBookService book = new BookServiceImpl();//图书业务层
			List<Book> bookall = book.queryBookAllInfo();//获取图书所有信息
			request.getSession().setAttribute("bookall", bookall);//将图书信息存储到会话中
			request.getSession().setAttribute("adminname", adminname);//将用户名存储到会话中
			request.getSession().setAttribute("adminpwd", adminpwd);//将密码存储到会话中
			request.getSession().setAttribute("adminid", Integer.toString(adminid));//将用户编号存储到会话中
			out.print("<script type='text/javascript'>"+"location.href='jsp/after/adminmanage.jsp';</script>");
		}else{
			out.print("<script type='text/javascript'>"+"alert('登录失败！');"+"location.href='jsp/after/adminlogin.jsp';</script>");
		}
	}

}
