package cn.springmvc.beans;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller		//表示当前类是一个处理器
@RequestMapping("/test")	//命名空间
public class MyController  {
	
	@RequestMapping(value="/ajax.do")	
	@ResponseBody
	public Object doAjax() {
		System.out.println(" ======================= ");
		return 123.321;
	}
}
