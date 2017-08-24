package cn.book.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.book.entity.Book;

/**
 * 添加到购物车控制器
 * @author tang
 *
 */
public class addCarServlet extends HttpServlet {


	Book bk = new Book();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String str = "添加成功！";
		int bid = 0;
		boolean flag = true;
		PrintWriter out = response.getWriter();
		
		List<Book> shopCar = (List<Book>)request.getSession().getAttribute("shoplist");
		List<Book> book = (List<Book>)request.getSession().getAttribute("book");
		if(shopCar == null){
			shopCar = new ArrayList<Book>();
		}
		int now = (Integer) request.getSession().getAttribute("now");
		String id = request.getParameter("bid");
		if(id != null){
			bid = Integer.valueOf(id);
		}
		Book bk = book.get(bid);
		
		for(Book b : shopCar){
			if(b.getBid()==bk.getBid()){
				b.setNum(b.getNum() + 1);
				flag = false;
				break;
			}
		}
		
		if(flag){
			shopCar.add(bk);
		}
		request.getSession().setAttribute("shoplist", shopCar);
		out.println("<script type='text/javascript' >"+"alert('"+str+"'); ");
		out.println("location.href='BookInfoServlet?pageIndex="+now+"'");
		out.println("</script>");
		
		
		//request.getRequestDispatcher("BookInfoServlet?pageIndex="+now+"").forward(request, response);
		/*for(Book b : book){
			if(b.getBid()==bid){
				bk = b;
				break;
			}
		}*/
	}

}
