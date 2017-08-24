var low ;
$(function(){
	$("[class^='info']").css({"width":"1020px","border":"1px solid #f9f9f9"});
	 var origLength;
	  origLength = document.all.length;
	  for(i=0;i<origLength;i++){
		  //alert();
	     if(document.all[i].name != null){
	    	 document.all[i].disabled=true;
	    	if(document.all[i].name=="like" || document.all[i].name=="adminbtn" ){
	    		 document.all[i].disabled=false;
	    	 }
	     }
	  }
	  $("[name='like']").css({"background-color":"#fff","text-align":"left","border":"1px solid gray"});
	  $("[name='adminbtn']").css({"background-color":"#ccc","text-align":"center","border":"1px solid #ccc","color":"#fff"});

	 low = setInterval("up()", 6000);
});

//点击查询按钮
function selectadminclick(){
	var uname = $("#selectadminvalue").val();
	if(uname==""){
		return false;
	}
	location.href="../../SelectAdminInfoServlet?adminindex=1&adminname="+uname;
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
		    		 if(document.all[i].id == "adminid"){
		    			 document.all[i].disabled=true;
		    		 }
		    	 }
		     }
		  }
		  $("[name='"+id+"']").css({"background-color":"#fff","text-align":"left","border":"1px solid gray"});
		  $("[id='adminid']").css({"background-color":"#f9f9f9","text-align":"center","border":"1px solid #f9f9f9"});
		  $(e).html("<img src=\"../../book_img/dui.png\" />确定");
	}else{
		var adminname = "";//帐号
		var adminpwd = "";//密码
		var adminidcard = "";//身份证号
		var admincontext = "";//备注
		
		var flag = false;//判断是否输入正确
		var origLength;
		  origLength = document.all.length;
		  for(i=0;i<origLength;i++){
		     if(document.all[i].name != null){
		    	if(document.all[i].name ==id ){
		    		 document.all[i].disabled=true;
		    		 var value = document.all[i].id;
		    		 if(value=="adminname"){//帐号
		    			 adminname = document.all[i].value;
		    		 }
		    		 if(value=="adminpwd"){//密码
		    			 adminpwd = document.all[i].value;
		    		 }
		    		 if(value=="adminidcard"){//身份证号
		    			 adminidcard = document.all[i].value;
		    		 }
		    		 if(value=="admincontext"){//备注
		    			 admincontext = document.all[i].value;
		    		 }
		    	 }
		     }
		  }
		  
		  if(adminname==""){//判断用户名是否为空
			  $(".javascripttext").html("帐号不能为空！");
			  $(".javascripttext").slideDown();
			  clearInterval(low);
				flag = true;
		  }
		  
		  //密码不能为空
		  if(adminpwd == null || adminpwd == ""){
				$(".javascripttext").html("密码不能为空！");
				$(".javascripttext").slideDown();
				  clearInterval(low);
					flag = true;
			}
		
		  //判断新密码的长度
			if(adminpwd.length<3){
				$(".javascripttext").html("密码长度为3~16位！");
				$(".javascripttext").slideDown();
				 clearInterval(low);
					flag = true;
			}
			
			//判断身份证号是否为空
			if(adminidcard == null || adminidcard == ""){
				$(".javascripttext").html("身份证号不能为空！");
				$(".javascripttext").slideDown();
				 clearInterval(low);
				flag = true;
			}
			
		  
			//身份证号
			var testNo = /^\d{17}[X,x,0-9]$/;
			var resultNo = testNo.test(adminidcard);
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
		 
		  $.get("../../UpdateAdminInfoServlet?aname="+adminname+"&apwd="+adminpwd+"&aidcard="+adminidcard+"&acontext="+admincontext,"adminid="+id,function(data){
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
	location.href="../../?userindex=1&statusindex="+value;
}


//删除用户
function deleteadminclick(e){
	var id = $(e).attr("id");
	var flag = confirm("确定要删除该用户吗？");
	if(flag){
		$.get("../../DeleteAdminInfoServlet","id="+id,function(data){
			$(".javascripttext").html(data);
			$(".javascripttext").slideDown();
		});
	}
}





/*//电话号码
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
}*/



