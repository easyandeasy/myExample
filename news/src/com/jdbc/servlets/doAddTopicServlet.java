package com.jdbc.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.jdbc.entity.Topic;
import com.jdbc.topicsdaoImpl.TopicsDaoImpl;
import com.jdbc.topicsdao.ITopicsDao;
/**
 * 添加主题
 * @author tang
 *
 */
public class doAddTopicServlet extends HttpServlet {

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
    	request.setCharacterEncoding("utf-8");
    	ITopicsDao topicsDao = new TopicsDaoImpl();
    	String tname = request.getParameter("tname");
    	Topic topic = topicsDao.findTopicByName(tname);
    	PrintWriter out = response.getWriter();
    	if(topic == null){
    		topicsDao.addTopic(tname);
    		out.print("<script type='text/javascript'>"+"alert('当前主题创建成功，点击确认返回主题列表！');"+"location.href='doTopicList?ad=ad';"+"</script>");
		 }else{
			 out.print("<script type='text/javascript'>"+"alert('当前主题已存在，请输入不同的主题！');"+"location.href='news/topic_add.jsp';"+"</script>");
		 } 
	}

}
