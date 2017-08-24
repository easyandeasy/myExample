

// div弹窗
function locking(){  
	$(window.parent.document).find("#newwindow").click();  
  }  

//根据输入的类型名称
function findbooktype(){
	var typename = document.getElementById("typename").value;
	if(typename==""){
		 return false;
	}
	$.get("../../BookTypeFindServlet","tname="+typename,function(data){
		$("#typeshow1").html(data);
	});
}

//根据选择的类型查询
function findbooktype2(){
	var typename = $(".selectone").val();
	if(typename=="0"){
		 return false;
	}
	$.get("../../BookTypeFindServlet","tname="+typename,function(data){
		$("#typeshow1").html(data);
	});
}


//点击删除分类
function typeclickdelete(e){
	var tid = $(e).attr("id");
	var flag = confirm("确定要删除该类型吗？");
	if(flag){
		$.get("../../BookTypeDeleteServlet","tid="+tid,function(data){
			$(".txt").html(data);
			//window.location=window.location;
		});
	}
}

//点击删除大类
function typeclickbigdelete(){
	var tid = $("#bigtype").val();
	if(tid=="0"){
		return false;
	}
	var flag = confirm("确定要删除该类型吗？");
	if(flag){
		$.get("../../DeletebigBookTypeServlet","tid="+tid,function(data){
			$(".txt").html(data);
			//window.location=window.location;
		});
	}
}

//点击修改大类
function typeclickupdate2(){
	var value = $("#bigtype").val();
	if(value=="0"){
		alert("请选择要修改的类型！");
		return false;
	}
	document.getElementById("bigtype").disabled=true;
	$(".typehiddle").css("display","block");
	$(".updatebtn3").html("<img src=\"../../book_img/dui.png\" onclick=\"updatebtn()\" />");
}

//确定修改
function updatebtn(){
	var value = $("#bigtype").val();
	var tname = $(".typehiddle").val();
	if(tname=="" || tname==null){
		$("#typetext1").html("<font size=\"1\" color=\"red\">类型不能为空！</font>");
		return false;
	}
	//判断类型名称是否存在
	var flag ;
	var t2 = document.getElementById("bigtype");
	var selectValue2=t2.options;//获取大类型 option的值
	for(i=0;i<selectValue2.length;i++){
		//alert(selectValue2[i].text);
		if(selectValue2[i].text==tname){
			$("#typetext1").html("<font size=\"1\" color=\"red\">类型已存在！</font>");
			flag = true;
			break;
		}
	}
	if(flag){//为true说明存在，结束
		return false;
	}
	
	//执行添加操作
	$.get("../../UpdateBookTypeServlet?tname="+tname,"tid="+value,function(date){
		//window.opener.location.reload();
		alert("修改成功！");
		window.location=window.location; 
		//$(".txt").html(data);
		//history.go(0);
	});
}


//给修改的弹窗赋值修改前的值
function updatesmallbtn(e){
	var pid = $(e).attr("name");//pid
	var tid = $(e).attr("id");//tid
	var tname = $(e).attr("class");//tname
	var tcontext = $("#hidden3").val();//tcontext
	$(window.parent.document).find("#newwindow3").click();  
	$(window.parent.document).find("#updatetid3").val(tid); 
	$(window.parent.document).find("#updatepid3").val(pid); 
	$(window.parent.document).find("#updatetname3").val(tname); 
	$(window.parent.document).find("#updatetcontext3").val(tcontext); 
	$(window.parent.document).find(".typeinfo").click();  
}
































