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
    
    <title>网上书城购物</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/before/shopping-head-center.css'/>">
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/before/shopping-head-top.css'/>">
	<script type="text/javascript" src="<c:url value='/js/jquery-2.1.4.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/before/shopping-head-top.js'/>"></script>
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/before/shopping-center-top.css'/>">
	<script type="text/javascript" src="<c:url value='/js/public/jquery-1.7.2.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/before/shopping-center-top.js'/>"></script>
	
  </head>
  
  <body>
  <div style="width:1347px;height:100%">
  
  	<c:if test="${bookListSend0 == null}">
  		<c:redirect url="/BookSendServlet"/>
  	</c:if>
  	
  	<!-- 个人中心及登录 div -->
    	<div class="box-2">
    		<c:choose>
    		<c:when test="${empty sessionScope.userSession}">
    			<span class="span-1">您好，欢迎光临网上书城!</span>
	    		<a href="<c:url value='/jsp/before/login.jsp'/>" class="a-1"><span>登录</span></a>
	    		<a href="<c:url value='/jsp/before/regist.jsp'/>" class="a-1"><span>免费注册</span></a>
    		</c:when>
    		<c:otherwise>
    			<span class="span-1">欢迎您，${unickName}</span>
	    		<a href="<c:url value='/SelectUserBuyBookServlet?unickname=${unickName}'/>" class="a-2"><span>我的购物车</span></a>
	    		<a href="<c:url value='/jsp/before/login.jsp'/>" class="a-1"><span>退出</span></a>
	    		<c:set var="userSession" value=""></c:set>
    		</c:otherwise>
    		</c:choose>
    	</div>
    <!-- 结束 -->
    <jsp:include page="/jsp/before/shopping-head-top.jsp" flush="true"></jsp:include>
    <jsp:include page="/jsp/before/shopping-head-center.jsp" flush="true"></jsp:include>
   </div>
  </body>
</html>
