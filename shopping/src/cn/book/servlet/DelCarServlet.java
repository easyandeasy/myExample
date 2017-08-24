package cn.book.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.book.entity.Book;

/**
 * É¾³ý¹ºÎï³µ¿ØÖÆÆ÷
 * @author tang
 *
 */
public class DelCarServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");//ÉèÖÃ×Ö·û±àÂë
		PrintWriter out = response.getWriter();
		String index = request.getParameter("index");
		List<Book> shopCar = (List<Book>)request.getSession().getAttribute("shoplist");
		int id = Integer.valueOf(index);
		//shopCar.remove(id);
		shopCar.remove(shopCar.get(id));
		request.getSession().setAttribute("shoplist", shopCar);
		out.println("<script type='text/javascript' >"+"alert('É¾³ý³É¹¦'); ");
		out.println("location.href='jsp/shoppingCar.jsp'");
		out.println("</script>");
	}

}
