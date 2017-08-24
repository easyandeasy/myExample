<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ognl.jsp' starting page</title>
    
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
     <%--  <s:iterator value="#{'china':'中国','usa':'美国','e':'俄国'}" var="c">
		<s:property value="#c.key"/>--<s:property value="#c.value"/><br/>
	 </s:iterator>
     
     
    <s:iterator value="#{'123':'321','456':'654','789':'987' }" var="obj">
    	<s:property value="#obj.key"/>--------<s:property value="#obj.value"/><br/>
    </s:iterator> --%>123
  </body>
</html>
