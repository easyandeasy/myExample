package cn.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class OnInterceptor implements HandlerInterceptor {

	@Override//controller执行之前
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("执行 -------- preHandle() 方法");
		return true;//此处为true是才Controller，为false则不执行
	}

	@Override//controller执行之后
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("执行 -------- postHandle() 方法");
		
	}

	@Override//controller执行操作完成之后
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("执行 -------- afterCompletion() 方法");
		
	}


}
