$(function(){
	/**鼠标移入移除为提交登录按钮添加样式*/
	$(".regist").mouseover(function(){
		$(this).addClass("zhuce");
	});
	$(".regist").mouseout(function(){
		$(this).removeClass("zhuce");
	});
	$(".input").mouseover(function(){
		$(this).addClass("zhuce");
	});
	$(".input").mouseout(function(){
		$(this).removeClass("zhuce");
	});
	$(".huanyizhang").mouseover(function(){
		$(this).addClass("chao");
	});
	$(".huanyizhang").mouseout(function(){
		$(this).removeClass("chao");
	});
	
	/*
	 * 得到所有的错误信息，循环遍历之。调用一个方法来确定是否显示错误信息！
	 */
	$(".error").each(function() {
		showError($(this));//遍历每个元素，使用每个元素来调用showError方法
	});
	
	/*
	 * 输入框得到焦点时隐藏错误信息
	 */
	$(".input1").focus(function() {
		var labelId = $(this).attr("id") + "Error";//通过输入框找到对应的label的id
		$("#" + labelId).text("");//把label的内容清空！
		showError($("#" + labelId));//隐藏没有信息的label
	});
	$(".input2").focus(function() {
		var labelId = $(this).attr("id") + "Error";//通过输入框找到对应的label的id
		$("#" + labelId).text("");//把label的内容清空！
		showError($("#" + labelId));//隐藏没有信息的label
	});
	$(".input3").focus(function() {
		var labelId = $(this).attr("id") + "Error";//通过输入框找到对应的label的id
		$("#" + labelId).text("");//把label的内容清空！
		showError($("#" + labelId));//隐藏没有信息的label
	});
	
	
	/*
	 * 输入框推动焦点时进行校验
	 */
	$(".input1").blur(function() {
		var inputName ="error"+ $(this).attr("id")+"()";
		eval(inputName);//执行函数调用
	});
	$(".input2").blur(function() {
		var inputName ="error"+ $(this).attr("id")+"()";
		eval(inputName);//执行函数调用
	});
	$(".input3").blur(function() {
		var inputName ="error"+ $(this).attr("id")+"()";
		eval(inputName);//执行函数调用
	});
	
});


/*
 * 登录名校验方法
 */
function errorloginname() {
	var id = "loginname";
	var value = $("#" + id).val();//获取输入框内容
	/*
	 * 1. 非空校验
	 */
	if(!value) {
		/*
		 * 获取对应的label
		 * 添加错误信息
		 * 显示label
		 */
		$("#" + id + "Error").text("用户名不能为空");
		showError($("#" + id + "Error"));
		return false;
	}
	
	/*
	 * 2. 长度校验
	 */
	if(value.length < 3 || value.length > 20) {
		/*
		 * 获取对应的label
		 * 添加错误信息
		 * 显示label
		 */
		$("#" + id + "Error").text("用户名长度必须在3 ~ 20之间");
		showError($("#" + id + "Error"));
		false;
	}
}

/*
 * Email校验方法
 */
function erroremail() {
	var id = "email";
	var value = $("#" + id).val();//获取输入框内容
	/*
	 * 1. 非空校验
	 */
	if(!value) {
		/*
		 * 获取对应的label
		 * 添加错误信息
		 * 显示label
		 */
		$("#" + id + "Error").text("Email不能为空");
		showError($("#" + id + "Error"));
		return false;
	}
	/*
	 * Email格式校验
	 */
	if(!/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/.test(value)) {
		/*
		 * 获取对应的label
		 * 添加错误信息
		 * 显示label
		 */
		$("#" + id + "Error").text("错误的Email格式");
		showError($("#" + id + "Error"));
		false;
	}
}

/*
 * 验证码校验方法
 */
function errorYzm() {
	var id = "Yzm";
	var value = $("#" + id).val();//获取输入框内容
	/*
	 * 非空校验
	 */
	if(!value) {
		/*
		 * 获取对应的label
		 * 添加错误信息
		 * 显示label
		 */
		$("#" + id + "Error").text("验证码不能为空");
		showError($("#" + id + "Error"));
		return false;
	}
	/*
	 * 长度校验
	 */
	if(value.length != 4) {
		/*
		 * 获取对应的label
		 * 添加错误信息
		 * 显示label
		 */
		$("#" + id + "Error").text("错误的验证码");
		showError($("#" + id + "Error"));
		false;
	}
	/*
	 * 是否正确
	 */
	$.ajax({
		url:"/bookwebs/SelectUserNameServlet",//要请求的servlet
		data:{method:"ajaxValidateVerifyCode",Yzm:value},//给服务器的参数
		type:"POST",
		dataType:"json",
		async:false,//是否异步请求，如果是异步，那么不会等服务器返回，我们这个函数就向下运行了。
		cache:false,
		success:function(result) {
			if(!result) {//如果校验失败
				$("#" + id + "Error").text("验证码错误！");
				showError($("#" + id + "Error"));
				return false;
			}
		}
	});
	return true;		
}

/*
 * 判断当前元素是否存在内容，如果存在显示，不页面不显示！
 */
function showError(ele) {
	var text = ele.text();//获取元素的内容
	if(!text) {//如果没有内容
		ele.css("display", "none");//隐藏元素
	} else {//如果有内容
		ele.css("display", "");//显示元素
	}
}

/*
 * 换一张验证码
 */
function _hyz() {
	/*
	 * 1. 获取<img>元素
	 * 2. 重新设置它的src
	 * 3. 使用毫秒来添加参数
	 */
	$("#imgsReplace").attr("src", "/bookwebs/ImageReplaceServlet?a=" + new Date().getTime());
}