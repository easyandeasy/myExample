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
    
    <title>My JSP 'forgetpasserror.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="<c:url value='/css/before/forgetpasserror.css'/>">
	<script type="text/javascript" src="<c:url value='/js/jquery-2.1.4.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/before/forgetpasserror.js'/>"></script>
	
  </head>
  
  <body>
   <script type="text/javascript">$(function(){$(".box-2").css("display","block");});</script>
    <div class="box-1" align="center">
  		<form action="<c:url value='/UserForgetServlet'/>" method="post">
  			<input type="hidden" name="method" value="forgetpasserror">
  				<div class="box-2">
  					<img src="<c:url value='/images/ooopic_1473782498.ico'/>" class="img-1"><span class="span-1">恭喜您，验证通过，请在下方重新设置您的登录密码</span><br>
  					<table>
  							<tr>
  								<td>
  									<span class="span2"><img src="<c:url value='/images/login-pass (2).png'/>" class="img1"></span>
									<input type="text" placeholder="请输入密码" class="input2" name="pass" id="pass">
  								</td>
  							</tr>
  						<tr>
  							<td><label class="error" id="passError">${passError}</label></td>
  						</tr>
  						<tr>
  							<td>
  								<span class="span1"><img src="<c:url value='/images/login-pass (2).png'/>" class="img1"></span>
								<input type="text" placeholder="请再输入一次" class="input1" name="passTwo" id="passTwo">
  							</td>
  						</tr>
  						<tr>
  							<td><label class="error" id="passTwoError">${passTwoError}</label></td>
  						</tr>
  						<tr>
  							<td>
  								<span class="span3"><img src="<c:url value='/images/login-input3.png'/>" class="img1"></span>
								<input type="text" placeholder="请输入右侧验证码" class="input3" name="yanzhengma" id="yanzhengma">
								<div class="huan">
								<img src="<c:url value='/ImageReplaceServlet'/>" class="imgsReplace" id="repImgs">
								</div>
								<a href="javascript:_hyz()" class="huanyizhang">换一张</a>
  							</td>
  						</tr>
  						<tr>
  							<td><label class="error" id="yanzhengmaError">${yanzhengmaError}</label></td>
  						</tr>
  						<tr>
  							<td>
  								<input type="submit" value="提  交" class="regist" id="regist">
  							</td>
  						</tr>
  					</table>
  			</div>
  			<c:if test="${falsesg eq 'falses' }">
  				<script type="text/javascript">$(function(){$(".box-2").css("display","none");});</script>
  				<div class="byt">
  				<img src="<c:url value='/images/reg-password-small.png'/>" class="img-ss">
  				<span class="span-1">设置密码成功，快去开启购物之旅吧</span>
  				<a href="<c:url value='/jsp/before/login.jsp'/>" class="a-1">
  				<input type="button" value="马上登录" class="input-1"></a>
  				<script type="text/javascript">
  					$(".input-1").mouseover(function(){$(this).addClass("ppoooo");});
					$(".input-1").mouseout(function(){$(this).removeClass("ppoooo");});
  				</script>
  				</div>
  				<c:set var="forget" value="bb" scope="session"></c:set>
  			</c:if>	
  		</form>
  	</div>
  </body>
</html>
