<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="../css/style.css">
	

  <script type="text/javascript" src="../js/jquery-2.1.4.js"></script>
  <script type="text/javascript" src="../js/register.js"></script>
  
  </head>
  
  <body>
    <form action="#" method="post">
		登录名 <input type="text" name="userName" maxlength="16" /><sapn></sapn><br/>
		&nbsp;密&nbsp;码 <input type="password" name="pwd" maxlength="16"/> <br/>
		&nbsp;<input type="submit" name="submit" value="登录"/><br/>	
	</form>
  </body>
</html>
