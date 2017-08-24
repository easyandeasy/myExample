package cn.springmvc.beans;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class MyController {

	public ModelAndView handleRequest() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message","Hello SpringMVC Word!");
		mv.setViewName("/WEB-INF/jsp/welcome.jsp");
		return mv;
	}


}
