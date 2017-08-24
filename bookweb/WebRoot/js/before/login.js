/**登录页面js*/

/**给忘记密码，注册鼠标移入移出时添加css样式*/

$(function(){
	
	/**鼠标移入移除 改变超链接忘记密码的颜色*/
	$("#forgetpass").mouseover(function(){
		$(this).addClass("a1js");
	});
	$("#forgetpass").mouseout(function(){
		$(this).removeClass("a1js");
	});
	
	/**鼠标移入移除 改超链接注册文本颜色*/
	$("#regist").mouseover(function(){
		$(this).addClass("a2js");
	});
	$("#regist").mouseout(function(){
		$(this).removeClass("a2js");
	});
	
	/**鼠标移入移除 改变登录框背景颜色*/
	$("#submit").mouseover(function(){
		$(this).addClass("input1js");
	});
	$("#submit").mouseout(function(){
		$(this).removeClass("input1js");
	});
	
	/*
	 * 输入框得到焦点时隐藏错误信息
	 */
	$(".input1").focus(function() {
		var inputName = $(this).attr("name");
		$("#" + inputName + "Error").css("display", "none");
	});
	
	/*
	 * 输入框推动焦点时进行校验
	 */
	$(".input1").blur(function() {
		var inputName = $(this).attr("name");
		ErrorFunction(inputName);
	});
});

/*
 * 输入input名称，调用对应的validate方法。
 * 例如input名称为：loginname，那么调用ErrorFunction()方法。
 */
function ErrorFunction(inputName) {
	inputName = inputName.substring(0, 1).toUpperCase() + inputName.substring(1);
	var functionName = "Error" + inputName;
	return eval(functionName + "()");	
}

/*
 * 校验登录名
 */
function ErrorLoginname() {
	var bool = true;
	$("#loginnameError").css("display", "none");
	var value = $("#loginname").val();
	if(!value) {// 非空校验
		$("#loginnameError").css("display", "");
		$("#loginnameError").text("用户名不能为空");
		bool = false;
	} else if(value.length < 3 || value.length > 20) {//长度校验
		$("#loginnameError").css("display", "");
		$("#loginnameError").text("用户名长度必须在3 ~ 16之间");
		bool = false;
	}
	return bool;
}

/*
 * 校验密码
 */
function ErrorLoginpass() {
	var bool = true;
	$("#loginpassError").css("display", "none");
	var value = $("#loginpass").val();
	if(!value) {// 非空校验
		$("#loginpassError").css("display", "");
		$("#loginpassError").text("密码不能为空");
		bool = false;
	} else if(value.length < 3 || value.length > 20) {//长度校验
		$("#loginpassError").css("display", "");
		$("#loginpassError").text("密码长度必须在3 ~ 16之间");
		bool = false;
	}
	return bool;
}