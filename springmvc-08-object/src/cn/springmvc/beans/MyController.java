package cn.springmvc.beans;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller // 表示当前类是一个处理器
@RequestMapping("/test") // 命名空间
public class MyController {

	// 如果是多个请求，可以使用数组：({"/my.do","hello.do"})
	@RequestMapping("/register.do")
	public ModelAndView register(Student stu) {
		System.out.println("name = " + stu.getName());
		System.out.println("age = " + stu.getAge());
		ModelAndView mv = new ModelAndView();
		mv.addObject("student", stu);
		mv.setViewName("/WEB-INF/jsp/welcome.jsp");
		return mv;
	}
}
