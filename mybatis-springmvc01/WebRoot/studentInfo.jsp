<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
  	<!-- 屏幕和设备的屏幕一致，初始缩放为1:1，禁止用户缩放 -->
	<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no">
    
    <title>My JSP 'index.jsp' starting page</title>
	
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	<script type="text/javascript" src="bootstrap/js/jquery.min.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	<style type="text/css">
		
	</style>
  </head>
  
  <body style="background:gray;">
    <div class="container" style="background:#fff;">
    
    
     
    <h3 class="page-header text-top">分页</h3>
    
    
    
    	<nav aria-label="...">
    		<ul class="pagination">
    			<li class=""><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
    			 <li class="active"><a href="#">1</a></li>
    			 <li class=""><a href="#">2 </a></li>
    			 <li class=""><a href="#">3 </a></li>
    			 <li class=""><a href="#">4 </a></li>
    			 <li class=""><a href="#">5 </a></li>
    			<li class=""><a href="#" aria-label="Previous"><span aria-hidden="true">&raquo;</span></a></li>
    		</ul>
    	</nav>
    
    
    
    
    
    
    
    
    
    
    <h3 class="page-header text-top">表单</h3>
    <form action="" class="form-horizontal">
    	<div class="form-group form-group-lg">
    		<label for="sname" class="col-sm-2 col-md-2 col-xs-2 control-label">用户名：</label>
	    	<div class="col-sm-3 col-md-3 col-xs-3 ">
	    		<input type="text" name="sname" id="sname" class="form-control" placeholder="手机号或帐号"/>
	    	</div>
    	</div>
    	<div class="form-group form-group-lg">
    		<label for="spwd" class="col-sm-2 col-md-2 col-xs-2 control-label">密&nbsp;&nbsp;&nbsp; 码：</label>
	    	<div class="col-sm-3 col-md-3 col-xs-3">
	    		<input type="password" name="spwd" id="spwd" class="form-control" placeholder="帐号密码"/>
	    	</div>
    	</div>
    	<div class="form-group form-group-lg">
	    	<div class="col-sm-4  col-md-4 col-xs-4 col-sm-offset-1">
	    		<input type="button" name="btn" class="btn btn-info btn-lg btn-block" value="登录"/>
	    	</div>
    	</div>
    </form>
    
    
    
    
    
    	<h3 class="page-header text-top">表格</h3>
    	<!-- 
    		table-bordered:给表格加外边框
    		table-hover：鼠标悬念效果，整行出现效果
    		table-striped:隔行换色
    		table-condensed:行和字体变小
    	 -->
    	 <div class="table-responsive"><!-- 给table的父元素加，以移动设备为优先，如果内容不能完全显示，会出现滚动条 -->
	    	<table class="table table-bordered table-hover table-striped table-condensed">
	    		<tr>
	    			<td>编号</td>
	    			<td>产品名称</td>
	    			<td>状态</td>
	    		</tr>
	    		<tr class="active">
	    			<td>001</td>
	    			<td>aaa</td>
	    			<td>000默认色</td>
	    		</tr>
	    		<tr class="success">
	    			<td>002</td>
	    			<td>bbb</td>
	    			<td>111成功色</td>
	    		</tr>
	    		<tr class="info">
	    			<td>003</td>
	    			<td>ccc</td>
	    			<td>222</td>
	    		</tr>
	    		<tr class="warning">
	    			<td>003</td>
	    			<td>ccc</td>
	    			<td>222</td>
	    		</tr>
	    		<tr class="danger">
	    			<td>004</td>
	    			<td>ddd</td>
	    			<td>333</td>
	    		</tr>
	    	</table>
    	</div>
    </div>
  </body>
</html>
