<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	

  </head>
  
  <body  class="loginBody">
  	<center class="center">
  		<h1>注册购物帐号</h1>
		<div class="form">
		   	<form action="" method="post">
		   		<table>
		   			<tr>
		   				<td>用户名：</td>
		   				<td><input type="text" name="userName" class="input"/></td>
		   			</tr>
		   			<tr>
		   				<td>密&nbsp;码：</td>
		   				<td><input type="password" name="password" class="input"/></td>
		   			</tr>
		   			<tr>
		   				<td>确认密码：</td>
		   				<td><input type="password" name="password" class="input"/></td>
		   			</tr>
		   			<tr>
		   				<td></td>
		   				<th><input type="submit" name="sub" value="注册" class="input"/>&nbsp;&nbsp;<input class="input" type="reset" value="重置"/></th>
		   			</tr>
		   		</table>
		   	</form>
    	</div>
    	<div class="login">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:history.back();">已有帐号!</a></div>
    </center>
  </body>
</html>
