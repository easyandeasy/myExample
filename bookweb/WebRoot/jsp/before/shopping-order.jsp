<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>书籍分类</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="js/jquery-2.1.4.js"></script>
  	<link rel="stylesheet" type="text/css" href="<c:url value='/css/before/shopping-head-top.css'/>">
  	<script type="text/javascript" src="<c:url value='/js/before/shopping-head-top.js'/>"></script>
  	<link rel="stylesheet" type="text/css" href="<c:url value='css/before/shopping-order.css'/>">

  </head>
  
  <body>

   <div style="border:solid 0px red">
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
	    		<a href="<c:url value='/SelectUserBuyBookServlet?unickname=${unickName}'/>" class="a-2"><span>个人中心</span></a>
	    		<a href="<c:url value='/jsp/before/login.jsp'/>" class="a-1"><span>退出</span></a>
	    		<c:set var="userSession" value=""></c:set>
    		</c:otherwise>
    		</c:choose>
    	</div>
    	
    	<!-- 鼠标悬浮在个人中心上出现该div -->
    	<!-- <div>
    	<span class="span-user"></span>
    	<div class="box-user-1">
    		<div class="box-user-2">
    			<a href="#">个人信息</a>
    		</div>
    		<div class="box-user-3">
    			<a href="#">我的购物车</a>
    		</div>
    		<div class="box-user-4">
    			<a href="#">修改密码</a>
    		</div>
    	</div>
    	</div> -->
    	<!--鼠标悬浮在个人中心上出现该div 结束 -->
    	
    	<!-- 搜索框 -->
    	<div class="center">
    		<div class="box-3">
    		<input type="text" placeholder="请输入关键字" class="input-1">
    		<input type="button" value="搜索" class="input-2">
    		</div>
    	</div>
    	
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
    	
    </div>
    <div class="box-top">
    <div class="box-top-1">	
    <c:forEach var="books" items="${bookAll}" varStatus="status">
			<div class="bookinfo" id="bookinfo${status.index }">	
				<table border="0" id="tb${status.index }">
		 			<tr>
		 				<th colspan="3"><a href="<c:url value='/BookPassIDqueryInfoServlet?name=${books.bid}'/>" target="_blank">
		 				<img src="${books.imagebig }" width="200" height="200"/></a></th>
		  			</tr>
		  			<tr>
		  				<th><font color="red">￥:${books.currprice }</font></th>
		  				<th><font color="gray">定价:<s>${books.price }</s></font></th>
		  				<th><font color="green">(${books.discount }折)</font></th>
		  			</tr>
		  			<tr>
		  				<th colspan="3">
			   			<c:choose>
			   				<c:when test="${fn:length(books.bname)>10}">
			   					<a href="#" title="${books.bname }">${fn:substring(books.bname,0,10) }..</a>
			   				</c:when>
			   				<c:otherwise>
			   					<a href="#" title="${books.bname }">${books.bname }</a>
			   				</c:otherwise>
			   			</c:choose>
		  				</th>
		  			</tr>
		  		</table>
		  		<div class="box-top-4">
	    			<a href="<c:url value='/BuycarUserOrderServlet?name=${unickName}&bid=${books.bid}'/>"><input type="button" value="加入购物车"></a>
	    			<a href="javascript:;"><input type="button" value="加入收藏"></a>
	    		</div>
			</div>
	</c:forEach>
    	</div>
    </div>
    <div>
    	<a href="<c:url value='/BookSelectAllServlet?pageindex=${pages.first}'/>" class="a-order-1">首页</a>
		<c:if test="${pages.now>1}">
		<a href="<c:url value='/BookSelectAllServlet?pageindex=${pages.now-1}'/>" class="a-order">上一页</a>
		</c:if>
		<c:if test="${pages.now<pages.count}">
		<a href="<c:url value='/BookSelectAllServlet?pageindex=${pages.now+1}'/>" class="a-order">下一页</a>
		</c:if>
		<a href="<c:url value='/BookSelectAllServlet?pageindex=${pages.last}'/>" class="a-order">尾页</a>
		<span class="a-order">当前页[${pages.now}/${pages.count}]&nbsp;&nbsp;&nbsp;共[${pages.count}]页</span>
    </div>
  </body>
</html>
