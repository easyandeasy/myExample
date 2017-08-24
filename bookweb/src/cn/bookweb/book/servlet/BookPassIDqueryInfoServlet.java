package cn.bookweb.book.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bookweb.book.buycar.service.BuycarService;
import cn.bookweb.book.buycar.serviceimpl.IBuycarServiceImpl;
import cn.bookweb.book.dao.IBookDao;
import cn.bookweb.book.daoimpl.BookDaoImpl;
import cn.bookweb.book.entity.Book;
import cn.bookweb.user.entity.User;
import cn.bookweb.user.service.IUserService;
import cn.bookweb.user.serviceimpl.UserServiceImpl;

@SuppressWarnings("serial")
public class BookPassIDqueryInfoServlet extends HttpServlet {
	
	private BuycarService buycar = new IBuycarServiceImpl();
	private IUserService iuser = new UserServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;chartset=utf-8");
		IBookDao ibook = new BookDaoImpl();
		Book book = new Book();
		String bid = request.getParameter("name");
		book.setBid(Integer.parseInt(bid));
		List<Book> list = new ArrayList<Book>();
		list=ibook.selectBookDacktionInfo(book);
		if(list!=null){
			for(Book books:list){
				request.getSession().setAttribute("booksQueryInfo",books);
			}
			response.sendRedirect("/bookweb/jsp/before/luckgoodsbook.jsp");
		}
	}
}
