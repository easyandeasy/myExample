<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户中心</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="<c:url value='/css/before/usercenter.css'/>">
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/before/shopping-head-top.css'/>">
	<script src="<c:url value='/js/before/prefixfree.min.js'/>"></script>
	<script src="<c:url value='/js/before/jquery-1.11.0.min.js'/>" type="text/javascript"></script>
	<script type="text/javascript" src="<c:url value='/js/before/jquery-tab.js'/>"></script>
	<script src="<c:url value='/js/before/usercenter.js'/>" type="text/javascript"></script>
	
	<script type="text/javascript">
		$(function(){
			$('.tab-group').tabify();
		});
	</script>
  </head>
  
  <body>
    <c:if test="${bookListSend0 == null}">
  		<c:redirect url="/BookSendServlet"/>
  	</c:if>
  	<div class="box-2">
  	<span class="span-1">欢迎您，${unickName}</span>
	    <a href="<c:url value='/jsp/before/login.jsp'/>" class="a-1"><span>退出</span></a>
	<c:set var="userSession" value=""></c:set>
	<a href="<c:url value='/BuycarCountServlet'/>" class="a-buy-stt">返回首页</a>
	</div>
	
</head>
<body>
	<div class="htmleaf-container">
		<div class="container">
		  <div class="tab-group">
			<section id="tab1" title="我的购物车">
				<div class="box-1-buy-info">
					<jsp:include page="/jsp/before/userbuycarinfo.jsp" flush="true"/>
				</div>
				<div class="box-2-buy-info" style="display:none;height:475px;">
						<c:choose>
							<c:when test="${empty buycarUserBook}"></c:when>
							<c:otherwise>
								<table width="95%" align="center" cellpadding="0" cellspacing="0">
									<tr bgcolor="#efeae5">
									<td width="400px" colspan="5"><span style="font-weight: 900;">生成订单</span></td>
									</tr>
									<tr align="center">
									<td width="10%">&nbsp;</td>
									<td width="50%">图书名称</td>
									<td>单价</td>
									<td>数量</td>
									<td>小计</td>
								</tr>
								<c:forEach items="${buycarUserBook}" var="buyCarBook">
								<tr align="center">
								<td align="right">
								<a class="linkImage" href="#"><img border="0" width="54" align="top" src="<c:url value='/${buyCarBook.imagesmall}'/>"/></a>
								</td>
								<td align="left">
								<a href="#"><span>${buyCarBook.bname}</span></a>
								</td>
								<td>&yen;${buyCarBook.price}</td>
								<td>${buyCarBook.numbertity}</td>
								<td>
								<c:set var="sumPrice1" value="${sumPrice1+(buyCarBook.price*buyCarBook.numbertity)}"></c:set>
								<span class="price_n">&yen;<span class="subtotal">${buyCarBook.price*buyCarBook.numbertity}</span></span>
								</td>
								</tr>
								</c:forEach>
								<tr>
									<td colspan="6" align="right">
										<span>总计：</span><span class="price_t">&yen;<span id="total">${sumPrice1}</span></span>
									</td>
								</tr>
								<tr>
									<td colspan="5" bgcolor="#efeae5"><span style="font-weight: 900">收货地址&nbsp;&nbsp;&nbsp;&nbsp;温馨提示>请务必填写真实地址</span></td>
								</tr>
								<tr>
								
									<td colspan="6">
										<span>请输入您的收获地址:&nbsp;&nbsp;</span><input type="text" placeholder="请填写您的收获地址" id="address" style="border:solid 1px #e5e5e5;width:550px;height:35px;font-size:15px;padding-left:5px;">
										<span id="errorAddressNull" style="color:red;font-size:16px;display:none">123</span>
									</td>
								</tr>
								<tr>
								<%
									session.setAttribute("order",request.getAttribute("buycarUserBook"));
								 %>
									<td style="border-top-width: 4px;" colspan="5" align="right">
										<a id="${unickName}" class="${sumPrice1}" onclick="ajaxOrder(this)" style="text-decoration:none;cursor:pointer;">
										<input type="button" value="提交订单" onclick="errorAddress()" style="border:solid 0px #62B0FF;background:#62B0FF;color:#fff;width:150px;height:35px;border-radius:5px;font-size:16px;cursor:pointer;"></a>
									</td>
								</tr>
							</table>
						</c:otherwise>
					</c:choose>
				</div>
				<div class="top-box-3" style="display:none;">
					<div class="div1">
					<span class="span1">订单已生成</span>
					</div>
					<div class="div2">
					<img src="<c:url value='/images/duihao.jpg'/>" class="img"/>
					<dl>
						<dt>订单编号</dt>
						<dd class="orderid"></dd>
						<dt>合计金额</dt>
						<dd style="font-size:24px;color:red">￥：<span id="money" class="price_t">&yen;</span></dd>
						<dt>收货地址</dt>
						<dd class="address"></dd>
					</dl>
					<span>网上书城感谢您的支持，祝您购物愉快！</span>
				</div>
				</div>
			</section>
			<a onclick="orderInfo()" class="${unickName}"><section id="tab2" title="我的订单"></a>
			 	<div class="box-httbox">
			 		<jsp:include page="/jsp/before/orderlis.jsp" flush="true"></jsp:include>
			 	</div>
			</section>
			<!-- <section id="tab3" title="交易记录">
			 	<div class="box-httbox">
			 		<span>这是交易记录</span>
			 	</div>
			</section>
			<section id="tab4" title="个人信息">
			  <div class="box-httbox">
			  		<span>这是个人信息</span>
			 </div>
			</section>
			<section id="tab5" title="订单查询">
			  <div class="box-httbox">
			  		<span>订单查询</span>
			 </div>
			</section>
			<section id="tab6" title="我的收藏">
			  <div class="box-httbox">
			  		<span>我的收藏</span>
			 </div>
			</section>
			<section id="tab7" title="修改密码">
			  <div class="box-httbox">
			  		<span>修改密码</span>
			 </div>
			</section> -->
		  </div>
		</div>
	</div>
</body>
</html>
