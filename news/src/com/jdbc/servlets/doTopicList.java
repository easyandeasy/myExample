package com.jdbc.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.entity.Topic;
import com.jdbc.serviceImpl.TopicsServiceImpl;

public class doTopicList extends HttpServlet {

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

		response.setContentType("text/html;charset=utf-8");
		String ad = request.getParameter("ad");
		TopicsServiceImpl dao = new TopicsServiceImpl();
    	//ITopicsDao dao = new TopicsDaoImpl();
       	List<Topic> topic = dao.selectAllTopics();
       	request.getSession().setAttribute("list", topic);
       	if(ad.equals("de")){
       		response.sendRedirect("news/update.jsp");
       	}else if(ad.equals("ad")){
       		response.sendRedirect("news/topic_add.jsp");
       	}
       	
	}

}
