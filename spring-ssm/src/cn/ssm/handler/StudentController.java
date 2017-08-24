package cn.ssm.handler;


import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import cn.ssm.beans.Student;
import cn.ssm.service.IStudentService;

public class StudentController implements Controller {

	private IStudentService service;
	
	public void setService(IStudentService service) {
		this.service = service;
	}

	@Override
	public ModelAndView handleRequest(HttpServletBean request, HttpServletBean response) throws Exception {
		ModelAndView mv = new ModelAndView();
		String name = request.getParameter("name");
		String ageStr = request.getParameter("age");
		
		int age = 0;
		if(ageStr != null) {
			age = Integer.parseInt(ageStr);
		}
		Student student = new Student();
		student.setAge(age);
		student.setName(name);
		service.addStudent(student);
		mv.setViewName("/welcome.jsp");
		return mv;
	}
}
