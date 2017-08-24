<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<!-- 屏幕和设备的屏幕一致，初始缩放为1:1，禁止用户缩放 -->
<meta name="viewport"
	content="width=device-width,initial-scale=1,user-scalable=no">

<title>My JSP 'index.jsp' starting page</title>
<!-- page -->

<link rel="stylesheet" href="page/jquery.page.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="easyui/easyui.css">
<link rel="stylesheet" type="text/css" href="easyui/icon.css">
<link rel="stylesheet" type="text/css" href="easyui/demo.css">
<script type="text/javascript" src="bootstrap/js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-2.1.4.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/students.js"></script>
<style type="text/css">
/* easyui */
</style>

</head>

<body style="background:gray;">
	<div class="container" style="background:#fff;">
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2">
				<h2>Student Info</h2>
				
				<table id="dg" class="easyui-datagrid" title=" Show Student Info" style="width:700px;height:auto"
						data-options="
							iconCls: 'icon-edit',
							singleSelect: true,
							toolbar: '#tb',
							url: '',
							method: 'get',
							onClickRow: onClickRow
						">
					<thead>
						<tr>
							<th data-options="field:'id',width:60">ID</th>
							<th data-options="field:'name',width:60,editor:'textbox'">Name</th>
							<th data-options="field:'birth',width:160,align:'center',editor:{type:'textbox',options:{precision:1}}">Birth</th>
							<th data-options="field:'class',width:80,align:'center',editor:'textbox'">Class</th>
							<th data-options="field:'address',width:250,editor:'textbox'">Address</th>
							<th data-options="field:'status',width:60,align:'center',editor:{type:'checkbox',options:{on:'P',off:'p'}}">Status</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${stu }" var="s">
							<tr>
								<td field="id" width="80" align="center">${s.id}</td>
								<td field="name" width="80" align="center">${s.sname}</td>
								<td field="birth" width="160" align="center"><fmt:formatDate value='${s.sbirth}' pattern='yyyy-MM-dd'/></td>
								<td field="class" width="80" align="center">${s.sclass}</td>
								<td field="address" width="120" align="center">${s.saddress}</td>
								<td field="status" width="80" align="center">p</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			 
				<div id="tb" style="height:auto">
					<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="append()">Append</a>
					<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="removeit()">Remove</a>
					<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="accept()">Accept</a>
					<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-undo',plain:true" onclick="reject()">Reject</a>
					<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="getChanges()">GetChanges</a>
				</div>
			</div>
		</div>	


	
			<br/>
			
			<!-- page 分页  -->
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1">
					<div class="tcdPageCode"></div>
				</div>
			</div>
			
			<link rel="stylesheet" href="page2/jquery.page.css">
			<script src="page2/jquery.page.js"></script>
			<script>
				$(".tcdPageCode").createPage({
					pageCount : 100,
					current : 1,
					backFn : function(p) {
						//console.log(p);
						alert(p); //当前页
					}
				});
			</script>

		</div>
	</div>
</body>
</html>


