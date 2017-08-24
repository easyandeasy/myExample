<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>岗位设置</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script language="javascript" src="${pageContext.request.contextPath }/script/jquery.js"></script>
    <script language="javascript" src="${pageContext.request.contextPath }/script/pageCommon.js" charset="utf-8"></script>
    <script language="javascript" src="${pageContext.request.contextPath }/script/PageUtils.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/style/blue/pageCommon.css" />
    <script type="text/javascript"> 
    </script>
</head>
<body> 

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath }/style/images/title_arrow.gif"/> 岗位设置
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id="MainArea">
    <form action="list.html">
        <div class="ItemBlock_Title1"><!-- 信息说明<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="${pageContext.request.contextPath }/style/blue/images/item_point.gif" /> 岗位信息 </DIV>  -->
        </div>
        
        <!-- 表单内容显示 -->

   	<s:form action="role_add" method="post">
   		<s:textfield name="name" label="姓名"></s:textfield><br/>
   		<s:textarea name="description" label="备注"></s:textarea><br/>
        
        <!-- 表单操作 -->
        <div id="InputDetailBar">
            <input type="image" src="${pageContext.request.contextPath }/style/images/save.png"/>
            <s:a action="role_list.action"><img src="${pageContext.request.contextPath }/style/images/goBack.png"/></s:a>
        </div>
   	</s:form>
</div>

</body>
</html>

