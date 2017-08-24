<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>

  </head>
  
  <body>
   <form action="${pageContext.request.contextPath }/test/register.do" method="post">
   <!--  整体接收时，要求表单参数名和对象属性名相同  -->
   	姓名：<input type="text" name="name" />${nameError}<br/>
   	成绩：<input type="text" name="score" value="0"/>${scoreError}<br/>
   	电话：<input type="text" name="mobile" />${mobileError}<br/>
   	<input type="submit" value="注册"/>
   </form>
  </body>
</html>
