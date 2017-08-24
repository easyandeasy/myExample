<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="cn.bookweb.admin.daoimpl.TableName"%>
<%@page import="cn.bookweb.basedao.BaseDao"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'tablename.jsp' starting page</title>
    
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
      <%
		ResultSet rs = null;
		List<String> tablename = new ArrayList<String>();
		Connection conn = null;
		String sql = "select schema_name from information_schema.SCHEMATA";
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb","root","123456");
			if(conn == null){
				System.out.println("空");
			}else{
				System.out.println("有值");
			}
			rs = conn.prepareStatement(sql).executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
		 try{
			while(rs.next()){
				tablename.add(rs.getString("schema_name"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if(rs != null){
					rs.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		%>
			<div>数据库的名称</div>
		<%
		for(String s :tablename){
		%>
		<div><% out.println(s); %></div>
			<%
		}
		
       %>
       
      
  </body>
</html>
