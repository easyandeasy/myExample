package cn.spring.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.spring.beans.Student;
import cn.spring.service.IStudentService;

public class RegisterServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		Integer a = Integer.valueOf(age);
		Student student = new Student(name,a);
		//1. 创建spring容器
		//ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		//ServletContext application = request.getSession().getServletContext();
		//WebApplicationContext ac = (WebApplicationContext) application.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		WebApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		System.out.println(name + "\t" + age + "\t"+ac);
		//2. 从容器中获取service对象
		IStudentService service = (IStudentService) ac.getBean("service");
		//3. 调用service中的addStudent
		//service.addStudent(student);
		//Student stu = service.queryStudentById(2);
		List<Student> stus = service.queryStudentAll();
		for (Student stu : stus) {
			System.out.println(stu.getId() + "\t" + stu.getName() + "\t" + stu.getAge());
			if(stu.getId()==5){
				break;
			}
		}
		request.getRequestDispatcher("welcome.jsp").forward(request, response);
	}

}
