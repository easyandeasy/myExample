package cn.book.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.user.service.IUserService;
import cn.user.serviceimpl.UserServiceImpl;

/**
 * µÇÂ¼¿ØÖÆÆ÷
 * @author tang
 *
 */
public class LoginServlet extends HttpServlet {

	IUserService service = new UserServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String path = "jsp/login.jsp";
		String name = request.getParameter("userName");
		String pwd = request.getParameter("password");
		
		boolean flag =  service.selectIsUser(name, pwd);
		
		if(flag){
			path = "jsp/shopping.jsp";
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
