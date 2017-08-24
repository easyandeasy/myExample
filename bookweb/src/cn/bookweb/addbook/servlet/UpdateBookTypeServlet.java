package cn.bookweb.addbook.servlet;

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

public class UpdateBookTypeServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String value = request.getParameter("updatetypevalue");
		IBookTypeService service = new BookTypeServiceImpl();
		List<BookType> type = service.queryBookTypeAllInfo();//查询获取所有图书类型信息
		out.println("<option value='0'>————请选择————</option>");
		System.out.println(value);
		if(value != null){//判断选择的类型是否为空
			for(BookType b : type){//遍历图书集合
				if(value.equals(b.getPid())){//判断选择的大类型与分类中字段 pid是否符合，符合将娄类输出
					out.println("<option value='"+b.getTid()+"' name='type2' class='two'>"+b.getTname()+"</option> ");
				}
			}
		}
	}

}
