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
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="pageThree/css/zzsc.css">
<link rel="stylesheet" href="pageThree/css/simplePagination.css">
<script  type="text/javascript" src="pageThree/js/jquery.min.js"></script>
<script  type="text/javascript" src="pageThree/js/jquery.simplePagination.js"></script>
		
</head>
<body style="background:gray;">
	<div class="container" style="background:#f0f0f0;">

		<!-- page3 -->
		<div class="row">
			<div class="col-sm-10 col-sm-offset-1">
				<div class="content">
				  <p class="spacer">"light-theme"</p>
				  <div class="pagination-holder clearfix">
				    <div id="light-pagination" class="pagination">1</div>
				  </div>
				  <p class="spacer">"dark-theme"</p>
				  <div class="pagination-holder black clearfix">
				    <ul id="dark-pagination" class="pagination">
				    </ul>
				  </div>
				  <p class="spacer">"compact-theme"</p>
				  <div class="pagination-holder clearfix">
				    <div id="compact-pagination">3</div>
				  </div>
				</div>
			</div>
		</div>
		
		<script type="text/javascript">
			
			$(function(){
				$('#light-pagination').pagination({
					pages: 20,
					cssStyle: 'light-theme',
					onPageClick: function(pageNo, event) {
						// Callback triggered when a page is clicked
						// Page number is given as an optional parameter
						alert(pageNo);//当前面
					}
				});
				
				
				$('#dark-pagination').pagination({
					pages: 20,
					cssStyle: 'dark-theme',
					displayedPages: 3,
					edges: 3,
					onPageClick: function(pageNo, event) {
						// Callback triggered when a page is clicked
						// Page number is given as an optional parameter
						alert(pageNo);//当前面
					}
				});
				
				
				$('#compact-pagination').pagination({
					pages: 70,
					cssStyle: 'compact-theme',
					displayedPages: 7,
					onPageClick: function(pageNo, event) {
						// Callback triggered when a page is clicked
						// Page number is given as an optional parameter
						alert(pageNo);//当前面
					}
				});
			})
		</script>
	</div>
</body>
</html>
