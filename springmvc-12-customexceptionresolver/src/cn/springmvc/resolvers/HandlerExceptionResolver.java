package cn.springmvc.resolvers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import cn.springmvc.exceptions.AgeException;
import cn.springmvc.exceptions.NameException;

public class HandlerExceptionResolver implements org.springframework.web.servlet.HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("ex", ex);
		mv.setViewName("/error/error.jsp");
		
		if(ex instanceof AgeException) {
			mv.setViewName("/error/ageError.jsp");
		}
		if(ex instanceof NameException) {
			mv.setViewName("/error/nameError.jsp");
		}
		
		return mv ;
	}


}
