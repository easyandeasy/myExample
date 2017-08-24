<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'logins.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
body{font-size:14px;}
ul{margin:0; padding:0; list-style:none;}
a{text-decoration:none; color:#000;}

#wrap{position:relative; top:0px;width:876px; height:34px; line-height:34px; margin:0 auto;}
ul#menu li{float:left; display:block; width:146px; height:34px; text-align:center;}
ul#menu li a:link,ul#menu li a:visited{display:block; background:url(link.gif) no-repeat;}
ul#menu li a:hover{background:url(hover.gif) no-repeat;}
/*子菜单*/
ul#menu li ul{position:absolute; top:35px; width:500px; display:none;}
ul#menu li ul.sub_menu_2{left:130px;}
ul#menu li ul.sub_menu_4{left:325px;}
ul#menu li ul li{font-size:12px; width:70px; height:25px; display:block;}
ul#menu li ul li a:link,ul#menu li ul li a:visited{color:#666; background:none; display:inline;}
</style>
<script type="text/javascript" src="js/jquery-2.1.4.js"></script>
<script type="text/javascript" language="javascript">
/* $(function(){
// var _over = $("ul#menu>li");
$("ul#menu>li:has(ul)").hover(
function(){
$(this).children().fadeIn(400);
},
function(){
$(this).children.fadeOut();
}
);
}); */

$(function(){
 $("ul#menu>li:has(ul)").hover( 
  function(){ 
   $(this).find('ul').fadeIn(400);
  },
  function(){
   $(this).find('ul').fadeOut(400);
  });
 });
</script>
</head>

	<body>
	<div id="wrap">
		<ul id="menu">
			<li><a href="#" >凯撒首页</a></li>
			<li><a href="#" >最新动态页</a>
				<ul class="sub_menu_2">
					<li><a href="#">聚焦凯撒</a> | </li>
					<li><a href="#">聚焦凯撒</a> | </li>
					<li><a href="#">聚焦凯撒</a></li>
				</ul>
			</li>
			<li><a href="#" >产品及预定中心页</a></li>
			<li><a href="#" >帮助及查询中心页</a>
				<ul class="sub_menu_4">
					<li><a href="#">聚焦凯撒</a> | </li>
					<li><a href="#">聚焦凯撒</a> | </li>
					<li><a href="#">聚焦凯撒</a> | </li>
					<li><a href="#">聚焦凯撒</a> | </li>
					<li><a href="#">聚焦凯撒</a> | </li>
					<li><a href="#">聚焦凯撒</a></li>
				</ul>
			</li>
			<li><a href="#" >会员俱乐部页</a></li>
			<li><a href="#" >凯撒论坛页</a></li>
		</ul>
	</div>
  </body>
</html>
