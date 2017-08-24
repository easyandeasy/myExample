package cn.bookweb.updatebook.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bookweb.book.entity.Book;
import cn.bookweb.book.service.IBookService;
import cn.bookweb.book.serviceimpl.BookServiceImpl;

/**
 * 删除 和 修改 图书信息 控制器
 * @author tang
 *
 */
public class DeleteBookInfoServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		IBookService service = new BookServiceImpl();
		String bid = request.getParameter("bid");//获取图书编号
		boolean flag = service.removeBookInfo(Integer.parseInt(bid));//调用业务层进行删除
		if(flag){//判断是否删除成功
			out.println("<script type='text/javascript'> alert('删除成功！'); location.href='jsp/after/showbookinfo.jsp' </script>");
		}else{
			out.println("<script type='text/javascript'> alert('删除失败！');  location.href='jsp/after/showbookinfo.jsp'  </script>");
		}
	}

}
