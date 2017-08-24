package cn.bookweb.basedao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

/**
 * 数据共用类
 * @author Administrator
 *
 */
public class BaseDao {

	public Connection conn = null;
	public ResultSet rs = null;
	public PreparedStatement pstmt = null;
	public DataSource ds = null;

	/*public static void main(String[] args){
		BaseDao dao = new BaseDao();
		dao.getConnectionSQl();
		//dao.executeQuerySQL(null, null);
	}*/
	/**
	 * 加载驱动 和 连接数据库
	 * @return
	 */
	public Connection getConnectionSQl(){

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dnews","root","123456");
			/*if(conn!=null){
				System.out.println("连接成功");
			}else{
				System.out.println("不成功");
			}*/
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//java.naming.Context 提供了查找JNDI Resource 的接口
		
		/*Context ctext;
		try {
			ctext = new InitialContext();
			ds = (DataSource)ctext.lookup("java:comp/env/jdbc/bookdb");
			conn = ds.getConnection();
			if(conn!=null){
				System.out.println("连接成功");
			}else{
				System.out.println("不成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		return conn;
	}

	/**
	 * 关闭PreparedStatement 和 数据集 、数据库连接
	 */
	public void closeAllSQL(){
		try {
			if(pstmt != null){
				pstmt.close();
			}
			if(rs != null){
				rs.close();
			}
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 执行查询操作
	 * @param sql sql语句
	 * @param obj 参数列表
	 * @return 返回数据集
	 */
	public ResultSet executeQuerySQL(String sql,Object[] obj){
		conn = getConnectionSQl();
		try {
			pstmt = conn.prepareStatement(sql);
			if(obj != null){
				for(int i= 0;i<obj.length;i++){
					pstmt.setObject(i+1, obj[i]);
				}
			}
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	
	/**
	 * 执行增、删、改操作
	 * @param sql
	 * @param obj
	 * @return
	 */
	public int executeUpdateSQL(String sql,Object[] obj){
		int row = 0;
		conn = getConnectionSQl();
		try {
			pstmt = conn.prepareStatement(sql);
			if(obj != null){
				for(int i= 0;i<obj.length;i++){
					pstmt.setObject(i+1, obj[i]);
				}
			}
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
	
	/**
	 * 获取当前添加的自增长序号
	 * @param sql
	 * @param obj
	 * @return 查询当前添加的序号，转换int使用：Integer.ValueOf(row.toString());
	 */
	public Serializable executeInsertBean(String sql,Object[] obj) {
		Serializable row = 0;
		conn = getConnectionSQl();
		try {
			pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			if(obj != null){
				for(int i= 0;i<obj.length;i++){
					pstmt.setObject(i+1, obj[i]);
				}
			}
			pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				row = (Serializable)rs.getObject(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}
}


