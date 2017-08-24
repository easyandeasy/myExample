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
  </head>
  
  <body>
  	<s:fielderror cssStyle="color:red;list-style:none;"/>
    <form action="validate01.action" >
    	用&nbsp;&nbsp;户&nbsp;&nbsp;名:<input type="text" name="user.name" /><br/>
    	 密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:<input type="password" name="user.pwd" /><br/>
    	确认密码:<input type="password" name="repwd" /><br/>
    	邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱:<input type="text" name="user.email" /><br/>
    	出生日期:<input type="text" name="user.birth" /><br/>
    	身份证号:<input type="text" name="user.card" /><br/>
    	电话号码:<input type="text" name="user.phone" /><br/> 
    	<input type="submit" name="submit" value="submit"/>
    </form>
    	
    	<%-- <s:form action="validate" namespace="/">  
	        <s:textfield name="name" label="姓名"></s:textfield>  
	        <s:textfield name="email" label="邮箱"></s:textfield>  
	        <s:textfield name="age" label="年龄"></s:textfield>  
	        <s:textfield name="date" label="日期"></s:textfield>  
	        <s:textfield name="uname" label="身份证号"></s:textfield>  
        <s:submit value="提交"></s:submit>  
    </s:form>   --%>
  </body>
</html>
