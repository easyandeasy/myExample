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
 * 删除最大类型的控制器
 * @author tang
 *
 */
public class DeletebigBookTypeServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String tid = request.getParameter("tid");//获取类型编号
		IBookTypeService service = new BookTypeServiceImpl();//创建类型业务层对象
		int count = service.queryBookTypeByPidCount(tid);//根据类型编号查询该类型包含分类
		if(count==0){//判断如果为0说明为有分类
			boolean flag = service.removeBookType(tid);//将该类型删除
			if(flag){//判断是否删除成功
				List<BookType> booktype = service.queryBookTypeAllInfo();//查询删除后的所有信息
				request.getSession().setAttribute("booktype", booktype);//将类型存储到会话中
				out.println("<script type='text/javascript'>  window.location=window.location; 	self.opener.location.reload(); </script>");
			}else{
				out.println("<script type='text/javascript'> alert('删除失败！类型已不存在');  </script>");
			}
		}else{
			out.println("<script type='text/javascript'> alert('删除失败！该类型下有【"+count+"】种分类，请谨慎操作！');  </script>");
		}
	}

}
