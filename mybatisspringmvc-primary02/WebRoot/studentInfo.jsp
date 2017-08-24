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

<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="easyui/easyui.css">
<link rel="stylesheet" type="text/css" href="easyui/icon.css">
<link rel="stylesheet" type="text/css" href="easyui/demo.css">
<script type="text/javascript" src="bootstrap/js/jquery.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/student.js"></script>
<style type="text/css">
/* easyui */
</style>

</head>

<body style="background:gray;">
	<div class="container" style="background:#fff;">


		<ul class="list-unstyled list-inline ">
			<li><a href="javascript:;" class="btn btn-primary btn-lg"
				data-toggle="modal" data-target="#myModal">添加学生信息</a></li>
			<li><a href="#">修改学生信息</a></li>
		</ul>

		<h2 class="page-header text-top ">学生信息</h2>
		<!-- 
    		table-bordered:给表格加外边框
    		table-hover：鼠标悬念效果，整行出现效果
    		table-striped:隔行换色
    		table-condensed:行和字体变小
    	 -->
		<div class="table-responsive">
			<!-- 给table的父元素加，以移动设备为优先，如果内容不能完全显示，会出现滚动条 -->
			<table
				class="table table-bordered table-hover table-striped table-condensed">
				<tr>
					<td>编号</td>
					<td>姓名</td>
					<td>出生日期</td>
					<td>班级</td>
					<td>地址</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${stu }" var="s">
					<tr>
						<td>${s.id}</td>
						<td>${s.sname}</td>
						<td>${s.sbirth}</td>
						<td>${s.sclass}</td>
						<td>${s.saddress}</td>
						<td>
							<ul class="list-unstyled list-inline ">
								<li><a href="#">修改</a></li>
								<li><a href="#">删除</a></li>
							</ul>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>

		<!-- easyui -->


		<table class="easyui-datagrid" style="width:600px;height:250px" title="student Info"
			   data-options="iconCls: 'icon-edit',
				singleSelect: true"
		>
			<thead>
				<tr>
					<th data-options="field:'id'">Id</th>
					<th data-options="field:'name'">Name</th>
					<th data-options="field:'birth'">Birth</th>
					<th data-options="field:'class'">Class</th>
					<th data-options="field:'address'">Address</th>
					<th data-options="field:'operate'">Operate</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${stu }" var="s">
					<tr>
						<td>${s.id}</td>
						<td>${s.sname}</td>
						<td>${s.sbirth}</td>
						<td>${s.sclass}</td>
						<td>${s.saddress}</td>
						<td>
							<ul class="list-unstyled list-inline ">
								<li><a href="#" onclick="getSelected()">修改</a></li>
								<li><a href="#" onclick="getSelections()">删除</a></li>
							</ul>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>






		<table id="tt" class="easyui-datagrid"
			style="width:600px;height:250px" title="student Info"
			data-options="
				iconCls: 'icon-edit',
				singleSelect: true,
				toolbar: '#tb',
				url:'test/doQueryStudent.do',
				method: 'get',
				onClickCell:onClickCell,
				onEndEdit:onEndEdit">
			<thead>
				<tr>
					<th field="itemid" width="80" align="center">Item ID</th>
					<th field="productid" width="80" align="center">Sname</th>
					<th field="listprice" width="160" align="center">Sbirth</th>
					<th field="unitcost" width="80" align="center">Sclass</th>
					<th field="attr1" width="120" align="center">Saddress</th>
					<th field="status" width="80" align="center">Operate</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${stu }" var="s">
					<tr>
						<td field="itemid" width="80" align="center">${s.id}</td>
						<td field="productid" width="80" align="center">${s.sname}</td>
						<td field="listprice" width="160" align="center">${s.sbirth}</td>
						<td field="unitcost" width="80" align="center">${s.sclass}</td>
						<td field="attr1" width="120" align="center">${s.saddress}</td>
						<td field="status" width="80" align="center">
							<ul class="list-unstyled list-inline ">
								<li><a href="#" onclick="getSelected()">修改</a></li>
								<li><a href="#" onclick="getSelections()">删除</a></li>
							</ul>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>






		<h2>Row Editing in DataGrid</h2>
		<p>Click the row to start editing.</p>
		<div style="margin:20px 0;"></div>

		<table id="dg" class="easyui-datagrid" title="Row Editing in DataGrid"
			style="width:700px;height:auto"
			data-options="
				iconCls: 'icon-edit',
				singleSelect: true,
				toolbar: '#tb',
				method: 'get',
				onClickCell: onClickCell,
				onEndEdit: onEndEdit
			">
			<thead>
				<tr>
					<th data-options="field:'id',width:80">ID</th>
					<th
						data-options="field:'name',width:150,editor:'textbox'">Name</th>
					<th
						data-options="field:'birth',width:80,align:'right',editor:'textbox'">Birth</th>
					<th
						data-options="field:'class',width:80,align:'right',editor:'textbox'">Class</th>
					<th data-options="field:'address',width:250,editor:'textbox'">Address</th>
					<th
						data-options="field:'status',width:60,align:'center',editor:{type:'checkbox',options:{on:'P',off:''}}">Status</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${stu }" var="s">
					<tr>
						<td field="id" width="80" align="center">${s.id}</td>
						<td field="name" width="80" align="center">${s.sname}</td>
						<td field="birth" width="160" align="center"><fmt:formatDate value='${s.sbirth}' pattern='yyyy-MM-dd HH:mm:ss'/></td>
						<td field="class" width="80" align="center">${s.sclass}</td>
						<td field="address" width="120" align="center">${s.saddress}</td>
						<td field="status" width="80" align="center">p</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<!-- 添删改操作 -->
		<div id="tb" style="height:auto">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-add',plain:true" onclick="append()">Append</a>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-remove',plain:true" onclick="removeit()">Remove</a>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-save',plain:true" onclick="accept()">Accept</a>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-undo',plain:true" onclick="reject()">Reject</a>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				data-options="iconCls:'icon-search',plain:true"
				onclick="getChanges()">GetChanges</a>
		</div>





		<script type="text/javascript">
				
				
					var editIndex = undefined;
					function endEditing() {
						if (editIndex == undefined) {
							return true
						}
						if ($('#dg').datagrid('validateRow', editIndex)) {
							$('#dg').datagrid('endEdit', editIndex);
							editIndex = undefined;
							return true;
						} else {
							return false;
						}
					}
					function onClickCell(index, field) {
						if (editIndex != index) {
							if (endEditing()) {
								$('#dg').datagrid('selectRow', index)
									.datagrid('beginEdit', index);
								var ed = $('#dg').datagrid('getEditor', {
									index : index,
									field : field
								});
								if (ed) {
									($(ed.target).data('textbox') ? $(ed.target).textbox('textbox') : $(ed.target)).focus();
								}
								editIndex = index;
							} else {
								setTimeout(function() {
									$('#dg').datagrid('selectRow', editIndex);
								}, 0);
							}
						}
					}
					function onEndEdit(index, row) {
						var ed = $(this).datagrid('getEditor', {
							index : index,
							field : 'productid'
						});
						row.productname = $(ed.target).combobox('getText');
					}
					function append() {
						
						
						var row = $('#dg').datagrid('getSelected');
						if (row) {
							alert('ID: ' + row.id + " Name: " + row.name);
						}
						
						
						if (endEditing()) {
							$('#dg').datagrid('appendRow', {
								status : 'P'
							});
							editIndex = $('#dg').datagrid('getRows').length - 1;
							$('#dg').datagrid('selectRow', editIndex)
								.datagrid('beginEdit', editIndex);
						}
					}
					function removeit() {
						if (editIndex == undefined) {
							return
						}
						$('#dg').datagrid('cancelEdit', editIndex)
							.datagrid('deleteRow', editIndex);
						editIndex = undefined;
					}
					function accept() {
						if (endEditing()) {
							$('#dg').datagrid('acceptChanges');
						}
					}
					function reject() {
						$('#dg').datagrid('rejectChanges');
						editIndex = undefined;
					}
					function getChanges() {
						var rows = $('#dg').datagrid('getChanges');
						alert(rows.length + ' rows are changed!');
					}
				</script>


























		

		<!-- 
			<nav aria-label="..." class="col-sm-4 col-sm-offset-4">
			<ul class="pagination">
				<li class=""><a href="#" aria-label="Previous"><span
						aria-hidden="true">&laquo;</span></a></li>
				<li class="active"><a href="#">1</a></li>
				<li class=""><a href="#">2</a></li>
				<li class=""><a href="#">3</a></li>
				<li class=""><a href="#">4</a></li>
				<li class=""><a href="#">5</a></li>
				<li class=""><a href="#" aria-label="Previous"><span
						aria-hidden="true">&raquo;</span></a></li>
			</ul>
			</nav>
			 -->
		</div>










		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">添加学生信息</h4>
					</div>
					<div class="modal-body">

						<form action="test/doAddStudent.do" class="form-horizontal"
							method="post">
							<div class="form-group form-group-sm">
								<label for="sname"
									class="col-sm-2 col-md-2 col-xs-2 control-label col-sm-offset-3">姓&nbsp;&nbsp;&nbsp;名：</label>
								<div class="col-sm-4 col-md-4 col-xs-4 ">
									<input type="text" name="sname" id="sname" class="form-control"
										placeholder="输入姓名" />
								</div>
							</div>
							<div class="form-group form-group-sm">
								<label for="sbirth"
									class="col-sm-2 col-md-2 col-xs-2 control-label col-sm-offset-3">出生日期：</label>
								<div class="col-sm-4 col-md-4 col-xs-4">
									<input id="dd" name="sbirth" type="text" class="easyui-datebox"
										value="21/7/2017" required="required" placeh
										form-contrololder="出生日期">
								</div>
							</div>
							<div class="form-group form-group-sm">
								<label for="sclass"
									class="col-sm-2 col-md-2 col-xs-2 control-label col-sm-offset-3">班&nbsp;&nbsp;&nbsp;级：</label>
								<div class="col-sm-4 col-md-4 col-xs-4">
									<input type="text" name="sclass" id="sclass"
										class="form-control" placeholder="班级" />
								</div>
							</div>
							<div class="form-group form-group-sm">
								<label for="saddress"
									class="col-sm-2 col-md-2 col-xs-2 control-label col-sm-offset-3">地&nbsp;&nbsp;&nbsp;址：</label>
								<div class="col-sm-4 col-md-4 col-xs-4">
									<input type="text" name="saddress" id="saddress"
										class="form-control" placeholder="地址" />
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
								<button type="submit" class="btn btn-primary">Save
									changes</button>
							</div>
						</form>


					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>


















<!-- 


						<th
						data-options="field:'name',width:100,
						formatter:function(value,row){
							return row.productname;
						},
						editor:{
							type:'combobox',
							options:{
								valueField:'productid',
								textField:'productname',
								method:'get',
								required:true
							}
						}">Name</th>
 -->