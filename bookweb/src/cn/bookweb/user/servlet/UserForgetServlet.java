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

/**
 * 忘记密码控制器
 * @author tang
 *
 */
@SuppressWarnings("serial")
public class UserForgetServlet extends HttpServlet {

	//创建用户业务逻辑层实体
	private IUserService iuser = new UserServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取用户请求的类型
		String result=request.getParameter("method");

		//处理客户端发送请求编码
		request.setCharacterEncoding("utf-8");
		//处理响应编码
		response.setContentType("text/html;charset=utf-8");

		if(result.equals("forgetpass")){
			updateforgetPass(request,response);
		}else if(result.equals("forgetpasserror")){
			updateForgetPassError(request,response);
		}
	}

	private void updateforgetPass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		//获取用户输入的用户名
		String uname=request.getParameter("loginname");
		//获取用户输入的邮箱
		String email=request.getParameter("email");
		//获取用户输入的验证码
		String yzm=request.getParameter("Yzm");
		//获取验证码的值
		String yzmTwo=(String)request.getSession().getAttribute("Yzm");

		//把用户输入的内容封装到用户实体中
		User user = new User();
		user.setEmail(email);
		user.setUname(uname);

		//调用业务逻辑层的方法  得到返回结果并判断
		if(uname!=""&&email!=""&&yzm!=""){
			if(iuser.replaceForget(user)&&yzm.equalsIgnoreCase(yzmTwo)){
				request.getSession().setAttribute("forget","forgets");
				request.getSession().setAttribute("uname",user.getUname());
				request.getSession().setAttribute("email",user.getEmail());
			}else{
				request.getSession().setAttribute("errors","用户名或邮箱账号不存在，找回失败！");
			}
		}else{
			if(uname==""&&email==""&&yzm==""){
				request.getSession().setAttribute("errors","用户名丶密码丶邮箱账号不能为空");
			}else if(uname==""){
				request.setAttribute("loginnameError","用户名不能为空");
			}else if(email==""){
				request.getSession().setAttribute("emailError","邮箱账号不能为空");
			}else if(yzm==""){
				request.getSession().setAttribute("errors","验证码不能为空");
			}else if(yzm.equalsIgnoreCase(yzmTwo)){
				request.getSession().setAttribute("errors","验证码不正确");
			}
		}
		response.sendRedirect("/bookweb/jsp/before/forgetpass.jsp");
	}

	private void updateForgetPassError(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		//获取用户输入的密码
		String pass=request.getParameter("pass");
		//获取用户输入的确认密码
		String passTwo=request.getParameter("passTwo");
		//获取用户输入的验证码
		String yzm=request.getParameter("yanzhengma");
		//获取验证码的值
		String yzmTwo=(String)request.getSession().getAttribute("Yzm");

		//把用户输入的内容封装到用户实体中
		User user = new User();
		user.setUname((String)request.getSession().getAttribute("uname"));
		user.setEmail((String)request.getSession().getAttribute("email"));

		if(pass!=""&&passTwo!=""&&yzm!=""){
			if(pass.equals(passTwo)){
				if(pass.length()>6&&passTwo.length()>6){
					if(iuser.updateForgetPass(user,passTwo)){
						request.getSession().setAttribute("falsesg","falses");
					}
				}else{
					request.getSession().setAttribute("passTwoError","长度必须大于6位数");
				}
			}else{
				request.getSession().setAttribute("passTwoError","两次输入的密码不一致");
			}
		}else{
			if(pass==""){
				request.getSession().setAttribute("passError","密码不能为空");
			}
			if(passTwo==""){
				request.getSession().setAttribute("passTwoError","确认密码不能为空");
			}
			if(yzm==""){
				request.getSession().setAttribute("yanzhengmaError","验证码不能为空");
			}
		}
		response.sendRedirect("/bookweb/jsp/before/forgetpass.jsp");
	}
}
