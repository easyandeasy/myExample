package cn.springmvc.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
		List<Student> stu = new ArrayList<Student>();
		stu.add(new Student("张三",23));
		stu.add(new Student("李四",24));
		return stu;
	}
}
