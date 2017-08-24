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
	
	<script type="text/javascript">
		function langSelecter_onChanged(){
			document.langForm.submit();
		}
	</script>

	
  </head>
  
  <body>
  	
    <form action="validate01.action" method="post">
    	用&nbsp;&nbsp;户&nbsp;&nbsp;名:<input type="text" name="user.name" /><br/>
    	 密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:<input type="password" name="user.pwd" /><br/>
    	确认密码:<input type="password" name="repwd" /><br/>
    	邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱:<input type="text" name="user.email" /><br/>
    	出生日期:<input type="text" name="user.birth"/><br/>
    	身份证号:<input type="text" name="user.card" /><br/>
    	电话号码:<input type="text" name="user.phone" /><br/>
    	<input type="submit" name="submit" value="submit"/>
    </form>
    	

	<s:set name="SESSION_LOCALE" value="#session['WW_TRANS_I18N_LOCALE']"/>
	<s:bean id="locales" name="cn.validate.util.Locales"/>
	<form action="<s:url includeParams="get" encode="true"/>" name="langForm" style="background-color:powderblue;padding-top:4px;padding-bottom:4px;">
	    Language: <s:select label="Language" list="#locales.locales" listKey="value" listValue="key" value="#SESSION_LOCALE == null ? locale : #SESSION_LOCALE" name="request_locale" id="langSelecter" onchange="langSelecter_onChanged()" theme="simple"/>
	</form>
	
	 <h2><s:text name="HelloWorld"/></h2>
	 <h2><s:property value="%{getText('HelloWorld')}"/></h2>

  </body>
</html>
