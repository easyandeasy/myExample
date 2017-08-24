package cn.bookweb.addbook.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 添加图书 文本框验证控制器
 * @author tang
 *
 */
public class AddBookTextServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//String bname = System.Web.HttpUtility.UrlDecode(request["txtName"]);
		String bname = request.getParameter("bname");

		System.out.println(request.getParameterNames());
		if(bname == null){
			//out.println("True");
		}
		String price = request.getParameter("price");
		if(price == null){
			//out.println("定价不能为空！");
		}
		String currprice = request.getParameter("currprice");
		if(currprice == null){
			//out.println("当前价不能为空！");
		}
		System.out.println(bname +" "+price);
	}

}
