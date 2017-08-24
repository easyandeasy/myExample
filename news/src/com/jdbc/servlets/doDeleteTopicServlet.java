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
 * ɾ������
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
       	ITopicsService topicsDao = new TopicsServiceImpl();//ɾ������ҵ����
       	String id = request.getParameter("id");//��ȡҪɾ���ı��
       	//��ѯ�������Ƿ����Ҫɾ��������
       	INewsService newsID = new NewsServiceImpl();
       	List<News> listID = newsID.selectAllnewsByTid(id);
       	//�ж��Ƿ�ȷ��ɾ������
	 			 	out.print("<p>"+id+"</p>");
       	
       out.print("<script type='text/javascript'> var con = confirm('ȷ��Ҫɾ����������'); if(con){");
       if(listID.size() == 0){ 
    	   if(topicsDao.removeTopic(id)){ 
    		   	out.print("alert('ɾ���ɹ���'); location.href='doTopicList?ad=de';");
    	   }else{ 
    		   	out.print("alert('ɾ��ʧ�ܣ����ѯ�����ݣ�'); location.href='news/update.jsp';");
    	   }
       }else{ 
    	   out.print("alert('ɾ��ʧ�ܣ������Ƿ����������ݰ��������⡣'); location.href='news/update.jsp';");
       }
      
    	   out.print(" }else{ location.href='news/update.jsp';} </script>");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*	<script type="text/javascript">
		var con = confirm("ȷ��Ҫɾ����������");
		if(con){
			 	<%
	       	if(listID.size() == 0){//ִ��ɾ������
	       		if(topicsDao.removeTopic(id)){
	       	%>
	       		alert("ɾ���ɹ���");
	       		location.href="do_topic_delete_list.jsp";
	       	<%	}else{%>
	       		alert("ɾ��ʧ�ܣ����ѯ�����ݣ�");
	       		location.href="update.jsp";
	       	<%	}
	       	}else{ %>
					alert("ɾ��ʧ�ܣ������Ƿ����������ݰ��������⡣");
					location.href="update.jsp";
			 	<%}%>
		}else{
			location.href="update.jsp";
		}
 </script>*/

}
