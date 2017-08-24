package cn.oracle.test;

import java.sql.SQLException;

public class StudentInfoImpl {

	public static void main(String[] args){
		BaseDao  dao = new BaseDao();
		String sql = "select * from clas";
		dao.rs = dao.executeQuerySQL(sql, null);
		try {
			while(dao.rs.next()){
				System.out.print(dao.rs.getString("cid")+"\t");
				System.out.print(dao.rs.getString("department")+"\t");
				System.out.println(dao.rs.getString("cname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
