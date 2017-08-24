$(function(){
	
	//文本框获取焦点样式
	$(".text").focus(function(){
		$(this).css("box-shadow","0 0 4px red");
		
	});
	//文本杠失去焦点样式
	$(".text").blur(function(){
		$(this).css("box-shadow","0 0 0px red");
	});
	
	
	//搜索出来的内容鼠标进入样式
	$(".sousuo").hover(function(){
		$(this).css({"background":"url(../../book_img/blue.png) no-repeat 0 -5px","cursor":"pointer"});
	},
	function(){
		$(this).css("background","url(../../book_img/red.png) no-repeat 0 -5px");
	});
	
	//键盘按下  enter 键
	 $(document).on('keyup',function(e){
         if(e.keyCode == 13){
             document.getElementById("sousuo").click();
         }
   });
	
});

//ajax事件 显示和隐藏 模糊查询的结果
function find(name){
	var bname = name.value;
	if(bname.length>0){
		$.get("../../SelectsBookServlet","bname="+bname,function(data){
			$(".find").html(data);
			$(".find").slideDown("fast");
		});
	}else{
		$(".find").slideUp("fast");
	}
}


//模糊查询出来的结果点击事件
function selectclick(e){
	var div = $(e).attr("id");
	var a = $("#"+div+">a").attr("id");
	document.getElementById(a).click();
	$(".find").slideUp("fast");
}


//点击搜索按钮 跳转链接
function sousuoclick(e){
	var value = $(".text").val();
	location.href="../../SelectBookInfoLike?index=1&bname="+value;
	
}
