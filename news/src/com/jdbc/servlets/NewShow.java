package com.jdbc.servlets;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.entity.News;
import com.jdbc.serviceImpl.NewsServiceImpl;

public class NewShow extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		req.getParameter("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		NewsServiceImpl service = new NewsServiceImpl();
		String id = req.getParameter("nid");
		
		List<News> news = service.selectAllnewsByNid(id);
		
		News n = new News();
		/*if(news != null){
			System.out.println(id+"	"+news.size());
		}*/
		for(News s : news){
			req.getSession().setAttribute("newss", s);
		}
		//req.getRequestDispatcher("news/news.jsp").forward(req, resp);
		resp.sendRedirect("news/news.jsp");
	}

}
