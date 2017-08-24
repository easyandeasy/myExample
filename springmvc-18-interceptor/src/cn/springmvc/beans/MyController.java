package cn.springmvc.beans;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller // 表示当前类是一个处理器
@RequestMapping("/test") // 命名空间
public class MyController {

	@RequestMapping("/some.do")
	public ModelAndView doSome() {
		ModelAndView mv = new ModelAndView();
		System.out.println("执行----------- doSome() --------");
		mv.setViewName("/WEB-INF/jsp/welcome.jsp");
		return mv;
	}
}
