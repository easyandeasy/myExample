package cn.bookweb.admin.dao;

import java.util.List;

import cn.bookweb.admin.entity.Admin;
import cn.bookweb.page.util.PageUtil;
import cn.bookweb.user.entity.User;

/**
 * 管理员数据访问层
 * @author tang
 *
 */
public interface IAdminDao {
	
	/**
	 * 查询管理员所有信息
	 * @return 返回集合对象
	 */
	public List<Admin> selectAdminAllInfo();

	/**
	 * 判断管理员是否登录
	 * @return 返回查询的管理员是否存在，如果存在就返回>0,否则不存在
	 */
	public int selectAdminLoginSQL(Admin admin);
	

	/**
	 * 查询管理员名称是否存在
	 * @return 返回受影响的行数
	 */
	public int selectAdminName(String adminname);
	
	/**
	 * 查询管理员身份证号是否存在
	 * @return 返回受影响的行数
	 */
	public int selectAdminIdcard(String idcar,String adminname);
	
	
	/**
	 * 查询管理员编号修改密码
	 * @return 返回受影响的行数
	 */
	public int selectAdminNewPwd(int adminid,String newpwd);
	
	/**
	 * 添加管理员
	 * @param admin 管理员对象
	 * @return 返回受影响的行数
	 */
	public int insertAdmin(Admin admin);
	
	
	/**
	 * 修改管理员信息
	 * @param admin 管理员对象
	 * @return 返回受影响的行数
	 */
	public int updateAdminInfo(Admin admin);
	
	
	/**
	 * 分页查询管理员信息
	 * @return 返回集合对象
	 */
	public List<Admin> selectAdminAllInfoLike(String adminname ,PageUtil page);
	
	
	/**
	 * 分页查询管理员信息条数
	 * @return 记录条数
	 */
	public int selectAdminAllInfoByNameCount(String adminname);
	
	
	
	/**
	 * 根据管理员编号删除管理员信息
	 * @return 返回受影响的行数
	 */
	public int deleteAdminInfo(int adminid);
}
