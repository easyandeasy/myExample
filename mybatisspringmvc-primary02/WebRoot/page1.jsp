<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
<head>
<!-- 屏幕和设备的屏幕一致，初始缩放为1:1，禁止用户缩放 -->
<meta name="viewport"
	content="width=device-width,initial-scale=1,user-scalable=no">

<title>My JSP 'index.jsp' starting page</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="easyui/easyui.css">
<link rel="stylesheet" type="text/css" href="easyui/icon.css">
<script type="text/javascript" src="bootstrap/js/jquery.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<link rel="stylesheet" href="page2/jquery.page.css">
<script src="page2/jquery.page.js"></script>
<script src="page2/jquery.pagination.js"></script>
<script src="page2/jquery.searchbox.js"></script>

<style type="text/css">
div[class^=""] {
	border: 0px solid red;
}
</style>

</head>

<body style="background:gray;">
	<div class="container" style="background:#f9f9f9;">
		<h3 class="page-header text-top">（向左向右偏移）</h3>
		<div class="row">
			<div class="col-sm-3">
				<!-- 
				<h2>Tab Position</h2>
					<p>Click the 'position' drop-down list and select an item to change the tab position.</p>
					<div style="margin:20px 0;">
						<span>Position:</span>
						<select onchange="$('#tt').tabs({tabPosition:this.value})">
							<option value="top">Top</option>
							<option value="bottom">Bottom</option>
							<option value="left">Left</option>
							<option value="right">Right</option>
						</select>
					</div>
				-->
					<div id="tt" class="easyui-tabs" style="width:294px;height:577px">
						<div title="About" style="margin-left:0px">
							<div class="list-group">
								  <a href="#" class="list-group-item active">
								    Cras justo odio
								  </a>
								  <a href="#" class="list-group-item">Dapibus ac facilisis in</a>
								  <a href="#" class="list-group-item">Morbi leo risus</a>
								  <a href="#" class="list-group-item">Porta ac consectetur ac</a>
								  <a href="#" class="list-group-item">Vestibulum at eros</a>
							</div>
						<!-- 
							<div id="tree" class="easyui-panel" style="padding:0px">
								<ul class="easyui-tree" data-options="method:'get',animate:true"></ul>
							</div>
						-->
						</div> 
					<!-- 
						<div title="My Documents" style="padding:10px">
							<ul class="easyui-tree" data-options="url:'tree_data1.json',method:'get',animate:true"></ul>
						</div> -->
					<!-- 	
						<div title="Help" data-options="iconCls:'icon-help',closable:true" style="padding:10px">
							This is the help content.
						</div>
					-->
					</div>
			</div>
			<div class="col-sm-8">
			<!-- 
				<h2>Tabs Tools</h2>
				<p>Click the buttons on the top right of tabs header to add or remove tab panel.</p>
			-->
				<div id="tt1" class="easyui-tabs" data-options="tools:'#tab-tools'" style="width:848px;height:577px">
					<div class="tag" title="首页">
						<table id="dg" class="easyui-datagrid" style="width:846px;height:402px"
							   data-options="singleSelect:true,collapsible:true,method:'get'">
							<thead>
								<tr>
									<th data-options="field:'itemid',width:55">ID</th>
									<th data-options="field:'productid',width:80">Name</th>
									<th data-options="field:'listprice',width:255,align:'center'">Birthday</th>
									<th data-options="field:'unitcost',width:100,align:'center'">Class</th>
									<th data-options="field:'attr1',width:259">Address</th>
									<th data-options="field:'status',width:80,align:'center'">Status</th>
								</tr>
							</thead>
						</table>
							<div class="easyui-panel">
								<div id="pg" class="easyui-pagination" data-options="showPageList:false,total:114,buttons:$('#buttons')"></div>
							</div>
							
							
							<div id="buttons">
								<table style="border-spacing:0">
									<tr>
										<td>
											<input class="easyui-searchbox" style="width:150px">
										</td>
										<td>
											<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true"></a>
										</td>
									</tr>
								</table>
							</div>
							
						<!-- 分页 -->
						<div class="tcdPageCode"></div>
					</div>
					
				</div>
				<div id="tab-tools">
					<a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-add'" onclick="addPanel()"></a>
					<a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-remove'" onclick="removePanel()"></a>
				</div>
				
				<input type="hidden" id="pageCount" value="1"/>
				<script type="text/javascript">
				
					var pageCount = 1;

					var buttons = [{
						iconCls:'icon-add',
						handler:function(){
							alert('add');
						}
					},{
						iconCls:'icon-cut',
						handler:function(){
							alert('cut');
						}
					},{
						iconCls:'icon-save',
						handler:function(){
							alert('save');
						}
					}];
					//初始化表样数据
					$(function(){
						pages(1);
						
						//分页延迟加载
						setTimeout(function(){
							$(".tcdPageCode").createPage({
								pageCount : $("#pageCount").val(),
								current : 1,
								backFn : function(p){
									//console.log(p);
									pages(p);
								}
							});
						}, 10)
						
						
						
						//第二种分页
						$("#pg").pagination({
							total : $("#pageCount").val(),//总页数
							pageSize : 1,//显示多少可选页
							pageList : [1],
							buttons : null,//buttons,
							onSelectPage : function(pageNow,pageCount) {
								pages(pageNow);
							}
						});
						
						
						//搜索按钮
						$("#ss").searchbox({
							keydown : function(e) {},
							searcher : function(_1c, _1d) {
								alert("aa");
							}
						});
						
						/* 
						//保存 按钮
						$("#save").linkbutton({
							onClick : function() {
								alert("save");
							}
						});
						 */
					});
					
					//添加面板
					var index = 0;
					function addPanel(){
						index++;
						$('#tt1').tabs('add',{
							title: 'Tab'+index,
							content: '<div style="padding:10px">Content'+'<input id="dd" type="text" class="easyui-datebox" value="3/4/2010" required="required">'+'</div>',
							closable: true
						});
					}
					
					//删除面板
					function removePanel(){
						var tab = $('#tt1').tabs('getSelected');
						if (tab){
							var index = $('#tt1').tabs('getTabIndex', tab);
							if(index == 0 ) 
								return false;
							$('#tt1').tabs('close', index);
						}
					}
					
					function pages(p) {
						$.ajax({
							url:"test/doPageStudent.do",//跳转到控制器
							data:{
								"pageNow":p
							},
							success:function(data){
								var obj = eval("("+data+")");
								var o = eval("("+obj.json+")");
								$("#pageCount").val(obj.count);
								//表格填充数据
								$('#dg').datagrid('loadData',o); 
							}
						});
					};
					
				</script>
			</div>
		</div>
	</div>
</body>
</html>









































		<!-- 窗体 -->
<!-- 	<div id="win" class="easyui-window" title="My Window"
		style="width:600px;height:400px"
		data-options="iconCls:'icon-save',modal:true"
		data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-0"
		data-genuitec-path="/mybatisspringmvc-primary02/WebRoot/index.jsp">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'north',split:true" style="height:100px"></div>
			<div data-options="region:'center'">The Content.</div>
		</div>
	</div>
 -->
 
 <!-- 

	<input class="easyui-datetimebox" name="birthday"
		data-options="required:true,showSeconds:false" value="3/4/2010 2:3"
		style="width:150px">



	<div id="p" class="easyui-panel"
		style="width:500px;height:200px;padding:10px;" title="My Panel"
		iconCls="icon-save" collapsible="true">The panel content</div>

	<input class="easyui-combobox" name="language"
		data-options="
    url:'combobox_data.json',
    valueField:'id',
    textField:'text',
    panelHeight:'auto',
    onSelect:function(record){
    alert(record.text)
    }" />


 -->