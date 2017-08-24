<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'shoppingCar.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	
  	<script type="text/javascript" src="js/jquery-2.1.4.js"></script>
  	<script type="text/javascript" src="js/add.js" ></script>

  </head>
  
  <body>
  <a href="javascript:history.back();">返回</a>
	 <center>
	    	 <h1>我的购物车</h1>
	 </center>
	 <center class="table">
  	
	    <table border="1" width="1100px">
    		<tr>
    			<th>名称</th>
    			<th>价格</th>
    			<th>出版社</th>
    			<th>作者</th>
    			<th>地址</th>
    			<th>编号</th>
    			<th>数量</th>
    			<th>总价格</th>
    			<th>加入购物车</th>
    		</tr>
    		<c:forEach items="${shoplist }" var="books" varStatus="status">
	    	<tr>
	    		<th width="240">${books.bname }<br/><br/><img src="images/${books.image }" width="60px" height="80px;"/></th>
	    		<th>￥：<font color='red'><fmt:formatNumber type="number" value="${books.bprice } " maxFractionDigits="2"/></font> 元</th>
	    		<th><font color='gray'>${books.publishing }</font></th>
	    		<th><font color='gray'>${books.bauthor }</font></th>
	    		<th><font color='gray'>${books.isbn }</font></th>
	    		<th><font color='gray'>${books.district }</font></th>	
	    		<th><font color='gray'>${books.num }</font></th>	
	    		<th><font color='gray'><fmt:formatNumber type="number" value="${books.num*books.bprice } " maxFractionDigits="2"/></font></th>
	    		<th><a href="DelCarServlet?index=${status.index }" >删除</a></th>	
	    		<c:set var="sum" value="${sum+(books.num*books.bprice) }" />
	    	</tr>
	    	</c:forEach>
	    </table>
	 </center>
	   <p class="p">总金额：￥：<font color='red' size='20'><fmt:formatNumber type="number" value="${sum } " maxFractionDigits="2"/></font> 元&nbsp;<input type="submit" value="结算" class="sub"></p>
  </body>
</html>
