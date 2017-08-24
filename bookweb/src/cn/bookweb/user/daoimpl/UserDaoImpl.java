package cn.bookweb.user.daoimpl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.bookweb.address.entity.Address;
import cn.bookweb.basedao.BaseDao;
import cn.bookweb.page.util.PageUtil;
import cn.bookweb.user.dao.IUserDao;
import cn.bookweb.user.entity.User;

/**
 * 数据访问层的实现类
 * @author tang
 *
 */
public class UserDaoImpl extends BaseDao implements IUserDao {
	
	/**
	 * 查询用户所有信息
	 * @return 返回集合对象
	 */
	public List<User> selectAllInfo(){
		List<User> list = new ArrayList<User>();;
		String sql = "SELECT uid,uname,upwd,unickname,uphone,email,uidcard,ustatus,uindate FROM user";
		rs = executeQuerySQL(sql, null);
		try {
			while(rs.next()){
				User u = new User();
				u.setUid(rs.getInt("uid"));
				u.setUidcard(rs.getString("uidcard"));
				u.setEmail(rs.getString("email"));
				u.setUidcard(rs.getString("uidcard"));
				u.setUname(rs.getString("uname"));
				u.setUindate(rs.getString("uindate"));
				u.setUpwd(rs.getString("upwd"));
				u.setUstatus(rs.getInt("ustatus"));
				u.setUnickname(rs.getString("unickname"));
				list.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return list;
	}
	
	
	/**
	 * 模糊查询用户所有信息
	 * @return 返回集合对象
	 */
	public List<User> selectUserInfoLike(String uname,PageUtil page){
		List<User> list = new ArrayList<User>();;
		String sql = "SELECT uid,uname,upwd,unickname,uphone,email,uidcard,ustatus,uindate FROM user where uname like concat('%',?,'%') limit ?,?";
		Object[] obj = {uname,(page.getNow()-1)*page.getPageSize(),page.getPageSize()};
		rs = executeQuerySQL(sql, obj);
		try {
			while(rs.next()){
				User u = new User();
				u.setUid(rs.getInt("uid"));
				u.setUidcard(rs.getString("uidcard"));
				u.setEmail(rs.getString("email"));
				u.setUidcard(rs.getString("uidcard"));
				u.setUphone(rs.getString("uphone"));
				u.setUname(rs.getString("uname"));
				u.setUindate(rs.getString("uindate"));
				u.setUpwd(rs.getString("upwd"));
				u.setUstatus(rs.getInt("ustatus"));
				u.setUnickname(rs.getString("unickname"));
				list.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return list;
	}
	
	/**
	 * 模糊查询用户条数
	 * @return 查询信息条数
	 */
	public int selectUserInfoCount(String uname){
		int row = 0;
		String sql="SELECT COUNT(*) FROM USER WHERE uname like concat('%',?,'%')";
		Object[] obj={uname};
		rs = executeQuerySQL(sql, obj);
		try{
			if(rs.next()){
				row = rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return row;
	}
	
	/**
	 * 根据状态模糊查询用户所有信息
	 * @return 返回集合对象
	 */
	public List<User> selectUserInfoLikeByUstatus(int status,PageUtil page){
		List<User> list = new ArrayList<User>();;
		String sql = "SELECT uid,uname,upwd,unickname,uphone,email,uidcard,ustatus,uindate FROM user where ustatus=? limit ?,?";
		Object[] obj = {status,(page.getNow()-1)*page.getPageSize(),page.getPageSize()};
		rs = executeQuerySQL(sql, obj);
		try {
			while(rs.next()){
				User u = new User();
				u.setUid(rs.getInt("uid"));
				u.setUidcard(rs.getString("uidcard"));
				u.setEmail(rs.getString("email"));
				u.setUidcard(rs.getString("uidcard"));
				u.setUphone(rs.getString("uphone"));
				u.setUname(rs.getString("uname"));
				u.setUindate(rs.getString("uindate"));
				u.setUpwd(rs.getString("upwd"));
				u.setUstatus(rs.getInt("ustatus"));
				u.setUnickname(rs.getString("unickname"));
				list.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return list;
	}
	
	/**
	 * 根据状态模糊查询用户条数
	 * @return 查询信息条数
	 */
	public int selectUserInfoCountByUstatus(int status){
		int row = 0;
		String sql="SELECT COUNT(*) FROM USER WHERE ustatus=?";
		Object[] obj={status};
		rs = executeQuerySQL(sql, obj);
		try{
			if(rs.next()){
				row = rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return row;
	}
	
	/**
	 * 查询 aid地址的信息
	 * @return 地址对象
	 */
	public Address selectAddressByAid(int aid){
		Address address = new Address();
		String sql = "SELECT aid,aname,uid,address,acontext from address where aid=?";
		Object[] obj = {aid};
		rs = executeQuerySQL(sql, obj);
		try {
			while(rs.next()){
				address.setAid(rs.getInt("aid"));
				address.setAname(rs.getString("aname"));
				address.setUid(rs.getInt("uid"));
				address.setAddress(rs.getString("address"));
				address.setAcontext(rs.getString("acontext"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return address;
	}

	/**
	 * 判断用户是否登录
	 * @return 返回查询的用户是否存在，如果存在就返回1,否则不存在
	 */
	public int selectLoginSQL(User user){
		int row = 0;
		String sql="SELECT COUNT(1) FROM USER WHERE uname=? AND upwd=?";
		Object[] obj={user.getUname(),user.getUpwd()};
		rs = executeQuerySQL(sql, obj);
		try{
			if(rs.next()){
				row = rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return row;
	}
	
	/**
	 * 用户注册
	 * @return 返回受影响的行数
	 */
	public boolean insertRegisterSQL(User user){
		String unickName="WSSC"+unRomdom()+"GW";
		String sql="INSERT INTO USER(uname,unickName,upwd,email) VALUE(?,?,?,?)";
		Object[] obj={user.getUname(),unickName,user.getUpwd(),user.getEmail()};
		closeAllSQL();
		return executeUpdateSQL(sql, obj)==1;
	}
	
	/**
	 * 生成不可重复的随机字符
	 * @return
	 */
	private String unRomdom(){
		String sixChar="";
		SimpleDateFormat sdf= new SimpleDateFormat("mmss");
		/*Date date = new Date();
		
		for(int i=0;i<time.length()/2;i++){
			String singleChar;
			String x = time.substring(i*2,(i+1)*2);
			int b = Integer.parseInt(x);
			if(b<10){
				singleChar = Integer.toHexString(Integer.parseInt(x));
			}else if(b>10&&b<36){
				singleChar = String.valueOf((char)(Integer.parseInt(x)+55));
			}else{
				singleChar = String.valueOf((char)(Integer.parseInt(x)+61));
			}
			sixChar = sixChar+singleChar;
		}*/
		Date date = new Date();
		String time = sdf.format(date);
		return sixChar+time;
	}
	
	/**
	 * 用户忘记密码
	 * @return 返回受影响的行数 如果为1则为true
	 */
	public boolean updateForgetSQL(User user){
		int row = 0;
		String sql="SELECT COUNT(1) FROM USER WHERE uname=? AND email = ?";
		Object[] obj={user.getUname(),user.getEmail()};
		rs=executeQuerySQL(sql, obj);
		try{
			if(rs.next()){
				row = rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return row==1;
	}
	
	/**
	 * 查询用户名是否存在！
	 * @return
	 */
	public boolean selectUserName(User user){
		String sql="SELECT COUNT(1) FROM USER WHERE uname=?";
		int row=0;
		Object[] obj={user.getUname()};
		rs=executeQuerySQL(sql, obj);
		try {
			if(rs.next()){
				row=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return row==1;
	}
	
	/**
	 * 查询用户名是否存在
	 * @return 返回一个boolean值 如果为真返回true
	 */
	public boolean selectUserEmail(User user){
		String sql="SELECT COUNT(1) FROM USER WHERE email=?";
		int row=0;
		Object[] obj={user.getEmail()};
		rs=executeQuerySQL(sql, obj);
		try {
			if(rs.next()){
				row=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return row==1;
	}
	
	/**
	 * 用户找回密码 更改密码
	 * @return 返回一个boolean值 如果查询结果为1 则为true
	 */
	public boolean updateForgetPass(User user,String upwd){
		String sql="UPDATE USER SET upwd=? WHERE uname=? AND email=?";
		Object[] obj={upwd,user.getUname(),user.getEmail()};
		closeAllSQL();
		return executeUpdateSQL(sql, obj)==1;
	}
	
	/**
	 * 根据用户id获取用户昵称
	 * @param user
	 * @return
	 */
	public String selectUserunickName(User user){
		String sql="select unickname from user where uname=?";
		Object[] obj={user.getUname()};
		String unickname="";
		rs=executeQuerySQL(sql, obj);
		try{
			if(rs.next()){
				unickname=rs.getString("unickname");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return unickname;
	}
	
	/**
	 * 根据用户编号修改用户信息
	 * @param uid 用户编号
	 * @return 返回受影响的行数
	 */
	public int updateUserInfoByUid(User u){
		int row = 0;
		String sql = "update user set uname=?,unickname=?,uphone=?,email=?,uidcard=?,ustatus=?,uindate=? where uid=?";
		Object[] obj = {u.getUname(),u.getUnickname(),u.getUphone(),u.getEmail(),u.getUidcard(),u.getUstatus(),u.getUindate(),u.getUid()};
		row = executeUpdateSQL(sql, obj);
		closeAllSQL();
		return row;
	}
	
	
	/**
	 * 根据用户id删除用户 
	 * @param uid 用户编号
	 * @return 返回受影响的行数
	 */
	public int deleteUserInfo(int uid){
		int row = 0;
		String sql = "delete from user where uid = ?";
		Object[] obj = {uid};
		row = executeUpdateSQL(sql, obj);
		closeAllSQL();
		return row;
	}
	
	
	/**
	 * 根据用户昵称查询用户id
	 * @param unickName 用户昵称
	 * @return 返回查询结果
	 */
	public int selectUserId(String unickName){
		String sql="SELECT uid FROM USER WHERE unickname=?";
		Object[] obj={unickName};
		rs=executeQuerySQL(sql, obj);
		int uid=0;
		try{
			while(rs.next()){
				uid=rs.getInt("uid");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return uid;
	}
	
	/**
	 * 根据用户名查询用户id
	 * @return 返回查询id
	 */
	public int selectUserNameId(User user){
		String sql="SELECT uid FROM USER WHERE uname=?";
		Object[] obj={user.getUname()};
		rs=executeQuerySQL(sql, obj);
		int uid=0;
		try{
			while(rs.next()){
				uid=rs.getInt("uid");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return uid;
	}
}
