<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<!-- 屏幕和设备的屏幕一致，初始缩放为1:1，禁止用户缩放 -->
<meta name="viewport"
	content="width=device-width,initial-scale=1,user-scalable=no">

<title>My JSP 'index.jsp' starting page</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="easyui/easyui.css">
<link rel="stylesheet" type="text/css" href="easyui/icon.css">
<script type="text/javascript" src="bootstrap/js/jquery.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>

</head>

<body style="background:gray;">



	<div class="container" style="background:#fff;">

		<!-- page1 -->
		<div class="row">
			<div class="col-sm-10 col-sm-offset-1">
				<div id="page"></div>
			</div>
		</div>
		<link rel="stylesheet" href="page1/jquery.page.css">
		<script type="text/javascript" src="page1/jquery.page.js"></script>
		<script type="text/javascript">
			$(function(){
				$("#page").Page({
				  totalPages: 100,//分页总数
				  liNums: 9,//分页的数字按钮数(建议取奇数)
				  activeClass: 'activP', //active 类样式定义
				  callBack : function(page){
						//console.log(page)
						alert(page);//当前页
				  }
			  });
			})
		</script>
		
	</div>
</body>
</html>
