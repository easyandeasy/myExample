<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <base href="<%=basePath%>">
    <title>My JSP 'adminmanage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  
  <link rel="stylesheet" href="css/after/adminmanage.css" type="text/css"></link>
  <link rel="stylesheet" href="css/after/left.css" type="text/css"></link>
  <script type="text/javascript" src="js/jquery-2.1.4.js"></script>
  <script type="text/javascript" src="js/after/adminmanage.js"></script>
  <script type="text/javascript" src="js/after/left.js"></script>
  </head>
  <c:if test="${adminname==null }">
  	<c:redirect url="adminlogin.jsp" />
  </c:if>
  <body onload="javascript:init(),nextTime()">
  	<div class="bigbox">
	     <div class="top">
	     	<div class="top_right">
				<div id="demo"> 
					<div id="indemo"> 
						<div id="demo1">
							<c:forEach var="all" items="${bookall }" varStatus="sta">
								<a href="UpdateBookInfoServlet?bid=${all.bid }" target="mainFrame" id="imgs${sta.index }"><img src="${all.imagesmall }" width="100" height="100"/></a>
							</c:forEach>
						</div> 
						<div id="demo2"></div> 
					</div> 
				</div> 
	     	</div>
	     	<div class="top_left"></div>
	     </div>
	     <div class="time">
	     	<div class="time_right">
	     		<font class="loginname"></font>当前时间：<font id="times"></font>
	     	</div>
	     	<div class="time_left">
		     	<div class="time_left_middle">
		     		<div><a href="javascript:;" class="out" onclick="out();">退出</a></div>
		     		<div><a href="jsp/after/welcome.jsp" target="mainFrame">首页</a></div>
		     		<div id="bookmanage">
		     			<a href="javascript:;" class="bookmanages" target="mainFrame">图书管理</a>
				     	<div id="hidden_menu">
		     				<div class="round_corner_reeat">
		     					<li><a href="jsp/after/addbook.jsp" target="mainFrame">添加图书</a></li>
		     				</div>
			     		</div>
		     		</div>
		     		<div id="typemanage">
		     			<a href="jsp/after/typemanage.jsp" target="mainFrame">类型管理</a>
		     		</div>
		     		<div id="ordermanage">
		     			<a href="jsp/after/ordermanage.jsp" target="mainFrame">订单管理</a>
		     		</div>
		     		<div id="usermanage">
		     			<a href="jsp/after/usermanage.jsp" target="mainFrame">用户管理</a>
		     			<!-- <div id="hidden_menuuser">
		     				<div class="round_corner_reeat">
		     					<li><a href="#" target="mainFrame">添加图书</a></li>
		     					<li><a href="#" target="mainFrame">编辑图书</a></li>
		     				</div>
			     		</div>	 -->
		     		</div>
		     		<div id="selectmanage">
		     			<a href="javascript:;" target="mainFrame">后台管理</a>
		     			<div id="hidden_menuselect">
		     				<div class="round_corner_reeat">
		     					<li><a href="jsp/after/manages.jsp" target="mainFrame">个人信息</a></li>
		     					<li><a href="jsp/after/managesaupdatepwd.jsp" target="mainFrame">修改密码</a></li>
		     					<li><a href="jsp/after/managesadd.jsp" target="mainFrame">添加帐号</a></li>
		     					<li><a href="jsp/after/updatemanages.jsp" target="mainFrame">查询帐号</a></li>
		     				</div>
			     		</div>
		     		</div>
		     	</div>
		     	<div class="time_left_left">
		     		欢迎您：<a href="jsp/after/manages.jsp" class="name" target="mainFrame">${adminname }</a>
		     	</div>
		     </div>
	     </div>
	     <div class="middle">
    		<div class="right"><!-- onLoad="iFrameHeight();" -->
				<iframe id="iframeId" name="mainFrame" frameborder="0" scrolling="no" style="height:600px; width:100%;" ></iframe>			
			</div>
    		<div class="middle_left">
    			<c:forEach var="book" items="${booktype }" varStatus="status">
			    	<c:if test="${book.tid.length() < 3 }">
			    		<li class="typeli" id="li${status.index }">
			    			<a class="img" id="img${status.index }"><img src="book_img/right6.png"/></a>${book.tname }
			    		</li>
			  	
				    	<div class="two" id="two${status.index }" >
					    	<c:forEach var="type" items="${booktype }"  varStatus="sta">
					    		<c:if test="${type.pid == book.tid }">
					    			<li class="twotype" id="${sta.index }">
						   				<a id="one${sta.index }" href="BookServlet?tid=${type.tid }&pageindex=1" target="mainFrame">${fn:substring(type.tname,0,15) }</a>
					    			</li>
					    		</c:if>
					    	</c:forEach>
				    	</div>
			    	</c:if>
			    </c:forEach>
	    		<%-- <%@ include file="left.jsp" %> --%>
		    </div>
    	</div>
    	
    </div>
    <div class="bottom">Copyright©2017-2017, ctrip.com. All rights reserved. | ICP证：湘B6-20170511</div>
    
    <a href="javascript:;" id="btn" title="回到顶部" name="obtn" onclick="javascript:oclick();"></a>
     <a href="jsp/after/welcome.jsp" id="welcome" target="mainFrame"></a>
    
    <!-- div 弹窗 -->
    <a href="#" onclick="locking();" id="newwindow"></a>
     <div id="ly"> </div>
    <!-- 浮层框架开始        -->
    <div id="Layer2" align="center" style="" >
    	<form action="BookTypeAddServlet" method="post" enctype="multipart/form-data">
	        <table width="340" height="240" border="0" cellpadding="0" cellspacing="0" style="border: 0 solid #e7e3e7;
	             border-collapse: collapse ;" >
	            <tr>
	                <td id="divhead" colspan="2" valign="middle">添加类型
	                   <div align="right" class="close">  <a href="JavaScript:;" class="STYLE1" onclick="Lock_CheckForm(this);">[关闭]</a> &nbsp;</div>
	                </td>
	            </tr>
	            <tr>
	                <td height="50" width="80" align="right">
	                    	类型名称:
	                </td>
	                <td height="50" align="left">
	                    	<input type="text" name="tname" /> <font size="1" color="red" class="txts"></font>
	                </td>
	            </tr>
	            <tr>
	                <td height="50" align="right">
	                    	所属类型:
	                </td>
	                <td height="50" align="left">
	                    	<select class="selectone2" onchange="changtype();"  name="pid">
								<option value="0">———请选择———</option>
								<c:forEach var="typeone" items="${booktype }"> 
									<c:if test="${fn:length(typeone.tid) < 3 }"> 
										<option value="${typeone.tid }" >${typeone.tname }</option>
									</c:if>
								</c:forEach>
							</select>
	                </td>
	            </tr>
	            <tr>
	                <td height="50" align="right">
	                    	备注:
	                </td>
	                <td height="50" align="left">
	                    	<input type="text" name="tcontext" />
	                </td>
	            </tr>
	            <tr>
	                <td height="50" colspan="2" align="center">
	                	<input type="button" name="bottons" onclick="typeclickadd();" value="确认"/>
	                    <input type="submit" name="sub" id="addtypesub" style="display:none;"/>
	                </td>
	            </tr>
	        </table>
        </form>
    </div>
    <!--          浮层框架结束         -->
    
    
    


<!-- 浮层框架开始        -->
<a href="#" onclick="locking3();" id="newwindow3"></a>
<div id="Layer3" align="center" style="" >
	<form action="BookTypeUpdateServlet" method="post" enctype="multipart/form-data">
        <table width="340" height="240" border="0" cellpadding="0" cellspacing="0" style="border: 0 solid #e7e3e7;
             border-collapse: collapse ;" >
            <tr>
                <td id="divhead3" colspan="2" valign="middle">
                     修改类型<div align="right" class="close"><a href="JavaScript:;" class="STYLE1" onclick="Lock_CheckForm3(this);">[关闭]</a> &nbsp;</div>
                </td>
            </tr>
            <tr>
                <td height="50" width="80" align="right">
                    	类型名称:
                </td>
                <td height="50" align="left">
                	<input type="hidden" value="" name="pid4" id="updatepid3"/>
                	<input type="hidden" value="" name="tid3" id="updatetid3"/>
                    <input type="text" name="tname3" id="updatetname3"/> <font size="1" color="red" class="txts"></font>
                </td>
            </tr>
            <tr>
                <td height="50" align="right">
                    	所属类型:
                </td>
                <td height="50" align="left">
                    	<select class="selectone3" name="pid3" id="updapid3" >
							<option value="0">———请选择———</option>
							<c:forEach var="typeone" items="${booktype }"> 
								<c:if test="${fn:length(typeone.tid) < 3 }"> 
									<option value="${typeone.tid }" >${typeone.tname }</option>
								</c:if>
							</c:forEach>
						</select>
                </td>
            </tr>
            <tr>
                <td height="50" align="right">
                    	备注:
                </td>
                <td height="50" align="left">
                    	<input type="text" name="tcontext3"  id="updatetcontext3"/>
                </td>
            </tr>
            <tr>
                <td height="50" colspan="2" align="center">
                	<input type="button" name="bottons" onclick="typeclickupdate()" value="确认"/>
                    <input type="submit" name="sub" id="updatetypesub" style="display:none;"/>
                </td>
            </tr>
        </table>
    </form>
</div>
<!--          浮层框架结束         -->


<!-- 浮层框架开始        -->
<a href="javascript:;" onclick="locking6();" id="newwindow6"></a>
<div id="Layer6" align="center" style="" >
	<form align="center">
        <table width="540" height="340" border="0" cellpadding="0" cellspacing="0" style="border: 0 solid #e7e3e7;
             border-collapse: collapse ;font-size:12px;" >
            <tr>
                <td id="divhead6" height="10" colspan="4">
                     订单信息<div align="right" class="close"><a href="JavaScript:;" class="STYLE1" onclick="Lock_CheckForm6(this);">[关闭]</a> &nbsp;</div>
                </td>
                <input type="hidden" id="orderinfovalue" value=""/>
            </tr>
            <tr>
                <td class="ordername" >
             		订单编号:
                </td>
                <td class="ordertexts" id="onumbertext" >
                	
                </td>
                  <td class="ordername" >
             		图书名称:
                </td>
                <td  class="ordertexts"  id="bnametext">
                    	
                </td>
            </tr>
            <tr>
                <td class="ordername" >
            		下单时间:
                </td>
                <td class="ordertexts"  id="ordertimetext" >
                    	
                </td>
               <td  class="ordername" >
                	图书价格:
                </td>
                 <td  class="ordertexts"  id="bpricetext" >
               
                </td>
            </tr>
            <tr>
                <td class="ordername" >
 					合计金额:
                </td>
                <td  class="ordertexts"  id="totaltext" >
                    	
                </td>
                  <td  class="ordername" >
              		订单状态 :
                </td>
                 <td  class="ordertexts"  id="ostatustext" >
                	
                </td>
            </tr>
             <tr>
                <td class="ordername" >
              		  收货地址 :
                </td>
                 <td  class="ordertexts"  id="aidtext" colspan="3">
               
                </td>
                
            </tr> 
            <tr>
                <td class="ordername" >
                	用户名:
                </td>
                 <td  class="ordertexts"  id="uidtext" >
                
                </td>
                 <td  class="ordername" >
                	图书数量:
                </td>
                 <td  class="ordertexts"  id="numtext">
                
                </td>
            </tr>
            <tr>
                 <td  class="ordername" >
                	备注:
                </td>
                 <td  class="ordertexts"  id="icontexttext" colspan="3" >
               
                </td>
            </tr>
        </table>
    </form>
</div>
<!--          浮层框架结束         -->


	<a href="javascript:;" id="selectorderinfo" onclick="selectorderinfo();"></a>
   <div class="typeinfo" onclick="selectinfo()"></div>
  </body>
</html>
