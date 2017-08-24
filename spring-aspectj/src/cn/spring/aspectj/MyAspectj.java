package cn.spring.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspectj {
	
	//前置通知
	@Before("execution(* *..IBuyStockService.doFirst(..))")
	public void before(JoinPoint jp) {	// JoinPoint 获取的是具体执行的方法
		System.out.println("前置通知方法    jp = " + jp);
	}

	//后置通知
	@AfterReturning(value="execution(* *..IBuyStockService.doSecond(..))",returning="result")
	public void after(String result) { // result 获取到的是对应方法的返回值 
		System.out.println("后置通知方法  result = " + result);
	}
	
	//环绕通知
	@Around(value="execution(* *..IBuyStockService.doSecond(..))")
	public Object afterAndBefore(ProceedingJoinPoint pjp) throws Throwable {
		
		System.out.println("环绕通知方法");
		Object result = pjp.proceed();
		
		System.out.println("环绕通知方法  result = " + result);
		
		return ((String)(result)).toUpperCase();
	}
	
	//异常通知
	@AfterThrowing(value="execution(* *..IBuyStockService.doThird(..))" ,throwing="ex")
	public void afterException(Exception ex) {
		System.out.println("异常通知方法\tex = " + ex);
	}
	
	
	//最终通知
	@After("execution(* *..IBuyStockService.doThird(..))")
	public void after() {
		System.out.println("最终通知");
	}
	
	
	//异常通知 <使用定义的切入点>
	@AfterThrowing(value="doTirdPointcut()" ,throwing="ex")
	public void afterException2(Exception ex) {
		System.out.println("异常通知方法\tex = " + ex);
	}
	//定义一个切入点
	@Pointcut("execution(* *..IBuyStockService.doThird(..))")
	public void doTirdPointcut(){}
}
