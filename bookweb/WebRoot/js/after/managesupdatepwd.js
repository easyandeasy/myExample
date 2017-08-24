var msg ;
$(function(){
	msg = setInterval("adminmsg()", 9000);
});

//关闭消息提示框
function adminmsg(){
	$(".adminjavascript").slideUp();
}

//点击修改密码确定按钮
function updatepwd(){
	var olderpwd = $("[name=olderpwd]").val();
	var newpwd1 = $("[name=newpwd1]").val();
	var newpwd2 = $("[name=newpwd2]").val();
	
	//判断旧密码是否为空
	if(olderpwd == null || olderpwd == ""){
		$(".adminjavascript").html("旧密码不能为空！");
		$(".adminjavascript").slideDown();
		clearInterval(msg);
		msg = setInterval("adminmsg()", 6000);
		return false;
	}
	//判断新密码1是否为空
	if(newpwd1 == null || newpwd1 == ""){
		$(".adminjavascript").html("新密码不能为空！");
		$(".adminjavascript").slideDown();
		clearInterval(msg);
		msg = setInterval("adminmsg()", 6000);
		return false;
	}
	
	//判断新密码2是否为空
	if(newpwd2 == null || newpwd2 == ""){
		$(".adminjavascript").html("确认新密码不能为空！");
		$(".adminjavascript").slideDown();
		clearInterval(msg);
		msg = setInterval("adminmsg()", 6000);
		return false;
	}
	
	//判断新密码两次输入是否一致
	if(newpwd2 != newpwd1){
		$(".adminjavascript").html("两次输入不一致！");
		$(".adminjavascript").slideDown();
		clearInterval(msg);
		msg = setInterval("adminmsg()", 6000);
		return false;
	}
	
	//判断新密码的长度
	if(newpwd2.length<3 || newpwd1.length<3 ){
		$(".adminjavascript").html("密码长度为3~16位！");
		$(".adminjavascript").slideDown();
		clearInterval(msg);
		msg = setInterval("adminmsg()", 6000);
		return false;
	}
	
	$.get("../../AdminPwdIsExistServlet?newpwd="+newpwd1,"olderpwd="+olderpwd,function(data){
		$(".adminjavascript").html(data);
		clearInterval(msg);
		msg = setInterval("adminmsg()", 6000);
	});
}