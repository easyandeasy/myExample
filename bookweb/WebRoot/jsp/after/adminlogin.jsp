<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="../../css/after/adminlogin.css">
	<link rel="stylesheet" href="../../css/after/adminforget.css" type="text/css"></link>
  <script type="text/javascript" src="../../js/jquery-2.1.4.js"></script>
  <script type="text/javascript" src="../../js/after/admin.js"></script>
  </head>
  
  <body class="admin">
		<center>
			<form action="../../AdminLoginServlet" method="post">
				<div class="div">
					<div id="form">
						<div><font color="red" id="error">&nbsp;</font></div>
						<input type="text" name="adminname" placeholder="管理员账号" class="input" id="text" maxlength="16"><br/>
						<input type="password" name="adminpwd"  placeholder="请输入密码" class="input" id="pwd" maxlength="16"><br/><br/>
						<input type="submit" class="sub" value=" "/>
					</div>
					<p  id="forget"><a href="javascript:;" onclick="fogetdiv()">忘记密码</a></p>
				</div>
			</form>
		</center>
		
		
		
		
		
		<center class="center">
			<div class="closeimg"><img src="../../book_img/2.png" onclick="closediv()" width="20"/></div>
			<div class="forgetbox">
			<div class="one">
				<li class="oneone">验证</li><span id="one"></span>
				<li class="onetwo">重置</li><span id="two"></span>
				<li class="onethree">完成</li><span id="three"></span>
			</div>
			
			<!-- 第一步 -->
			<div class="infoone" align="center">
				<table border="0" id="tableone">
					<tr>
						<th align="right" class="thhead">用户名:<input type="hidden" name="unameerror" value="111" /></th>
						<td><input type="text" name="uname" class="forgettext"/><span class="unameerror"></span></td>
					</tr>
					<tr>
						<th align="right" class="thhead">身份证号:<input type="hidden" name="idcarderror" value="222" /></th>
						<td><input type="text" name="idcard" class="forgettext"/><span class="idcarderror"></span></td>
					</tr>
					<tr>
						<th></th>
						<td><input type="button" value="下一步" class="nextone" onclick="numberone();"/></td>
					</tr>
				</table>
			</div>
			
			<!-- 第二步 -->
			<div class="infotwo" align="center">
				<table border="0">
					<tr>
						<th align="right" class="thhead">新密码:</th>
						<td><input type="password" name="newpwd" maxlength="16" class="forgettext"/><span class="pwderror"></span></td>
					</tr>
					<tr>
						<th align="right" class="thhead">确认新密码:</th>
						<td><input type="password" name="newpwd2" maxlength="16" class="forgettext"/><span class="pwd1error"></span></td>
					</tr>
					<tr>
						<th></th>
						<td><input type="button" value="下一步" class="nextone" onclick="newpwdclick();"/></td>
					</tr>
				</table><br/><br/>
				<div><input type="button" value="返回" class="back" onclick="backclick();"/></div>
			</div>
			
			
			
			<!-- 第三步 -->
			<div class="infothree" align="center">
				<table border="0">
					<tr>
						<th><img src="../../book_img/ooopic_1473782498.ico" style="vertical-align: middle;" width="90px"/><font size="5"> 重置密码成功！</font></th>
					</tr>
					<tr>
						<th><input type="button" name="successbtn" value="马上登录" class="nextone" onclick="closediv()"/></th>
					</tr>
				</table>
			</div>
			</div>
			<img src="../../images/psw-logo-r.png" class="logo"/>
		</center>
  </body>
</html>