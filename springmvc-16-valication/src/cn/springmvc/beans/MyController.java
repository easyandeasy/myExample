package cn.springmvc.beans;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // 表示当前类是一个处理器
@RequestMapping("/test") // 命名空间
public class MyController {

	// 如果是多个请求，可以使用数组：({"/my.do","hello.do"})
	@RequestMapping("/register.do")
	public ModelAndView register(@Validated Student stu,BindingResult br) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("student",stu);
		mv.setViewName("/WEB-INF/jsp/welcome.jsp");
		int errorCount = br.getErrorCount();
		if(errorCount > 0 ){
			FieldError nameError = br.getFieldError("name");
			FieldError scoreError = br.getFieldError("score");
			FieldError mobileError = br.getFieldError("mobile");
			
			if(nameError != null) {
				String nameMessage = nameError.getDefaultMessage();
				mv.addObject("nameError",nameMessage);
			}
			if(scoreError != null) {
				String scoreMessage = scoreError.getDefaultMessage();
				mv.addObject("scoreError",scoreMessage);
			}
			if(mobileError != null) {
				String mobileMessage = mobileError.getDefaultMessage();
				mv.addObject("mobileError",mobileMessage);
			}
			mv.setViewName("/index.jsp");
		}
		return mv;
	}
}
