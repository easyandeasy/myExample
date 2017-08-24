var editIndex = undefined;//当前行下标

//整体操作
function endEditing() {
	if (editIndex == undefined) {
		return true
	}
	if ($('#dg').datagrid('validateRow', editIndex)) {
		var ed = $('#dg').datagrid('getEditor', {
			index : editIndex,
			field : 'name'
		});
		var productname = $(ed.target).combobox('getText');
		$('#dg').datagrid('getRows')[editIndex]['productname'] = productname;
		$('#dg').datagrid('endEdit', editIndex);
		editIndex = undefined;
		return true;
	} else {
		return false;
	}
}
//点击行
function onClickRow(index) {
	if (editIndex != index) {
		if (endEditing()) {
			$('#dg').datagrid('selectRow', index)
				.datagrid('beginEdit', index);
			saveAndUpdate(editIndex);
			editIndex = index;
		} else {
			$('#dg').datagrid('selectRow', editIndex);
		}

	}	
}

//添加
function append() {
	if (endEditing()) {
		$('#dg').datagrid('appendRow', {
			status : 'P'
		});
		editIndex = $('#dg').datagrid('getRows').length - 1;
		$('#dg').datagrid('selectRow', editIndex)
			.datagrid('beginEdit', editIndex);
	}
}

//移除
function removeit() {
	if (editIndex == undefined) {
		return
	}
	$('#dg').datagrid('cancelEdit', editIndex)
		.datagrid('deleteRow', editIndex);
	editIndex = undefined;
}

//保存
function accept() {
	if (endEditing()) {
		$('#dg').datagrid('acceptChanges');

		var index = undefined;
		saveAndUpdate(index);
	}
}

//撤销
function reject() {
	$('#dg').datagrid('rejectChanges');
	editIndex = undefined;
}

//修改
function getChanges() {
	var rows = $('#dg').datagrid('getChanges');
	
//	var row = $('#dg').datagrid('getSelected');//获取当前行的对象
//	alert("id=" + row.id + " sname=" + row.name + "&sbirth=" + row.birth + "&sclass=" + row.class + "&saddress=" + row.address);
	
	alert(rows.length + ' rows are changed!');
}




function saveAndUpdate(index) {
	var row  = $('#dg').datagrid('getSelected');//获取当前行的对象
	//alert("id=" + row.id + " sname=" + row.name + "&sbirth=" + row.birth + "&sclass=" + row.class + "&saddress=" + row.address);
	
	
	/*var birth = new Date(row.birth);
	var str = "test/doAddStudent.do";
	if(row.id != null || row.id != 0)
		str = "test/doUpdateStudent.do";
	$.ajax({
		url:str,//跳转到控制器
		data:{//传递参数
			"id":row.id,
			"sname":row.name,
			"sbirth":birth,
			"sclass":row.class,
			"saddress":row.address
		},
		success:function(data){
			if(data == "" || data == undefined)
				return false;
			$('#dg').datagrid('updateRow',{
			    index: $('#dg').datagrid('getRows').length - 1,
			    row: {
			        id: data
			    }
			});
			$('#dg').datagrid('reload');    // reload the current page data
			
			
//					$(data).each(function(index,stu){	//遍历
//						//alert(stu.name + "   " + stu.age);//两个输出结果是一样的
//						alert(data[index].name + "    " +data[index].age);
//					});
		}
	});*/
}