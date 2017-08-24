<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/style.css">
  </head>
  
  <body class="topic">
  	<!-- 添加主题 -->
	  	<c:if test="${topicType == null }" >
		 	<c:redirect url="../TitleServlet?topicTypes=add" />
		 </c:if>
  	<div class="addtopicbody">
		<div class="biaoti">${topicType }</div>
		<div class="form">
			<form method="post" action="doAddTopicServlet">
				主题名称：<input type="text" name="tname" /><br/><br/>
				<input type="submit" name="sub" value="提交"/>&nbsp;<input type="reset" name="reset" value="重置" />
			</form>
		</div>
	</div>
  </body>
</html>
