$(function() {
	$("#tabs").tabs({
		active:1,
		collapsible:true,
		activate:function(event,ui) {
			alert("触发activate事件！");
		}
	});
});