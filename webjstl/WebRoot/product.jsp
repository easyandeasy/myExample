<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'product.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div style="width:600px;">
    	<table border="1" width="80%">
    		<tr>
    			<th>商品名称</th>
    			<th>产地</th>
    			<th>价格</th>
    		</tr>
    		<c:if test="${not empty products }">
	    		<c:forEach var="product" items="${products }" varStatus="status">
		    		<tr <c:if test="${status.index % 2 ==1 }"> style="background-color:rgb(219,241,212);" </c:if>>
		    			<td>${product.name }</td>
		    			<td>${product.area }</td>
		    			<td>${product.price }</td>
		    		</tr>
	    		</c:forEach>
	    	</c:if>	
    	</table>
    </div>
  </body>
</html>
