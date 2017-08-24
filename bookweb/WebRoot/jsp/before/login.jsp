<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>登录页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/before/login.css'/>">
	<script type="text/javascript" src="<c:url value='/js/jquery-2.1.4.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/before/login.js'/>"></script>
	
  </head>
  
  <body class="bod">
		<div class="box">
			<div class="box2">
			<img src="<c:url value='/images/login-deng (1).jpg'/>" class="img1">
			<form action="<c:url value='/UserLoginServlet'/>" method="post">
				<table>
					<tr>
						<td>
							<span class="span1"><img src="<c:url value='/images/login-user(1).png'/>" class="img2"></span>
							<input type="text"  placeholder="请输入用户名" class="input1" id="loginname" name="loginname" value="${username}">
						</td>
					</tr>
					<tr>
						<td><label id="loginnameError" class="error"></label></td>
					</tr>
					<tr>
						<td>
							<span class="span2"><img src="<c:url value='/images/login-pass (2).png'/>" class="img3"></span>
							<input type="password"  placeholder="请输入密码" class="input1" id="loginpass" name="loginpass">
						</td>
					</tr>
					<tr>
						<td><label id="loginpassError" class="error">${error}</label></td>
					</tr>
					<tr>
						<td>
							<input type="submit" class="sub" value="登 录" id="submit">
						</td>
					</tr>
					<tr>
						<td>
							<a href="<c:url value='/jsp/before/forgetpass.jsp'/>" class="a1" id="forgetpass">忘记密码</a>
							<c:set var="falses" value="aa" scope="session"></c:set>
							<c:set var="flags" value="aa" scope="session"></c:set>
							<c:set var="forget" value="aa" scope="session"></c:set>
							<a href="<c:url value='/jsp/before/regist.jsp'/>" class="a2" id="regist">注册</a>
						</td>
					</tr>
				</table>
			</form>
		</div>
		</div>
  </body>
</html>