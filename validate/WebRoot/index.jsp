<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		td{
		width:400px;
		}
	</style>
  </head>
  
  <body>
    <!-- <form action="validate01">
    	用&nbsp;&nbsp;户&nbsp;&nbsp;名:<input type="text" name="name" /><br/>
    	密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:<input type="password" name="pwd" /><br/>
    	确认密码:<input type="password" name="repwd" /><br/>
    	邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱:<input type="text" name="email" /><br/>
    	年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄:<input type="text" name="age" /><br/>
    	出生日期:<input type="text" name="date" /><br/>
    	身份证号:<input type="text" name="card" /><br/>
    	电话号码:<input type="text" name="phone" /><br/>
    	<input type="submit" name="submit" value="submit"/>
    </form> -->
    	
    	<s:form action="validate01" namespace="/" width="800px">  
	        <s:textfield name="name" label="用户名"/>
	        <s:textfield name="pwd" label="密码"/>
	        <s:textfield name="repwd" label="确认密码"/>
	        <s:textfield name="email" label="邮箱"/>  
	        <s:textfield name="age" label="年龄"/>  
	        <s:textfield name="dates" label="日期"/>  
	        <s:textfield name="card" label="身份证号"/>  
	        <s:textfield name="phone" label="电话号码"/>  
        <s:submit value="提交"/>  
    </s:form>  
  </body>
</html>
