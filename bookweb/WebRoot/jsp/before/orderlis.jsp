<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>订单列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/before/orderlis.css'/>"/>

  </head>
  
  <body>
  <div class="divMain">
  <c:choose>
  	<c:when test="${empty listMyOrderAllInfo}">
  		<table width="95%" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td align="right">
				<img align="top" src="<c:url value='/images/icon_empty.png'/>"/>
			</td>
			<td>
				<span class="spanEmpty">亲，你还没有下单记录哦，赶紧去挑选几本喜欢的书下单吧~</span>
				<a href="<c:url value='/jsp/before/shopping-head.jsp'/>" style="color:#ed155b">去首页挑选</a>
			</td>
		</tr>
	</table>  
  	</c:when>
  	<c:otherwise>
	<div class="divTitle">
		<span style="margin-left: 180px;margin-right: 280px;">商品信息</span>
		<span style="margin-left: 48px;margin-right: 38px;">金额</span>
		<span style="margin-left: 70px;margin-right: 40px;">订单状态</span>
		<span style="margin-left: 60px;margin-right: 50px;">操作</span>
	</div>
	<br/>
	<table align="center" border="0" width="100%" cellpadding="0" cellspacing="0">

	<c:forEach items="${listMyOrderAllInfo}" var="orders">
		<tr class="tt">
			<td width="320px">订单号：<a  href="<c:url value='/OrderServlet?method=load&oid=${orders.onumber}'/>">${orders.onumber}</a></td>
			<td width="200px">下单时间：${orders.ordertime}</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr style="padding-top: 10px; padding-bottom: 10px;">
		<td colspan="2">


	  	<c:forEach items="${orders.litsImage}" var="img">
			<a class="link2" href="javascript:;">
			    <img border="0" width="70" src="<c:url value='/${img.imggesmall}'/>"/>
			</a>
	  </c:forEach>
	
			</td>
			<td width="115px">
				<span class="price_t">&yen;${orders.total}</span>
			</td>
			<td width="142px">
			
		<c:choose>
			<c:when test="${orders.ostatus eq 1 }">(等待付款)</c:when>
			<c:when test="${orders.ostatus eq 2 }">(准备发货)</c:when>
			<c:when test="${orders.ostatus eq 3 }">(等待确认)</c:when>
			<c:when test="${orders.ostatus eq 4 }">(交易成功)</c:when>
			<c:when test="${orders.ostatus eq 5 }">(已取消)</c:when>
		</c:choose>			

			</td>
			<td>
			<a href="<c:url value='javascript:;'/>">查看</a><br/>
		<c:if test="${orders.ostatus eq 1 }">
				<a href="javascript:;">支付</a><br/>
				<a href="<c:url value='/UpdateUserOrdersServlet?onumber=${orders.onumber}&unickName=${unickName}&ostatus=5'/>">取消</a><br/>						
		</c:if>
		<c:if test="${orders.ostatus eq 3 }">
				<a href="<c:url value='/UpdateUserOrdersServlet?onumber=${orders.onumber}&unickName=${unickName}&ostatus=3'/>">确认收货</a><br/>
		</c:if>
			</td>
		</tr>
	</c:forEach>
	</table>
	</c:otherwise>
  </c:choose>
	</div>
  </body>
</html>
