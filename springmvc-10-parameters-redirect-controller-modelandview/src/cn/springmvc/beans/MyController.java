package cn.springmvc.beans;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // 表示当前类是一个处理器
@RequestMapping("/test") // 命名空间
public class MyController {

	// 请求方式的定义 method=RequestMethod.POST
	// 如果是多个请求，可以使用数组：({"/my.do","hello.do"})
	@RequestMapping("/register.do")
	public String register(String name, int age,Model model) {
		//使用redirect 就是重定向 到 controller 通过model携带数据，不能放对象
		model.addAttribute("pname", name);
		model.addAttribute("page", age);
		return "redirect:other.do";
	}
	
	/*第一种方式*/
//	@RequestMapping("/other.do")
//	public String doOther(String pname, int page) {
//		System.out.println("pname" + pname);
//		System.out.println("page" + page);
//		return "/welcome.jsp";//转发
//	}
	@RequestMapping("/other.do")
	public String doOther() {
		return "/welcome.jsp";//转发
	}
}
