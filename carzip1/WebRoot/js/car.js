$(function(){
	alert("aa");
	$.ajax("car!carInfo",function(data){
			alert(data);
		}
	);
});