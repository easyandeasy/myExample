<%@page import="com.jdbc.entity.News"%>
<%@page import="com.jdbc.topicsdaoImpl.NewsDaoImpl"%>
<%@page import="com.jdbc.newsdao.INewsDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

	<!-- 固定主题页面 -->
	<div class="side_list">
		<img src="images/title_1.gif" alt="国内新闻" />
		
		<c:forEach items="${list1 }" var="list1" varStatus="status" end="18">
			<li class="li"><a href="NewShow?nid=${list1.nid}" target="if"
				title=${list1.ntitle }><b>${list1.str }</b> </a>
			</li>
		</c:forEach>
	</div>


	<div class="side_list">
		<img src="images/title_2.gif" alt="国际新闻" />
		<c:forEach items="${list2 }" var="list2" varStatus="status" end="13">
			<li class="li"><a href="NewShow?nid=${list2.nid}" target="if"
				title=${list2.ntitle }><b>${list2.str }</b> </a>
			</li>
		</c:forEach>
	</div>


	<div class="side_list">
		<img src="images/title_3.gif" alt="娱乐新闻" />
		<c:forEach items="${list3 }" var="list3" varStatus="status" end="13">
			<li class="li"><a href="NewShow?nid=${list3.nid}" target="if"
				title=${list3.ntitle }><b>${list3.str }</b> </a>
			</li>
		</c:forEach>
	</div>











































<%-- <%
			INewsDao newsDao = new NewsDaoImpl();
			List<News> list4 = (List<News>) session.getAttribute("list1");
			List<News> list5 = (List<News>) session.getAttribute("list2");
			List<News> list6 = (List<News>) session.getAttribute("list3");
			int i = 0;

			String str = "";
			for (News news : list4) {
				i++;
				if (i == 10){
					
					break;
				}
		%> --%>
		<%-- <%
			}
		%> --%>
		
		<%-- <img src="images/title_2.gif" alt="国际新闻" />
		<%
			int j = 0;
			for (News news : list5) {
				j++;
				if (j == 10)
					break;
		%>
		<li class="li"><a href='news_read.jsp?nid=<%=news.getNid()%>'
			title=<%=news.getNtitle()%>><b><%=str(news.getNtitle())%></b> </a>
		</li>

		<%
			}
		%> --%>
		<%-- <img src="images/title_3.gif" alt="国际新闻" />
		<%
			int a = 0;
			for (News news : list6) {
				a++;
				if (a == 10)
					break;
		%>
		<li class="li"><a href='news_read.jsp?nid=<%=news.getNid()%>'
			title=<%=news.getNtitle()%>><b><%=str(news.getNtitle())%></b> </a>
		</li>

		<%
			}
		%> --%>
