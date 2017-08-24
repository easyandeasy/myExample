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
	
	<link rel="stylesheet" href="../../css/after/updatemanages.css" type="text/css"></link>
	<script type="text/javascript" src="../../js/jquery-2.1.4.js"></script>
	<script type="text/javascript" src="../../js/after/updatemanages.js"></script>
  </head>
  
  <body>
  	<%-- <c:if test="${admininfos == null }">
  		<c:redirect url="../../SelectAdminInfoServlet?adminindex=1&adminname="></c:redirect>
  	</c:if> --%>
  		<div id="adminbox">
  			<div id="admininfo">
  				<div id="admininfotop">
  					<div id="sousuoright">帐号:<input type="text" value="" name="like" id="selectadminvalue"/><input type="button" name="adminbtn" value="查询"  onclick="selectadminclick()"/></div>
  				</div>
  				
  				<div id="admininfohead">
  					<li>序</li>
  					<li>帐号</li>
  					<li>密码</li>
  					<li>身份证号</li>
  					<li>备注</li>
  					<li>操作</li>
  				</div>
  				
	  			<div class="infosbox">
	  				<c:forEach var="admininfo" items="${admininfos }">
	  					<div class="info${admininfo.adminid }" id="info${admininfo.adminid }">
		  					<input type="text" name="${admininfo.adminid }" id="adminid"  value="${admininfo.adminid }" />
		  					<input type="text" name="${admininfo.adminid }" id="adminname" value="${admininfo.adminname }" />
		  					<input type="text" name="${admininfo.adminid }" id="adminpwd" value="${admininfo.adminpwd }" />
		  					<input type="text" name="${admininfo.adminid }" id="adminidcard" value="${admininfo.adminidcard }" />
		  					<input type="text" name="${admininfo.adminid }" id="admincontext" value="${admininfo.admincontext }" />	
		  					<span id="updatedelete"><a href="javascript:;" class="update11" id="${admininfo.adminid }" onclick="updateclick(this)"><img src="../../book_img/update.png" />修改</a>&nbsp;&nbsp;<a href="javascript:;" id="${admininfo.adminid }" onclick="deleteadminclick(this);"><img src="../../book_img/delete1.png"/>删除</a></span>
		  				</div>
	  				</c:forEach>
  				</div>
  			</div>
  			
  			
  			
  			<!-- 分页 -->
  	<c:if test="${admininfos != null}">
   		<div class="adminpage" align="right">
   			当前页:[${adminpage.now }/${adminpage.count }]&nbsp;&nbsp;
   			<c:if test="${adminpage.now>1 }">
   				<a href="../../SelectAdminInfoServlet?adminname=${adminnamelike}&adminindex=${adminpage.first }" target="mainFrame">首页</a>&nbsp;&nbsp;
   				<a href="../../SelectAdminInfoServlet?adminname=${adminnamelike}&adminindex=${adminpage.back }" target="mainFrame">上一页</a>&nbsp;&nbsp;
   			</c:if>
   			<c:if test="${adminpage.now<adminpage.count }">
   				<a href="../../SelectAdminInfoServlet?adminname=${adminnamelike}&adminindex=${adminpage.next }" target="mainFrame">下一页</a>&nbsp;&nbsp;
   				<a href="../../SelectAdminInfoServlet?adminname=${adminnamelike}&adminindex=${adminpage.last }" target="mainFrame">未页</a>&nbsp;&nbsp;
   			</c:if>
   		</div>
   	</c:if>
   	
   	 <c:if test="${adminempty eq 'empty' }">
   		
   	</c:if>
    	</div>
    	
   
    	
    	<div class="javascripttext"></div>
  </body>
</html>
