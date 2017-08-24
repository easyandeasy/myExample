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
 * 修改大类型控制器
 * @author tang
 *
 */
public class UpdateBookTypeServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String tid = request.getParameter("tid");//获取类型编号
		String tname = request.getParameter("tname");//获取类型名称
		BookType type = new BookType();//创建类型对象
		type.setTid(tid);//将类型编号存储到对象中
		type.setTname(tname);//将类型名称存储到对象中
		type.setTcontext(tname);//将类型名称存储到对象的备注中
		IBookTypeService service = new BookTypeServiceImpl();//创建业务层对象
		boolean flag = service.replaceBookType(type);//调用业务层方法进行修改
		if(flag){//判断判断是否成功
			List<BookType> booktype = service.queryBookTypeAllInfo();//查询修改后的数据
			request.getSession().setAttribute("booktype", booktype);//将数据存储到会话中
			out.println("<script type='text/javascript'>  window.location=window.location;  </script>");
		}
	}
}
