<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>

  </head>
  
  <body>
   <form action="${pageContext.request.contextPath }/test/dologin.do" method="post">
   	姓名：<input type="text" name="name" /><br/>
   	年龄：<input type="text" name="age" /><br/>
   	<input type="submit" value="注册"/>
   </form>
  </body>
</html>
