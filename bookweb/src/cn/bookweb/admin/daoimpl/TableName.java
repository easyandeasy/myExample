package cn.bookweb.admin.daoimpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bookweb.basedao.BaseDao;

public class TableName extends BaseDao {

	public List<String> tablenames(){
		List<String> tablename = new ArrayList<String>();
		String sql = "select table_name from information_schema.tables where table_schema='bookdb'";
		
		rs = executeQuerySQL(sql, null);
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
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		 return tablename;
	}
}
