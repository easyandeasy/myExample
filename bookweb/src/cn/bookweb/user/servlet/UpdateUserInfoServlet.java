package cn.bookweb.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bookweb.user.entity.User;
import cn.bookweb.user.service.IUserService;
import cn.bookweb.user.serviceimpl.UserServiceImpl;

/**
 * 修改用户信息控制器
 * @author tang
 *
 */
public class UpdateUserInfoServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		IUserService service = new UserServiceImpl();//实例化业务层对象
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM--dd");
		String uid = request.getParameter("uid");//用户编号
		String uname = request.getParameter("uname");//用户名
		String unickname = request.getParameter("unickname");//昵称
		String uphone = request.getParameter("uphone");//联系电话
		String email = request.getParameter("email");//邮箱
		String uidcard = request.getParameter("uidcard");//身份证号
		String uindate = request.getParameter("uindate");//注册时间
		String ustatus = request.getParameter("ustatus");//状态
		int status = Integer.parseInt(ustatus);
		if(uid!=null || uid!= ""){//判断用户编号是否为空
			User u = new User();//实例化用户对象，将获取到的数据添加到对象中
			//Date date = (Date)formatter.parse(uindate);//将字符串转换成Date类型
			u.setUid(Integer.parseInt(uid));
			u.setUname(uname);
			u.setUnickname(unickname);
			u.setUphone(uphone);
			u.setEmail(email);
			u.setUidcard(uidcard);
			u.setUindate(uindate);
			u.setUstatus(status);
		
			//System.out.println(uid+"-"+uname+"-"+unickname+"-"+uphone+"-"+email+"-"+uidcard+"-"+uindate+"-"+status);
			boolean flag = service.replaceUserInfoByUid(u);//调用业务层实现修改操作
			if(flag){//判断是否修改成功
				out.println("修改成功！");
			}else{
				out.println("修改失败！");
			}
		}
	}

}
