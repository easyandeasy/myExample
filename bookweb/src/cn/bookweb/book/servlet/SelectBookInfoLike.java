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
 * 模糊查询图书信息控制器
 * @author tang
 *
 */
public class SelectBookInfoLike extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String index = request.getParameter("index");//获取当前页
		if(index == null || index == ""){
			index = "1";
		}
		int now = Integer.parseInt(index);//转换成int
		
		IBookService service = new BookServiceImpl();//实例业务层对象
		String bname = request.getParameter("bname");//获取图书名称
		int count = service.queryBookCountByBname(bname);
		System.out.println(count);
		PageUtil page = new PageUtil(now,count,10);//分页对象
		List<Book> booklike = service.queryBookInfoPage(bname,page);//获取分页的图书集合
		System.out.print(booklike.size());
		String str = "null";//判断是否显示分页
		String path = "jsp/after/bookinfono.jsp";
		if(booklike.size()!=0){
			str = "like";
			path ="jsp/after/showselectbookinfo.jsp";
		}
		request.getSession().setAttribute("strlike", str);
		request.getSession().setAttribute("index", index);//存储当前页
		request.getSession().setAttribute("page", page);//存储分页对象
		request.getSession().setAttribute("bname", bname);//存储当前分类id
		request.getSession().setAttribute("selectbookinfolike", booklike);//将集合存储入会话中
		out.print("<script type='text/javascript'>"+"location.href='"+path+"';</script>");
	}


}
