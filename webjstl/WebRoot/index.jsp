<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
    <c:set var="isLogin" value="${empty sessionScope.user}" scope="request"/>
  <%--  <c:if test="${isLogin}" > --%>
   <c:choose>
  	 	<c:when test="${isLogin }">
	    	<form id="login" method="post" action="login_2">
	    		<input type="hidden" value="post" name="cmdStr" />
	    		<c:if test="${not empty errMsg }" >
	    			<div style="color:red;">${errMsg }</div>
	    			<c:remove var="errMsdg"/>
	    		</c:if>
	    		<table>
	    			<tr>
	    				<td>用户名：</td>
	    				<td><input type="text" name="userName" id="userName" /></td>
	    			</tr>
	    			<tr>
	    				<td>密码：</td>
	    				<td><input type="password" name="password" id="password"/></td>
	    			</tr>
	    			<tr>
	    				<td></td>
	    				<td><input type="submit" value="登录" /></td> 
	    			</tr>
	    		</table>
	    	</form>
    	</c:when>
    	<%-- <c:if test="${!isLogin }" var="a">
    		欢迎  ${user.userName },您已经登录成功！
    		<c:out value="${a }"></c:out>
    	</c:if> --%>
    	<c:otherwise>
    		<c:choose>
    			<c:when test="${user.role eq 'a' }">
    				经理页面
    			</c:when>
    			<c:when test="${user.role eq 'aa' }">
    				总监页面
    			</c:when>
    			<c:otherwise>
    				员工页面
    			</c:otherwise>
    		</c:choose>
    	</c:otherwise>
   </c:choose>
   
   <%--  </c:if> --%>
   
  </body>
</html>
