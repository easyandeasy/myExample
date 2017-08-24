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
    
    <title>用户购物车</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/before/userbuycarinfo.css'/>">
	

  </head>
  
  <body>
 <div class="box-httbox">
 <c:choose>
	<c:when test="${empty buycarUserBook}">
	<table width="95%" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td align="right">
				<img align="top" src="<c:url value='/images/icon_empty.png'/>"/>
			</td>
			<td>
				<span class="spanEmpty">您的购物车中暂时没有商品</span>
			</td>
		</tr>
	</table>  
	</c:when>
	<c:otherwise>
	<table width="95%" align="center" cellpadding="0" cellspacing="0">
	<tr align="center" bgcolor="#efeae5">
		<td align="left" width="50px">
			<!-- <input type="checkbox" id="selectAll" checked="checked"/><label for="selectAll">全选</label> -->
		</td>
		<td colspan="2">商品名称</td>
		<td>单价</td>
		<td>数量</td>
		<td>小计</td>
		<td>操作</td>
	</tr>
	<c:forEach items="${buycarUserBook}" var="buyCarBook">
	<tr align="center" class="remove${buyCarBook.bid}">
		<td align="left">
			<%-- <input value="${buyCarBook.bname}" type="checkbox" name="checkboxBtn" checked="checked"/> --%>
		</td>
		<td align="left" width="70px">
		 <c:set var="sumPrice" value="${sumPrice+(buyCarBook.price*buyCarBook.numbertity)}"></c:set>
		<a class="linkImage" href="<c:url value='/UserBuyBookServlet?name=${unickName}&bid=${buyCarBook.bid}'/>"><img border="0" width="54" align="top" src="<c:url value='/${buyCarBook.imagesmall}'/>"/></a>
		</td>
		<td align="left" width="400px">
		    <a href="<c:url value='/UserBuyBookServlet?name=${unickName}&bid=${buyCarBook.bid}'/>"><span>${buyCarBook.bname}</span></a>
		</td>
		<td><span>&yen;<span class="currPrice">${buyCarBook.price}</span></span></td>
		<td>
			<%-- <a class="jian" id="${buyCarBook.numbertity}Jian"></a><input class="quantity" readonly="readonly" id="${cartItem.cartItemId }Quantity" type="text" value="${buyCarBook.numbertity}"/><a class="jia" id="${cartItem.cartItemId }Jia"></a> --%>
			<span>${buyCarBook.numbertity}</span>
		</td>
		<td width="100px">
			<span class="price_n">&yen;<span class="subTotal" id="${cartItem.cartItemId }Subtotal">${buyCarBook.price*buyCarBook.numbertity}</span></span>
		</td>
		<td>
			<a class="${buyCarBook.bid}" id="${unickName}" onclick="deleteOrder(this)">删除</a>
			<script type="text/javascript">
				var low ;
				function deleteOrder(e){
					var bid = $(e).attr("class");
					var uid = $(e).attr("id");
					$.get("DeleteUserBuycarServlet?unickName="+uid+"&bid="+bid,"",function(date){
						$(".remove"+bid).remove();
						low = setInterval("up()", 2000);
						 $(".javascripttext").slideDown();
					});
				};
				function up(){
	  				$(".javascripttext").slideUp();
				}
			</script>
		</td>
	</tr>
</c:forEach>	
	<tr>
		<td colspan="4" class="tdBatchDelete">
			<!-- <a href="javascript:batchDelete();">批量删除</a> -->
		</td>
		<td colspan="3" align="right" class="tdTotal">
			<span>总计：</span><span class="price_t">&yen;<span id="total">${sumPrice}</span></span>
		</td>
	</tr>
	<tr>
		<td colspan="7" align="right">
			<a href="javascript:jiesuan();" id="jiesuan" class="jiesuan" ></a>
			<script type="text/javascript">
				function jiesuan(){
					$(".box-httbox").css("display","none");
					$(".box-1-buy-info").css("display","none");
					$(".box-2-buy-info").css("display","block");
				}
			</script>
			
		</td>
	</tr>
</table>
	<form id="jieSuanForm" action="<c:url value='/CartItemServlet'/>" method="post">
		<input type="hidden" name="cartItemIds" id="cartItemIds"/>
		<input type="hidden" name="total" id="hiddenTotal"/>
		<input type="hidden" name="method" value="loadCartItems"/>
	</form>
	</c:otherwise>
</c:choose>
</div>
<div class="javascripttext">删除成功~</div>
  </body>
</html>
