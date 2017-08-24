

$(function(){
	/*设置登录中的  input 标签获取焦点后 将边框设置为透明 */
	$(".input").focus(function(){
		$(this).css("outline","none");
	});
	
	/* 设置登录中的按钮 点击后 边框设置为透明 */
	$(".sub").hover(function(){
		$(this).css({"outline":"none","cursor":"pointer"});
	});
	
	//文本框失去焦点事件
	$("[name='adminname']").blur(function(){
		var adminname = $(this).val();
		if(adminname == "" || adminname == null){
			$("#error").text("帐号不能为空！");	
		}else{
			$("#error").text(".").css("color","#ffa");			
		}
	});
});

//点击显示忘记密码窗口
function fogetdiv(){
	$(".center").css("display","block");
}

//点击关闭忘记密码窗口
function closediv(){
	$(".center").css("display","none");
}

//第一步中的下一步按钮
function numberone(){
	var uname = $("[name='uname'").val();//获取用户名
	var idcard = $("[name='idcard'").val();//获取身份证号
	//判断用户名是否为空
	if(uname == "" || uname == ""){
		$(".unameerror").html("<font color='red' size='1'>用户名不能为空！</font>");
		return false;
	}else{
		$(".unameerror").html("");
	}
	
	
	//判断身份证号是否为空
	if(idcard == "" || idcard == ""){
		$(".idcarderror").html("<font color='red' size='1'>身份证号不能为空！</font>");
		return false;
	}else{
		$(".idcarderror").html("");
	}
	
	//身份证号
	var testNo = /^\d{17}[X,x,0-9]$/;
	var resultNo = testNo.test(idcard);
	if(resultNo==false){
		 $(".idcarderror").html("<font color='red' size='1'>身份证号输入错误！</font>");
		 return false;
	}

	//判断用户名是否存在
	$.get("../../AdminIsExistServlet","forgetname="+uname,function(data){
		$(".unameerror").html(data);
	});
	
	//判断用户名是否存在
	$.get("../../AdminIdcardIsExistServlet?forgetname="+uname,"forgetidcard="+idcard,function(data){
		$(".idcarderror").html(data);
	});
	
	
}

//返回按钮
function backclick(){
	$('#two').css('border-color','transparent transparent transparent #33FF33'); 
	$('.onetwo').css('background-color','#33FF33');  
	$('#one').css('border-color','transparent transparent transparent #00AA00'); 
	$('.oneone').css('background-color','#00AA00'); 
	$('.infoone').show(); 
	$('.infotwo').hide(); 
}

//重置密码的下一步按钮
function newpwdclick(){
	
	var pwd1 = $("[name=newpwd]").val();
	var pwd2 = $("[name=newpwd2]").val();
	
	if(pwd1 == null || pwd1 ==""){//判断新密码不能为空
		$(".pwderror").html("<font color='red' size='1'>新密码不能为空！</font>");
		return false;
	}else{
		$(".pwderror").html("");
	}
	
	if(pwd2 == null || pwd2 == ""){//判断
		$(".pwd1error").html("<font color='red' size='1'>确认新密码不能为空！</font>");
		return false;
	}else{
		$(".pwd1error").html("");
	}
	
	if(pwd1!=pwd2){//判断两次输入的密码是否一致
		$(".pwd1error").html("<font color='red' size='1'>两次输入的密码不一致！</font>");
		return false;
	}else{
		$(".pwd1error").html("");
	}
	
	if(pwd1.length<3){//判断两次输入的密码是否一致
		$(".pwderror").html("<font color='red' size='1'>长度必须是3-16位！</font>");
		return false;
	}else{
		$(".pwderror").html("");
	}
	
	if(pwd2.length<3){//判断两次输入的密码是否一致
		$(".pwd1error").html("<font color='red' size='1'>长度必须是3-16位！！</font>");
		return false;
	}else{
		$(".pwd1error").html("");
	}
	
	$.get("../../AdminForgetPwdServlet","pwd="+pwd1,function(data){
		$(".pwd1error").html(data);
	});
	/* $('#two').css('border-color','transparent transparent transparent #33FF33');  $('.onetwo').css('background-color','#33FF33');  $('#three').css('border-color','transparent transparent transparent #00AA00'); $('.onethree').css('background-color','#00AA00'); $('.infothree').show(); $('.infotwo').hide();*/
}





