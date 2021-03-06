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
				<div id="tt" class="easyui-tabs" style="width:294px;height:577px">
					<div title="About" style="margin-left:0px">
						<div class="list-group">
							<a href="#" class="list-group-item active"> Cras justo odio </a>
							<a href="#" class="list-group-item">${message }Dapibus ac
								facilisis in</a> <a href="#" class="list-group-item">Morbi leo
								risus</a> <a href="#" class="list-group-item">Porta ac
								consectetur ac</a> <a href="#" class="list-group-item">Vestibulum
								at eros</a>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-8">
				<div id="tt1" class="easyui-tabs" data-options="tools:'#tab-tools'"
					style="width:848px;height:577px">
					<div class="tag" title="首页">
						<table id="dg" class="easyui-datagrid"
							style="width:846px;height:402px"
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
						<!-- 分页 -->
						<div class="tcdPageCode"></div>
					</div>

				</div>
				<div id="tab-tools">
					<a href="javascript:void(0)" class="easyui-linkbutton"
						data-options="plain:true,iconCls:'icon-add'" onclick="addPanel()"></a>
					<a href="javascript:void(0)" class="easyui-linkbutton"
						data-options="plain:true,iconCls:'icon-remove'"
						onclick="removePanel()"></a>
				</div>

				<input type="hidden" id="pageCount" value="1" />

				<script type="text/javascript">
				
					var stu; //学生对象
					var pageSize = 15; //每页显示多少条数据
					var pageCount = $("#pageCount").val(); //总记录数
					var pageNow = 1; //当前面，默认为第一页
					var start = 0 ;//开始位置
					//初始化表样数据
					$(function() {
						pages(start, pageSize * pageNow,pageSize);
						
				
						//分页延迟加载
						setTimeout(function() {
							$(".tcdPageCode").createPage({
								pageCount : pageCount,
								current : 1,
								backFn : function(p) { //p 是当前选中的页
									//console.log(p);
									var end = pageSize * p; //结束位置
									pageNow = (p-1)*pageSize;//开始位置
									jsons(stu,pageNow,end);
								}
							});
						}, 10)
				
					});
					
					function recordCount(pageCount,pageSize){//计算总页数
						var count = pageCount / pageSize;
						if(pageCount % pageSize != 0) {
							count = pageCount / pageSize + 1;
						}
						return count;
					}
					//添加面板
					var index = 0;
					function addPanel() {
						index++;
						$('#tt1').tabs('add', {
							title : 'Tab' + index,
							content : '<div style="padding:10px">Content' + '<input id="dd" type="text" class="easyui-datebox" value="3/4/2010" required="required">' + '</div>',
							closable : true
						});
					}
				
					//删除面板
					function removePanel() {
						var tab = $('#tt1').tabs('getSelected');
						if (tab) {
							var index = $('#tt1').tabs('getTabIndex', tab);
							if (index == 0)
								return false;
							$('#tt1').tabs('close', index);
						}
					}
				

				
					//p 当前页、end 结束位置
					function pages(p,end,pageSize) {
						$.ajax({
							url : "test/doQueryStudent.do", //跳转到控制器
							success : function(data) {
								var obj = eval("(" + data + ")");
								stu = obj.stus;
								var count = recordCount(stu.length,pageSize);//计算总记录数
								$("#pageCount").val(count);
								jsons(stu,p,end);
							}
						});
					};
				
					//stu 集合对象、start 开始位置、end 结束位置
					function jsons(stu,start,end) {
						var obj = "{'total':100,'rows':[";
						if (end > stu.length) {
							end = stu.length;
						}
						for (var i = start; i < end; i++) {
							var str = "{itemid:'" + stu[i].id + "',productid:'" + stu[i].sname + "',listprice:'" + stu[i].sbirth + "',unitcost:'" + stu[i].sclass + "',attr1:'" + stu[i].saddress + "',status:'p'},";
							obj += str;
						}
						obj = obj.substr(0, obj.length - 1); //截取最后一个逗号
						obj += "]}";
						//表格填充数据
						var j = eval("(" + obj + ")");
						$('#dg').datagrid('loadData', j);
					}
				 
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