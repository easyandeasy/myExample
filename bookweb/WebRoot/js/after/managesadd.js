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
	var adminname = $("[name=adminname]").val();
	var newpwd1 = $("[name=adminpwd]").val();
	var newpwd2 = $("[name=adminpwd]").val();
	var idcard = $("[name=adminidcard]").val();
	var context = $("[name=admincontext]").val();
	
	
	//判断旧密码是否为空
	if(adminname == null || adminname == ""){
		$(".adminjavascript").html("帐号不能为空！");
		$(".adminjavascript").slideDown();
		clearInterval(msg);
		msg = setInterval("adminmsg()", 6000);
		return false;
	}
	//判断新密码1是否为空
	if(newpwd1 == null || newpwd1 == ""){
		$(".adminjavascript").html("密码不能为空！");
		$(".adminjavascript").slideDown();
		clearInterval(msg);
		msg = setInterval("adminmsg()", 6000);
		return false;
	}
	
	//判断新密码2是否为空
	if(newpwd2 == null || newpwd2 == ""){
		$(".adminjavascript").html("确认密码不能为空！");
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
	
	//判断身份证号是否为空
	if(idcard == null || idcard == ""){
		$(".adminjavascript").html("身份证号不能为空！");
		$(".adminjavascript").slideDown();
		clearInterval(msg);
		msg = setInterval("adminmsg()", 6000);
		return false;
	}
	
	
	//身份证号
	var testNo = /^\d{17}[X,x,0-9]$/;
	var resultNo = testNo.test(idcard);
	if(resultNo==false){
		 $(".adminjavascript").html("身份证号输入错误！");
		 $(".adminjavascript").slideDown();
		 clearInterval(msg); msg = setInterval("adminmsg()", 6000);
		 return false;
	}
	
	$.get("../../AddAdminInfoServlet?iname="+adminname+"&ipwd="+newpwd1+"&iid="+idcard,"icontext="+context,function(data){
		$(".adminjavascript").html(data);
		$(".adminjavascript").slideDown();
		clearInterval(msg); 
		msg = setInterval("adminmsg()", 6000);
	});
}