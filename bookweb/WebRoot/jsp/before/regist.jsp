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
    
    <title>注册页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/before/regist.css'/>">
	<script type="text/javascript" src="<c:url value='/js/jquery-2.1.4.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/before/regist.js'/>"></script>

  </head>
  <body class="bod">
   <script type="text/javascript">$(function(){$("#flag").css("display","block");});</script>
  	<div class="box">
  		<img src="<c:url value='/images/reg-logo-r.png'/>" class="img3">
  		<div class="box3" align="center"><span class="span">新用户注册</span></div>
  		<form action="<c:url value='/UserRegisterServlet'/>" method="post">
  			<div class="box1">
  				<div id="flag">
  				<table>
  					<tr>
  						<td>
  							<span class="span1"><img src="<c:url value='/images/login-input5.png'/>" class="img1"></span>
							<input type="text" placeholder="请输入常用邮箱" class="input1" name="RegistEmail" id="RegistEmail">
							<label class="error" id="RegistEmailError">${RegistEmail}</label>
  						</td>
  					</tr>
  					<tr>
  						<td>
  							<span class="span1"><img src="<c:url value='/images/login-user(1).png'/>" class="img1"></span>
							<input type="text" placeholder="请用户名" class="input1" name="Registname" id="Registname">
							<label class="error" id="RegistnameError">${Registname}</label>
  						</td>
  					</tr>
  					<tr>
  						<td>
  							<span class="span1"><img src="<c:url value='/images/login-pass (2).png'/>" class="img1"></span>
							<input type="password" placeholder="请输入密码" class="input1" name="RegistPass" id="RegistPass">
							<label class="error" id="RegistPassError">${RegistPass}</label>
  						</td>
  					</tr>
  					<tr>
  						<td>
  							<span class="span1"><img src="<c:url value='/images/login-pass (2).png'/>" class="img1"></span>
							<input type="password" placeholder="请确认密码" class="input1" name="RegistTwoPass" id="RegistTwoPass">
							<label class="error" id="RegistTwoPassError">${RegistTwoPass}</label>
  						</td>
  					</tr>
  					<tr>
  						<td>
  							<span class="span2"><img src="<c:url value='/images/login-input3.png'/>" class="img1"></span>
							<input type="text" placeholder="请输入右侧验证码" class="input2" name="Yzm" id="Yzm">
							<div class="checkbox" id="checkbox"><img src="<c:url value='/ImageReplaceServlet'/>" class="imgRound" id="imgRound"></div>
							<label class="error" id="YzmError">${registYzm}</label>
							<a href="javascript:_hyz()" class="aReplace" id="aReplace">换一张</a>
  						</td>
  					</tr>
  					<tr>
  						<td><label class="error1" id="registTwoPassError">${error1}</label></td>
  					</tr>
  					<tr>
  						<td>
  							<input type="submit" value="注 册" class="regist" id="RegistForm">
  						</td>
  					</tr>
  				</table>
  			</div>		
  			<c:if test="${flags eq 'flag' }">
  				<script type="text/javascript">$(function(){$("#flag").css("display","none");});</script>
  				<div class="ssmdiv" align="center">
  					<img src="<c:url value='/images/ooopic_1473782498.ico'/>" class="mings"><span class="addspan">恭喜您，注册成功!</span><br>
  					<a href="<c:url value='/jsp/before/login.jsp'/>" class="asp"><input type="button" value="马 上 登 录" class="denglu" id="denglu"></a>
  				</div>
  			</c:if>
  		</form>
  				<c:set var="flags" value="aa" scope="session"></c:set>	
  		</div>
  		<div class="box2"><a href="<c:url value='/jsp/before/login.jsp'/>"><input type="submit" value="已有账号，马上登录" class="input" id="loginuser"></a></div>
  	</div>
  </body>
</html>
