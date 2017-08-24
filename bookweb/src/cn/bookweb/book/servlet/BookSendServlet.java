package cn.bookweb.book.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bookweb.book.entity.Book;
import cn.bookweb.book.service.IBookService;
import cn.bookweb.book.serviceimpl.BookServiceImpl;
import cn.bookweb.booktype.entity.BookType;
import cn.bookweb.booktype.service.IBookTypeService;
import cn.bookweb.booktype.serviceimpl.BookTypeServiceImpl;

@SuppressWarnings("serial")
public class BookSendServlet extends HttpServlet {

	private IBookService ibook = new BookServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		List<Book> lists= new ArrayList<Book>();
		//类型实现化业务层对象//
		IBookTypeService servicet = new BookTypeServiceImpl();
		//获取图书类型的集合
		List<BookType> booktype2 = servicet.queryBookTypeAllInfo();
		//图书实现化业务层对象//
		IBookService books = new BookServiceImpl();
		//获取图书的集合
		List<Book> list = books.queryBookAllInfo();
		//图书对象
		
		
		for(BookType type : booktype2){//遍历类型
			Book book = new Book();
			int i = 1;
			for(Book b : list){
				if(b.getBigtid().equals(type.getTid())){
					book.setTid(type.getTid());
					book.setSelectone(type.getTname());
					if(i==1){
						book.setImagesmall1(b.getImagesmall());
						book.setBid1(b.getBid());
					}
					if(i==2){
						book.setImagesmall2(b.getImagesmall());
						book.setBid2(b.getBid());
					}
					if(i==3){
						book.setImagesmall3(b.getImagesmall());
						book.setBid3(b.getBid());
					}
					if(i==4){
						book.setImagesmall4(b.getImagesmall());
						book.setBid4(b.getBid());
					}
					if(i==5){
						book.setImagesmall5(b.getImagesmall());
						book.setBid5(b.getBid());
					}
					if(i==6){
						book.setImagesmall6(b.getImagesmall());
						book.setBid6(b.getBid());
					}
					i++;
					if(i==7){
						break;
					}
				}
			}
			lists.add(book);
		}
		
		
		request.getSession().setAttribute("shoppingtype", booktype2);
		request.getSession().setAttribute("shoppingbooks", lists);
		
		
		Book book2 = new Book();
		List<Book> list2= new ArrayList<Book>();
		list2=ibook.selectBooksend(book2);
		for(int i=0;i<list2.size();i++){
			Book bookss = (Book)list2.get(i);
			request.getSession().setAttribute("bookListSend"+i,bookss);
		}
		
		//out.println("<script type='text/javascript'> location.href='jsp/before/shopping-head.jsp' </script>");
		request.getRequestDispatcher("/jsp/before/shopping-head.jsp").forward(request,response);
	}

}
