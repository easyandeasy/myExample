<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加图书</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="tdis is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	
	<link rel="stylesheet" href="../../css/after/updatebook.css" type="text/css"></link>
 	<script type="text/javascript" src="../../js/jquery-2.1.4.js"></script>
  	<script type="text/javascript" src="../../My97DatePicker/WdatePicker.js"></script>
  <script type="text/javascript" src="../../js/after/updatebook.js"></script>
  </head>
  
  <body onload="onloadone()"  ><!-- ../../UpdateBookInfoServlet -->
  		<input id="type1" value="${update.selectone }" style="display:none;"/>
  		<input id="type2" value="${update.selecttwo }" style="display:none;"/>
        <form action="../../BookImageFileServlet?add=update" method="post" enctype="multipart/form-data">
	        <div class="bigbox">
	            <div class="forms">
	            	<table border="0">
	            		<tr>
	            			<td class="checkbox"><input type="checkbox" disabled="false" id="checkbox" onclick="checkboxclick();" name="checkbox"/></td>
	            			<td class="td" >点击编辑<input type="hidden" name="bid" value="${update.bid }"/></td>
	            			<td class="td" colspan="2" align="right"><a href="javascript:;" class="hlframe" id="${update.bid }" onclick="hlframeclick(this)">下架</a></td>
	            		</tr>
	            		<tr>
	            			<td>书名:</td>
	            			<td class="td" colspan="3"><input type="text" class="bname" name="bname" value="${update.bname }" />&nbsp;<font id="bname" color="red" size="2px"></font></td>
	            		</tr>
	            		<tr>
	            			<td>作者:</td>
	            			<td class="td"><input type="text" name="author" class="author" value="${update.author }"/></td>
	            		</tr>
	            		<tr>
	            			<td>定价:</td>
	            			<td class="td"><input type="text" class="price" name="price" onkeyup="num(this);"  value="${update.price }"/>&nbsp;<font id="price" color="red" size="2px"></font></td>
	            			<td>当前价:</td>
	            			<td class="td"><input type="text" class="currprice" name="currprice" onkeyup="num(this);"  value="${update.currprice }"/>&nbsp;<font id="currprice" color="red" size="2px"></font></td>
	            		</tr>
	            		<tr>
	            			<td>折扣:</td>
	            			<td class="td"><input type="text" name="discount"  onkeyup="num(this);"  value="${update.discount }"/></td>
	            			<td>出版社:</td>
	            			<td class="td"><input type="text" name="press"  value="${update.press }"/></td>
	            		</tr>
	            		<tr>
	            			<td>出版时间:</td>
	            			<td class="td"><input type="text" id="publishtime" name="publishtime" value="${update.publishtime }" onfocus="WdatePicker({isShowWeek:true})" class="Wdate"/></td>
	            			<td>版次:</td>
	            			<td class="td"><input type="text" name="edition"  value="${update.edition }"/></td>
	            		</tr>
	            		<tr>
	            			<td>页数:</td><!-- onkeyup="this.value=this.value.replace(/\D/g,'')" onnafterpaste="this.value.replace(/\D/g,'')" -->
	            			<td class="td"><input type="text" id="pagenum" name="pagenum"  value="${update.pagenum }" onkeyup="num(this);"/></td>
	            			<td>字数:</td>
	            			<td class="td"><input type="text" name="wordnum"  value="${update.wordnum }" onkeyup="this.value=this.value.replace(/\D/g,'')" /></td><!-- onnafterpaste="this.value.replace(/\D/g,'')" -->
	            		</tr>
	            		<tr>
	            			<td>印刷时间:</td>
	            			<td class="td"><input type="text" id="printtime" name="printtime" value="${update.printtime }"  onfocus="WdatePicker({isShowWeek:true})" class="Wdate"/></td>
	            			<td >纸质:</td>
	            			<td  class="td"><input type="text" name="paper"  value="${update.paper }"/></td>
	            		</tr>
	            		<tr>
	            			<td>库存:</td>
	            			<td class="td"><input type="text" id="stock" name="stock" value="${update.stock }"  onkeyup="this.value=this.value.replace(/\D/g,'')"/></td><!-- onkeyup="this.value=this.value.replace(/\D/g[0],'')" -->
	            		</tr>
	            		<tr>
	            			<td>类型:</td>
	            			<td colspan="3" class="tdtype" >
								<select class="selectone" id="selectone" onchange="changtype();"  name="type1" >
									<option value="0">————请选择————</option>
									<c:forEach var="typeone" items="${booktype }"> 
										<c:if test="${fn:length(typeone.tid) == 1 }"> 
											<option value="${typeone.tid }" >${typeone.tname }</option>
										</c:if>
									</c:forEach>
								</select>
								<select class="selecttwo" id="selecttwo" name="type2" >
									<option value="0">————请选择————</option>
								</select>
							</td>
	            		</tr>
	            		<tr>
	            			<th colspan="4" class="buttonth">
	            				<input type="button" class="button" onclick="btntypeclick(this);" name="del" value="删除" />
	            				<input type="submit" class="button" name="upd" value="修改" /></th>
	            				<a href="../../DeleteBookInfoServlet?btntype=del&bid=${update.bid }" id="del"></a>
	            		</tr>
	            	</table>
	            </div>
	           
	            <div class="picture">
	            	<img id="bigImg" src="../../${update.imagebig }" width="350" height="350"/><br/>
	            	<input type="button" value="添加图片" class="btnimg" onclick="addclick()"/>
	            	 <input type="file" id="bigFileImg" name="filename" onchange="bigUploadImg(this)" accept="image/*"/>
	            	 <input type="hidden" value="${update.imagebig }" name="image"/>
	            </div>
	        </div>
        </form> 
        
        <div class="data"></div>
  </body>
</html>