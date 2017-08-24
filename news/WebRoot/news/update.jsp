<%@page import="com.jdbc.util.PageUtil"%>
<%@page import="com.jdbc.serviceImpl.NewsServiceImpl"%>
<%@page import="com.jdbc.entity.Topic"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  <link rel="stylesheet" href="../css/style.css" type="text/css">
  </head>
  
  <body class="deletetopic" style="">
  	<div style="margin:0px;">
		 <c:if test="${pages == null }" >
		 	<c:redirect url="../PageControl?pageIndex=1&id=1&type=del" />
		 </c:if>
		<div style="background-image:url(images/opt_name.gif);padding:5px;padding-left:20px;width:310px;">${topicType }</div><br/>
	    <div class="deletebody" >
			 <c:forEach items="${list }" var="topic" varStatus="status">
			 	<li class="updateLi" style="list-style:none;">${topic.tid }&#160;&#160;&#160;&#160;${topic.tname }&#160;&#160;&#160;&#160;
					<a href="#?id=${topic.tid }" class="update">修改</a>&#160;&#160;&#160;&#160;<a class="delete" href="doDeleteTopicServlet?id=${topic.tid }">删除</a></li><p></p>
			 </c:forEach>
			 
		 </div>
		 <div class="page" style="text-algin:right;">当前页数：[${now }/${count }]
	   	
	   		  <c:if test="${now > 1 }" >
	   		 	<a href="PageControl?pageIndex=${pages.first}&id=${id}&type=del" >首页</a>&nbsp;
	   		 	<a href="PageControl?pageIndex=${pages.back}&id=${id}&type=del">上一页</a>&#160;
	   		 </c:if>
	   		  <c:if test="${now < count }" >
	   		 	<a href="PageControl?pageIndex=${pages.next}&id=${id}&type=del">下一页</a>&#160;
	   		 	<a href="PageControl?pageIndex=${pages.last}&id=${id}&type=del">末页</a>&#160;
	   		 </c:if>
	   		 </div>
   		 </div>
  </body>
</html>







			<%--  <%
		    	NewsServiceImpl service = new NewsServiceImpl();
		    	PageUtil pages = (PageUtil)request.getAttribute("pages");
		    	if(pages==null){
		    		response.sendRedirect("../UpdatePageControl?pageIndex=1");
		    	}else{
		    	int totalpages = pages.getCount();//总页数
		    	int pageIndex = pages.getNow();//当前页号
		   		List<Topic> list = (List<Topic>)pages.getList();
		     %>
			<%
				if (list != null) {
					for (Topic tempTopic : list) {
			%>
			<li class="updateLi" style="list-style:none;"><%=tempTopic.getTid() %>&#160;&#160;&#160;&#160;<%=tempTopic.getTname()%>&#160;&#160;&#160;&#160;
				<a href="#?id=<%=tempTopic.getTid()%>" class="update">修改</a>&#160;&#160;&#160;&#160;<a class="delete" href="doDeleteTopicServlet?id=<%=tempTopic.getTid()%>">删除</a></li><p></p>
				 <%
		 			}
		 		}
		 %> --%>



	<!-- //List<Topic> list = (ArrayList<Topic>) session.getAttribute("list");
	//session.removeAttribute("list");
	//List<News> list13 = (List<News>)session.getAttribute("lists"); -->