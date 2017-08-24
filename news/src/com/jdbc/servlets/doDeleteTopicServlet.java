package com.jdbc.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.entity.News;
import com.jdbc.service.INewsService;
import com.jdbc.service.ITopicsService;
import com.jdbc.serviceImpl.NewsServiceImpl;
import com.jdbc.serviceImpl.TopicsServiceImpl;


/**
 * 删除主题
 * @author tang
 *
 */
public class doDeleteTopicServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);

	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
       	ITopicsService topicsDao = new TopicsServiceImpl();//删除主题业务类
       	String id = request.getParameter("id");//获取要删除的编号
       	//查询新闻中是否包含要删除的主题
       	INewsService newsID = new NewsServiceImpl();
       	List<News> listID = newsID.selectAllnewsByTid(id);
       	//判断是否确定删除操作
	 			 	out.print("<p>"+id+"</p>");
       	
       out.print("<script type='text/javascript'> var con = confirm('确定要删除该主题吗？'); if(con){");
       if(listID.size() == 0){ 
    	   if(topicsDao.removeTopic(id)){ 
    		   	out.print("alert('删除成功！'); location.href='doTopicList?ad=de';");
    	   }else{ 
    		   	out.print("alert('删除失败！请查询下数据！'); location.href='news/update.jsp';");
    	   }
       }else{ 
    	   out.print("alert('删除失败！请检查是否有新闻内容包含该主题。'); location.href='news/update.jsp';");
       }
      
    	   out.print(" }else{ location.href='news/update.jsp';} </script>");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*	<script type="text/javascript">
		var con = confirm("确定要删除该主题吗？");
		if(con){
			 	<%
	       	if(listID.size() == 0){//执行删除操作
	       		if(topicsDao.removeTopic(id)){
	       	%>
	       		alert("删除成功！");
	       		location.href="do_topic_delete_list.jsp";
	       	<%	}else{%>
	       		alert("删除失败！请查询下数据！");
	       		location.href="update.jsp";
	       	<%	}
	       	}else{ %>
					alert("删除失败！请检查是否有新闻内容包含该主题。");
					location.href="update.jsp";
			 	<%}%>
		}else{
			location.href="update.jsp";
		}
 </script>*/

}
