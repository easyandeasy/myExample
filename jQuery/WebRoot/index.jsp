<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  <!--   <link rel="stylesheet" href="jqueryui/themes/base/jquery.ui.all.css" type="text/css"></link>
    <link rel="stylesheet" href="jqueryui/demos.css" type="text/css"></link>
    <script type="text/javascript" src="jqueryui/ui/jquery.ui.dialog.js"></script>
    <script type="text/javascript" src="jqueryui/myjs.js"></script> -->
    <script type="text/javascript" src="jqueryui/jquery-2.1.4.js"></script>
    <link rel="stylesheet" href="js/custom.css" type="text/css"></link>
    <script type="text/javascript" src="js/yetii-min.js"></script>
    <script type="text/javascript" src="js/yetii.js"></script>
  </head>
  
  <body>
    <div id="tab-container-1">



    <ul id="tab-container-1-nav">

    <li><a href="#tab1">tab 1</a></li>

    <li><a href="#tab2">tab 2</a></li>

    </ul>



    <div class="tab" id="tab1">

    <h2>tab 1</h2>

    <p>Lorem Ipsum is simply dummy text

    of the printing and typesetting industry.</p>

    </div>

    

    <div class="tab" id="tab2">

    <h2>tab 2</h2>

    <p>It was popularised in the 1960s with 

    the release of Letraset sheets.</p>

    </div>

    

</div>



<script type="text/javascript">

var tabber1 = new Yetii({

id: 'tab-container-1'

});

</script>

  </body>
</html>
