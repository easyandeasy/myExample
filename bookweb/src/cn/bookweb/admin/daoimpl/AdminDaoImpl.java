package cn.bookweb.admin.daoimpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bookweb.admin.dao.IAdminDao;
import cn.bookweb.admin.entity.Admin;
import cn.bookweb.basedao.BaseDao;
import cn.bookweb.page.util.PageUtil;

/**
 * 管理员数据访问层的实现类
 * @author tang
 *
 */
public class AdminDaoImpl extends BaseDao implements IAdminDao {
	
	/**
	 * 查询管理员所有信息
	 * @return 返回集合对象
	 */
	public List<Admin> selectAdminAllInfo(){
		List<Admin> list = new ArrayList<Admin>();
		String sql = "select adminid,adminname,adminpwd,adminidcard,admincontext from admin";
		rs = executeQuerySQL(sql, null);
		try {
			while(rs.next()){
				Admin admin = new Admin();
				admin.setAdminid(rs.getInt("adminid"));
				admin.setAdminname(rs.getString("adminname"));
				admin.setAdminpwd(rs.getString("adminpwd"));
				admin.setAdminidcard(rs.getString("adminidcard"));
				admin.setAdmincontext(rs.getString("admincontext"));
				list.add(admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return list;
	}

	/**
	 * 判断管理员是否登录
	 * @return 返回查询的管理员是否存在，如果存在就返回>0,否则不存在
	 */
	public int selectAdminLoginSQL(Admin admin){
		int row = 0;
		String sql = "select adminid from admin where adminname=? and adminpwd=?";
		Object[] obj = {admin.getAdminname(),admin.getAdminpwd()};
		rs = executeQuerySQL(sql, obj);
		try {
			while(rs.next()){
				row = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return row;
	}
	

	
	/**
	 * 查询管理员名称是否存在
	 * @return
	 */
	public int selectAdminName(String adminname){
		int row = 0;
		String sql = "select count(*) from admin where adminname=?";
		Object[] obj = {adminname};
		rs = executeQuerySQL(sql, obj);
		try {
			while(rs.next()){
				row = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return row;
	}
	
	/**
	 * 查询管理员身份证号是否存在
	 * @return 返回受影响的行数
	 */
	public int selectAdminIdcard(String idcar,String adminname){
		int row = 0;
		String sql = "select adminid from admin where adminidcard=? and adminname=?";
		Object[] obj = {idcar,adminname};
		rs = executeQuerySQL(sql, obj);
		try {
			while(rs.next()){
				row = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return row;
	}
	
	/**
	 * 查询管理员编号修改密码
	 * @return 返回受影响的行数
	 */
	public int selectAdminNewPwd(int adminid,String newpwd){
		int row = 0;
		String sql = "update admin set adminpwd=? where adminid=?";
		Object[] obj = {newpwd,adminid};
		row = executeUpdateSQL(sql, obj);
		closeAllSQL();
		return row;
	}
	
	/**
	 * 添加管理员
	 * @param admin 管理员对象
	 * @return 返回受影响的行数
	 */
	public int insertAdmin(Admin admin){
		int row = 0;
		String sql = "insert into admin(adminname,adminpwd,adminidcard,admincontext) value(?,?,?,?)";
		Object[] obj = {admin.getAdminname(),admin.getAdminpwd(),admin.getAdminidcard(),admin.getAdmincontext()};
		row = executeUpdateSQL(sql, obj);
		closeAllSQL();
		return row;
	}
	
	
	/**
	 * 修改管理员信息
	 * @param admin 管理员对象
	 * @return 返回受影响的行数
	 */
	public int updateAdminInfo(Admin admin){
		int row = 0;
		String sql = "";
		
		if(admin.getAdminpwd()==null){
			sql = "update admin set adminname=?,adminidcard=?,admincontext=? where adminid=?";
			Object[] obj = {admin.getAdminname(),admin.getAdminidcard(),admin.getAdmincontext(),admin.getAdminid()};
			row = executeUpdateSQL(sql, obj);
		}else{
			sql = "update admin set adminname=?,adminpwd=?,adminidcard=?,admincontext=? where adminid=?";
			Object[] obj = {admin.getAdminname(),admin.getAdminpwd(),admin.getAdminidcard(),admin.getAdmincontext(),admin.getAdminid()};
			row = executeUpdateSQL(sql, obj);
		}
		
		
		closeAllSQL();
		return row;
	}
	
	
	/**
	 * 分页查询管理员信息
	 * @return 返回集合对象
	 */
	public List<Admin> selectAdminAllInfoLike(String adminname ,PageUtil page){
		List<Admin> list = new ArrayList<Admin>();
		String sql = "select adminid,adminname,adminpwd,adminidcard,admincontext from admin where adminname like concat('%',?,'%') limit ?,?";
		Object[] obj = {adminname,(page.getNow()-1)*page.getPageSize(),page.getPageSize()};
		rs = executeQuerySQL(sql, obj);
		try {
			while(rs.next()){
				Admin admin = new Admin();
				admin.setAdminid(rs.getInt("adminid"));
				admin.setAdminname(rs.getString("adminname"));
				admin.setAdminpwd(rs.getString("adminpwd"));
				admin.setAdminidcard(rs.getString("adminidcard"));
				admin.setAdmincontext(rs.getString("admincontext"));
				list.add(admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return list;
	}
	
	
	/**
	 * 分页查询管理员信息条数
	 * @return 记录条数
	 */
	public int selectAdminAllInfoByNameCount(String adminname){
		int row = 0;
		String sql = "select count(*) from admin where adminname like concat('%',?,'%')";
		Object[] obj = {adminname};
		rs = executeQuerySQL(sql, obj);
		try {
			while(rs.next()){
				row = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return row;
	}
	
	
	/**
	 * 根据管理员编号删除管理员信息
	 * @return 返回受影响的行数
	 */
	public int deleteAdminInfo(int adminid){
		int row = 0;
		String sql = "delete from admin where adminid=?";
		Object[] obj = {adminid};
		row = executeUpdateSQL(sql, obj);
		closeAllSQL();
		
		return row;
	}
}
