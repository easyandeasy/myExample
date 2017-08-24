package com.jdbc.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.entity.News;
import com.jdbc.entity.Topic;
import com.jdbc.service.IPageService;
import com.jdbc.serviceImpl.PageServiceImpl;
import com.jdbc.util.PageUtil;

/**
 * 分页处理
 * @author tang
 *
 */
public class PageControl extends HttpServlet {

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

		String pageIndex = request.getParameter("pageIndex");//获取当前页数
		String type = request.getParameter("type");
		if(type == null){
			type="login";
		}
		String id = request.getParameter("id");
		if(pageIndex==null){
			pageIndex="1";
		}
		int currPageNo = Integer.parseInt(pageIndex);
		int tid = Integer.parseInt(id);//主题编号
		IPageService service = new PageServiceImpl();
		int totalCount = service.selectTotalCount(tid);//总记录数
		PageUtil pages = new PageUtil(currPageNo,totalCount);
		//pages.setList(list);//设置每页显示的集合
		request.setAttribute("pages", pages);
		request.setAttribute("count", pages.getCount());//总页数
		request.setAttribute("now", pages.getNow());//当前页号
		request.setAttribute("id", tid);

		request.setAttribute("topicType","删除主题");
		if(type.equals("login")){//登录分页操作
			List<News> list = service.selectPageNewsCountList(pages, tid);
			request.setAttribute("list", list);//每页新闻集合
			request.getRequestDispatcher("news/loginRight.jsp").forward(request, response);
		}else if(type.equals("del")){//删除分页操作
			List<Topic> list = service.selectPageTopicCountListSQL(pages);
			request.setAttribute("list", list);//每页新闻集合
			request.getRequestDispatcher("news/update.jsp").forward(request, response);
		}
	}

}
