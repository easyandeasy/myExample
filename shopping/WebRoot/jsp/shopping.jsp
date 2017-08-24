<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	
  <script type="text/javascript" src="js/jquery-2.1.4.js"></script>
 <!--  <script type="text/javascript"  charset="gb2312" src="js/add.js" ></script> -->
  </head>
  	
  <body>

	 <c:if test="${book==null }" >
	 	<c:redirect url="BookInfoServlet?pageIndex=1" />
	 </c:if>
	 <center class="table1">
	    <table  border="1">
    		<c:forEach items="${book }" var="books" varStatus="status">
	    	<tr>
	    		<th colspan="2"><img src="images/${books.image }" width="100px" height="164px;"/></th>
	    	</tr>
	    	<tr>
	    		<td><font color='gray'>${books.bname }</font></td>
	    		<td>￥：<font color='red'>${books.bprice }</font> 元</td>
	    	</tr>
	    	<tr>
	    		<th colspan="2"><a href="addCarServlet?bid=${status.index}" name="add">加入购物车</a></th>
	    	</tr>
	    	</c:forEach>
	    </table>
	 </center>
	    
    <!-- 分页操作-->
	<center>    
		<c:set var="now" value="${now }" scope="session"/>
	    <p class="page">当前页数：[${now }/${count }]
	   		 <c:if test="${now > 1 }" >
	   		 	<a href="BookInfoServlet?pageIndex=${pages.first}" >首页</a>&nbsp;
	   		 	<a href="BookInfoServlet?pageIndex=${pages.back}">上一页</a>&nbsp;
	   		 </c:if>
	   		  <c:if test="${now < count }" >
	   		 	<a href="BookInfoServlet?pageIndex=${pages.next}">下一页</a>&nbsp;
	   		 	<a href="BookInfoServlet?pageIndex=${pages.last}">末页</a>
	   		 </c:if>
	  		<a  href="jsp/shoppingCar.jsp" class="car">我的购物车</a>
	  	</p>
  	</center>
  </body>
</html>
