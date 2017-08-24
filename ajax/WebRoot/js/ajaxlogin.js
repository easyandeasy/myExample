$(function() {
	$("div[id='login']>a").click(function() {
		var html = "用&nbsp;&nbsp;&nbsp;户:<input type=\"text\" name=\"username\" onkeyDown='username(event)' class=\"username\"/><span id=\"name\"></span><br /> 密&nbsp;&nbsp;&nbsp;码:<input type=\"password\" name=\"password\" class=\"password\" onkeyDown='userpwd(event)'/><span id=\"pwd\"></span><br /> <input type=\"button\" name=\"btn\" value=\"登录\" />";
		$("#login").html(html);
	});	
});


//退出
function outclick() {
	$.post("ajaxAction!outLogin.action",function(data) {
		var html = "用&nbsp;&nbsp;&nbsp;户:<input type=\"text\" name=\"username\" onkeyDown='username(event)' class=\"username\"/><span id=\"name\"></span><br /> 密&nbsp;&nbsp;&nbsp;码:<input type=\"password\" name=\"password\" class=\"password\" onkeyDown='userpwd(event)'/><span id=\"pwd\"></span><br /> <input type=\"button\" name=\"btn\" value=\"提交\" />";
		$("#login").html(html);
	});
};

// 点击 提交 显示数据
function login() {
	var pwd = $(".password").val();
	var name = $(".username").val();
	getJSONLogin(name,pwd);  //$.getJSON(); 方法
}


/**
 * 按下enter键光标定位到密码框
 * @param event
 */
function username(event) {
	var v = event.keyCode;
	if(v == 13) {
		$(".password").focus();
	}
}

/**
 * 光标定位到密码框按下enter键时 提交数据到action中
 * @param event
 */
function userpwd(event) {
	var v = event.keyCode;
	if(v == 13) {
		var pwd = $(".password").val();
		var name = $(".username").val();
		//CheckLogin(pwd,name);//调用函数对服务器的访问
		//getLogin(name,pwd);  //$.get(); 方法
		//postLogin(name,pwd); //$.post(); 方法
		//ajaxLogin(name,pwd); //$.ajax(); 方法
		//loadLogin(name,pwd);  //$().load(); 方法
	}
}

//创建 url 路径
function getUrl(name,pwd) {
	return "ajaxAction!isLogin.action?user.name="+name+"&user.pwd="+pwd+"&time="+new Date().getMilliseconds();
}

// $.get(); 方法
function getLogin(name,pwd) {
	var url = getUrl(name,pwd);
	$.get(url,function(data) {
		alert(data);
		xxx(data);
	});
}

// $.post(); 方法
function postLogin(name,pwd) {
	var url = getUrl(name,pwd);
	$.get(url,function(data) {
		xxx(data);
	});
}

// $.ajax(); 方法
function ajaxLogin(name,pwd) {
	var url = "ajaxAction!isLogin.action";
	var datas = {"user.name":name,"user.pwd":pwd,"time":new Date().getMilliseconds()};
	$.get(url,datas,function(data) {
		xxx(data);
	});
}

//$().load(); 方法
function loadLogin(name,pwd) {
	var url = "ajaxAction!isLogin.action";
	var datas = {"user.name":name,"user.pwd":pwd,"time":new Date().getMilliseconds()};
	$("#login").load(url,datas,function(data) {
		xxx(data);
	});
}


//$.getJSON(); 方法
function getJSONLogin(name,pwd) {
	alert(name);
	var url = "ajaxAction!queryJSON.action";
	//var datas = {"user.name":name,"user.pwd":pwd,"time":new Date().getMilliseconds()};datas,
	$.getJSON(url,function(data) {
		alert(data);
		var html = "";
		$.each(data,function(i,obj) {
			html += "<tr><td>"+obj.name+"</td><td>"+obj.pwd+"</td></tr>";
		});
		$("#tbody").append(html);
	},"json");
}



//get 、 post 、ajax 操作成功 与 失败进行的操方法
function xxx(txt) {
	var html = "";
	if(txt.indexOf("error") != -1){
		$(".error").html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户名或密码不正确！");
		html = "用&nbsp;&nbsp;&nbsp;户:<input type=\"text\" name=\"username\" onkeyDown='username(event)' class=\"username\"/><span id=\"name\"></span><br /> 密&nbsp;&nbsp;&nbsp;码:<input type=\"password\" name=\"password\" class=\"password\" onkeyDown='userpwd(event)'/><span id=\"pwd\"></span><br /> <input type=\"button\" name=\"btn\" value=\"提交\" />";
	}else{
		$(".error").html("&nbsp;");
		html = "欢迎您："+txt+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"javascript:;\" onclick='outclick()'>退出</a>	";
	}
	$("#login").html(html);
}


var XMLHttpRequest;//声明一个null对象
/**
 * 创建 XMLHttpRequest对象 函数
 * @returns
 */
function getXMLHttpRequest() {
	//非IE浏览器
	if (window.XMLHttpRequest) {
		xmlHttpRequest = new XMLHttpRequest();// 1.创建 XMLHttpRequest对象
	} else {// 返回值为false 时说明是老版本IE浏览器（IE5和IE6）
		xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
	}
	return xmlHttpRequest;
}

/**
 * 编写函数实现对服务器端的访问
 * @param pwd 密码
 * @param name 用户
 */
function CheckLogin(pwd,name) {
	var xmlHttpRequest = getXMLHttpRequest();//调用 创建 XMLHttpRequest 对象函数
	// 初始化XMLHttpRequest组件
	var url = "ajaxAction!isLogin?user.name="+name+"&user.pwd="+pwd+"&time="+new Date().getMilliseconds();
	// 设置回调函数
	xmlHttpRequest.onreadystatechange = callBack;
	xmlHttpRequest.open("get", url);// get方式
	// 4.发送请求
	xmlHttpRequest.send(null);
}


function callBack() {
	if(xmlHttpRequest.readyState==4){
		if(xmlHttpRequest.status == 200){
			var txt = xmlHttpRequest.responseText;
			var html = "";
			if(txt.indexOf("error") != -1){
				$(".error").html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用户名或密码不正确！");
				html = "用&nbsp;&nbsp;&nbsp;户:<input type=\"text\" name=\"username\" onkeyDown='username(event)' class=\"username\"/><span id=\"name\"></span><br /> 密&nbsp;&nbsp;&nbsp;码:<input type=\"password\" name=\"password\" class=\"password\" onkeyDown='userpwd(event)'/><span id=\"pwd\"></span><br /> <input type=\"button\" name=\"btn\" value=\"提交\" />";
			}else{
				$(".error").html("&nbsp;");
				html = "欢迎您："+txt+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=\"javascript:;\" onclick='outclick()'>退出</a>	";
			}
			$("#login").html(html);
		}
	}
}










































	/*function login() {
		var name = document.getElementById("username").value;
		var pwd = document.getElementById("password").value;
		$.ajax({
			url : 'ajax.action',// 要提交的URL路径
			type : 'get',// 发送请求方式
			data : 'username=' + name,// 要发送到服务器的数据
			dataType : 'text',// 指定传输数据的格式
			beforeSend : function(result) {// 请求完成后调用
				alert(name + "---beforeSend1---" + pwd);
			},
			complete : function(result) {// 请求完成后调用
				alert(name + "---complete3---" + pwd);
			},
			success : function(data, result) {
				// 这里将服务器返回的文本数据显示到页面的代码
				alert("----success2-----");
				$("#name").html(name);
				$("#pwd").html(pwd);
			},
			error : function(data, result) {
				alert("ajax执行失败！error2" + result);
			}
		});
	}*/