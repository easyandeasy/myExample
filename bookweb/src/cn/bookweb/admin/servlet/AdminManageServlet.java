package cn.bookweb.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bookweb.book.entity.Book;
import cn.bookweb.book.service.IBookService;
import cn.bookweb.book.serviceimpl.BookServiceImpl;

/**
 * 管理员主界面控制吕
 * @author tang
 *
 */
public class AdminManageServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		/*IBookService book = new BookServiceImpl();
		List<Book> bookall = book.queryBookAllInfo();
		for(Book b :bookall){
			System.out.println(b.getImagesmall());
		}
		request.getSession().setAttribute("bookall", bookall);
		response.sendRedirect("jsp/after/adminmanage.jsp");*/
	}

}
