package cn.book.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.book.entity.Book;
import cn.book.entity.PageUtil;
import cn.book.service.IBookService;
import cn.book.serviceimpl.BookServiceImpl;

public class BookInfoServlet extends HttpServlet {

	IBookService service = new BookServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String pageIndex = request.getParameter("pageIndex");//获取当前页数
		
		//将pageIndex 和 bid 转换成int类型
		int currPageNo = Integer.parseInt(pageIndex);//当前页数
		
		int totalCount = service.selectBookCount();//总记录数
		
		PageUtil pages = new PageUtil(currPageNo,totalCount);//分页对象
		List<Book> book = service.selectAllBook(pages);
		request.getSession().setAttribute("book", book);
		request.setAttribute("pages", pages);//将分页对象存储到request中
		request.setAttribute("count", pages.getCount());//总页数
		request.setAttribute("now", pages.getNow());//当前页号
		
		request.getRequestDispatcher("jsp/shopping.jsp").forward(request, response);
		//response.sendRedirect("jsp/shopping.jsp");
	}


}
