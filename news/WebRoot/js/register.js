//╪сть
$(function(){
	$("[name='userName']").blur(function(){
		var name = $(this).val();
		$.get("../RegisterServlet","userName="+name,function(data){
			$("[name='userName']").next().html(data);
		});
	});
});