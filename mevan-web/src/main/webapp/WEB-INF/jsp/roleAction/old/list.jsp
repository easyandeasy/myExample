<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
  
 	 <!-- 用EL表达式显示数据 -->
   	<s:iterator value="#roleList">
   		${id }&nbsp;&nbsp;&nbsp;&nbsp;
   		${name }&nbsp;&nbsp;&nbsp;&nbsp;
   		${description }&nbsp;&nbsp;&nbsp;&nbsp;
   		<s:a action="role_delete.action?id=%{id}" onclick="return confirm('确定要删除吗！')">删除</s:a>&nbsp;&nbsp;&nbsp;&nbsp;
   		<s:a action="role_editUI.action?id=%{id}">修改</s:a>
   		<br/>
   	</s:iterator>
   	
   	
   	<%--
   	<s:iterator value="#roleList">
   		<s:property value="id"/>&nbsp;&nbsp;&nbsp;&nbsp;
   		<s:property value="name"/>&nbsp;&nbsp;&nbsp;&nbsp;
   		<s:property value="description"/>&nbsp;&nbsp;&nbsp;&nbsp;
   		<s:a action="role_delete.action?id=%{id}" onclick="return confirm('确定要删除吗！')">删除</s:a>&nbsp;&nbsp;&nbsp;&nbsp;
   		<s:a action="role_editUI.action?id=%{id}">修改</s:a>
   		<br/>
   	</s:iterator>
   	
   	--%>
   	<s:a action="role_addUI.action">添加</s:a>
  </body>
</html>
