package cn.bookweb.booktype.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bookweb.booktype.entity.BookType;
import cn.bookweb.booktype.service.IBookTypeService;
import cn.bookweb.booktype.serviceimpl.BookTypeServiceImpl;


/**
 * 图书类型查询控制器
 * @author tang
 *
 */
public class BookTypeServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//实现化业务层对象
		IBookTypeService service = new BookTypeServiceImpl();
		//获取图书类型的集合
		List<BookType> booktype = service.queryBookTypeAllInfo();
		//将booktype信息存储到 session中
		request.getSession().setAttribute("booktype", booktype);
		
		//转发到adminmanage.jsp中
		request.getRequestDispatcher("jsp/after/adminmanage.jsp").forward(request, response);
	}

}
