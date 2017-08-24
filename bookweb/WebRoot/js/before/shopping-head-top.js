$(function(){
	$(".box-type-2").hover(function(){
		$(".box-book-type-1").slideDown(250);
	},function(){
		$(".box-book-type-1").hide();
	});
	$(".box-book-type-1").hover(function(){
		$(this).show();
	}, function(){
		$(this).slideUp(250);
	});
	
	$(".a-2").hover(function(){
		$(".box-user-1").slideDown();
		$(".span-user").slideDown();
	});
	
	$(".box-user-1").hover(function(){
		$(this).show();
		$(".span-user").show();
	},function(){
		$(this).slideUp();
		$(".span-user").slideUp();
	});
	
	$(".input-1").focus(function(){
		$(this).addClass("addjs");
	});
	$(".input-1").blur(function(){
		$(this).removeClass("addjs");
	});
});