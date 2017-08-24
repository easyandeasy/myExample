<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ognl.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
      <s:iterator value="#{'china':'中国','usa':'美国','e':'俄国'}" var="c" status="st">
		<s:property value="#st.index"/><!-- 下标  取值类型 int-->--
		<s:property value="#st.count"/><!-- 长度 取值类型int-->--
		<s:property value="#st.even"/><!-- 是否是偶数 取值类型 boolean -->--
		<s:property value="#st.odd"/><!-- 是否是奇数 取值类型 boolean-->--
		<s:property value="#st.first"/><!-- 是否是第一个 取值类型 boolean -->--
		<s:property value="#st.last"/><!-- 是否是最后一个 取值类型 boolean -->--
		<s:property value="#c.key"/>--<s:property value="#c.value"/><br/>
	 </s:iterator>
     
<br/>-----------------------------------------------------------------------<br/>
    <s:iterator value="#attr.map" var="obj">
    	<s:property value="#obj.key"/>--------<s:property value="#obj.value"/><br/>
    </s:iterator>
<br/>-----------------------------------------------------------------------<br/>
     
     <!-- ?号代表所有       获取list集合中所有uid 模2 = 0 的对象 。再输出获取出来的名字 -->
     <s:iterator value="#attr.list.{?#this.uid % 2 != 0}" var="cur">
		<s:property value="#cur.uname"/>,
	</s:iterator>
<br/>-----------------------------------------------------------------------<br/>
	 
	 <!-- ^代表第一个       获取list集合中 第一个 uid 模2 = 0 的对象 。再输出获取出来的名字 -->
	<s:iterator value="#attr.list.{^#this.uid % 2 != 0}" var="cur">
		<s:property value="#cur.uname"/>
	</s:iterator>
<br/>-----------------------------------------------------------------------<br/>
	  <!-- $代表最后一个     获取list集合中 最后一个 uid 模2 = 0 的对象 。再输出获取出来的名字 -->
	<s:iterator value="#attr.list.{$#this.uid % 2 != 0}" var="cur">
		<s:property value="#cur.uname"/>
	</s:iterator>
<br/>-----------------------------------------------------------------------<br/>
      <!-- 获取list集合中所有的uname的值 ,[0]代表取下标为0的值 -->
      <s:property value="#attr.list.{uname}[0]"/>
      
<br/>-----------------------------------------------------------------------<br/>
	<!-- 获取list集合中 ，所有uid等于3的对象（this代表当前集合）的所有uname值，[0]代表取下标为0的值 -->
      <s:property value="#attr.list.{?#this.uid == 3}.{uname}[0]"/>  
            
            
<br/>-----------------------------------------------------------------------<br/>

<s:property value="#attr.user.doSomeThing('王五')"/>
<br/>-----------------------------------------------------------------------<br/>
	<% 
		Random random = new Random(); /* 创建随机数对象 */
		int n = random.nextInt(200);/* 随机200以内int类型随机数 */
		pageContext.setAttribute("n", n);
	%>
	<s:property value="#attr.n"/>
	<s:if test="#attr.n % 7 == 0">
		<s:property value="恭喜您，中一等奖"/>恭喜您，中一等奖
	</s:if>
	<s:elseif test="#attr.n % 5 == 0">
		<s:property value="恭喜您，中二等奖"/>恭喜您，中二等奖
	</s:elseif>
	<s:else>
		<s:property value="谢谢参与"/>谢谢参与
	</s:else>

<br/>-----------------------------------------------------------------------<br/>
	<!-- 遍历list集合 -->
	<s:iterator value="{'中华人民共和国','美利坚合众国','阿拉伯联合酋长国'}" var="cur">
		<s:property value="#cur"/>，
	</s:iterator>
<br/>-----------------------------------------------------------------------<br/>
	<!-- 集合合并标签 -->
	<!-- append 将后一个集合的内容拼接到前集合的后面 组成一个新的集合appendList-->
	<s:append var="appendList">
		<s:param value="{'中华人民共和国','美利坚合众国','阿拉伯联合酋长国'}"/>
		<s:param value="{'--','--','--'}"/>
		<s:param value="{'//','//','//'}"/>
	</s:append>
	<!-- 遍历 appendList -->
	<s:iterator value="#appendList" var="cur">
		<s:property value="cur"/>
	</s:iterator>
	<br/>
	<!-- merge 将后面有集合中的内容交叉拼接到前一个集合中 组成一个新的集合 mergeList-->
	<s:merge var="mergeList">
		<s:param value="{'中华人民共和国','美利坚合众国','阿拉伯联合酋长国'}"/>
		<s:param value="{'--','--','--'}"/>
		<s:param value="{'//','//','//'}"/>
	</s:merge>
	<!-- 遍历mergeList -->
	<s:iterator value="#mergeList" var="m">
		<s:property value="m"/>
	</s:iterator>
	
<br/>-----------------------------------------------------------------------<br/>
	<!-- 字符串分割标签 generator -->
	<!-- 
		separator:分割符 
		val:字符串
		count:字符串数组中元素的个数(指定字符数组的长度)
	-->
	<s:generator separator="," val="'中华人民共和国,美利坚合众国,阿拉伯联合酋长国'" var="cur" count="1"/>
	<s:iterator value="#cur" var="c">
		<s:property value="#c"/><br/>
	</s:iterator>
<br/>-----------------------------------------------------------------------<br/>
		<!-- 集合子集标签 subset -->
		<!-- 
			从集合中取出一个子集，注意：子集被放在值栈的顶部，subset标签执行完后子集自动移除
			属性：
				source：集合
				start：起始索引（下标）
				count：子集中元素个数（从集合中取多少个元素出来）
				注：如果取不到值就会为空
		 -->
		<s:subset source="{'中华人','民共和国','美利坚','合众国','阿拉伯联','合酋长国'}" start="3" count="4">
			<s:iterator var="cur">
				<s:property value="#cur"/><br/>
			</s:iterator>
		</s:subset>
		
		
<br/>-----------------------------------------------------------------------<br/>
		
		
		<!-- 设置变量标签 set -->
		<!-- 
			用于设置一个新变量，并将新变量放入指定的作用域中
			属性：
				var：新变量的引用（变量名）
				value：值（变量的值）
				scope：指定变量的作用域
				
				注：如果不指定作用域，默认放 在Stack Context中
		 -->
		
		<s:set var="v1" value="'中国人','123','654'" scope="page"></s:set>
		<s:property value="#attr.v1"/>
		
<br/>-----------------------------------------------------------------------<br/>
		<!-- 将某个值置于值栈的顶部,标签结束后,将从值栈中移除.
		 -->
		<s:push value="'中国人','a'">
			<s:property/><br/>
		</s:push>
<br/>-----------------------------------------------------------------------<br/>
		<%-- 
			<s:bean name="com.file.entity.User" var="s">
			<s:param name="uid">4</s:param>
			<s:param name="uname">小小</s:param>
			<s:param name="upwd">987654</s:param>
			<s:param name="uemail">x@qq.com</s:param>
		</s:bean>
		<s:property value="#s.uemail"/>
			 --%>
			
			
<br/>-----------------------------------------------------------------------<br/>
	<% pageContext.setAttribute("d", new Date()); %>
	不指定日期格式：<s:date name="#attr.d"/><br/>
	指 定 日 期 格式：<s:date name="#attr.d" format="yyyy年MM月dd日HH时mm分ss秒"/>
				
<br/>-----------------------------------------------------------------------<br/>
		<s:url value="ognl.jsp">
			<s:param name="id">1</s:param>
			<s:param name="page">2</s:param>
		</s:url>
	
<br/>-----------------------------------------------------------------------<br/>

	<%--  
	<s:bean name="com.aptech.sorted.LengthSorted" var="ls"/>  
	
	<s:sort comparator="#ls" source="{'中1','88w','777','6666'}">
		-- <s:iterator>
			<s:property/><br/>
		-- </s:iterator>
	</s:sort> 
	--%>
	
	
	
	
	
	
	
	
	
	
	
	
  </body>
</html>
