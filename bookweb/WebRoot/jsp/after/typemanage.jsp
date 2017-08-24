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
	
	<link rel="stylesheet" href="../../css/after/typemanage.css" type="text/css"></link>
	<script type="text/javascript" src="../../js/jquery-2.1.4.js"></script>
	<script type="text/javascript" src="../../js/after/typemanage.js"></script>
  </head>
  
  <body>
  
  	<div class="typemanagetop">
	  	<div id="find" align="center">类型名称:<input type="text" id="typename" name="typesousuo" onkeyup="findbooktype();"/><input type="button" name="typebtn" value="查找" onclick="findbooktype();"/></div>
	  	<div align="center" id="typebig1">
	  		<div id="typebig">
		  		<li>所属类型:
				<select class="selectone" onchange="findbooktype2();"  name="type1" id="bigtype">
					<option value="0">————请选择————</option>
					<c:forEach var="typeone" items="${booktype }"> 
						<c:if test="${fn:length(typeone.tid) < 3 }"> 
							<option value="${typeone.tid }" >${typeone.tname }</option>
						</c:if>
					</c:forEach>
				</select>
				</li>
				<li class="updatebigtype"><span></span><input type="text" name="updatetext" class="typehiddle"/>&nbsp;&nbsp;<span id="typetext1"></span></li>
				<li>
					<a href="javascript:;" class="addbtn3"><img src="../../book_img/add1.png" onclick="locking()"/></a>
					<a href="javascript:;" class="deletebtn3"><img src="../../book_img/delete1.png" onclick="typeclickbigdelete()"/></a>
					<a href="javascript:;" class="updatebtn3"><img src="../../book_img/update.png" onclick="typeclickupdate2()" /></a>
				</li>
			</div>
		</div>
  		<div id="typetop1" align="center">
		  	<div id="typetop2">
		  	 	<li>类型名称</li>
		  	 	<li>备注</li>
		  	 	<li>操作</li>
		  	 </div>
		 </div>
		 <div id="typeshow1"  align="center">

	    </div>
    </div>

    <div class="txt"></div>
  </body>
</html>
