package cn.springmvc.beans;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.sf.json.JSONObject;

@Controller		//表示当前类是一个处理器
@RequestMapping("/test")	//命名空间
public class MyController  {
	
	@RequestMapping("/ajax.do")	
	public void doAjax( String name ,int age ,HttpServletResponse response) throws IOException {
		System.out.println(" name = " + name);
		System.out.println(" age = " + age);
		response.setCharacterEncoding("utf-8");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", name);
		map.put("age", age);
		JSONObject myJson = JSONObject.fromObject(map);
		String json = myJson.toString();
		PrintWriter out = response.getWriter();
		out.print(json);
		out.close();
	}
}
