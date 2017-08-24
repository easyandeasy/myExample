<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
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
		</h1>
	</div>
	<div>
		<form action="helloWord.action" method="post">
			请输入您的姓名:
			<input name="name" type="text" />
			<input type="submit" value="提交" />
		</form>
	</div>
	
	<%-- <s:form  action="/helloWorld" method="post">
	 	<s:textfield name="name" label="用户名"/>
	 	<s:password name="pwd" label="密码"/>
	 	<s:radio list="#{'nv':'女','nan':'男'}" name="sex1" label="性别1"/>
	 	<s:radio list="{'女','男'}" name="sex2" label="性别2"/>
	 	
	 	<s:checkboxlist list="{'吃饭','睡觉','敲代码'}" name="box1" label="爱好"/>
	 	
	 	<s:select list="{'小学','中学','大学'}" name="college" label="学历"></s:select>
	 	
	 	<s:textarea name="text1" rows="2" cols="5" label="文本域"/>
	 	<s:submit name="submit" value="登录"/>
 	</s:form> --%>
  </body>
</html>
