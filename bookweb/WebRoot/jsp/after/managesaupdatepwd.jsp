<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- http://java.sun.com/jsp/jstl/fmt -->

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'adminmanage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	

	<link rel="stylesheet" href="../../css/after/managesupdatepwd.css" type="text/css"></link>
  
	<script type="text/javascript" src="../../js/jquery-2.1.4.js"></script>
	<script type="text/javascript" src="../../js/after/managesupdatepwd.js"></script>
  </head>
  
  <body>
	  	<font size="5" color="#ccc" class="admintoptext">修改密码</font>
	  <form action="javascript:;" method="post" class="adminform" enctype="application/form-data">
		 <table border="0" class="tableadmin">
		 	 <tr>
		  		<td align="right">旧密码:</td>
		  		<th><input type="password" value="" class="admintext" maxlength="16" name="olderpwd"/></th>
		 	 </tr>
		 	  <tr>
		  		<td align="right">新密码:</td>
		  		<th><input type="password" value="" class="admintext" maxlength="16" name="newpwd1"/></th>
		 	 </tr>
		 	  <tr>
		  		<td align="right">确认新密码:</td>
		  		<th><input type="password" value="" class="admintext" maxlength="16" name="newpwd2"/></th>
		 	 </tr>
		 	  <tr>
		 	  	<td align="right"></td>
		  		<th align="left"><input type="button" value="确定" class="adminbtn" name="adminbtn" onclick="updatepwd()"/></th>
		 	 </tr>
		 </table>
	  </form>
	  
	  <div class="adminjavascript"></div>
  </body>
</html>
