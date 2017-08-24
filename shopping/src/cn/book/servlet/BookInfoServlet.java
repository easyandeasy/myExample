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
		
		String pageIndex = request.getParameter("pageIndex");//��ȡ��ǰҳ��
		
		//��pageIndex �� bid ת����int����
		int currPageNo = Integer.parseInt(pageIndex);//��ǰҳ��
		
		int totalCount = service.selectBookCount();//�ܼ�¼��
		
		PageUtil pages = new PageUtil(currPageNo,totalCount);//��ҳ����
		List<Book> book = service.selectAllBook(pages);
		request.getSession().setAttribute("book", book);
		request.setAttribute("pages", pages);//����ҳ����洢��request��
		request.setAttribute("count", pages.getCount());//��ҳ��
		request.setAttribute("now", pages.getNow());//��ǰҳ��
		
		request.getRequestDispatcher("jsp/shopping.jsp").forward(request, response);
		//response.sendRedirect("jsp/shopping.jsp");
	}


}
