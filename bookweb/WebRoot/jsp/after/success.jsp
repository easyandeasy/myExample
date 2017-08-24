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
	

  <!-- <link rel="stylesheet" href="css/left.css" type="text/css"></link> -->
  
   <style type="text/css"> 
	
		.imgw{
			vertical-align: middle;
		}
		.success{
			margin:80px 0px 0px 120px;
		}
		a{
			margin-left:8px;
			color:#fff;
			text-decoration:none;
			padding:6px 39px 6px 39px;
			background-image:url(../../book_img/huang_1_btn.jpg);
		}
		a:hover{
			background-image:url(../../book_img/huang_2_btn.jpg);
		}
	</style> 
	<script type="text/javascript" src="../../js/jquery-2.1.4.js"></script>
	  <script type="text/javascript"> 
		
	</script>
  </head>
  
  <body>
	<div class="success">
 	  <img class="imgw" src="../../book_img/duihao.jpg" width="40" height="40"/><font size="5px"> 成功${addbook }图书《${newbook }》</font><br/><br/>
 	  <c:choose>
 	  		<c:when test="${addbook eq '添加' }">
 	  			<a href="addbook.jsp" >继续添加</a>
 	  		</c:when>
 	  		<c:otherwise>
 	  			<a href="welcome.jsp" >搜索图书</a>
 	  		</c:otherwise>
 	  </c:choose>
 	  <a href="../../SelectBookInfoLike?index=1&bname=${newbook }" >查看图书</a>
 	</div>
  </body>
</html>
