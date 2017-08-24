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
 * 判断输入的旧密码是否正确控制器
 * @author tang
 *
 */
public class AdminPwdIsExistServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String olderpwd = (String)request.getSession().getAttribute("adminpwd");//登录的密码
		String pwd = request.getParameter("olderpwd");//输入的旧密码
		String newpwd = request.getParameter("newpwd");//新密码
		String adminid = (String)request.getSession().getAttribute("adminid");//获取管理员编号
		IAdminService admins = new AdminServiceImpl();
		if(olderpwd != null && pwd !=null){
			if(!pwd.equals(olderpwd)){//判断输入的旧密码是否正确
				out.println("<script type=\"text/javascript\" > $(\".adminjavascript\").html('旧密码不正确！'); $(\".adminjavascript\").slideDown(); </script>");
			}else{
				if(newpwd != null && adminid != null){//判断获取到的新密码和用户编号不为空
					boolean flag = admins.queryAdminNewPwd(Integer.parseInt(adminid), newpwd);//调用业务层实现修改操作
					if(flag){//判断是否修改成功，返回true为修改成功，false为修改失败
						out.println("<script type=\"text/javascript\" > $(\".adminjavascript\").html('修改成功！'); $(\".adminjavascript\").slideDown(); </script>");
					}else{
						out.println("<script type=\"text/javascript\" > $(\".adminjavascript\").html('修改失败！'); $(\".adminjavascript\").slideDown(); </script>");
					}
				}
			}
		}
	}

}
