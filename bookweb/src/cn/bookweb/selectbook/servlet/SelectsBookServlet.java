package cn.bookweb.selectbook.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bookweb.book.dao.IBookDao;
import cn.bookweb.book.daoimpl.BookDaoImpl;
import cn.bookweb.book.entity.Book;
import cn.bookweb.book.service.IBookService;
import cn.bookweb.book.serviceimpl.BookServiceImpl;

public class SelectsBookServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		IBookService service = new BookServiceImpl();
		String bname = request.getParameter("bname");//获取书名
		List<Book> booklike = service.queryBookInfoLike(bname);//service.queryBookInfoLike("java");
		//request.getSession().setAttribute("selectbookinfolike", booklike);
		int i = 0;
		for(Book b :booklike){//遍历图书集合 显示模糊查询的图书名
			String name = b.getBname();
			if(name.length()>30){//截取长度大于30的书名
				name = name.substring(0,30);
			}
			if(i==15){//显示前15个书名
				break;
			}
			String a = "<div onclick=\"selectclick(this)\" id=\"selectli"+i+"\" ><a href=\"../../SelectBookInfoLike?bname="+b.getBname()+"\" title=\""+b.getBname()+"\" id=\"selecta"+i+"\" target=\"mainFrame\">"+name+"</a></div>";
			out.print(a);
			i++;
		}
	}

}
