<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" href="jqueryui/themes/base/jquery.ui.all.css" type="text/css"></link>
    <link rel="stylesheet" href="jqueryui/demos.css" type="text/css"></link>
    <script type="text/javascript" src="jqueryui/jquery-2.1.4.js"></script>
    <script type="text/javascript" src="jqueryui/ui/jquery.ui.dialog.js"></script>
    <script type="text/javascript" src="jqueryui/myjs.js"></script>
    <script type="text/javascript" src="jqueryui/ui/jquery.ui.core.js"></script>
    <script type="text/javascript" src="jqueryui/ui/jquery.ui.tabs.js"></script>
    <script type="text/javascript" src="jqueryui/ui/jquery.ui.widget.js"></script>
  </head>
  
  <body>
   <%
   		String result = "Ajax load content :test";
   		out.print(result);
    %>
  </body>
</html>
