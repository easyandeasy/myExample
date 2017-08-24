<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- http://java.sun.com/jsp/jstl/fmt -->

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'adminmanage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	

	<link rel="stylesheet" href="../../css/after/manages.css" type="text/css"></link>
  
	<script type="text/javascript" src="../../js/jquery-2.1.4.js"></script>
	<script type="text/javascript" src="../../js/after/manages.js"></script>
  </head>
  
  <body onload="adminselect()">
  		<c:if test="${admin==null }">
  			<c:redirect url="../../AdminInfoServlet"/>
  		</c:if>
  		<font size="5" color="#ccc" class="admintoptext">个人信息</font>
	  <form action="javascript:;" method="post" class="adminform" enctype="application/form-data">
		 <table border="0" class="tableadmin">
		 	 <tr>
		  		<td align="right">帐号:</td>
		  		<th><input type="text" value="${admin.adminname }" class="admintext" name="adminname"/></th>
		 	 </tr>
		 	  <tr>
		  		<td align="right">身份证号:</td>
		  		<th><input type="text" value="${admin.adminidcard }"  class="admintext" name="adminidcard"/></th>
		 	 </tr>
		 	  <tr>
		  		<td align="right">备注:</td>
		  		<th><input type="text" name="admincontext" value="${admin.admincontext }" class="textarea" />
		 	 </tr>
		 	  <tr>
		 	  	<td align="right"></td>
		  		<th align="left"><input type="button" class="adminbtn" value="修改" name="adminbtn" onclick="updateadmin(this)"/></th>
		 	 </tr>
		 </table>
	  </form>
	  
	  <div class="adminjavascript"></div>
  </body>
</html>
