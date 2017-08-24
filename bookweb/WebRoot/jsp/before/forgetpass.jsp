<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>找回密码</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/before/forgetpass.css'/>">
	<script type="text/javascript" src="<c:url value='/js/jquery-2.1.4.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/before/forgetpass.js'/>"></script>

  </head>
   <body class="bod">
   <script type="text/javascript">$(function(){$(".forgetyy").css("display","block");});</script>
  	<div class="box">
  		<img src="<c:url value='/images/psw-logo-r.png'/>" class="img3">
  		<div class="box3" align="center"><span class="span">通过邮箱找回密码</span></div>
  		<div class="box1">
  		<div class="forgetyy">
  		<form action="<c:url value='/UserForgetServlet'/>" method="post">
  			<input type="hidden" name="method" value="forgetpass">
  				<table>
  					<tr>
  						<td>
  							<span class="span2"><img src="<c:url value='/images/login-input5.png'/>" class="img1"></span>
							<input type="text" placeholder="请输入您的常用邮箱" class="input2" name="email" id="email">
  						</td>
  					</tr>
  					<tr>
  						<td><label class="error" id="emailError"></label></td>
  					</tr>
  					<tr>
  						<td>
  							<span class="span1"><img src="<c:url value='/images/login-user(1).png'/>" class="img1"></span>
							<input type="text" placeholder="请输入用户名" class="input1" name="loginname" id="loginname">
  						</td>
  					</tr>
  					<tr>
  						<td><label class="error" id="loginnameError"></label></td>
  					</tr>
  					<tr>
  						<td>
  							<span class="span3"><img src="<c:url value='/images/login-input3.png'/>" class="img1"></span>
							<input type="text" placeholder="请输入右侧验证码" class="input3" name="Yzm" id="Yzm">
							<div class="huan">
								<img src="<c:url value='/ImageReplaceServlet'/>" class="imgsReplace" id="imgsReplace">
							</div>
							<a href="javascript:_hyz()" class="huanyizhang">换一张</a>
  						</td>
  					</tr>
  					<tr>
  						<td><label class="error" id="YzmError">${errors}</label></td>
  					</tr>
  					<tr>
  						<td>
  							<input type="submit" value="提   交 " class="regist" id="regist">
  						</td>
  					</tr>
  				</table>
  		</form>
  		</div>
  		<div class="disppy">
	  		<c:if test="${forget eq 'forgets' }">
	  			<script type="text/javascript">$(function(){$(".forgetyy").css("display","none");});</script>
	  			<jsp:include page="/jsp/before/forgetpasserror.jsp" flush="true"/>
	  			<c:set var="falsesg" value="aa" scope="session"></c:set>
	  		</c:if>
  		</div>
  		</div>
  		<div class="box2"><a href="<c:url value='/jsp/before/login.jsp'/>"><input type="submit" value="已有账号，马上登录" class="input"></a></div>
  	</div>
  </body>
</html>
