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
 * 添加管理员信息控制器
 * @author tang
 *
 */
public class AddAdminInfoServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		IAdminService service = new AdminServiceImpl();
		String adminname = request.getParameter("iname");//帐号
		String adminpwd = request.getParameter("ipwd");//密码
		String adminidcard = request.getParameter("iid");//身份证号
		String admincontext = request.getParameter("icontext");//备注
		Admin admin = new Admin();
		//判断获取到的数据不为空
		if(adminname != null && adminpwd != null && adminidcard != null){
			//将获取到的数据添加到对象中
			admin.setAdminname(adminname);
			admin.setAdminpwd(adminpwd);
			admin.setAdminidcard(adminidcard);
			admin.setAdmincontext(admincontext);
			boolean isName = service.queryAdminName(adminname);
			if(isName){//判断用户是否存在,为ture存在，为false不存在
				out.println("帐号已经存在！");
			}else{//帐号不存在
				//调用业务层实现管理员添加
				boolean flag = service.addAdmin(admin);
				if(flag){
					out.println("<script type=\"text/javascript\" > $(\".adminjavascript\").html(\" 添加成功！\"); $(\"[name=adminname]\").val(''); $(\"[name=adminpwd]\").val(''); $(\"[name=adminpwd]\").val(''); $(\"[name=adminidcard]\").val(''); $(\"[name=admincontext]\").val(''); </script>");
				}else{
					out.println("添加失败！");
				}
			}
		}
	}

}
