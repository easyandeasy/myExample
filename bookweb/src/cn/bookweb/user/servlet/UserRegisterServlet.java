package cn.bookweb.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bookweb.user.entity.User;
import cn.bookweb.user.service.IUserService;
import cn.bookweb.user.serviceimpl.UserServiceImpl;

@SuppressWarnings("serial")
public class UserRegisterServlet extends HttpServlet {

	//创建用户逻辑层实体
	private IUserService iuser = new UserServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置请求编码
		request.setCharacterEncoding("utf-8");
		//设置响应编码
		response.setContentType("text/html;chartset=utf-8");

		//调用本类方法验证用户是否注册成功
		registUser(request,response);
	}

	private void registUser(HttpServletRequest request, HttpServletResponse response) throws IOException{

		//获取用户输入的信息
		String uname=request.getParameter("Registname");
		String upwd1 =request.getParameter("RegistTwoPass");
		String email = request.getParameter("RegistEmail");
		String upwd=request.getParameter("RegistPass");
		String yzm=request.getParameter("Yzm");
		String yzmTwo=(String)request.getSession().getAttribute("Yzm");

		//创建用户实体
		User user = new User();
		user.setEmail(email);
		user.setUname(uname);
		user.setUpwd(upwd);
		
		if(uname!=""&&upwd!=""&&email!=""&&upwd1!=""&&yzm!=""){
			if(!iuser.queryUserName(user)&&!iuser.queryUserEmail(user)){
				if(iuser.addRegister(user)&&yzm.equalsIgnoreCase(yzmTwo)){
					request.getSession().setAttribute("flags","flag");
				}
			}else{
				if(iuser.queryUserName(user))
					request.getSession().setAttribute("Registname","用户名已经存在！");
				if(iuser.queryUserEmail(user))
					request.getSession().setAttribute("RegistEmail","邮箱账号已经存在！");
			}
		}else{
			if(uname=="")
				request.getSession().setAttribute("Registname","用户名不能为空");
			if(upwd=="")
				request.getSession().setAttribute("RegistPass","密码不能为空");
			if(email=="")
				request.getSession().setAttribute("RegistEmail","邮箱账号不能为空");
			if(upwd1=="")
				request.getSession().setAttribute("RegistTwoPass","确认密码不能为空");
			if(yzm=="")
				request.getSession().setAttribute("registYzm","验证码不能为空");
		}
		response.sendRedirect("/bookweb/jsp/before/regist.jsp");
	}
}
