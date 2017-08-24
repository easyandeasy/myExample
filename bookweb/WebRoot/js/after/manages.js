var msg ;
$(function(){
	msg = setInterval("adminmsg()", 9000);
});
//窗体加载时禁用管理员文本框
function adminselect(){
  var origLength;
  origLength = document.all.length;
  for(i=0;i<origLength;i++){
     if(document.all[i].name != null){
    	 document.all[i].disabled=true;
    	if(document.all[i].name=="adminbtn"){
    		 document.all[i].disabled=false;
    	 }
     }
  }
}

//关闭消息提示框
function adminmsg(){
	$(".adminjavascript").slideUp();
}


//点击修改按钮
function updateadmin(e){
	var value = $(e).val();
	if(value=="修改"){
		 var origLength;
		  origLength = document.all.length;
		  for(i=0;i<origLength;i++){
		     if(document.all[i].name != null){
		    	 document.all[i].disabled=false;
		     }
		  }
		  $(".admintext").css({"background-color":"#f0f0f0","border":"1px solid gray"});
		  $(".textarea").css({"background-color":"#f0f0f0","border":"1px solid gray"});
		  
		  $(e).val("确定");
	}else{
	  var name = $("[name=adminname]").val();
	  var idcard = $("[name=adminidcard]").val();
	  var context = $("[name=admincontext]").val();
	 
	  $.get("../../AdminAddUpdateServlet?aidcard="+idcard+"&acontext="+context+"&admintype=update","aname="+name,function(data){
		 $(".adminjavascript").html(data); 
		 $(".adminjavascript").slideDown();
	});
		
	  var origLength;
	  origLength = document.all.length;
	  for(i=0;i<origLength;i++){
	     if(document.all[i].name != null){
	    	 document.all[i].disabled=true;
	    	if(document.all[i].name=="adminbtn"){
	    		 document.all[i].disabled=false;
	    	 }
	     }
	  }
	  $(".admintext").css({"background-color":"#f9f9f9","border":"0px solid gray"});
	  $(".textarea").css({"background-color":"#f9f9f9","border":"0px solid gray"});
	  $(e).val("修改");
	}
	
}




