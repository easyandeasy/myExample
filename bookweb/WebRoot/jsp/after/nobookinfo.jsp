<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="../../js/jquery-2.1.4.js"></script>
	<style type="text/css">
			/* 没有数据图片样式 */
	.wu{
		margin-left:120px;
		height:600px;
		width:683px;
		background:url(../../book_img/wu.png) no-repeat 0px -82px;
		border:1px solid #f9f9f9;
		text-align:center;
	}
	a{
		text-decoration:none;
		color:#fff;
		margin-top:180px;
		font-size:25px;
		font-weight:bolder;
		padding:19px 45px 19px 45px;
		border-radius:5px 5px 5px 5px;
		background-color:#2aa8d9;
	}
	a:hover{
		color:blue;
		background-color:#6fba3b;
	}
	.add{
		margin-top:445px;
		margin-left:241px;
		width:200px;
		height:64px;
	}

	</style>
  </head>
  
  <body>
		<div class="wu">
			<div class="add"><a href="../../jsp/after/addbook.jsp" target="mainFrame">添加图书</a></div>
		</div>
  </body>
</html>