package cn.bookweb.booktype.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bookweb.booktype.service.IBookTypeService;
import cn.bookweb.booktype.serviceimpl.BookTypeServiceImpl;

/**
 * 判断输入的类型名称是否为空控制器
 * @author tang
 *
 */
public class BookTypeIsUpdateServlet extends HttpServlet {



	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String tname = request.getParameter("tname");
		if(tname==""){//判断输入的类型名称是否为空
			out.println("类型不能为空！");
		}else{
			out.println("<script type='text/javascript'> document.getElementById('updatetypesub').click(); </script>");
		}
	}


}
