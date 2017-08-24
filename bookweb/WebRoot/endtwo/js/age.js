$(function(){
	//$("#color").text("<li id=\"blue\" onclick=\"colorclick(this)\" style=\"background-color:blue;padding:10px;width:80px;color:#fff;list-style:none;\">蓝色</li><li id=\"red\" onclick=\"colorclick(this)\" style=\"background-color:red;padding:10px;width:80px;color:#fff;list-style:none;\">红色</li><li id=\"gray\" onclick=\"colorclick(this)\" style=\"background-color:gray;padding:10px;width:80px;color:#fff;list-style:none;\">灰色</li><li id=\"yellow\" onclick=\"colorclick(this)\" style=\"background-color:yellow;padding:10px;width:80px;color:#fff;list-style:none;\">黄色</li><li id=\"#000\" onclick=\"colorclick(this)\" style=\"background-color:#000;padding:10px;width:80px;color:#fff;list-style:none;\">黑色</li><li id=\"green\" onclick=\"colorclick(this)\" style=\"background-color:green;padding:10px;width:80px;color:#fff;list-style:none;\">绿色</li><li id=\"#4B0082\" onclick=\"colorclick(this)\" style=\"background-color:#4B0082;padding:10px;width:80px;color:#fff;list-style:none;\">紫色</li><li id=\"#D87093 \" onclick=\"colorclick(this)\" style=\"background-color:#D87093 ;padding:10px;width:80px;color:#fff;list-style:none;\">粉红</li><li id=\"#fff\" onclick=\"colorclick(this)\" style=\"background-color:#fff;padding:10px;width:80px;color:#000;list-style:none;\">白色</li><li id=\"#FFD700\" onclick=\"colorclick(this)\" style=\"background-color:#FFD700;padding:10px;width:80px;color:#fff;list-style:none;\">金黄</li>"):
	var scores = new Array("语文","数学","英语");
	
 	var sum = 0.0;//总成绩
 	var con = false;//判断是否输入有误，默认无误
 	for(var i = 0;i<scores.length;i++){
 		var score = prompt("请输入"+scores[i]+"成绩","");
 		if(parseFloat(score)<0 || isNaN(score)){//判断输入的是否是数字和是否是负数
			con=true;
			break;
		}
 		sum += parseFloat(score);//计算总成绩
 	}
 	if(con){
		alert("输入不正确、请重新输入！");
	}
	else{
		var age = sum/scores.length;//平均成绩
	 	if(age>=90){
	 		alert("成绩为：A等级。");
	 	}else if(age>=80){
	 		alert("成绩为：B等级。");
	 	}else if(age>=70){
	 		alert("成绩为：C等级。");
	 	}else if(age>=60){
	 		alert("成绩为：D等级。");
	 	}else if(age<60){
	 		alert("成绩为：E等级。");
	 	}
	}
 	
 	
});

/*$(function(){
	alert("aaa");
});*/


