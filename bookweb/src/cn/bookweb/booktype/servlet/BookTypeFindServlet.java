package cn.bookweb.booktype.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bookweb.booktype.entity.BookType;
import cn.bookweb.booktype.service.IBookTypeService;
import cn.bookweb.booktype.serviceimpl.BookTypeServiceImpl;
import cn.bookweb.page.util.PageUtil;

/**
 * 图书类型控制器
 * @author tang
 *
 */
public class BookTypeFindServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String tname = request.getParameter("tname");
		boolean flag = Pattern.compile("^[0-9]+$").matcher(tname).matches();//判断是否是数字
		IBookTypeService service = new BookTypeServiceImpl();
		int count = service.queryBookTypeCount(tname);//查询该类型名的条数
		PageUtil page = new PageUtil(1,count,10);//分页对象
		List<BookType> booktypes = null;
		if(flag){
			booktypes = service.queryBookByPidSQL(Integer.parseInt(tname), page);
		}else{
			booktypes = service.queryBookTypeByTnameInfo(tname, page);
			
		}
		for(int i = 0 ;i<booktypes.size();i++){
			BookType type = booktypes.get(i);
			if(type.getTid().length()>3){
				out.println("<div id='"+type.getTid()+"' class='typeshow2'><input type='hidden' id='hidden3'  value='"+type.getTcontext()+"' /> <li>"+type.getTname()+"</li>"+"<li>"+type.getTcontext()+"</li>"+"<li><img src='../../book_img/delete1.png'  id='"+type.getTid()+"' onclick='typeclickdelete(this)'/><img src='../../book_img/update.png'  id='"+type.getTid()+"' class='"+type.getTname()+"' name='"+type.getPid()+"' onclick='updatesmallbtn(this)'/></li></div>");
			}
			
		}
	}
}






