package cn.springmvc.beans;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // 表示当前类是一个处理器
@RequestMapping("/test") // 命名空间
public class MyController {

	// 请求方式的定义 method=RequestMethod.POST
	// 如果是多个请求，可以使用数组：({"/my.do","hello.do"})
	@RequestMapping("/register.do")
	public ModelAndView register(int age,Date birthday) {
		System.out.println("age = " + age);
		System.out.println("birthday = " + birthday);
		ModelAndView mv = new ModelAndView();
		mv.addObject("age", age);
		mv.addObject("birthday", birthday);
		mv.setViewName("/WEB-INF/jsp/welcome.jsp");
		return mv;
	}
}
