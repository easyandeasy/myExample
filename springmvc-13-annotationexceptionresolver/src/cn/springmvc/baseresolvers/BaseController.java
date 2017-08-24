package cn.springmvc.baseresolvers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.springmvc.exceptions.AgeException;
import cn.springmvc.exceptions.NameException;
import cn.springmvc.exceptions.StudentException;

@Controller // 表示当前类是一个处理器
@RequestMapping("/test") // 命名空间
public class BaseController {
	//注解式 异常处理
	@ExceptionHandler(NameException.class)
	public ModelAndView hendleNameException(Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("ex", ex);
		mv.setViewName("/error/nameError.jsp");
		return mv ;
	}
	//注解式 异常处理
	@ExceptionHandler(AgeException.class)
	public ModelAndView hendleAgeException(Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("ex", ex);
		mv.setViewName("/error/ageError.jsp");
		return mv ;
	}
	//注解式 异常处理
	@ExceptionHandler
	public ModelAndView hendleException(Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("ex", ex);
		mv.setViewName("/error/error.jsp");
		return mv ;
	}
}
