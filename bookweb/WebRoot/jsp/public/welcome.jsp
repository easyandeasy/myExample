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
	

	<link rel="stylesheet" href="../../css/after/welcome.css" type="text/css"></link>
  
	<script type="text/javascript" src="../../js/jquery-2.1.4.js"></script>
	<script type="text/javascript" src="../../js/after/welcome.js"></script>
  </head>
  
  <body>
	  <form action="" method="post" enctype="application/form-data">
		  <div class="select">
		  		<input type="text" class="text" value="" onkeyup="find(this);"/><a href="#" class="sousuo" id="sousuo" onclick="sousuoclick(this);">搜索</a>
		  </div>
	 	  <img class="imgw" src="../../book_img/9999.jpg"/>
	 	  <div class="find">
				<!-- <li class="selectli" style=''><a href="#" class="selecta">首钢股份股份的故事风格法国德国法国风格</a></li> -->
	 	  </div>
	  </form>
  </body>
</html>
