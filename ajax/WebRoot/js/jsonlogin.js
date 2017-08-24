function login() {
	alert("aaa");
	$.getJSON("jsons.action",function(result) {
		
		// 这里将服务器返回的文本数据显示到页面的代码
		alert(result);
		var html = "";
		for ( var i = 0; result.length; i++) {
			html += "<tr><td>" + result[i].name + "</td><td>" + result[i].age + "</td></tr>";
		}
		$("#tbody").html(html);
	});

}











/*

$(function() {
	var jsonStr = {
			'name' : '刘玮',
			'age' : '12'
	};
	alert(jsonStr.name + "-----" + jsonStr.age);
	var ary = [ "中", "国", "人" ];
	var arys = [ {
		'name' : '小明',
		'age' : '22'
	}, {
		'name' : '小椰',
		'age' : '23'
	}, {
		'name' : '小张',
		'age' : '24'
	} ];
	for ( var i = 0; i < ary.length; i++) {
		alert(ary[i]);
	}
	for ( var i = 0; i < arys.length; i++) {
		alert(arys[i].name + "-----" + arys[i].age);
	}
});






 * $.ajax({ url:'json.action',//要提交的URL路径 type:'get',//发送请求方式
 * dataType:'text',//指定传输数据的格式 success:function(data,result){
 * //这里将服务器返回的文本数据显示到页面的代码 var html = ""; for(var i = 0; data.length;i++) {
 * $("#tbody").html("<tr><td>"+data[i].name+"</td><td>"+data[i].age+"</td></tr>"); } },
 * error:function(data,result){ alert("ajax执行失败！"); } },'json');
 */

