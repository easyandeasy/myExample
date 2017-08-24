package cn.springmvc.beans;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class AbstractControllers extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message","执行doFirst()方法");
		mv.setViewName("/WEB-INF/jsp/welcome.jsp");
		return mv;
	}
}
