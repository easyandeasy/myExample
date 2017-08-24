<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>

  </head>
  
  <body>
   <form action="${pageContext.request.contextPath }/test/upload.do" method="post" enctype="multipart/form-data">
   	<input type="file" name="img"/>
   	<input type="submit" value="上传"/>
   </form>
  </body>
</html>
