package com.jdbc.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jdbc.entity.News;
import com.jdbc.entity.Topic;
import com.jdbc.service.ITopicsService;
import com.jdbc.serviceImpl.NewsServiceImpl;
import com.jdbc.serviceImpl.TopicsServiceImpl;

public class NewsControl extends HttpServlet {

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

		request.getParameter("utf-8");
		NewsServiceImpl service = new NewsServiceImpl();
		//INewsService service = new NewsServiceImpl();
		ITopicsService topic = new TopicsServiceImpl();
		String opr = request.getParameter("opr");
		if(opr.equals("listTitle")){
			//左边新闻
			List<News> list1 = service.selectAllnewsByTid("1");
			str(list1);
			List<News> list2 = service.selectAllnewsByTid("2");
			str(list2);
			List<News> list3 = service.selectAllnewsByTid("5");
			str(list3);
			//主题
			List<Topic> list = topic.selectAllTopics();
			//主题内容
			List<News> lists = service.selectAllnewsByTid("1");
			HttpSession session = request.getSession();
			session.setAttribute("lists", lists);
			session.setAttribute("list1",list1);
			session.setAttribute("list2",list2);
			session.setAttribute("list3",list3);
			session.setAttribute("list",list);
			response.sendRedirect("news/login.jsp");
		}
	}

	
	/**
	 * 
	 * 截取字符串
	 * @param str
	 * @return
	 */
	public void str(List<News> str) {
		for(News news : str){
			if (news.getNtitle().length() > 10) {
				news.setStr(news.getNtitle().substring(0, 10));
			}
		}
	}
}
