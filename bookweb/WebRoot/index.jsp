<%@page import="cn.bookweb.book.entity.Book"%>
<%@page import="cn.bookweb.book.service.IBookService"%>
<%@page import="cn.bookweb.book.serviceimpl.BookServiceImpl"%>
<%@page import="cn.bookweb.basedao.BaseDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <%
    
   		 IBookService service = new BookServiceImpl();
		List<Book> booklike = service.queryBookInfoLike("java");
		for(Book b :booklike){
			out.println(b.getBname());
		}
    	/* BaseDao dao = new BaseDao();
    	if(dao.getConnectionSQl()==null){
    		out.println("为空");
    	}else{
    		out.println("有值");
    	} */
     %>
  </body>
</html>
