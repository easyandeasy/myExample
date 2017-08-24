<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'showbookinfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
 	<link rel="stylesheet" href="../../css/after/showbookinfo.css" type="text/css"></link>
 	
  	<script type="text/javascript" src="../../js/jquery-2.1.4.js"></script>
  	<script type="text/javascript" src="../../js/public/showbookinfo.js"></script>
  </head>
  
  <body>
  	<div class="boxi">
		<c:forEach var="books" items="${selectbookinfolike }" varStatus="status">
			<div class="bookinfo" id="bookinfo${status.index }">	
				<table border="0" id="tb${status.index }">
		 			<tr>
		 				<th colspan="3"><a href="../../UpdateBookInfoServlet?bid=${books.bid }" title="${books.bname }"><img src="../../${books.imagebig }" width="200" height="200"/></a></th>
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
			   					<a href="../../UpdateBookInfoServlet?bid=${books.bid }" title="${books.bname }">${fn:substring(books.bname,0,10) }..</a>
			   				</c:when>
			   				<c:otherwise>
			   					<a href="../../UpdateBookInfoServlet?bid=${books.bid }" title="${books.bname }">${books.bname }</a>
			   				</c:otherwise>
			   			</c:choose>
		  				</th>
		  			</tr>
		  		</table>
			</div>
		</c:forEach>
	</div>
   	
   	
   <%-- 	<c:if test="${str eq 'length'}">
   		<div class="page">
   			当前页:[${pages.now }/${pages.count }]&nbsp;&nbsp;
   			<c:if test="${pages.now>1 }">
   				<a href="BookServlet?pageindex=${pages.first }&tid=${tid}" target="mainFrame">首页${pages.first }</a>&nbsp;&nbsp;
   				<a href="BookServlet?pageindex=${pages.back }&tid=${tid}" target="mainFrame">上一页${pages.back }</a>&nbsp;&nbsp;
   			</c:if>
   			<c:if test="${pages.now<pages.count }">
   				<a href="BookServlet?pageindex=${pages.next }&tid=${tid}" target="mainFrame">下一页${pages.next }</a>&nbsp;&nbsp;
   				<a href="BookServlet?pageindex=${pages.last }&tid=${tid}" target="mainFrame">未页${pages.last }</a>&nbsp;&nbsp;
   			</c:if>
   		</div>
   	</c:if> --%>
   	
   	 <c:if test="${str eq 'null' }">
   		
   	</c:if>
  </body>
</html>
