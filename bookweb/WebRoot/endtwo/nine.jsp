<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'layui.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  <link rel="stylesheet" href="../../layui/css/layui.css" type="text/css"></link>
  <script type="text/javascript" src="../../layui/layui.js"></script>
  <script type="text/javascript" src="../../layer/layer.js"></script>
  </head>
  
  <body>
 <script>
//layer.msg('hello'); 

/* layui.use('layer', function(){
  var layer = layui.layer;
  
  layer.msg('hello111');
});    */   

/*
 如果是iframe层
 */
/* layer.open({
  type: 2, 
  content: 'http://sentsin.com' //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
});  */   
</script>
<c:forEach begin="1" end="9" varStatus="i">
	<c:forEach begin="1" end="${i.index }" varStatus="k">
		<c:out value="${k.index}"></c:out>*<c:out value="${i.index }"></c:out>=<c:out value="${k.index*i.index}"></c:out>&nbsp;
		<c:if test="${(k.index*i.index)<10 }">
			&nbsp;
		</c:if>
	</c:forEach>
	<br/>
</c:forEach>


  </body>
</html>




<!--  <blockquote class="layui-elem-quote">
  温馨提示：如果最左侧的导航的高度超出了你的屏幕，你可以将鼠标移入导航区域，然后滑动鼠标滚轮即可
</blockquote>
 
<div class="layui-tab layui-tab-card" lay-filter="demo" style="height: 300px;">
  <ul class="layui-tab-title">
    <li class="layui-this">演示说明</li>
    <li>标题一</li>
    <li>标题二</li>
    <li>标题三</li>
  </ul>
  <div class="layui-tab-content">
    <div class="layui-tab-item layui-show">
       在这里，你将以最直观的形式体验Layui！在编辑器中可以执行layui相关的一切代码。
      <br>你也可以点击左侧导航针对性地试验我们提供的示例。
    </div>
    <div class="layui-tab-item">内容1</div>
    <div class="layui-tab-item">内容2</div>
    <div class="layui-tab-item">内容3</div>
  </div>
</div>
 
<div id="pageDemo"></div>
 
<script>
layui.use(['layer', 'laypage', 'element'], function(){
  var layer = layui.layer
  ,laypage = layui.laypage
  ,element = layui.element();
  
  //向世界问个好
  layer.msg('Hello World');
 
  //监听Tab切换
  element.on('tab(demo)', function(data){
    layer.msg('切换了：'+ this.innerHTML);
    console.log(data);
  });
  
  //分页
  laypage({
    cont: 'pageDemo' //分页容器的id
    ,pages: 100 //总页数
    ,skin: '#5FB878' //自定义选中色值
    //,skip: true //开启跳页
    ,jump: function(obj, first){
      if(!first){
        layer.msg('第'+ obj.curr +'页');
      }
    }
  });
});
</script> -->