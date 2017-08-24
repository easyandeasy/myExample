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
		div[class ^= "col-lg"]{
			border:1px solid red;
		}
		
	</style>
  </head>
  
  <body style="background:gray;">
    <div class="container" style="background:#fff;">
    
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
    
    
    
    
    
    
    
    <h3 class="page-header text-top">栅格系统--偏移（向左向右偏移）</h3>
    	<div class="row">
    		<div class="col-lg-4">4444</div>
    		<div class="col-lg-8">8888</div>
    	</div>
    	<div class="row">
    		<div class="col-lg-4 col-lg-push-8">4444 向中右偏移了8个</div>
    		<div class="col-lg-8 col-lg-pull-4">8888向左偏移了4个</div>
    	</div>
    
    
    
    
    
    
    
    
    
    
   	<h3 class="page-header text-top">栅格系统</h3>
   <!-- row表示一行，一行共有12个格 ,多余的“列（column）”所在的元素将被作为一个整体另起一行排列。 -->
    <div class="row">
    		<!-- 
    			col-xs-4 :表示超小屏幕手机（<768px）,数字4表示占4个格
    			col-sm-3 :表示小屏幕 平板      (≥768px),数字3表示占3个格
    			col-md-3  ：表示中等屏幕 桌面显示器 (≥992px),数字3表示占3个格
    			col-lg-4 ：表示大屏幕 大桌面显示器 (≥1200px),数字4表示占4个格
    		 -->
    		<div class="col-lg-4 col-sm-3 col-md-3 col-xs-4">删格系统用法
			</div>
    		<div class="col-lg-4 col-sm-3 col-md-3 col-xs-4">删格系统用法
			</div>
    		<div class="col-lg-4 col-sm-3 col-md-3 col-xs-4">删格系统用法
    		</div>
    	</div>
    	
    	
    	<h3 class="page-header text-top">栅格系统--偏移（只能向右偏移）</h3>
    	<div class="row">
    		<div class="col-lg-1">1</div>
    		<div class="col-lg-1">1</div>
    		<div class="col-lg-1">1</div>
    		<div class="col-lg-1">1</div>
    		<div class="col-lg-1">1</div>
    		<div class="col-lg-1">1</div>
    		<div class="col-lg-1">1</div>
    		<div class="col-lg-1">1</div>
    		<div class="col-lg-1">1</div>
    		<div class="col-lg-1">1</div>
    		<div class="col-lg-1">1</div>
    		<div class="col-lg-1">1</div>
    	</div>
    	<div class="row">
    		<div class="col-lg-2">2</div>
    		<!-- 向右偏移5个格 -->
    		<div class="col-lg-2 col-lg-offset-5">前面空出5个格，向右偏移5个格</div>
    	</div>
    	
    	
    	
    	<h3 class="page-header text-top">响应式图片/图片形状/删格系统</h3>
    	<div class="row">
    		<div class="col-xs-4 col-sm-3 col-md-3 col-lg-4">
				<img alt="1.jpg" src="images/1.jpg" class="img-rounde img-responsive"/>
			</div>
    		<div class="col-xs-4 col-sm-3 col-md-3 col-lg-4">
				<img alt="2.jpg" src="images/2.jpg" class="img-circle img-responsive"/>
			</div>
    		<div class="col-xs-4 col-sm-3 col-md-3 col-lg-4">
    			<img alt="3.jpg" src="images/3.jpg" class="img-thumbnail img-responsive"/>
    		</div>
    	</div>

    
    
    
    
    
    
    
    
    
    
    	<h1 class="page-header text-right">产品展示</h1>
    	<h2 class="page-header text-center">新闻<small>内容</small></h2>
    	<h3 class="page-header text-top">英文大小写</h3>
    	<p class="text-uppercase"><!-- 英文大写 -->
    		bootstrap 中文网 联合 又拍云 共同为 bootstrap 专门构建了免费的 CDN 加速服务，访问速度更快、
    		加速效果更明显、没有速度和带宽限制、永久免费。bootCDN 还对大量的前端开源工具库提供了 cdn 加速服务，
    		<del>请进入bootCDN 主页查看更多可用的工具库。</del>
    	</p>
    	<p class="text-lowercase"><!-- 英文小写 -->
    		BOOTSTRAP 中文网 联合 又拍云 共同为 BOOTSTRAP 专门构建了免费的 CDN 加速服务，访问速度更快、 加速效果更明显、没有速度和带宽限制、永久免费。BOOTSTRAP 还对大量的前端开源工具库提供了 CDN 加速服务， 请进入BOOTSTRAP 主页查看更多可用的工具库。
    	</p>
    	<p class="text-capitalize"><!-- 英文首字母大写 -->
    		bootstrap 中文网 联合 又拍云 共同为 bootstrap 专门构建了免费的 CDN 加速服务，访问速度更快、
    		加速效果更明显、没有速度和带宽限制、永久免费。bootcdn 还对大量的前端开源工具库提供了 cdn 加速服务，
    		<del>请进入bootcdn 主页查看更多可用的工具库。</del>
    	</p>
    	<h3 class="page-header text-top">列表</h3>
    	<!-- 
    		 list-unstyled 去掉前面的符号，和去掉原有有格式
    		 list-inline  把li变成横向排列
    		 -->
    	<ul class="list-unstyled list-inline">
    		<li>html</li>
    		<li>css</li>
    		<li>php</li>
    		<li>mysql</li>
    	</ul>
    	<h3 class="page-header text-top">自定义列表</h3>
    	<!-- 
    		 dl-horizontal  把li变成横向排列
    		 -->
    	<dl class="dl-horizontal">
    		<dt>标题</dt>
    		<dd>c标题解释</dd>
    	</dl>
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
