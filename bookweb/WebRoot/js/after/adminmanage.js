
// 管理员主界面js

	// 获取系统时间 和 日期 和 星期
	function nextTime(){
		var now = new Date();
		var year = now.getFullYear();
		var month = now.getDate();
		var day = now.getMonth()+1;
		var week = now.getDay();
		var weekday = "一";
		switch(week){
		case 0:
			weekday = "天";
			break;
		case 1:
			weekday = "一";		
			break;
		case 2:
			weekday = "二";
			break;
		case 3:
			weekday = "三";
			break;
		case 4:
			weekday = "四";
			break;
		case 5:
			weekday = "五";
			break;
		case 6:
			weekday = "六";
			break;
		}
		
		var hour = now.getHours();//获取小、分钟、秒
		if(hour.toString().length==1){
			hour = "0"+hour;
		}
		var minute = now.getMinutes();
		if(minute.toString().length==1){
			minute = "0"+minute;
		}
		var second = now.getSeconds();
		if(second.toString().length==1){
			second = "0"+second;
		}
		var times = year+"年 "+day+"月  "+month+"日    "+"&nbsp;&nbsp;"+hour+":"+minute+":"+second +"&nbsp;&nbsp;&nbsp;&nbsp;星期 "+weekday;
		document.getElementById("times").innerHTML= times;
		if(document.getElementById("date").val()==""){
			
		}
		return times;
	}
	//每隔一秒调用一次
	var nowTime = setInterval("nextTime()", 1000);



	// 设置 管理员页面中的 iframe 的高度
	$("#iframeId").load(function () {
	    var mainheight = $(this).contents().find("body").height() + 30;
	    $(this).height(mainheight);
	});

	 
	
	//返回顶部 显示和隐藏
	  window.onscroll = function(){         //滚动条滚动事件
		  var obtn = $("[name='obtn']").attr('id');  //获取回到顶部按钮的ID/
	        //获取滚动条的滚动高度
	        var osTop = document.documentElement.scrollTop || document.body.scrollTop;

	        if(osTop > 0){  //如果滚动高度大于可视区域高度，则显示回到顶部按钮
	            $("#"+obtn).css("display","block");
	        }else{         //否则隐藏
	        	$("#"+obtn).css("display","none");
	        }
	    };  
	    //点击返回顶部
	    function oclick(){
            document.body.scrollTop = document.documentElement.scrollTop = 0;
        };
	  
      //窗体加载时点击 欢迎页面
        function init(){
        	$.get("LeftTypeServlet","",function(data){
        		$(".typeinfo").html(data);
        	});
        	document.getElementById("welcome").click();
        }
        
        
        //窗体加载时点击图书初始信息
        function initinfo(){
        	//document.getElementById("img").click();
        }
        
        //图片滚动效果
        var tab = "";
        function Marquee(){ 
    		var speed=0; //数字越大速度越慢 
    		tab=document.getElementById("demo"); 
    		var tab1=document.getElementById("demo1"); 
    		var tab2=document.getElementById("demo2"); 
    		tab2.innerHTML=tab1.innerHTML; 
    		if(tab2.offsetWidth-tab.scrollLeft<=0) {
    			tab.scrollLeft-=tab1.offsetWidth ;
    		}else{ 
    			tab.scrollLeft++; 
    		} 
    	} 
    	var MyMar=setInterval("Marquee()",40); 

		//停止 和 开始 滚动图片
    	$(function(){
    		$("#demo1>a>img").hover(function(){
        		clearInterval(MyMar);
        	},function(){
        		MyMar=setInterval("Marquee()",40);
        	});
    	});
	
    	//图书管理中的子菜单显示和隐藏
    	$(function(){
	        $("div #bookmanage:has(div)").hover( function(){ 
	        	$(this).find('div').fadeIn(400).css("box-shadow","0 0 2px red");;
	        },
	        function(){
	        	$(this).find('div').fadeOut(400);
	        }); 
	        
	        $("div #typemanage:has(div)").hover( function(){ 
	        	$(this).find('div').fadeIn(400).css("box-shadow","0 0 2px red");;
	        },
	        function(){
	        	$(this).find('div').fadeOut(400);
	        }); 
	        
	        $("div #ordermanage:has(div)").hover( function(){ 
	        	$(this).find('div').fadeIn(400).css("box-shadow","0 0 2px red");;
	        },
	        function(){
	        	$(this).find('div').fadeOut(400);
	        }); 
	        
	        $("div #usermanage:has(div)").hover( function(){ 
	        	$(this).find('div').fadeIn(400).css("box-shadow","0 0 2px red");;
	        },
	        function(){
	        	$(this).find('div').fadeOut(400);
	        }); 
	        
	        $("div #selectmanage:has(div)").hover( function(){ 
	        	$(this).find('div').fadeIn(400).css("box-shadow","0 0 2px red");;
	        },
	        function(){
	        	$(this).find('div').fadeOut(400);
	        }); 
	        
	        
	        
	    });
	
 
    	// div 弹出窗体 添加类型
    	  function locking(){   
    		  	 document.all.ly.style.display="block";   
    		  	 document.all.ly.style.width=document.body.clientWidth;   
    		  	 document.all.ly.style.height=document.body.clientHeight;   
    		  	 document.all.Layer2.style.display='block';  
    		  	 
    		  	
		   }   
		  function   Lock_CheckForm(theForm){   
		  	 document.all.ly.style.display='none';document.all.Layer2.style.display='none';
		 	 return   false;   
		   }
		  
		  
		// div 弹出窗体 修改类型
    	  function locking3(){   
    		  	 document.all.ly.style.display="block";   
    		  	 document.all.ly.style.width=document.body.clientWidth;   
    		  	 document.all.ly.style.height=document.body.clientHeight;   
    		  	 document.all.Layer3.style.display='block';  

		   }   
		  function   Lock_CheckForm3(theForm){   
		  	 document.all.ly.style.display='none';document.all.Layer3.style.display='none';
		 	 return   false;   
		   }
		  
		// div 弹出窗体 查看订单信息
    	  function locking6(){   
    		  	 document.all.ly.style.display="block";   
    		  	 document.all.ly.style.width=document.body.clientWidth;   
    		  	 document.all.ly.style.height=document.body.clientHeight;   
    		  	 document.all.Layer6.style.display='block';  

		   }   
		  function   Lock_CheckForm6(theForm){   
		  	 document.all.ly.style.display='none';document.all.Layer6.style.display='none';
		 	 return   false;   
		   }
		  
		  
		  
		  //添加类型
		  function typeclickadd(){
				var tname = $("input[name='tname']").val();
				$.get("BookTypeIsAddServlet","tname="+tname,function(data){
					$(".txts").html(data);
				});
			}
		  
		  
		  
		  //修改类型
		  function typeclickupdate(){
			  var tname = $("input[id='updatetname3']").val();
				$.get("BookTypeIsUpdateServlet","tname="+tname,function(data){
					$(".txts").html(data);
				});
			  
		  }
		  
		  //修改分类 给下拉框赋值
		  function selectinfo(){
			  var tid = $("#updatepid3").val();
			  var t2 = document.getElementById("updapid3");
				var selectValue2=t2.options;//获取大类型 option的值
				for(i=0;i<selectValue2.length;i++){
					//alert(selectValue2[i].text);
					if(selectValue2[i].value==tid){
						selectValue2[i].selected = true;
						break;
					}
				}
		  }
		  
		  
		  //订单信息
		  function selectorderinfo(){
			  var onumber = $("#orderinfovalue").val();
			  $.get("SelectOrderInfoServlet","onumber="+onumber,function(data){
					$("#selectorderinfo").html(data);
				});
			  document.getElementById("newwindow6").click();
		  }
		  
		  //退出
		  function out(){
			  location.href="OutServlet";
		  }