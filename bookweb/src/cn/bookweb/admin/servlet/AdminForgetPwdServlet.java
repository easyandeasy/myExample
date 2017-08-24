package cn.bookweb.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bookweb.admin.service.IAdminService;
import cn.bookweb.admin.serviceimpl.AdminServiceImpl;


/**
 * 忘记密码控制器
 * @author tang
 *
 */
public class AdminForgetPwdServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String adminid =(String)request.getSession().getAttribute("forgetid");//用户名
		String pwd = request.getParameter("pwd");//重置密码
		
		IAdminService service = new AdminServiceImpl();
		if(adminid != null || adminid != "" ){//判断用户编号是否为空
			if(service.queryAdminNewPwd(Integer.parseInt(adminid), pwd)){//调用业务层进行密码修改，并判断是否修改成功
				request.getSession().setAttribute("forgetpwd", pwd);//将密码存储到会话中	
				out.print("<script type='text/javascript' >  $('#two').css('border-color','transparent transparent transparent #33FF33');  $('.onetwo').css('background-color','#33FF33');  $('#three').css('border-color','transparent transparent transparent #00AA00'); $('.onethree').css('background-color','#00AA00'); $('.infothree').show(); $('.infotwo').hide(); </script>");
			}
		}
	}

}
