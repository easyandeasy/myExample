package cn.bookweb.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bookweb.book.buycar.service.BuycarService;
import cn.bookweb.book.buycar.serviceimpl.IBuycarServiceImpl;
import cn.bookweb.user.entity.User;
import cn.bookweb.user.service.IUserService;
import cn.bookweb.user.serviceimpl.UserServiceImpl;

/**
 * 登录控制器
 * @author tang
 *
 */
@SuppressWarnings("serial")
public class UserLoginServlet extends HttpServlet {

	//创建用户业务逻辑层实体
	private IUserService iuser = new UserServiceImpl();
	private BuycarService buy = new IBuycarServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置请求编码
		request.setCharacterEncoding("utf-8");
		//设置响应编码
		response.setContentType("text/html;charset=utf-8");
		
		//获取用户输入的用户名
		String username=request.getParameter("loginname");
		
		//获取用户输入的密码
		String userpwd=request.getParameter("loginpass");
		
		User user = new User();
		user.setUname(username);
		user.setUpwd(userpwd);
		int uid = iuser.queryUserNameId(user);
		user.setUid(uid);
		
		//客户端发送请求后 数据访问层得到结果返回给业务逻辑层  
		//如果存在该客户  就让客户进入主页面 否则继续登录
		if(iuser.queryLogin(user)){
			int count = buy.queryUserBookCountBuycar(uid);
			request.getSession().setAttribute("userSession",user);
			request.getSession().setAttribute("userBuycarCount",count);
			String strUnickName=iuser.queryUserUnickName(user);
			request.getSession().setAttribute("unickName",strUnickName);
			request.getRequestDispatcher("/jsp/before/shopping-head.jsp").forward(request, response);
		}else{
			if(username==""&&userpwd==""){
				request.getSession().setAttribute("error","用户名密码不能为空");
			}else if(username==null||username==""){
				request.getSession().setAttribute("error","用户名不能为空");
			}else if(userpwd==null||userpwd==""){
				request.getSession().setAttribute("error","密码不能为空");
			}else{
				request.getSession().setAttribute("error","用户名或密码不正确");
			}
			request.getSession().setAttribute("username",username);
			response.sendRedirect("/bookweb/jsp/before/login.jsp");
		}
	}
}
