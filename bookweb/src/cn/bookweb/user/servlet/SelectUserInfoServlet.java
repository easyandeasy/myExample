package cn.bookweb.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bookweb.page.util.PageUtil;
import cn.bookweb.user.entity.User;
import cn.bookweb.user.service.IUserService;
import cn.bookweb.user.serviceimpl.UserServiceImpl;

/**
 * 查询用户控制器
 * @author tang
 *
 */
public class SelectUserInfoServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		IUserService service = new UserServiceImpl();
		List<User> user = null;
		PageUtil page = null;
		String index = request.getParameter("userindex");//获取当前页
		String sta = request.getParameter("statusindex");//状态编号
		if(index == null || index == ""){
			index = "1";
		}
		String uname = request.getParameter("uname");//获取查询的用户名
		if(uname != null || uname != ""){
			int count = service.queryUserInfoCount(uname);//查询信息总条数
			page = new PageUtil(Integer.parseInt(index),count,6);//分页对象
			user = service.queryUserInfoLike(uname, page);//模糊查询出来的信息集合
		} 
		
		if(uname == null || uname == ""){
			int count = service.queryUserInfoCountByUstatus(Integer.parseInt(sta));//查询信息总条数
			page = new PageUtil(Integer.parseInt(index),count,2);//分页对象
			user = service.queryUserInfoLikeByUstatus(Integer.parseInt(sta), page);//模糊查询出来的信息集合
		}
		String userempty = "noempty";
		//System.out.println(user.size());
		if(user.size()==0){//判断查询出的集合是否有值
			userempty = "empry";
		}
		if(sta == null || sta == ""){
			sta = "0";
		}
		request.getSession().setAttribute("stas", Integer.parseInt(sta));//将获取到的用户名存储到会话中
		request.getSession().setAttribute("userinfos", user);//将用户信息集合存储到会话中
		request.getSession().setAttribute("userpage", page);//将用户信息分页对象存储到会话中
		request.getSession().setAttribute("username", uname);//将按用户名查询的名称存储到会话中
		request.getSession().setAttribute("userindex", index);//将当前页存储到会话中
		request.getSession().setAttribute("userempty", userempty);//将判断是否显示分页的字符串存储到会话中
		if(user.size()==0){
			out.println("<script type='text/javascript'> alert('没有该用户的信息!'); location.href='jsp/after/usermanage.jsp'  </script>");
		}else{
			out.println("<script type='text/javascript'> location.href='jsp/after/usermanage.jsp'  </script>");
		}
	}

}
