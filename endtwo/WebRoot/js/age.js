$(function(){
	alert("sss");
	var scores = new Array("语文","数学","英语");
 	var sum = 0.0;
 	for(var i = 0;i<score.length;i++){
 		var score = confirm("请输入"+scores[i]+"成绩","");
 		sum += parseFloat(score);
 	}
 	alert(sum);
});