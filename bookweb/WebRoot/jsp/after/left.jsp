<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- http://java.sun.com/jsp/jstl/fmt -->

  	<div class="lefttype"></div>





 <%-- <c:forEach var="book" items="${booktype }" varStatus="status">
    	<c:if test="${book.tid.length() == 1 }">
    		<li class="typeli" id="li${status.index }">
    			<a class="img" id="img${status.index }"><img src="book_img/right6.png"/></a>${book.tname }
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
     --%>
