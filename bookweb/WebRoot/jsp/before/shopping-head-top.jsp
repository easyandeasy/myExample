<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
  <!-- 最大盒子 -->
    <div class="box-1">
    	
    	<!-- 鼠标悬浮在个人中心上出现该div -->
    	
    	<!-- <span class="span-user"></span>
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
    	</div> -->
    	<!--鼠标悬浮在个人中心上出现该div 结束 -->
    	
    	<!-- 搜索框 -->
    	<div class="center">
    		<div class="box-3">
    		<input type="text" placeholder="请输入关键字" class="input-1">
    		<input type="button" value="搜索" class="input-2">
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
    	
    	<c:if test="${empty userSession&&empty userBuycarCount}">
    		<span class="span-buy-gouwu"></span>
    	</c:if>
    	
    	<c:if test="${!empty userSession&&!empty userBuycarCount}">
    		<c:if test="${userBuycarCount==0}">
    			<span class="span-buy-gouwu"></span>
    		</c:if>
    		<c:if test="${userBuycarCount!=0}">
    			<span class="span-buy-gouwu">${userBuycarCount}</span>
    		</c:if>
    	</c:if>
    	
    	<jsp:include page="/jsp/before/shopping-center-top.jsp" flush="true"></jsp:include>
    	
    	<div>
    	
    	<!-- 特价商品div两个 -->
    	<div class="box-4">
    		<div class="box-tejia-1">
    			<span class="span-tejia-1">今日促销</span>
    			<span class="span-tejia-3">程序员必备精品</span>
    			<div class="box-tejia-3" align="center">
    				<a href="javascript:;">BUY NOW</a>
    			</div>
    			<a href="<c:url value='/BookPassIDqueryInfoServlet?name=${bookListSend10.bid}'/>">
    			<img src="<c:url value='/${bookListSend10.imagesmall}'/>" class="img-2"></a>
    			<a href="<c:url value='/BookPassIDqueryInfoServlet?name=${bookListSend11.bid}'/>">
    			<img src="<c:url value='/${bookListSend11.imagesmall}'/>" class="img-3"></a>
    		</div>
    		<div class="box-tejia-2">
    			<span class="span-tejia-1">精品推荐</span>
    			<span class="span-tejia-3">从菜鸟到大神必备</span>
    			<div class="box-tejia-3" align="center">
    				<a href="javascript:;">BUY NOW</a>
    			</div>
    			<a href="<c:url value='/BookPassIDqueryInfoServlet?name=${bookListSend12.bid}'/>" class="img-a">
    			<img src="<c:url value='/${bookListSend12.imagesmall}'/>" class="img-2"></a>
    			<a href="<c:url value='/BookPassIDqueryInfoServlet?name=${bookListSend13.bid}'/>" class="img-a">
    			<img src="<c:url value='/${bookListSend13.imagesmall}'/>" class="img-3"></a>
    		</div>
    	</div>
    	<!-- 结束 -->
    </div>
   </div>