package cn.bookweb.book.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bookweb.book.buycar.service.BuycarService;
import cn.bookweb.book.buycar.serviceimpl.IBuycarServiceImpl;
import cn.bookweb.book.entity.Book;
import cn.bookweb.book.service.IBookService;
import cn.bookweb.book.serviceimpl.BookServiceImpl;
import cn.bookweb.page.util.PageUtil;
import cn.bookweb.rundom.util.CommonUtil;
import cn.bookweb.user.entity.User;
import cn.bookweb.user.service.IUserService;
import cn.bookweb.user.serviceimpl.UserServiceImpl;

@SuppressWarnings("serial")
public class BookSelectAllServlet extends HttpServlet {

	private IBookService bookType = new BookServiceImpl();
	private IUserService iuser = new UserServiceImpl();
	private BuycarService buycar = new IBuycarServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		List<Book> book = new ArrayList<Book>();
		
		String index = request.getParameter("pageindex");
		String tid = request.getParameter("tid");
		if(index==null){
			index="1";
		}
		if(tid==null){
			tid="1";
		}
		System.out.println(tid);
		int pageindex = Integer.parseInt(index);//当前页
		
		PageUtil pages = new PageUtil(pageindex,6,20);
		
		book=bookType.queryAllOrderBook(pages,tid);
		
		request.getSession().setAttribute("bookAll",book);
		
		request.getSession().setAttribute("pageindex", pageindex);//存储当前页
		request.getSession().setAttribute("pages", pages);//存储分页对象
		
		
		if(request.getParameter("uname")!=""){
			
			User users =(User)request.getSession().getAttribute("userSession");
			
			//获取用户id
			User user = new User();
			user.setUname(users.getUname());
			
			//获取用户id
			int uid=iuser.queryUserNameId(user);

			user.setUid(uid);

			//获取用户购物车总数量
			int buycarCount = buycar.queryUserBookCountBuycar(uid);
			request.getSession().setAttribute("userBuycarCount",buycarCount);
		}	
		request.getRequestDispatcher("/jsp/before/shopping-order.jsp").forward(request,response);
	}
}
