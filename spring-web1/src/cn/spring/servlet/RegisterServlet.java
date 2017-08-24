package cn.spring.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
		System.out.println(name + "\t" + age);
		//1. 创建spring容器
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2. 从容器中获取service对象
		IStudentService service = (IStudentService) ac.getBean("service");
		//3. 调用service中的addStudent
		//service.addStudent(student);
		List<Student> stu = service.queryStudentAll();
		System.out.println(stu);
		request.getRequestDispatcher("welcome.jsp").forward(request, response);
	}

}
