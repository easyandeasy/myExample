package cn.bookweb.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bookweb.admin.service.IAdminService;
import cn.bookweb.admin.serviceimpl.AdminServiceImpl;

/*
 * 判断身份证号是否存在控制器
 */
public class AdminIdcardIsExistServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String idcard = request.getParameter("forgetidcard");//身份证号
		String adminname = request.getParameter("forgetname");//用户名
		IAdminService service = new AdminServiceImpl();
		int adminid = service.queryAdminIdcard(idcard,adminname);
		//判断用户名是否存在
		if(adminid==0){
			out.print("<font size='1' color='red'>身份证号不存在！</font>");
		}else{
			request.getSession().setAttribute("forgetid", Integer.toString(adminid));//将用户编号存储到会话中
			request.getSession().setAttribute("forgetname", adminname);//将用户名存储到会话中
			out.print("<script type='text/javascript' > $('#two').css('border-color','transparent transparent transparent #00AA00'); $('.onetwo').css('background-color','#00AA00');  $('#one').css('border-color','transparent transparent transparent #33FF33'); $('.oneone').css('background-color','#33FF33'); $('.infoone').hide(); $('.infotwo').show(); </script>"); 
		}
	}

}
