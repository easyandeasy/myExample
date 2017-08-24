<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
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
    <s:form action="#">
    	<p>订单号:<s:property value="order.id	"/></p>
    	<p>收货人: <s:property value="order.name"/></p>
    	<p>收货人地址: <s:property value="order.address"/></p><hr style="border:1px #f0f0f0 dashed;"/>
    	<table>
	    	<tr>
	    	<td>名称</td><td style="width:90;text-align:center;">价格(元)</td><td>数量(件)</td>
	    	</tr>
	    	<s:iterator value="#attr.goods" var="g" status="i">
	    		<tr>
		    		<td><s:property value="#g.name"/></td>
					<td style="width:90;text-align:center;"><s:property value="#g.price"/></td>
					<td><s:property value="g.price"/><s:property value="amounts[#i.index]"/></td>
	    		</tr>
	    	</s:iterator>
    	</table>
		总价格:<s:property value="#attr.totalprice"/> 元
    </s:form>
  </body>
</html>
