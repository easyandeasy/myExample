package com.user.interceptor;


import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;


/**
 * 判断用户是否登录拦截器
 * @author tang
 *
 */
public class IsLoginInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		Map session = invocation.getInvocationContext().getSession();
		System.out.println("3");
		String user = (String)session.get("CURRENT_USER");
		System.out.println(user);
		if(user==null){
			return "error";
		}else{
			return invocation.invoke();
		}
	}
}
