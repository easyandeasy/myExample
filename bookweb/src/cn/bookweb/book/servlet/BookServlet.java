package cn.bookweb.book.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bookweb.book.entity.Book;
import cn.bookweb.book.service.IBookService;
import cn.bookweb.book.serviceimpl.BookServiceImpl;
import cn.bookweb.page.util.PageUtil;


/**
 * 图书查询控制器
 * @author tang
 *
 */
public class BookServlet extends HttpServlet {

	IBookService service = new BookServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String index = request.getParameter("pageindex");
		if(index==null){
			index="1";
		}
		int pageindex = Integer.parseInt(index);//当前页
		String tid = request.getParameter("tid");//图书分类 tid
		int count = service.queryBookCount(tid);//总记录数
		PageUtil pages = new PageUtil(pageindex,count,10);
		//获取所有属于 tid 类型的图书
		List<Book> book = service.queryBookByTid(tid,pages);
		request.getSession().setAttribute("book", book);
		String str = "null";
		String path = "jsp/after/nobookinfo.jsp";
		if(book.size()!=0){
			str = "length";
			path ="jsp/after/showbookinfo.jsp";
		}
		request.getSession().setAttribute("str", str);
		request.getSession().setAttribute("pageindex", pageindex);//存储当前页
		request.getSession().setAttribute("pages", pages);//存储分页对象
		request.getSession().setAttribute("tid", tid);//存储当前分类id
		out.println("<script type='text/javascript'> location.href='"+path+"' </script>");
	}

}
