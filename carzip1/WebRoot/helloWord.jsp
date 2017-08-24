<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'helloWord.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    
	<div>
		<h1>
			<!--显示Struts Action中message的属性内容-->
			<s:property value="message"/>
			<br/>
			<s:iterator value="list" id="name">
				<s:property value="name"/> , 
			</s:iterator>
		</h1>
	</div>
	<div>
		<form action="helloWorld.action">
			请输入您的姓名:
			<input name="name" type="text" />
			<input type="submit" value="提交" />
		</form>
	</div>
	
	<s:form>
	 	<s:textfield name="name" label="用户名"/>
	 	<s:password name="pwd" label="密码"/>
	 	<s:submit name="submit" value="登录"/>
 	</s:form>
	
  </body>
</html>
