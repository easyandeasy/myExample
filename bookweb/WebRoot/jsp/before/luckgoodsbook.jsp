<%@ page language="java" import="java.util.*,cn.bookweb.book.dao.*,cn.bookweb.book.service.*,cn.bookweb.book.entity.*,cn.bookweb.book.serviceimpl.*,cn.bookweb.book.daoimpl.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查看商品详细信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/before/luckgoodsbook.css'/>" />
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/before/shopping-head-top.css'/>">
	<script type="text/javascript" src="<c:url value='/js/jquery-2.1.4.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/before/shopping-head-top.js'/>"></script>

  </head>
  
  <body>
  <div class="dov-box">
  
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
    	
    	<!-- 搜索框 -->
    	<div class="center">
    		<div class="box-3">
    		<input type="text" placeholder="请输入关键字" class="input-1">
    		<input type="submit" value="搜索" class="input-2">
    		</div>
    	</div>
    	<!-- 结束 -->
  	
  	<!-- 我的购物车div -->
    	<div class="buy-che">
    		<div class="buy-che-1">
    			<a href="<c:url value='/SelectUserBuyBookServlet?unickname=${unickName}'/>"><img src="<c:url value='/images/cart.gif'/>"></a>
    		</div>
    		<div class="buy-che-2">
    			<a href="<c:url value='/SelectUserBuyBookServlet?unickname=${unickName}'/>">去购物车结算</a>
    		</div>
    	</div>
    	
    	<c:if test="${userBuycarCount!=0}">
    		<span class="span-buy-gouwu">${userBuycarCount}</span>
    	</c:if>
    	<c:if test="${userBuycarCount==0}">
    		<span class="span-buy-gouwu"></span>
    	</c:if>	
   
  <div class="dov-box-1">
    <img align="top" src="<c:url value='/${booksQueryInfo.imagebig}'/>" class="img_image_w"/>
    <div class="divBookDesc">
	    <ul>
	    	<li style="font-size: 22px;">${booksQueryInfo.bname}</li>
	    	<li>商品编号：${booksQueryInfo.tid}</li>
	    	<li>商品价：<span class="price_n">&yen;${booksQueryInfo.currprice }</span></li>
	    	<li>定价：<span class="spanPrice">&yen;${booksQueryInfo.price }</span>　折扣：<span style="color:#ed145b;">${booksQueryInfo.discount }</span>折</li>
	    </ul>
		<table style="margin-left:8px;">
			<tr>
				<td colspan="3">
					作者：${booksQueryInfo.author} 著
				</td>
			</tr>
			<tr>
				<td colspan="3">
					出版社：${booksQueryInfo.press}
				</td>
			</tr>
			<tr>
				<td colspan="3">出版时间：${booksQueryInfo.publishtime}</td>
			</tr>
			<tr>
				<td>版次：${booksQueryInfo.edition}</td>
				<td>页数：${booksQueryInfo.pagenum}</td>
				<td>字数：${booksQueryInfo.wordnum}</td>
			</tr>
			<tr>
				<td width="180">印刷时间：${booksQueryInfo.printtime}</td>
				<td>开本：${booksQueryInfo.booksize}开</td>
				<td>纸张：${booksQueryInfo.paper}</td>
			</tr>
		</table>
		<div class="divForm">
			<div class="box-mai-buy">
  			<a href="<c:url value='/UserBuyBookServlet?name=${unickName}&bid=${booksQueryInfo.bid}'/>" class="a-buycar-1"><input name="adminbtn" type="button" value="加入购物车" class="gouwuche"></a>
  			<a href="<c:url value='/UserNowBuycarServlet?name=${unickName}&bid=${booksQueryInfo.bid}'/>" class="a-buycar-1"><input type="button" value="立即购买" class="nowbuy" name="buycar"></a>
  			</div>
  			<!-- <a id="btn" href="javascript:$('#form1').submit();"></a> -->
  		</div>
  		 <c:if test="${booksQueryInfo.hlframe==0}">
    		<div style="position:fixed;top:425px;left:1050px;font-size:14px;color:#666">亲~此商品已下架<br/><a href="<c:url value='/jsp/before/shopping-head.jsp'/>" style="color:#ed155b;text-decoration:none;">继续去首页挑选</a></div>
    		<script type="text/javascript">
    			$(function(){
    				var origLength;
					  origLength = document.all.length;
					  for(i=0;i<origLength;i++){
					     if(document.all[i].name != null){
					    	if(document.all[i].name=="like" || document.all[i].name=="adminbtn" || document.all[i].name=="buycar" || document.all[i].name=="buycarname"){
					    		 document.all[i].disabled=true;
					    	 }
					     }
					 }
					 $("[name='like']").css({"background-color":"#ccc","opacity:":"0.3"});
					 $("[name='adminbtn']").css({"background-color":"#ccc","opacity:":"0.3"});
					 $("[name='buycar']").css({"background-color":"#ccc","opacity:":"0.3"});
    			});
    		</script>
    	</c:if>
    	 <c:if test="${booksQueryInfo.hlframe==1}">
    		<div style="position:fixed;top:425px;left:1050px;font-size:14px;color:#666"><a href="<c:url value='/jsp/before/shopping-head.jsp'/>" style="color:#ed155b;text-decoration:none;">去往首页挑选商品</a></div>
    	</c:if>
	</div>
  </div>
  </div>
  </body>
</html>
