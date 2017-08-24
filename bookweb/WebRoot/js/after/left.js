// 左边分类javascript代码
$(function(){
	$("li.typeli").click(function(){
		var str = $(this).next().attr("id");//获取当前li下一个标签的id属性
		var li = $(this).attr("id");//获取当前li的id属性
		var img = $("#"+li+">a").attr("id");//根据li的id属性获取下面子类的id属性
		if($("#"+str).css("display")=="none"){
			$("#"+str).slideDown("fast");//显示二级分类
			$("#"+img).html("<img src='book_img/xia6.png' />");//展开的图片
		}else{
			$("#"+str).slideUp("fast");//隐藏二级分类
			$("#"+img).html("<img src='book_img/right6.png' />");//收起的图片
		}
		//$("#"+li).addClass("currt");
		//$("#"+li).parent().siblings().slideUp("fast");
	});
	//siblings 同辈
	//鼠标进入分类菜单栏时样式
	$("li.typeli").hover(
		function(){
			$(this).css({"background-image":"url(book_img/blue1.png)","cursor":"pointer"});
		},
		function(){
			$(this).css("background-image","url(book_img/gray6.png)");
	});
	
	//鼠标进入图书信息时样式
	$(".twotype").hover(
			function(){
				$(this).css({"background-color":"#0f4679","cursor":"pointer"});
			},
			function(){
				$(this).css("background-color","#2aa8d9");
		});
	
	//左边菜单的边框样式
	$("li[id!='li0']").css("border-top","0px");
	
	//点击二级分类时点击对应的a标签
	$(".twotype").click(function(){
		var a = $(this).attr("id");
		var id = $("#"+a+">a").attr("id");
		document.getElementById(id).click();
	});
	
	//窗体加载时点击 欢迎页面
    function init(){
    	document.getElementById("imgw").click();
    }
    
});


