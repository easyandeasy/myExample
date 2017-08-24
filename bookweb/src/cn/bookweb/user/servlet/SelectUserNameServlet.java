package cn.bookweb.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bookweb.user.entity.User;
import cn.bookweb.user.service.IUserService;
import cn.bookweb.user.serviceimpl.UserServiceImpl;

/**
 * 效验用户名 邮箱 是否被注册
 * @author Happy
 *
 */
@SuppressWarnings("serial")
public class SelectUserNameServlet extends BaseServlet {

	//创建用户业务逻辑层实体
	private IUserService iuserService = new UserServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	/**
	 * 效验用户名是否被注册
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void ajaxQueryUserName(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*
		 * 1. 获取用户名
		 */
		String loginname = req.getParameter("Registname");
		User user = new User();
		user.setUname(loginname);
		/*
		 * 2. 通过service得到校验结果
		 */
		boolean b = iuserService.queryUserName(user);
		/*
		 * 3. 发给客户端
		 */
		resp.getWriter().print(b);
	}
	
	/**
	 * 效验邮箱名是否被注册
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void ajaxQueryUserEmail(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*
		 * 1. 获取用户名
		 */
		String loginname = req.getParameter("RegistEmail");
		User user = new User();
		user.setEmail(loginname);
		/*
		 * 2. 通过service得到校验结果
		 */
		boolean b = iuserService.queryUserEmail(user);
		/*
		 * 3. 发给客户端
		 */
		resp.getWriter().print(b);
	}
	
	/**
	 * ajax验证码是否正确校验
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public void ajaxValidateVerifyCode(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*
		 * 1. 获取输入框中的验证码
		 */
		String yzm = req.getParameter("Yzm");
		/*
		 * 2. 获取图片上真实的校验码
		 */
		String vcode = (String) req.getSession().getAttribute("Yzm");
		/*
		 * 3. 进行忽略大小写比较，得到结果
		 */
		boolean b = yzm.equalsIgnoreCase(vcode);
		/*
		 * 4. 发送给客户端
		 */
		resp.getWriter().print(b);
	}
}
