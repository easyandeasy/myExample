<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
    <script type="text/javascript" src="js/jquery-2.1.4.js"></script>
    <script type="text/javascript">
    	$(function(){
    		$("button").click(function(){
    			$.ajax({
    				url:"test/ajax.do",
    				data:{
    					name:"张三",
    					age:23
    				},
    				success:function(data){
    					var json = eval("("+data+")");
    					alert(json.name + "\t" + json.age);
    				}
    				
    			});
    		});
    	});
    </script>
  </head>
  
  <body>
    <button>ajax请求</button>
  </body>
</html>
