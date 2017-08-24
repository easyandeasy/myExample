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
	
	<link rel="stylesheet" href="../../css/after/addbook.css" type="text/css"></link>
 	<script type="text/javascript" src="../../js/jquery-2.1.4.js"></script>
 	<script type="text/javascript" src="../../js/after/addbook.js"></script>
  	<script type="text/javascript" src="../../My97DatePicker/WdatePicker.js"></script>
  </head>
  
  <body><!-- ../../BookImageFileServlet -->
        <form action="../../BookImageFileServlet?add=add" method="post" enctype="multipart/form-data">
	        <div class="bigbox">
	            <div class="forms">
	            	<table border="0">
	            		<tr>
	            			<td>书名:</td>
	            			<td class="td"><input type="text" class="bname" name="bname" />&nbsp;<font id="bname" color="red" size="2px"></font></td>
	            			<td>作者:</td>
	            			<td class="td"><input type="text" name="author" /></td>
	            		</tr>
	            		<tr>
	            			<td>定价:</td>
	            			<td class="td"><input type="text" class="price" name="price" onkeyup="num(this);"/>&nbsp;<font id="price" color="red" size="2px"></font></td>
	            			<td>当前价:</td>
	            			<td class="td"><input type="text" class="currprice" name="currprice" onkeyup="num(this);"/>&nbsp;<font id="currprice" color="red" size="2px"></font></td>
	            		</tr>
	            		<tr>
	            			<td>折扣:</td>
	            			<td class="td"><input type="text" name="discount"  onkeyup="num(this);"/></td>
	            			<td>出版社:</td>
	            			<td class="td"><input type="text" name="press" /></td>
	            		</tr>
	            		<tr>
	            			<td>出版时间:</td>
	            			<td class="td"><input type="text" id="publishtime" name="publishtime" onfocus="WdatePicker({isShowWeek:true})" class="Wdate"/></td>
	            			<td>版次:</td>
	            			<td class="td"><input type="text" name="edition" /></td>
	            		</tr>
	            		<tr>
	            			<td>页数:</td><!-- onkeyup="this.value=this.value.replace(/\D/g,'')" onnafterpaste="this.value.replace(/\D/g,'')" -->
	            			<td class="td"><input type="text" id="pagenum" name="pagenum"  onkeyup="num(this);"/></td>
	            			<td>字数:</td>
	            			<td class="td"><input type="text" name="wordnum"  onkeyup="this.value=this.value.replace(/\D/g,'')" /></td><!-- onnafterpaste="this.value.replace(/\D/g,'')" -->
	            		</tr>
	            		<tr>
	            			<td>印刷时间:</td>
	            			<td class="td"><input type="text" id="printtime" name="printtime"  onfocus="WdatePicker({isShowWeek:true})" class="Wdate"/></td>
	            			<td >纸质:</td>
	            			<td  class="td"><input type="text" name="paper" /></td>
	            		</tr>
	            		<tr>
	            			<td>库存:</td>
	            			<td class="td"><input type="text" id="stock" name="stock"  onkeyup="this.value=this.value.replace(/\D/g,'')"/></td>
	            		</tr>
	            		<tr>
	            			<td>类型:</td>
	            			<td colspan="4" class="tdtype">
								<select class="selectone" onchange="changtype();"  name="type1">
									<option value="0">————请选择————</option>
									<c:forEach var="typeone" items="${booktype }"> 
										<c:if test="${fn:length(typeone.tid) == 1 }"> 
											<option value="${typeone.tid }" >${typeone.tname }</option>
										</c:if>
									</c:forEach>
								</select>
								<select class="selecttwo" name="type2">
									<option value="0">————请选择————</option>
								</select>
								<font id="selectone" color="red" size="2px"></font>
							</td>
	            		</tr>
	            		<tr>
	            			<th colspan="4" class="submitth">	
	            				<input type="submit"  id="submitclick" />
	            				<input type="button" class="button" id="submit" name="submit" onclick="submitclick2()" value="提交" />
	            			</th>
	            		</tr>
	            	</table>
	            </div>
	           
	            <div class="picture">
	            	<img id="bigImg" src="../../book_img/big.png" width="200" height="200"/><br/>
	            	<input type="button" value="添加图片" class="btnimg" onclick="addclick()"/>
	               <input type="file" id="bigFileImg" name="filename" onchange="bigUploadImg(this)" accept="image/*"/>
	            </div>
	        </div>
        </form> 
  </body>
</html>