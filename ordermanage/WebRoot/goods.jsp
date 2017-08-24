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
    <h1><s:text name="商品展示"></s:text></h1>
    
    <s:form action="order_preOrder">
    	<s:iterator value="#attr.goods" var="good">
	    	<s:property value="#good.name"/>&nbsp;&nbsp;&nbsp;&nbsp;选购<input type="checkbox" name="gids" value="${good.id}"/><br/><hr style="border:1px #f0f0f0 dashed;"/>
	    	厂商:<s:property value="#good.manufcturer"/><br/>
	    	价格:<s:property value="#good.price"/> 元<br/>
	    	<s:property value="#good.specification"/><br/><hr/><br/>
    	</s:iterator>
    	<s:submit value="订购"/>
    </s:form>
  </body>
</html>
