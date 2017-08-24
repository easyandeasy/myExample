package cn.spring.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

public class MyAspectj {
	
	//前置通知
	public void before() {
		System.out.println("无参前置通知方法  ");
	}
	public void before(JoinPoint jp) {
		System.out.println("有参前置通知方法    jp = " + jp);
	}

	//后置通知
	public void after(String result) {
		System.out.println("后置通知方法  result = " + result);
	}
	
	//环绕通知
	public Object afterAndBefore(ProceedingJoinPoint pjp) throws Throwable {
		
		System.out.println("环绕通知方法");
		Object result = pjp.proceed();
		System.out.println("环绕通知方法  result = " + result);
		return ((String)(result)).toUpperCase();
	}
	
	//异常通知
	public void afterException(Exception ex) {
		System.out.println("异常通知方法\tex = " + ex);
	}
	
	//最终通知
	public void after() {
		System.out.println("最终通知");
	}
}
