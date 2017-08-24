var low ;
$(function(){
	$("[class^='info']").css({"width":"1020px","border":"1px solid #f9f9f9"});
	 var origLength;
	  origLength = document.all.length;
	  for(i=0;i<origLength;i++){
		  //alert();
	     if(document.all[i].name != null){
	    	 document.all[i].disabled=true;
	    	
	    	if(document.all[i].name=="like" || document.all[i].name=="userbtn" ){
	    		 document.all[i].disabled=false;
	    	 }
	     }
	  }
	  $("[name='like']").css({"background-color":"#fff","text-align":"left","border":"1px solid gray"});
	  $("[name='userbtn']").css({"background-color":"#ccc","text-align":"center","border":"1px solid #ccc","color":"#fff"});
	  
	 low = setInterval("up()", 6000);
});

//点击查询按钮
function selectuserclick(){
	var uname = $("#selectuservalue").val();
	if(uname==""){
		return false;
	}
	location.href="../../SelectUserInfoServlet?userindex=1&uname="+uname;
}

//关闭消息提示框
function up(){
	  $(".javascripttext").slideUp();
}

//点击修改按钮
function updateclick(e){
	var id = $(e).attr("id");
	var text = $(e).text();
	if(text=="修改"){
		 var origLength;
		  origLength = document.all.length;
		  for(i=0;i<origLength;i++){
		     if(document.all[i].name != null){
		    	if(document.all[i].name ==id ){
		    		 document.all[i].disabled=false;
		    		// alert(document.all[i].id);
		    		 if(document.all[i].id == "uid"){
		    			 document.all[i].disabled=true;
		    		 }
		    	 }
		     }
		  }
		  $("[name='"+id+"']").css({"background-color":"#fff","text-align":"left","border":"1px solid gray"});
		  $("[id='uid']").css({"background-color":"#f9f9f9","text-align":"center","border":"1px solid #f9f9f9"});
		  $(e).html("<img src=\"../../book_img/dui.png\" />确定");
	}else{
		var uname = "";//用户名
		var unickname = "";//昵称
		var uphone = "";//联系电话
		var email = "";//邮箱
		var uidcard = "";//身份证号
		var uindate = "";//注册时间
		var ustatus = "";//状态
		var flag = false;//判断是否输入正确
		var origLength;
		  origLength = document.all.length;
		  for(i=0;i<origLength;i++){
		     if(document.all[i].name != null){
		    	if(document.all[i].name ==id ){
		    		 document.all[i].disabled=true;
		    		 var value = document.all[i].id;
		    		 if(value=="uname"){//用户名
		    			 uname = document.all[i].value;
		    		 }
		    		 if(value=="unickname"){//昵称
		    			 unickname = document.all[i].value;
		    		 }
		    		 if(value=="uphone"){//联系电话
		    			 uphone = document.all[i].value;
		    		 }
		    		 if(value=="email"){//邮箱
		    			 email = document.all[i].value;
		    		 }
		    		 if(value=="uidcard"){//身份证号
		    			 uidcard = document.all[i].value;
		    		 }
		    		 if(value=="uindate"){//注册时间
		    			 uindate = document.all[i].value;
		    		 }
		    		 if(value=="ustatus"){//状态
		    			 ustatus = document.all[i].value;
		    		 }
		    	 }
		     }
		  }
		  if(uname==""){//判断用户名是否为空
			  $(".javascripttext").html("用户名不能为空！");
			  $(".javascripttext").slideDown();
			  clearInterval(low);
			  flag = true;
		  }
		  //电话号码
			var testTell = /^1\d{10}$/;
			var resultTell = testTell.test(uphone);
			if(resultTell==false){
				 $(".javascripttext").html("联系电话输入有误！");
				 $(".javascripttext").slideDown();
				 clearInterval(low);
				 flag = true;
			}
			//电子邮箱
			var testEmail = /^\w+@\w+(\.[a-zA-Z]{2,3}){1,2}$/;
			var resultEmail = testEmail.test(email);
			if(resultEmail==false){
				 $(".javascripttext").html("邮箱格式不正确！");
				 $(".javascripttext").slideDown();
				 clearInterval(low);
				 flag = true;
			}
			
			//身份证号
			var testNo = /^\d{17}[X,x,0-9]$/;
			var resultNo = testNo.test(uidcard);
			if(resultNo==false){
				 $(".javascripttext").html("身份证输入错误！");
				 $(".javascripttext").slideDown();
				 clearInterval(low);
				 flag = true;
			}
		  
			
		  if(flag){
			  for(i=0;i<origLength;i++){
				     if(document.all[i].name != null){
				    	if(document.all[i].name ==id ){
				    		 document.all[i].disabled=false;
				    	 }
				     }
				  }
			  low = setInterval("up()", 9000); 
			  return false;
		  }
		 
		  $.get("../../UpdateUserInfoServlet?uname="+uname+"&unickname="+unickname+"&uphone="+uphone+"&email="+email+"&uidcard="+uidcard+"&uindate="+uindate+"&ustatus="+ustatus,"uid="+id,function(data){
			  $(".javascripttext").html(data);
			  $(".javascripttext").slideDown();
		  });
		$(e).html("<img src=\"../../book_img/update.png\" />修改");
		$("[name='"+id+"']").css({"background-color":"#f9f9f9","text-align":"center","border":"1px solid #f9f9f9"});
		text = "";
	}
}



//选择状态下拉框查询用户信息
function changestatus(e){
	var value = $(e).val();
	if(value=="0"){
		return false;
	}
	location.href="../../SelectUserInfoServlet?userindex=1&statusindex="+value;
}


//删除用户
function deleteuserclick(e){
	var id = $(e).attr("id");
	var flag = confirm("确定要删除该用户吗？");
	if(flag){
		$.get("../../DeleteUserInfoSerlvet","id="+id,function(data){
			$(".javascripttext").html(data);
		})
	}
}






