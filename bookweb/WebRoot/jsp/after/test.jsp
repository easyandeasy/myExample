<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <script type="text/javascript" src="../../js/jquery-2.1.4.js"></script>
 <style type="text/css">
	  body
	  {
	  	 font-size: 13px;
	  }
	  .divFrame
	  {
	 	  width: 225px;
	 	  border: solid 1px #666;
	  }
	  .divFrame .divTitle
	  {
		   padding: 5px;
		   background-color: #eee;
		   height: 23px;
	  }
	  .divFrame .divTitle span
	  {
		   float: left;
		   padding: 2px;
		   padding-top: 5px;
	  }
	  .divFrame .divContent
	  {
		   padding: 8px;
		   text-align: center;
	  }
	  .divFrame .divContent .clsShow
	  {
	  	 font-size: 14px;
	  	 line-height: 2.0em;
	  }
	  .divFrame .divContent .clsShow .clsError
	  {
	 	   font-size: 13px;
	  	   border: solid 1px #cc3300;
		   padding: 2px;
		   display: none;
		   margin-bottom: 5px;
		   background-color: #ffe0a3;
	  }
	  .txt
	  {
		   border: #666 1px solid;
		   padding: 2px;
		   width: 150px;
		   margin-right: 3px;
	  }
	  .btn
	  {
		   border: #666 1px solid;
		   padding: 2px;
		   width: 50px;
	  }
 </style>
 <script type="text/javascript">
  $(function () {
	   $("#txtName").focus();//输入焦点
	   $("#txtName").keydown(function (event) {
	    if (event.which == "13") {//回车键,移动光标到密码框
	    	 $("#txtPass").focus();
	    }
   });
   $("#txtPass").keydown(function (event) {
    if (event.which == "13") {//回车键，用.ajax提交表单
     $("#btnLogin").trigger("click");
    }
   });
   $("#btnLogin").click(function () { //“登录”按钮单击事件
    //获取用户名称
    var strTxtName = encodeURI($("#txtName").val());
    //获取输入密码
    var strTxtPass = encodeURI($("#txtPass").val());
    //开始发送数据
    $.ajax
    ({ //请求登录处理页
     url: "Login.aspx", //登录处理页
     dataType: "html",
     //传送请求数据
     data: { txtName: strTxtName, txtPass: strTxtPass },
     success: function (strValue) { //登录成功后返回的数据
      //根据返回值进行状态显示
      if (strValue == "True") {//注意是True,不是true
       $(".clsShow").html("操作提示，登录成功！" + strValue);
      }
      else {
       $("#divError").show().html("用户名或密码错误！" + strValue);
      }
     }
    })
   })
  })
 </script>
</head>
<body>
 <form id="frmUserLogin">
 <div class="divFrame">
  <div class="divTitle">
   <span>用户登录</span>
  </div>
  <div class="divContent">
   <div class="clsShow">
    <div id="divError" class="clsError">
    </div>
    <div>
     名称：<input id="txtName" type="text" class="txt" /></div>
    <div>
     密码：<input id="txtPass" type="password" class="txt" /></div>
    <div>
     <input id="btnLogin" type="button" value="登录" class="btn" />  
     <input id="btnReset" type="reset" value="取消" class="btn" />
    </div>
   </div>
  </div>
 </div>
 </form>
  </body>
</html>
