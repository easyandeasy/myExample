package cn.Animal.entity;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class tablename extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		ResultSet rs = null;
		List<String> tablename = new ArrayList<String>();
		Connection conn = null;
		String sql = "select table_name from information_schema.tables where table_schema='bookdb'";
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
				tablename.add(rs.getString("table_name"));
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
		System.out.println("123");
		for(String s :tablename){
			System.out.println(s);
		}
		
		 request.getSession().setAttribute("tablename", tablename);
		// request.getRequestDispatcher("endtwo/tablename.jsp");
		 out.println("<script type='text/javascript' > history.href='endtwo/tablename.jsp'; </script>");
	}

}
