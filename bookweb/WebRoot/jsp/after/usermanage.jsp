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
	<link rel="stylesheet" href="../../css/after/usermanage.css" type="text/css"></link>
	<script type="text/javascript" src="../../js/jquery-2.1.4.js"></script>
	<script type="text/javascript" src="../../js/after/usermanage.js"></script>
  </head>
  
  <body>
  	<c:if test="${userstatus == null }">
  		<c:redirect url="../../SelectUserStatusServlet"></c:redirect>
  	</c:if>
  		<div id="userbox">
  			<div id="userinfo">
  				<div id="userinfotop">
  					<div id="sousuoleft">
  						状态:
  						<select name="like" onchange="changestatus(this);">
  							<option value="0">请选择</option>
  							<c:forEach var="sta" items="${userstatus }">
  								<option value="${sta.sid }"  <c:if test="${stas==sta.sid}" >selected="selected"</c:if>>${sta.sname }</option>
  							</c:forEach>
  							
  						</select>
  					</div>
  					<div id="sousuoright">用户名:<input type="text" value="" name="like" id="selectuservalue"/><input type="button" name="userbtn" value="查询"  onclick="selectuserclick();"/></div>
  				</div>
  				
  				<div id="userinfohead">
  					<li>序</li>
  					<li>用户名</li>
  					<li>昵称</li>
  					<li>联系电话</li>
  					<li>身份证号</li>
  					<li>电子邮箱</li>
  					<li>注册时间</li>
  					<li>状态</li>
  					<li>操作</li>
  				</div>
	  			<div class="infosbox">
	  				<c:forEach var="userinfo" items="${userinfos }">
	  					<div class="info${userinfo.uid }" id="info${userinfo.uid }">
		  					<div id="updatedelete"><a href="javascript:;" id="${userinfo.uid }" onclick="updateclick(this)"><img src="../../book_img/update.png" />修改</a>&nbsp;&nbsp;<a href="javascript:;" id="${userinfo.uid }" onclick="deleteuserclick(this);"><img src="../../book_img/delete1.png"/>删除</a></div>
		  					<input type="text" name="${userinfo.uid }" id="uid"  value="${userinfo.uid }" />
		  					<input type="text" name="${userinfo.uid }" id="uname" value="${userinfo.uname }" />
		  					<input type="text" name="${userinfo.uid }" id="unickname" value="${userinfo.unickname }" />
		  					<input type="text" name="${userinfo.uid }" id="uphone" value="${userinfo.uphone }" />
		  					<input type="text" name="${userinfo.uid }" id="uidcard" value="${userinfo.uidcard }" />	
		  					<input type="text" name="${userinfo.uid }" id="email" value="${userinfo.email }" />
		  					<input type="text" name="${userinfo.uid }" id="uindate" value="${userinfo.uindate }" />
		  					<select name="${userinfo.uid }" id="ustatus">
  							<option value="0">请选择</option>
	  							<c:forEach var="sta" items="${userstatus }">
	  								<option value="${sta.sid }" <c:if test="${userinfo.ustatus==sta.sid}" >selected="selected"</c:if>>${sta.sname }</option>
	  							</c:forEach>
  							</select>
		  				</div>
	  				</c:forEach>
  				</div>
  			</div>
    	</div>
    	
    		<c:if test="${userempty eq 'noempty'}">
   		<div class="userpage" align="right">
   			当前页:[${userpage.now }/${userpage.count }]&nbsp;&nbsp;
   			<c:if test="${userpage.now>1 }">
   				<a href="../../SelectUserInfoServlet?username=${username}&userindex=${userpage.first }&statusindex=${stas }" target="mainFrame">首页</a>&nbsp;&nbsp;
   				<a href="../../SelectUserInfoServlet?username=${username}&userindex=${userpage.back }&statusindex=${stas }" target="mainFrame">上一页</a>&nbsp;&nbsp;
   			</c:if>
   			<c:if test="${userpage.now<userpage.count }">
   				<a href="../../SelectUserInfoServlet?username=${username}&userindex=${userpage.next }&statusindex=${stas }" target="mainFrame">下一页</a>&nbsp;&nbsp;
   				<a href="../../SelectUserInfoServlet?username=${username}&userindex=${userpage.last }&statusindex=${stas }" target="mainFrame">未页</a>&nbsp;&nbsp;
   			</c:if>
   		</div>
   	</c:if>
   	
   	 <c:if test="${userempty eq 'empty' }">
   		
   	</c:if>
    	
    	<div class="javascripttext"></div>
  </body>
</html>
