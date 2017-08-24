package cn.springmvc.beans;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller		//表示当前类是一个处理器
@RequestMapping("/test")	//命名空间
public class MyController  {
	
	@RequestMapping(value="/ajax.do")	
	@ResponseBody
	public Object doAjax() {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("stu1", new Student("张三",23));
		map.put("stu2", new Student("李四",24));
		return map;
	}
}
