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
 * 左边菜单控制器
 * @author tang
 *
 */
public class LeftTypeServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();		
		//实现化业务层对象//
		IBookTypeService servicet = new BookTypeServiceImpl();
		//获取图书类型的集合
		List<BookType> booktype = servicet.queryBookTypeAllInfo();
		//将booktype信息存储到 session中
		request.getSession().setAttribute("booktype", booktype);
		
	}

}






















































/*int i = 0;
for(BookType type :booktype){
	//out.println(type.getTname());
	if(type.getTid().length()<3){
		out.println("<li class=\"typeli\" id=\"li"+i+"\"><a class=\"img\" id=\"img"+i+"\" onclick=\"leftclick(this);\"><img src=\"book_img/right6.png\"/></a>"+type.getTname()+"</li>");
		System.out.println("<li class=\"typeli\" id=\"li"+i+"\"><a class=\"img\" id=\"img"+i+"\"  onclick=\"leftclick(this);\"><img src=\"book_img/right6.png\"/></a>"+type.getTname()+"</li>");
		
		out.println("<div class=\"two\" id=\"two"+i+"\" >");
		System.out.println("<div class=\"two\" id=\"two"+i+"\" >");
		int a = 0;
		for(BookType t :booktype){
			if(t.getPid()!=null){
				if(t.getPid().equals(type.getTid())){
					out.println("<li class=\"twotype\" id=\""+a+"\">"+"<a id=\"one"+a+"\" href=\"BookServlet?tid="+t.getTid()+"&pageindex=1\" target=\"mainFrame\">"+t.getTname()+"</a></li>");
					System.out.println("<li class=\"twotype\" id=\""+a+"\">"+"<a id=\"one"+a+"\" href=\"BookServlet?tid="+t.getTid()+"&pageindex=1\" target=\"mainFrame\">"+t.getTname()+"</a></li>");
				}
			}
			a++;
		}
		out.println("</div>");
		System.out.println("</div>");
	}
	i++;
}
*/
/*
<c:forEach var="book" items="${booktype }" varStatus="status">
<c:if test="${book.tid.length() == 1 }">
	<li class="typeli" id="li${status.index }">
		<a class="img" id="img${status.index }"><img src="book_img/right6.png"/></a>${book.tname }
	</li>

	<div class="two" id="two${status.index }" >
    	<c:forEach var="type" items="${booktype }"  varStatus="sta">
    		<c:if test="${type.pid == book.tid }">
    			<li class="twotype" id="${sta.index }">
	   				<a id="one${sta.index }" href="BookServlet?tid=${type.tid }&pageindex=1" target="mainFrame">${fn:substring(type.tname,0,15) }</a>
    			</li>
    		</c:if>
    	</c:forEach>
	</div>
</c:if>
</c:forEach>

*/
