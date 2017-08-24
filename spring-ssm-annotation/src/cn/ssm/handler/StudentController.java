package cn.ssm.handler;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.ssm.beans.Student;
import cn.ssm.service.IStudentService;

@Controller  //表示这是一个处理器
@RequestMapping("/test") //命名空间
public class StudentController{

	@Autowired
	@Qualifier("studentService")//第一种方式 注入
//	@Resource(name="studentService")//第二种方式 注入
	private IStudentService service;
	
	public void setService(IStudentService service) {
		this.service = service;
	}

	@RequestMapping("/register.do") //请求路径
	public ModelAndView handleRequest(String name,int age){
		ModelAndView mv = new ModelAndView();
		Student student = new Student();
		student.setAge(age);
		student.setName(name);
		service.addStudent(student);
		mv.setViewName("/welcome.jsp");
		return mv;
	}
}
