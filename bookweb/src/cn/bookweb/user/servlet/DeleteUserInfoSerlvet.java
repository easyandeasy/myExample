package cn.bookweb.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bookweb.user.entity.User;
import cn.bookweb.user.service.IUserService;
import cn.bookweb.user.serviceimpl.UserServiceImpl;

/**
 * 删除用户信息控制器
 * @author tang
 *
 */
public class DeleteUserInfoSerlvet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String del = "info"+id;
		IUserService service = new UserServiceImpl();
		if(id != null || id != ""){
			boolean flag = service.removeUserInfo(Integer.parseInt(id));
			if(flag){
				List<User> user = service.queryAllInfo();
				request.getSession().setAttribute("userinfos", user);//将用户信息集合存储到会话中
				out.println("<script type='text/javascript'> document.getElementById('"+del+"').remove(); </script>");
			}else{
				out.println("<script type='text/javascript'> alert('删除失败！'); </script>");
			}
		}
		
	}

}
