
//进入图书信息边框样式
var d = "";//存储div的id值
var t = "";//存储table的id值
$(function(){
	$(".boxi>div").hover(
			function(){
				d = $(this).attr("id");
				t = $("#"+d+">table").attr("id");
				$("#"+t).css("border","2px solid gray");
			},
			function(){
				t = $("#"+d+">table").attr("id");
				$("#"+t).css("border","2px solid #f9f9f9");
		});
});
	
//获取页面的高度 
$(window.parent.document).find("#iframeId").load(function () {
    var main = $(window.parent.document).find("#iframeId");
    var thisheight = $(document).height() + 30;
    main.height(thisheight);
});



