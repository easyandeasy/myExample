<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'welcome.jsp' starting page</title>
  </head>
  <body>
  	<!-- 
  		param.age的底层执行的是：request.getParameter("age");这个获取到的是个字符串
  		requestScope.age 的底层执行的是request.getAttribute("age");这个获取到的是个整数
  	 -->
  	name = ${param.pname }<br/>
  	age = ${param.page }
  </body>
</html>
