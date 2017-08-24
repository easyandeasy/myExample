<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript" src="js/jquery-2.1.4.js"></script>
<script type="text/javascript" src="js/ajaxlogin.js"></script>
</head>

<body>
	<div class="error" style="color:red;font-size:11px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
	<div id="login">
	<c:choose>
		<c:when test="${not empty user }">
			欢迎您：${user.name }	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:;"  onclick='outclick()'>退出</a>	
		</c:when>
		<c:otherwise>
			<a href="javascript:;" >请登录</a>
		</c:otherwise>
	</c:choose>
	</div>
	<br /><br /><br /><br />
	<input type="button" name="btnlogin" value="提交" onclick="login()" />
	<table align="center" width="15%">
		<tr>
			<td>姓名</td>
			<td>年龄</td>
		</tr>
		<tbody id="tbody">
			
		</tbody>
	</table>
</body>
</html>
