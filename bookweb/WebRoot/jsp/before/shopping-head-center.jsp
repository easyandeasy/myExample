<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<link rel="stylesheet" type="text/css" href="<c:url value='/css/before/shopping-head-center.css'/>">
  			<!-- 新书 div -->
  
  	<div class="bos-sum">
  	   
    	
		<c:if test="${shoppingbooks==null }">
			<c:redirect url="../../BookSendServlet"/>
		</c:if>
		
		<c:forEach var="shbooks" items="${shoppingbooks }" varStatus="sta">
			<c:if test="${shbooks.imagesmall6!=null }">
				<!-- 包含8个小盒子的父类div -->  		
	    	<div class="box-xinpin-1">
	    	
	    		<!-- 新书上市div -->
	    		<div class="box-xinpin-2">${shbooks.selectone }
	    		<a href="<c:url value='/BookSelectAllServlet?tid=${shbooks.tid }&uname=${unickName}'/>" class="chengxu-box" target="_blank">更多</a></div>
	    		
	    		<!-- 结束 -->
	    		
	    		<!-- 包含左边三个小盒子的父类div -->
	    		<div class="box-xinpin-sum">
	    		
	    		<div class="box-xinpin-3">
	    			<a href="<c:url value='/BookPassIDqueryInfoServlet?name=${shbooks.bid1}'/>">
	    			<img src="<c:url value='${shbooks.imagesmall1}'/>" class="img-top-1"></a>
	    			<div class="div-book-1">
	    				
	    			</div>
	    		</div>
	    		
	    		<div class="box-xinpin-4">
	    			<a href="<c:url value='/BookPassIDqueryInfoServlet?name=${shbooks.bid2}'/>">
	    			<img src="<c:url value='${shbooks.imagesmall2}'/>" class="img-top-1"></a>
	    			<div class="div-book-1">
	    			</div>
	    		</div>
	    		
	    		<div class="box-xinpin-5">
	    			<a href="javascript:;"><img src="<c:url value='22606835-1div_02.jpg'/>" class="biv-img-box"></a>
	    		</div>
	    		</div>
	    		<!--包含左边三个小盒子的父类div  结束 -->
	    		
	    		<!-- 包含右侧4个小盒子的div父类 -->
	    		<div class="box-xinpin-fulei">
	    			<div class="box-xinpin-6">
	    				<a href="<c:url value='/BookPassIDqueryInfoServlet?name=${shbooks.bid3}'/>">
	    				<img src="<c:url value='${shbooks.imagesmall3}' />" class="img-xinpin-box"></a>
	    				<div>
	    				</div>
	    			</div>
	    			
	    			<div class="box-xinpin-7">
	    				<a href="<c:url value='/BookPassIDqueryInfoServlet?name=${shbooks.bid4}'/>">
	    				<img src="<c:url value='${shbooks.imagesmall4}'/>" class="img-xinpin-box"></a>
	    			</div>
	    			
	    			<div class="box-xinpin-8">
	    				<a href="<c:url value='/BookPassIDqueryInfoServlet?name=${shbooks.bid5}'/>">
	    				<img src="<c:url value='${shbooks.imagesmall5}'/>" class="img-xinpin-box"></a>
	    			</div>
	    			
	    			<div class="box-xinpin-9">
	    				<a href="<c:url value='/BookPassIDqueryInfoServlet?name=${shbooks.bid6}'/>">
	    				<img src="<c:url value='${shbooks.imagesmall6}'/>" class="img-xinpin-box"></a>
	    			</div>
	    		</div>
	    		<!--包含右侧4个小盒子的div父类  结束 -->
	    	</div>
	    	<!-- 包含8个小盒子的div结束 -->
		
			</c:if>
		</c:forEach>
   </div>