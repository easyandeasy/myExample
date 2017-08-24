package cn.springmvc.beans;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller		//表示当前类是一个处理器
@RequestMapping("/test")	//命名空间
public class MyController  {
	
	//请求方式的定义  method=RequestMethod.POST 
	//如果是多个请求，可以使用数组：({"/my.do","hello.do"})
	@RequestMapping(value={"/my.do","hello.do"},method=RequestMethod.POST)	
	public ModelAndView doFirst(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message","执行doFirst()方法!");
		mv.setViewName("/WEB-INF/jsp/welcome.jsp");
		return mv;
	}
	
	@RequestMapping("/second.do")
	public ModelAndView doSecond(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message","执行doSecond()方法!");
		mv.setViewName("/WEB-INF/jsp/welcome.jsp");
		return mv;
	}
	
	/*
	 * 通配符 * 的使用
	 * 
	 * */
	@RequestMapping("/*third.do")	//资源名称必须以 third结尾
	public ModelAndView doThird(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message","执行doThird()方法!");
		mv.setViewName("/WEB-INF/jsp/welcome.jsp");
		return mv;
	}
	@RequestMapping("/third*.do")	//资源名称必须以third开头
	public ModelAndView doThird2(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message","执行doThird2()方法!");
		mv.setViewName("/WEB-INF/jsp/welcome.jsp");
		return mv;
	}
	
	
	/*
	 * 通配符  /* 和 /** 的使用
	 * 
	 * */
	@RequestMapping("/*/four.do")	//路径级数的绝对匹配，要求在test与four.do之间必须要有一级路径
	public ModelAndView doFour(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message","执行doFour()方法!");
		mv.setViewName("/WEB-INF/jsp/welcome.jsp");
		return mv;
	}
	@RequestMapping("/**/four2.do")	//要求在test与four.do之间可以包含多级路径，也可以没有其他路径
	public ModelAndView doFour2(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message","执行doFour2()方法!");
		mv.setViewName("/WEB-INF/jsp/welcome.jsp");
		return mv;
	}
}
