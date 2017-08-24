package cn.bookweb.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bookweb.admin.entity.Admin;
import cn.bookweb.admin.service.IAdminService;
import cn.bookweb.admin.serviceimpl.AdminServiceImpl;


/**
 * 添加管理员和修改管理员控制器
 * @author tang
 *
 */
public class AdminAddUpdateServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		IAdminService service = new AdminServiceImpl();
		String adminid = (String)request.getSession().getAttribute("adminid");//用户编号
		String adminname = request.getParameter("aname");//管理员名称
		String adminpwd = request.getParameter("apwd");//管理员密码
		String adminidcard = request.getParameter("aidcard");//管理员身份证号
		String admincontext = request.getParameter("acontext");//备注
		Admin admin = new Admin();
		//将获取到的数据添加到对象中
		admin.setAdminid(Integer.parseInt(adminid));
		admin.setAdminpwd(adminpwd);
		admin.setAdminname(adminname);
		admin.setAdminidcard(adminidcard);
		admin.setAdmincontext(admincontext);;
		
		boolean flag = service.replaceAdminInfo(admin);//调用业务层方法实现修改
		
		System.out.println(adminid + " " + adminname +" " + adminpwd +" " + adminidcard + " " + flag);
		if(flag){
			request.getSession().setAttribute("adminname",adminname);//将修改后的管理名称存储到会话中
			//System.out.println(adminname + " " + adminidcard + " " + admincontext);
			request.getSession().setAttribute("admin", admin);//将当前管理员信息存储到会话中
			request.getSession().setAttribute("adminpwd", adminpwd);//将密码存储到会话中
			out.print("修改成功！");
		}else{
			out.print("修改失败！");
		}
	}

}
