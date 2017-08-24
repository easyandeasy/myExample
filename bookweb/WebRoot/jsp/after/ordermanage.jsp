<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'logins.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  <link rel="stylesheet" href="../../css/after/ordermanage.css" type="text/css"></link>  
  <script type="text/javascript" src="../../js/jquery-2.1.4.js"></script>
  <script type="text/javascript" src="../../js/after/ordermanage.js"></script>
  </head>
  <!-- 1 未付款，2 未发货，3未收货，4交易成功，5已取消 -->
  <body onload="ordersinfo1()">
  	<c:if test="${orders==null }">
  		<c:redirect url="../../OrderInfoServlet?status=0&orderindex=1"/>
  	</c:if>
    	<div>
    		<div class="ordertopright">订单号:<input type="text" value="${onumber }" id="orderonumbervalue"/><input type="button" value="查询" onclick="orderonumberselect();"/></div>
    		<div class="ordertop">
    			<a href="../../OrderInfoServlet?status=0&orderindex=1" target="mainFrame">全部</a>
    			<a href="../../OrderInfoServlet?status=1&orderindex=1" target="mainFrame">未付款</a>
    			<a href="../../OrderInfoServlet?status=2&orderindex=1" target="mainFrame">未发货</a>
    			<a href="../../OrderInfoServlet?status=3&orderindex=1" target="mainFrame">未收货</a>
    			<a href="../../OrderInfoServlet?status=4&orderindex=1" target="mainFrame">交易成功</a>
    			<a href="../../OrderInfoServlet?status=5&orderindex=1" target="mainFrame">已取消</a>
    		</div>
    	</div>
    	<div class="orderinfotops">
			<li class="orderbnametops">商品</li>
			<li class="pricetops">单价</li>
			<li class="numtops">数量</li>
			<li class="shipricetops">实付款</li>
			<li class="statustops">状态</li>
			<li class="chaozuotops">操作</li>
    	</div>
    	
    	<div class="orders">
    		<c:forEach var="orderss" items="${orders }">
    			<div class="orderinfos">
	   			<div class="ordertop1">&nbsp;&nbsp;${orderss.ordertime }&nbsp;&nbsp;${orderss.onumber }</div>
	    		<div class="orderinfo1">
    				<li class="images" ><img src="../../${orderss.imagesmall }" width="80px" height="80px"/></li>
    				<li class="bnames">${orderss.bname }</li>
    				<li class="price">￥${orderss.bprice }</li>
    				<li class="num">${orderss.num }</li>
    				<li class="shiprice"><e>￥${orderss.total }</e></li>
    				<li class="status">
	    				<c:if test="${orderss.ostatus==1 }">
	    					未付款
	    				</c:if>
	    				<c:if test="${orderss.ostatus==2 }">
	    					未发货
	    				</c:if>
	    				<c:if test="${orderss.ostatus==3 }">
	    					未收货
	    				</c:if>
	    				<c:if test="${orderss.ostatus==4 }">
	    					交易成功
	    				</c:if>
	    				<c:if test="${orderss.ostatus==5 }">
	    					已取消
	    				</c:if></li>
    				<li class="chaozuo"><a href="javascript:;" id="${orderss.onumber }" class="" onclick="ordersinfo(this)">详情</a><br/><br/>
    					<c:if test="${orderss.ostatus==2 }">
    						<input type="button" name="orderbtn" value="发货" onclick="clickgo();"/>
    						<a href="../../OrderStatusServlet?status=${ostatus}&orderindex=${orderpage.now }&onumber=${orderss.onumber }" id="ordergo" target="mainFrame"></a>
    					</c:if>
    				</li>
	    		</div>
	    	</div>	
    		</c:forEach>
    	</div>
    	
    		
   	<c:if test="${isempty eq 'noempty'}">
   		<div class="orderspage" align="right">
   			当前页:[${orderpage.now }/${orderpage.count }]&nbsp;&nbsp;
   			<c:if test="${orderpage.now>1 }">
   				<a href="../../OrderInfoServlet?status=${ostatus}&orderindex=${orderpage.first }&onumber=${onumber }" target="mainFrame">首页</a>&nbsp;&nbsp;
   				<a href="../../OrderInfoServlet?status=${ostatus}&orderindex=${orderpage.back }&onumber=${onumber }" target="mainFrame">上一页</a>&nbsp;&nbsp;
   			</c:if>
   			<c:if test="${orderpage.now<orderpage.count }">
   				<a href="../../OrderInfoServlet?status=${ostatus}&orderindex=${orderpage.next }&onumber=${onumber }" target="mainFrame">下一页</a>&nbsp;&nbsp;
   				<a href="../../OrderInfoServlet?status=${ostatus}&orderindex=${orderpage.last }&onumber=${onumber }" target="mainFrame">未页</a>&nbsp;&nbsp;
   			</c:if>
   		</div>
   	</c:if>
   	
   	 <c:if test="${isempty eq 'empty' }">
   		
   	</c:if>
   	
   	<div class="ordersinfos"></div>
  </body>
</html>
