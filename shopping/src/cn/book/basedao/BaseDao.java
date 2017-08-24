package cn.book.basedao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * ���ݹ�����
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
	 * �������� �� �������ݿ�
	 * @return
	 */
	public Connection getConnectionSQl(){
/*
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dnews","root","123456");
			if(conn!=null){
				System.out.println("���ӳɹ�");
			}else{
				System.out.println("���ɹ�");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		//java.naming.Context �ṩ�˲���JNDI Resource �Ľӿ�
		
		Context ctext;
		try {
			ctext = new InitialContext();
			ds = (DataSource)ctext.lookup("java:comp/env/jdbc/news");
			conn = ds.getConnection();
			/*if(conn!=null){
				System.out.println("���ӳɹ�");
			}else{
				System.out.println("���ɹ�");
			}*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * �ر�PreparedStatement �� ���ݼ� �����ݿ�����
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
	 * ִ�в�ѯ����
	 * @param sql sql���
	 * @param obj �����б�
	 * @return �������ݼ�
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
	 * ִ������ɾ���Ĳ���
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
		}finally{
			closeAllSQL();
		}
		return row;
	}
}

