
//查看订单详细信息
function ordersinfo(e){
	var onumber = $(e).attr("id");//订单编号
	$(window.parent.document).find("#orderinfovalue").val(onumber);
	$(window.parent.document).find("#selectorderinfo").click();
}

//点击发货
function clickgo(){
	document.getElementById("ordergo").click();
}

function orderonumberselect(){
	var onumber = $("#orderonumbervalue").val();
	location.href = "../../OrderInfoServlet?onumber="+onumber;
}