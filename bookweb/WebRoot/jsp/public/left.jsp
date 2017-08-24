<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- http://java.sun.com/jsp/jstl/fmt -->

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'adminmanage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	

  <link rel="stylesheet" href="css/after/left.css" type="text/css"></link>
  <script type="text/javascript" src="js/jquery-2.1.4.js"></script>
  <script type="text/javascript" src="js/public/left.js"></script>

  </head>
  
  <body class="left">
    <c:if test="${booktype == null }" >
    	<c:redirect url="../../BookTypeServlet" />
    </c:if>
    
    <c:forEach var="book" items="${booktype }" varStatus="status">
    	<c:if test="${book.tid.length() == 1 }">
    		<li class="li" id="li${status.index }">
    			<a class="img" id="img${status.index }"><img src="book_img/right6.png"></a></img>${book.tname }
    		</li>
  	
	    	<div class="two" id="two${status.index }" >
		    	<c:forEach var="type" items="${booktype }"  varStatus="sta">
		    		<c:if test="${type.pid == book.tid }">
		    			<li class="twotype" id="${sta.index }">
			   				<a id="one${sta.index }" href="BookServlet?tid=${type.tid }&pageindex=1" target="mainFrame">${fn:substring(type.tname,0,15) }</a>
		    			</li>
		    		</c:if>
		    	</c:forEach>
	    	</div>
    	</c:if>
    </c:forEach>
    
   
   <a href="jsp/public/welcome.jsp" id="welcome" target="mainFrame"></a>
  </body>
</html>
