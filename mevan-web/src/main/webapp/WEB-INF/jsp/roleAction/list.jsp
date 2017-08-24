<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>岗位列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script language="javascript" src="${pageContext.request.contextPath }/script/jquery.js"></script>
    <script language="javascript" src="${pageContext.request.contextPath }/script/pageCommon.js" charset="utf-8"></script>
    <script language="javascript" src="${pageContext.request.contextPath }/script/PageUtils.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/style/blue/pageCommon.css" />
    <script type="text/javascript">
    </script>
</head>
<body>
 
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath }/style/images/title_arrow.gif"/> 岗位管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align="CENTER" valign="MIDDLE" id="TableTitle">
            	<td width="200px">岗位名称</td>
                <td width="300px">岗位说明</td>
                <td>相关操作</td>
            </tr>
        </thead>

		<!--显示数据列表-->
         <tbody id="TableData" class="dataContainer" datakey="roleList">
			<s:iterator value="#roleList">
		   		<tr class="TableDetail1 template">
					<td>${name }&nbsp;</td>
					<td>${description}&nbsp;</td>
					<td>
						<s:a action="role_delete.action?id=%{id}" onclick="return confirm('确定要删除吗！')">删除</s:a>
						<s:a action="role_editUI.action?id=%{id}">修改</s:a>
						<%--<a href="setPrivilegeUI.html">设置权限</a>--%>
					</td>
				</tr>
		   	</s:iterator>
        </tbody>
	  
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
        	<s:a action="role_addUI.action"><img src="${pageContext.request.contextPath }/style/images/createNew.png" /></s:a>
        </div>
    </div>
</div>
</body>
</html>


   	
   	
   	<%--
   	<s:iterator value="#roleList">
   		<s:property value="id"/>&nbsp;&nbsp;&nbsp;&nbsp;
   		<s:property value="name"/>&nbsp;&nbsp;&nbsp;&nbsp;
   		<s:property value="description"/>&nbsp;&nbsp;&nbsp;&nbsp;
   		<s:a action="role_delete.action?id=%{id}" onclick="return confirm('确定要删除吗！')">删除</s:a>&nbsp;&nbsp;&nbsp;&nbsp;
   		<s:a action="role_editUI.action?id=%{id}">修改</s:a>
   		<br/>
   	</s:iterator>
   	
   	--%>
   	