$(function(){
	alert("aaa");
	$(".color").html("<li style='background-color:blue;width:80px;height:40px;'>蓝色</li>"):
});

function colorclick(e){
	var id = $(e).attr("id");
	$("body").css("background-color",id);
}