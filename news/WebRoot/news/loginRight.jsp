<%@page import="com.jdbc.util.PageUtil"%>
<%@page import="com.jdbc.entity.Page"%>
<%@page import="com.jdbc.serviceImpl.NewsServiceImpl"%>
<%@page import="com.jdbc.entity.News"%>
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
    
    <title>My JSP 'loginRight.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="css/style.css">
  </head>
  
  <body class="rightBody">
     
     	<c:if test="${pages == null || id == null }">
     		<c:redirect url="../PageControl?pageIndex=1&id=1&type=login"/>
     	</c:if>
    	<div class="rightText">
   					<div class="text1">
   						
     					<c:forEach items="${list }" var="news" varStatus="status">
     						<c:if test="${(status.index % 6) ==0 }">
     							<br/>
     						</c:if>
     						<li><span class="time">${news.ntime }</span><a href="NewShow?nid=${news.nid}" target="if" class="text" title="${news.ntitle }">${news.ntitle }</a></li>
     					</c:forEach>
     				</div>
   				</div>
   		<% %>
   		<p class="page">当前页数：[${now }/${count }]
	   		 <c:if test="${now > 1 }" >
	   		 	<a href="PageControl?pageIndex=${pages.first}&id=${id}&type=login" >首页${pages.first}</a>&nbsp;
	   		 	<a href="PageControl?pageIndex=${pages.back}&id=${id}&type=login">上一页${pages.back}</a>
	   		 </c:if>
	   		  <c:if test="${now < count }" >
	   		 	<a href="PageControl?pageIndex=${pages.next}&id=${id}&type=login">下一页${pages.next}</a>
	   		 	<a href="PageControl?pageIndex=${pages.last}&id=${id}&type=login">末页${pages.last}</a>
	   		 </c:if>
   		 </p>
  </body>
</html>






 <%--  <%
    	NewsServiceImpl service = new NewsServiceImpl();
    	String id = request.getParameter("id");
    	PageUtil pages = (PageUtil)request.getAttribute("pages");
    	if(pages==null || id == null){
    		response.sendRedirect("PageControl?pageIndex=1&id=1");
    		//request.getRequestDispatcher("PageControl?pageIndex=1&id=1").forward(request, response);
    	}else{
    	int totalpages = pages.getCount();//总页数
    	int pageIndex = pages.getNow();//当前页号
   		List<News> list13 = (List<News>)pages.getList();
   		//List<News> list13 = (List<News>)session.getAttribute("lists");
     %> 
     
     
     <%
   							for(News n : (List<News>)request.getAttribute("list13")){
								out.println(n.getNtitle());
							}
   						 %>
     --%>
     




	<%-- <%
   							int j = 1;
   							for(News news : list13){
   						 %>
     					<li><span class="time"><%=news.getNtime() %></span><a href="#" class="text" title=<%=news.getNtitle() %>><%=news.getNtitle() %></a></li>
     					<%
     						if(++j==6){
   									out.print("<p></P>");
   									j = 1;
   								}
     					} 
     					%> --%>
     					






<%-- <%
   			if(pageIndex>1){
   		 %>
   		 	<a href="PageControl?pageIndex=<%=pages.getFirst() %>&id=<%=id %>" >首页</a>&nbsp;
   		 	<a href="PageControl?pageIndex=<%=pages.getBack() %>&id=<%=id %>">上一页</a>
   		 <%} 
   		 	if(pageIndex<totalpages){
   		 %>
   		 	<a href="PageControl?pageIndex=<%=pages.getNext() %>&id=<%=id%>">下一页</a>
   		 	<a href="PageControl?pageIndex=<%=pages.getLast() %>&id=<%=id%>">末页</a>
   		 <%}
   		 } %> --%>
   		 
