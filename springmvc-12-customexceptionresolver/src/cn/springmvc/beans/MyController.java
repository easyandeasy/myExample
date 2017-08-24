package cn.springmvc.beans;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.springmvc.exceptions.AgeException;
import cn.springmvc.exceptions.NameException;
import cn.springmvc.exceptions.StudentException;

@Controller // 表示当前类是一个处理器
@RequestMapping("/test") // 命名空间
public class MyController {

	// 请求方式的定义 method=RequestMethod.POST
	// 如果是多个请求，可以使用数组：({"/my.do","hello.do"})
	@RequestMapping("/register.do")
								//当表单中的属性名定义不一致时使用@RequestParam("pname") ，表示pname的值由name来接收
	public ModelAndView register(String name, int age) throws StudentException {
		
//		int i = 3 / 0;//制造一个异常
		
		System.out.println(name + "\t" + age);
		//自定义异常
		if(!"张三".equals(name)) {
			throw new NameException("用户名不正确！");
		}
		
		if(age > 60) {
			throw new AgeException("年龄不符合规定！");
		}
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", name);
		mv.addObject("age", age);
		mv.setViewName("/WEB-INF/jsp/welcome.jsp");
		return mv;
	}
}
