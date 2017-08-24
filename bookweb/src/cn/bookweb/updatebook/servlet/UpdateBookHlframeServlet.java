package cn.bookweb.updatebook.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bookweb.book.service.IBookService;
import cn.bookweb.book.serviceimpl.BookServiceImpl;

/**
 * 修改上下架控制器
 * @author tang
 *
 */
public class UpdateBookHlframeServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		IBookService service = new BookServiceImpl();
		String hlframe = request.getParameter("hlframe");//图书编号
		String text = request.getParameter("text");//文本
		int status = 1;//上下架状态
		if(text.equals("下架")){
			status = 0;
			text = "上架";
		}
		if(hlframe!=null){
			int bid = Integer.parseInt(hlframe);//将图书编号转换成int类型
			boolean  flag = service.replaceBookHlframeSQL(status,bid);
			if(flag){//更改成功
				if(status==0){//下架
					out.print("<script type='text/javascript'> $(\".hlframe\").css(\"background-image\",\"url(../../book_img/huang_2_btn.jpg)\"); $(\".hlframe\").text(\"	上架\"); </script>");
				}else{
					out.print("<script type='text/javascript'> $(\".hlframe\").css(\"background-image\",\"url(../../book_img/hong_2_btn.jpg)\"); $(\".hlframe\").text(\"下架\"); </script>");
				}
			}
		}
	}
}
