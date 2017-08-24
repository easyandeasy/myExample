//判断浏览器是否支持FileReader接口
    if (typeof FileReader == 'undefined') {
        document.getElementById("xmTanDiv").InnerHTML = "<h1>当前浏览器不支持FileReader接口</h1>";
        //使选择控件不可操作
        document.getElementById("bigFileImg").setAttribute("disabled", "disabled");
    }

    //选择大图片，马上预览
    function bigUploadImg(obj) {
        var file = obj.files[0];               
        console.log(obj);
        console.log(file);
        console.log("file.size = " + file.size);  //file.size 单位为byte
        var reader = new FileReader();
        reader.onload = function (e) {
            var img = document.getElementById("bigImg");
            img.src = e.target.result;
            //img.src = this.result;  
            //e.target == this
        };
        reader.readAsDataURL(file);
    };
  
  //点击添加图片按钮
  function addclick(){
	  document.getElementById("bigFileImg").click();
  }


 //鼠标进入提交按钮时添加样式 
  $(function(){
	  $(".button").hover(
		function(){
			$(this).addClass("btn");
		},function(){
			$(this).removeClass("btn");
		});
  });
  
  //添加图书中的类型下拉框的值改变事件
  function changtype(){
	  var value = $(".selectone").val();
	  $.get("../../AddBookServlet","value="+value,function(data){
		  $(".selecttwo").html(data);
	  });
  }
  
/*  
  //修改图书中的类型下拉框的值改变事件
  function changtype1(){
	  var value = $(".selectone").val();
	  alert(value);
	  $.get("../../UpdateBookTypeServlet","updatetypevalue="+value,function(data){
		  alert(value);
		  $(".selecttwo").html(data);
	  });
  }*/


  //只能输入数字和两位小数
  function num(obj){
	  //清除“数字” 和 “ 。 ”以外的字符
	  obj.value = obj.value.replace(/[^\d.]/g,'');
	  //验证第一个字符是数字
	  obj.value = obj.value.replace(/^\./g,'');
	  //只保留第一个，清除多余的
	  obj.value = obj.value.replace(/\.{2,}/g,'.');
	  
	  obj.value = obj.value.replace(".","$#$").replace(/\./g,'').replace("$#$",".");
	  //只以输入两个小数
	  obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/,'$1$2.$3');
  }
	  

  
  
  
  
  
  //给编辑图书中的类型赋值
  function onloadone(){
		var type1 = document.getElementById("type1").value;
		var type2 = document.getElementById("type2").value;
		var t = document.getElementById("selectone");
		var selectValue=t.options;//获取大类型 option的值
		var value;
		for(i=0;i<selectValue.length;i++){
			if(selectValue[i].text==type1){
				value = selectValue[i].value;
				selectValue[i].selected = true;
				break;
			}
		}
		
		 $.get("../../AddBookServlet","value="+value,function(data){
			  $("#selecttwo").html(data);
				var t2 = document.getElementById("selecttwo");
				var selectValue2=t2.options;//获取大类型 option的值
				for(i=0;i<selectValue2.length;i++){
					//alert(selectValue2[i].value);
					if(selectValue2[i].text==type2){
						selectValue2[i].selected = true;
						break;
					}
				}
				  var origLength;
				  origLength = document.all.length;
				  for(i=0;i<origLength;i++){
					  //alert();
				     if(document.all[i].name != null){
				    	 document.all[i].disabled=true;
				    	 if(document.all[i].name=="checkbox"){
				    		 document.all[i].disabled=false;
				    	 }
				     }
				  }
		  });
		
	};
		
  
  //点击编辑
	function checkboxclick(){
		var flag = document.getElementById("checkbox").checked;
		var origLength;
		if(flag){
			  origLength = document.all.length;
			  for(i=0;i<origLength;i++){
			     if(document.all[i].name != null){
			    	 document.all[i].disabled=false;
			    	 if(document.all[i].name=="checkbox"){
			    		 document.all[i].disabled=false;
			    	 }
			     }
			  }
		}else{
			 origLength = document.all.length;
			  for(i=0;i<origLength;i++){
			     if(document.all[i].name != null){
			    	 document.all[i].disabled=true;
			    	 if(document.all[i].name=="checkbox"){
			    		 document.all[i].disabled=false;
			    	 }
			     }
			  }
		}
	}
  
  
  //点击悠事件
  function btntypeclick(e){
	  var id = e.name;
	  var flag = confirm("确定要删除吗！");
	  if(flag){
		document.getElementById(id).click();
	  }
  }
  
  
  function hlframeclick(e){
	  var hlframe = $(e).attr("id");//图书编号
	  var text = $(e).text();//上下架文本
	   $.get("../../UpdateBookHlframeServlet?text="+text,"hlframe="+hlframe,function(data){
		  $(".data").html(data);
	   });
  }
  
  

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
	//图书名称失去焦点
	/* $(".bname").blur(function(){
		 var bname = $(this).val();
		 $.get("../../AddBookTextServlet","bname="+bname,function(data){
			// $("#bname").html(data);
		 });
	 });
	 
	 
	 //定价框失去焦点
	 $(".price").blur(function(){
		var price = $(this).val();
		$.get("../../AddBookTextServlet","price="+price,function(data){
			//$("#price").html(data);
		});
	 });
	 
	 $(".currprice").blur(function(){
		 var currprice = $(this).val();
		$.get("../../AddBookTextServlet","currprice="+currprice,function(data){
			//$("#currprice").html(data);
		});
	 });*/
  
  
  
  
  
  
  
  
  
  
  
  
  
//jquery代码
 /* $(function() {
      $('#submit').click(function() {
              //获取图书名称
          var strTxtName = encodeURI($(".bname").val());
          //获取图书定价
          var strTxtPrice = encodeURI($(".price").val());
          //获取图书当前价
          var strTxtCurr = encodeURI($(".currprice").val());
          //alert(strTxtName + strTxtPrice + strTxtCurr);
          //开始发送数据
          $.ajax({ //请求登录处理页
        	  url: "${pageContext.request.contextPath}/AddBookTextServlet", //登录处理页  
        	  dataType: form,
        	  processData:false,
              contentType:false,
        	  //传送请求数据
        	  data: { bname: strTxtName, price: strTxtPrice ,currprice:strTxtCurr},
        	  success: function (strValue) { //登录成功后返回的数据
	        	  //根据返回值进行状态显示
	              if (strValue == "True") {//注意是True,不是true
	            	  $("#bname").html("图书名称不能为空！" + strValue);
	              }else{
	            	  //$("#divError").show().html("用户名或密码错误！" + strValue);
	              }
        	  },
        	  error:function(e){
                  alert("错误！！");
                  window.clearInterval(timer);
              }
          });
      });
  });*/
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
/*  //只能输入0-9的数字
  function numbercheckkey(key){
	  if(!(key>=96 && key<=105 || key>=48 && key<=57)){
		  event.returnValue=false;
	  }
	  var number = document.getElementsByName("number")[0].value;
	  if(number.length>9){
		  event.returnValue=false;
	  }
	  if(key==8){
		  event.returnValue=true;
	  }
  }
  
  
  //可以输入小数类型的数字
  function floatnumbercheck(key){
	  if((!key>=96 && key<=105 || key>=48 && key<=57)){
		  event.returnValue=false;
	  }
	  var number = document.getElementsByName("floatnumber")[0].value;
	  if(number.length>9){
		  event.returnValue=false;
	  }
	  if(key==8 || key==110){
		  event.returnValue=true;
	  }
  }
  */
  
  /*function checkNumber(e,txt){
	  var key window.event?e.keyCode:e.which;
	  var keychar = String.fromCharCode(key);
	  var msg = document.getElementById("msg");
	  reg = /^\d|\.$/;
	  var result = reg.test(keychar);
	  if(result){
		  if(e.keyCode==46){
			  result = !(txt.value.split('.').length>1);
		  }else{
			  result = !(txt.value.split('.').length>1 && txt.value.split('.')[1].length>1);
		  };
	  };
	  
	  if(!result){
		  msg.innerHTML = "只能输入数字";
		  return false;
	  }else{
		  msg.innerHTML = "";
		  return true;
	  };
  };*/
  
  
  
  