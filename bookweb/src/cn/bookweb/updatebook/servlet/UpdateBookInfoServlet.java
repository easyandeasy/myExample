package cn.bookweb.updatebook.servlet;

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
import cn.bookweb.booktype.entity.BookType;
import cn.bookweb.booktype.service.IBookTypeService;
import cn.bookweb.booktype.serviceimpl.BookTypeServiceImpl;

/**
 * 查看、修改、删除图书控制器
 * @author tang
 *
 */
public class UpdateBookInfoServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		IBookService service = new BookServiceImpl();//创建图书业务层对象
		IBookTypeService servicetype = new BookTypeServiceImpl();//创建图书类型对象
		String id = request.getParameter("bid");//获取图书编号
		int bid = Integer.parseInt(id);//转换成功int类型
		Book update = service.queryBookByBid(bid);//根据bid获取该图书对象
		List<BookType> type = servicetype.queryBookTypeAllInfo();//查询出所有类型信息
		String i = "";
		for(BookType t :type){//遍历图书类型
			if(t.getTid().equals(update.getTid())){//查出小类型
				update.setSelecttwo(t.getTname());
				i=t.getPid();
			}
		}
		for(BookType t :type){
			if(t.getTid().equals(i)){//查出大类型
				update.setSelectone(t.getTname());
			}
		}
		request.getSession().setAttribute("update", update);
		out.print("<script type='text/javascript'>"+" location.href='jsp/after/updatebook.jsp'"+"</script>");
		//request.getRequestDispatcher("jsp/after/updatebook.jsp").forward(request, response);
	}

}
