<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 <script>   
  function locking(){   
  	 document.all.ly.style.display="block";   
  	 document.all.ly.style.width=document.body.clientWidth;   
  	 document.all.ly.style.height=document.body.clientHeight;   
  	 document.all.Layer2.style.display='block';  
    
   }   
  function    Lock_CheckForm(theForm){   
  	 document.all.ly.style.display='none';document.all.Layer2.style.display='none';
 	 return   false;   
   }   
    </script>
    <style type="text/css">
<!--
.STYLE1 {font-size: 12px}
.close a:link {
	color: #FFFFFF;
	text-decoration: none;
}
.close a:visited {
	text-decoration: none;
}
.close a:hover {
	text-decoration: none;
}
.close a:active {
	text-decoration: none;
}
-->
    </style>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312"></head>
<body>
    <div id="ly" style="position: absolute; top: 0px;opacity:0.2; filter: alpha(opacity=60); background-color: #000;
         z-index: 2; left: 0px; display: none;">
    </div>
    <!--          浮层框架开始         -->
    <div id="Layer2" align="center" style="position: absolute; z-index: 3; left:520px ; top:120px ;
         background-color: #fff; display: none;" >
        <table width="340" height="400" border="0" cellpadding="0" cellspacing="0" style="border: 0    solid    #e7e3e7;
             border-collapse: collapse ;" >
            <tr>
                <td style="background-color: #73A2d6; color: #fff; padding-left: 4px; padding-top: 2px;
                     font-weight: bold; font-size: 12px;" height="10" valign="middle">
                     <div align="right" class="close"><a href=JavaScript:; class="STYLE1" onclick="Lock_CheckForm(this);">[关闭]</a> &nbsp;</div></td>
            </tr>
            <tr>
                <td height="130" align="center">
                    123
                </td>
            </tr>
        </table>
    </div>
    <!--          浮层框架结束         -->
  </body>
</html>
