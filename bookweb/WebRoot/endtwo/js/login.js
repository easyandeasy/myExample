//创建一个登录层
$(function(){
	var str = "";
	for(var i = 0;i<10;i++){
		var random = (Math.random()*999999+100000);
		var sub = random.toString().substring(0, 6);
		str = str + "  <li id='"+sub+"' onclick='colorclick(this)' style='background-color:"+sub+";padding:10px;width:80px;color:#fff;list-style:none;'>#"+sub+"</li> ";
	}
	$(".login").html(str);
});
//$(".login").html("   <li id='"+sbu+"' onclick='colorclick(this)' style='background-color:"+sbu+";padding:10px;width:80px;color:#fff;list-style:none;'>#"+sbu+"</li>");
//<li id='red' onclick='colorclick(this)' style='background-color:red;padding:10px;width:80px;color:#fff;list-style:none;'>红色</li><li id='gray' onclick='colorclick(this)' style='background-color:gray;padding:10px;width:80px;color:#fff;list-style:none;'>灰色</li><li id='yellow' onclick='colorclick(this)' style='background-color:yellow;padding:10px;width:80px;color:#fff;list-style:none;'>黄色</li><li id='#000' onclick='colorclick(this)' style='background-color:#000;padding:10px;width:80px;color:#fff;list-style:none;'>黑色</li><li id='green' onclick='colorclick(this)' style='background-color:green;padding:10px;width:80px;color:#fff;list-style:none;\">绿色</li><li id='#4B0082' onclick='colorclick(this)' style='background-color:#4B0082;padding:10px;width:80px;color:#fff;list-style:none;'>紫色</li><li id='#D87093' onclick='colorclick(this)' style='background-color:#D87093 ;padding:10px;width:80px;color:#fff;list-style:none;'>粉红</li><li id='#fff' onclick='colorclick(this)' style='background-color:#fff;padding:10px;width:80px;color:#000;list-style:none;'>白色</li><li id='#FFD700' onclick='colorclick(this)' style='background-color:#FFD700;padding:10px;width:80px;color:#fff;list-style:none;'>金黄</li>
//用户名:<input type='text' name='loginname'/><br/><br/>密&nbsp;码:<input type='password' name='pwd' /><br/><br/>&nbsp;&nbsp;<input type='button' name='logingtn' onclick='login()' value='登录'/>&nbsp;&nbsp;<input type='button' name='close' onclick='closelogin()' value='关闭' /> <br/><br/>
//$("#color").html(" <li id='blue' onclick='colorclick(this)' style='background-color:blue;padding:10px;width:80px;color:#fff;list-style:none;'>蓝色</li>"):
//<li id='red' onclick='colorclick(this)' style='background-color:red;padding:10px;width:80px;color:#fff;list-style:none;'>红色</li><li id='gray' onclick='colorclick(this)' style='background-color:gray;padding:10px;width:80px;color:#fff;list-style:none;'>灰色</li><li id='yellow' onclick='colorclick(this)' style='background-color:yellow;padding:10px;width:80px;color:#fff;list-style:none;'>黄色</li><li id='#000' onclick='colorclick(this)' style='background-color:#000;padding:10px;width:80px;color:#fff;list-style:none;'>黑色</li><li id='green' onclick='colorclick(this)' style='background-color:green;padding:10px;width:80px;color:#fff;list-style:none;\">绿色</li><li id='#4B0082' onclick='colorclick(this)' style='background-color:#4B0082;padding:10px;width:80px;color:#fff;list-style:none;'>紫色</li><li id='#D87093' onclick='colorclick(this)' style='background-color:#D87093 ;padding:10px;width:80px;color:#fff;list-style:none;'>粉红</li><li id='#fff' onclick='colorclick(this)\" style=\"background-color:#fff;padding:10px;width:80px;color:#000;list-style:none;'>白色</li><li id='#FFD700' onclick='colorclick(this)' style='background-color:#FFD700;padding:10px;width:80px;color:#fff;list-style:none;'>金黄</li>	

//弹出登录信息
function login(){
	var name = $("[name='loginname']").val();
	var pwd = $("[name='pwd']").val();
	if(name == null || name == ""){
		alert("请输入用户名！");
		$("[name='loginname']").focus();
		return false;
	}
	if(pwd == null || pwd == ""){
		alert("请输入密码！");
		$("[name='pwd']").focus();
		return false;
	}
	
	alert("用户名："+name+"\n密   码；"+pwd);
}

//关闭登录层
function closelogin(){
	$(".login").css("display","none");
}


function colorclick(e){
	var id = $(e).attr("id");
	$("body").css("background-color","#"+id);
}