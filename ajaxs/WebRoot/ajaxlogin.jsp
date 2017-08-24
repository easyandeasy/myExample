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
<style type="text/css" >
</style>
<script type="text/javascript" src="js/jquery-2.1.4.js"></script>
<script type="text/javascript" src="js/ajaxlogin.js"></script>
</head>

<body>
	<nav class=""></nav>
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
	<br /><br />
	
	<table width="900" border="1">
		<tr><td><input type="button" name="btnlogin" value="查询" onclick="login()" /></td><td><input type="button" name="btnadd" value="添加" onclick="addinfo()" /></td></tr>
		<tr>
			<td width="200px">编号</td>
			<td width="200px">姓名</td>
			<td width="200px">年龄</td>
			<td width="200px">操作</td>
		</tr>
		<tbody id="tbody">
			
		</tbody>
	</table>
</body>
</html>
