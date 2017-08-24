<%@page import="com.jdbc.entity.Users"%>
<%@page import="com.jdbc.serviceImpl.UserServiceImpl"%>
<%@page import="com.jdbc.service.IUserService"%>
<%@page import="com.jdbc.entity.Topic"%>
<%@page import="com.jdbc.entity.News"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<base href="<%=basePath%>">
	
	<title>首页</title>
	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/style.css">
	
	
	</head>

	<body>
		<div class="head">
			<div class="login">
				<form action="doLoginServlet" method="post">
					登录名 <input type="text" name="userName" maxlength="16" class="text" />
					&nbsp;密&nbsp;码 <input type="password" name="pwd" maxlength="16" class="pwd" /> 
					&nbsp;<input type="submit" name="submit" value="登录" class="sub" />
					&nbsp;<a href="register.jsp" >注册</a>
				</form>
			</div>
			
			<div class="img">
				<img src="images/logo.jpg" /><img src="images/a_b01.gif" height="77px" width="871px" />
			</div>
	
			<div class="midden">
				<c:if test="${(list1 ==null && list2 == null && list3 == null) && (list == null || lists == null) }">
					<c:redirect url="../NewsControl?opr=listTitle" />
				</c:if>
			</div>
			
			<div class="right">
				<%@ include file="index.html"%>
			</div>
			
			
			<div>
				<%@ include file="index_sedebar.jsp"%>
			</div>
		</div>
	</body>
</html>













<%-- 
				<%
					List<News> list1 = (List<News>) session.getAttribute("list1");
					List<News> list2 = (List<News>) session.getAttribute("list2");
					List<News> list3 = (List<News>) session.getAttribute("list3");
					List<Topic> list = (List<Topic>) session.getAttribute("list");
					List<News> lists = (List<News>) session.getAttribute("lists");
					//out.print(lists.size()+"456");
					if () {
						/* out.print("123"); */
						response.sendRedirect("../NewsControl?opr=listTitle");
						return;
					} else {
				%> --%>
				<%-- <%
					}
				%> --%>
			<%-- <%
				if (list1 == null && list2 == null && list3 == null) {
					/* out.print("123"); */
					response.sendRedirect("../NewsControl?opr=listTitle");
					return;
				} else {
			%> --%>
			
		
			<%-- <%
				}
			%> --%>


<!-- <div class="right-head">
					<img src="images/class_type.gif" class="rightimg" />
				</div>
				<div class="text-head">
					<div class="text-head-one">
						<a href="#">国内</a><a href="#">国际</a> <a href="#">军事</a><a href="#">体育</a>
						<a href="#">娱乐</a><a href="#">社会</a> <a href="#">财经</a><a href="#">科技</a>
						<a href="#">健康</a><a href="#">汽车</a> <a href="#">教育</a>
					</div>
					<div class="text-head-two">
						<a href="#">房产</a><a href="#">家居</a> <a href="#">旅游</a><a href="#">文化</a>
						<a href="#">其他</a>
					</div>
				</div> -->


<!-- <div class="text1">
     					<li><span class="time">2013-06-06 01:03:51.0</span><a href="#" class="text">驾驶证逾期未换证公告</a></li>
     					<li><span class="time">2013-06-06 01:03:51.0</span><a href="#" class="text">逾期提交身体条件证明公告</a></li>
     					<li><span class="time">2013-06-06 01:03:51.0</span><a href="#" class="text">机动车临界强制报废公告</a></li>
     					<li><span class="time">2013-06-06 01:03:51.0</span><a href="#" class="text">驾驶证停止使用公告</a></li>
     					<li><span class="time">2013-06-06 01:03:51.0</span><a href="#" class="text">校车驾驶资格作废公告</a></li>
     			</div>
     			
     			<div class="text2">
     					<li><span class="time">2013-06-06 01:03:51.0</span><a href="#" class="text">机动车号牌未收回作废公</a></li>
     					<li><span class="time">2013-06-06 01:03:51.0</span><a href="#" class="text">机动车强制报废公告</a></li>
     					<li><span class="time">2013-06-06 01:03:51.0</span><a href="#" class="text">机动车逾期未检验公告</a></li>
     					<li><span class="time">2013-06-06 01:03:51.0</span><a href="#" class="text">机动车临界强制报废公告</a></li>
     					<li><span class="time">2013-06-06 01:03:51.0</span><a href="#" class="text">机动车行驶证未收回作废公告</a></li>
     			</div>
     			
     			<div class="text3">
     					<li><span class="time">2013-06-06 01:03:51.0</span><a href="#" class="text">驾驶证逾期未换证公告</a></li>
     					<li><span class="time">2013-06-06 01:03:51.0</span><a href="#" class="text">机动车号牌未收回作废公告</a></li>
     					<li><span class="time">2013-06-06 01:03:51.0</span><a href="#" class="text">1机动车号牌未收回作废公告</a></li>
     					<li><span class="time">2013-06-06 01:03:51.0</span><a href="#" class="text">2机动车号牌未收回作废公告</a></li>
     					<li><span class="time">2013-06-06 01:03:51.0</span><a href="#" class="text">3机动车号牌未收回作废公告</a></li>
     			</div> -->




<!-- <div class="left">
     			<img src="images/title_1.gif" />
     			<div><a href="#" title="景区，如何不再依靠门票收入">景区，如何不再依靠门票</a></div>
     			<div><a href="#" title="高考期间中东地区将现大范围降雨">高考期间中东地区将....</a></div>
     			<div><a href="#" title="山西离柳焦煤集团并下人行车发生事故6人死亡">山西离柳焦煤集团并....</a></div>
     			<div><a href="#" title="公司股东共 本奋斗故事告诉过">公司股东共 本奋斗故...</a></div>
     			<div><a href="#" title="跟师傅过富贵人行车发生豆腐干是个">跟师傅过富贵人行车....</a></div>
     			<div><a href="#" title="但发发嗲发发按分发都发广告">但发发嗲发发按分....</a></div>
     			<div><a href="#" title="更好的公司发电股份的感受到">更好的公司发电股份....</a></div>
     			<div><a href="#" title="山西离柳焦煤集团并下人行车发生事故6人死亡">山西离柳焦煤集团并....</a></div>
     		</div>
     		
     		<div class="left1">
     			<img src="images/title_2.gif" />
     			<div><a href="#" title="景区，如何不再依靠门票收入">景区，如何不再依靠门票</a></div>
     			<div><a href="#" title="高考期间中东地区将现大范围降雨">高考期间中东地区将....</a></div>
     			<div><a href="#" title="山西离柳焦煤集团并下人行车发生事故6人死亡">山西离柳焦煤集团并....</a></div>
     			<div><a href="#" title="公司股东共 本奋斗故事告诉过">公司股东共 本奋斗故...</a></div>
     			<div><a href="#" title="跟师傅过富贵人行车发生豆腐干是个">跟师傅过富贵人行车....</a></div>
     			<div><a href="#" title="但发发嗲发发按分发都发广告">但发发嗲发发按分....</a></div>
     			<div><a href="#" title="更好的公司发电股份的感受到">更好的公司发电股份....</a></div>
     			<div><a href="#" title="山西离柳焦煤集团并下人行车发生事故6人死亡">山西离柳焦煤集团并....</a></div>
     		</div> -->
     		
     		
     		
     		
     		<!-- 	<marquee scrollAmount="n" width="n" height="n" direction="type" 
scrollDelay="n" behavior="type" loop="n" onmouseover="this.stop()" onmouseout="this.start()">
					成功通过了科目一！！！
			</marquee> -->