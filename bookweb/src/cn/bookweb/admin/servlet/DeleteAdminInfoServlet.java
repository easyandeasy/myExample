package cn.bookweb.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bookweb.admin.service.IAdminService;
import cn.bookweb.admin.serviceimpl.AdminServiceImpl;
import cn.bookweb.user.entity.User;

/**
 * 删除管理员控制器
 * @author tang
 *
 */
public class DeleteAdminInfoServlet extends HttpServlet {


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
		IAdminService service = new AdminServiceImpl();
		if(id != null || id != ""){
			boolean flag = service.removeAdminInfo(Integer.parseInt(id));
			if(flag){
				out.println("删除成功！<script type='text/javascript'> document.getElementById('"+del+"').remove(); </script>");
			}else{
				out.println("删除失败！");
			}
		}
	}

}
