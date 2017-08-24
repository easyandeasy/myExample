<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'helloWord.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body>
	<!-- <form action="login.action" >

	用户名:<input type="text" name="name" /><br/>
	密     码:<input type="password" name="pwd" /><br/>
		 <input type="submit" value="login" />
	</form>
 -->
 
 <s:form>
 	<s:textfield name="name" label="用户名"/>
 	<s:password name="pwd" label="密码"/>
 	<s:submit name="submit" value="登录"/>
 </s:form>
  </body>
</html>
