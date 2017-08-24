$(function(){
	
});

function ajaxOrder(e){
		var id=$(e).attr("id");
		var clas=$(e).attr("class");
		var address = $("#address").val();
		if(address=="" || address == null){
			$("#errorAddressNull").text(" 请输入收货地址！");
			return false;
		}
		$.get("UserOrderBuyBookServlet?unickName="+id+"&total="+clas+"&address="+address,"",function(data){
			$('.orderid').html(data);
			$('.errorAddressNull').html(data);
			$(".box-1-buy-info").css("display","none");
			$(".box-2-buy-info").css("display","none");
			$(".tab-group").css("border-left","solid 1px #eee");
			$(".top-box-3").css("display","block");
		});
};

function orderInfo(e){
	var unickName = $(e).attr("class");
	$.get("SelectUserBuyBookServlet","unickname="+unickName,function(date){
		$(".box-httbox").html(date);
	});
}