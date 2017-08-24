<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'index.jsp' starting page</title>
<script type="text/javascript" src="js/jquery-2.1.4.js"></script>
<script type="text/javascript" src="js/tangram-1.3.5.js"></script>
<script type="text/javascript">
	$(function() {
		//获得id为byG的DOM节点
		T.dom.g("byG", function(e) {
			alert(e);
		});

		//节点样式设置
		T.dom.setStyles("byG", {
			position : "absolute",
			top : 80,
			left : 100,
			opacity : 0.2
		});

		//万事俱备，只欠东风！ 现在开始，我们就让页面动起来吧。
		T.event.on("byG", "click", function(event) {
			alert(this.innerHTML);
		});

		T.event.on("byG", "mouseenter", function() {
			alert("在我地盘这你就得听我的");
		});

		//插入HTML
		var htmlString = "<strong>我是插班生</strong>";
		T.dom.insertHTML("byG", "beforeEnd", htmlString);
	});
</script>
</head>

<body>
	<div id="byG">
		<div class="byQ">
			<h2>Tangram是个简单可依赖的框架。</h2>
		</div>
	</div>
</body>
</html>
