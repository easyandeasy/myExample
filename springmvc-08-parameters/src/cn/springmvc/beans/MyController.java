package cn.springmvc.beans;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller // 表示当前类是一个处理器
@RequestMapping("/test") // 命名空间
public class MyController {

	// 请求方式的定义 method=RequestMethod.POST
	// 如果是多个请求，可以使用数组：({"/my.do","hello.do"})
	@RequestMapping("/register.do")
								//（@RequestParam:校正请求参数）当表单中的属性名定义不一致时使用@RequestParam("pname") ，表示pname的值由name来接收
	public ModelAndView register(@RequestParam("pname") String name, int age) {
		System.out.println("name = " + name);
		System.out.println("age = " + age);
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", name);
		mv.addObject("age", age);
		mv.setViewName("/WEB-INF/jsp/welcome.jsp");
		return mv;
	}
}
