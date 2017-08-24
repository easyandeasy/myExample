package cn.bookweb.booktype.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bookweb.book.service.IBookService;
import cn.bookweb.book.serviceimpl.BookServiceImpl;
import cn.bookweb.booktype.entity.BookType;
import cn.bookweb.booktype.service.IBookTypeService;
import cn.bookweb.booktype.serviceimpl.BookTypeServiceImpl;
import cn.bookweb.md5.util.MD5Utils;

/**
 * 删除类型控制器
 * @author tang
 *
 */
public class BookTypeDeleteServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String tid = request.getParameter("tid");//分类编号
		String orderby = "";//分类的排序号
		IBookTypeService service = new BookTypeServiceImpl();
		IBookService bookservice = new BookServiceImpl();
		List<BookType> list2 = service.queryBookTypeAllInfo();
		for(BookType bt :list2){
			if(bt.getTid().equals(tid)){
				orderby = Integer.toString(bt.getOrderby());
				break;
			}
		}
		//查询图书信息中是否包含该类型的图书
		int count = bookservice.queryBookCount(tid);//所属类型的图书记录数
		if(count==0){//等于0执行删除操作
			//删除类型操作
			IBookTypeService booktypedelete = new BookTypeServiceImpl();	
			boolean flag = booktypedelete.removeBookType(tid);
			if(flag){
				List<BookType> booktype = booktypedelete.queryBookTypeAllInfo();
				request.getSession().setAttribute("booktype", booktype);
				out.println("<script type='text/javascript'> document.getElementById('"+tid+"').remove(); </script>");
			}else{
				out.println("<script type='text/javascript'> alert('删除失败！由于那我类型已不存在');  </script>");
			}
		}else{//不能删除
			out.println("<script type='text/javascript'> alert('删除失败！该类型有【"+count+"】本书，请对图书类型更换再进行删除该类型！');  </script>");
		}
	}

}
