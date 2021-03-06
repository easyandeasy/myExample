package cn.springmvc.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

public class HttpRequestHandlers implements HttpRequestHandler {

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("message","执行doFirst()方法");
		request.getRequestDispatcher("/WEB-INF/jsp/welcome.jsp").forward(request, response);
	}
}
