package cn.mybatisspringmvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import cn.mybatisspringmvc.beans.Student;
import cn.mybatisspringmvc.beans.Users;
import cn.mybatisspringmvc.service.IStudentService;
import cn.mybatisspringmvc.service.IUsersService;
import cn.mybatisspringmvc.service.StudentServiceImpl;
import cn.mybatisspringmvc.service.UsersServiceImpl;

@Controller
@RequestMapping("/test")
public class MyController {
	
	private IStudentService stuService = new StudentServiceImpl();
	private IUsersService userService = new UsersServiceImpl();

	//登录
	@RequestMapping("/dologin")
	public String doLogin(String uname,String upwd){
		//查询数据库判断用户是否存在
		
		Users user = new Users(); 
		user.setUname(uname);
		user.setUpwd(upwd);
		
		boolean flag = userService.isLogin(user);
		
		if(false) {
			return "doQueryStudent";//如果登录成功，跳转到初始化数据
		}
		return "/index.jsp";
	}
	
	//初始化数据
	@RequestMapping("/doQueryStudent")
	public ModelAndView doQueryStudent(){
		ModelAndView mv = new ModelAndView();
		
		List<Student> stu = stuService.queryStudentInfo();
		
		mv.addObject("stu",stu);
		mv.setViewName("/studentInfo.jsp");
		return mv;
	}
	
}
