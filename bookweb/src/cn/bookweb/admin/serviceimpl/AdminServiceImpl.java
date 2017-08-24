package cn.bookweb.admin.serviceimpl;

import java.util.List;

import cn.bookweb.admin.dao.IAdminDao;
import cn.bookweb.admin.daoimpl.AdminDaoImpl;
import cn.bookweb.admin.entity.Admin;
import cn.bookweb.admin.service.IAdminService;
import cn.bookweb.basedao.BaseDao;
import cn.bookweb.page.util.PageUtil;
import cn.bookweb.user.entity.User;

/**
 * 管理员业务逻辑层实现类
 * @author tang
 *
 */
public class AdminServiceImpl extends BaseDao implements IAdminService  {

	IAdminDao dao = new AdminDaoImpl();
	/**
	 * 查询管理员所有信息
	 * @return 返回集合对象
	 */
	public List<Admin> queryAdminAllInfo(){
		return dao.selectAdminAllInfo();
	}
	

	/**
	 * 判断管理员是否登录
	 * @return 返回查询的管理员是否存在，如果存在就返回 true,否则不存在返回false
	 */
	public int queryAdminLogin(Admin admin){
		return dao.selectAdminLoginSQL(admin);
	}
	
	/**
	 * 添加管理员
	 * @return 返回是否注册成功，成功返回true，不成功返回false
	 */
	public boolean addAdminRegister(){
		boolean flag = false;
		
		return flag;
	}
	
	/**
	 * 管理员忘记密码
	 * @return 返回重置密码是否成功，成功返回true，不成功返回false
	 */
	public boolean replaceAdminForget(){
		boolean flag = false;
		
		return flag;
	}
	
	
	/**
	 * 查询管理员名称是否存在
	 * @return
	 */
	public boolean queryAdminName(String adminname){
		boolean flag = false;
		if(dao.selectAdminName(adminname)>0){
			flag = true;
		}
		return flag;
	}
	
	/**
	 * 查询管理员身份证号是否存在
	 * @return 返回受影响的行数
	 */
	public int queryAdminIdcard(String idcar,String adminname){
		return dao.selectAdminIdcard(idcar, adminname);
	}
	
	
	/**
	 * 查询管理员编号修改密码
	 * @return 返回受影响的行数
	 */
	public boolean queryAdminNewPwd(int adminid,String newpwd){
		boolean flag = false;
		if(dao.selectAdminNewPwd(adminid, newpwd)>0){
			flag = true;
		}
		return flag;
	}
	
	
	/**
	 * 添加管理员
	 * @param admin 管理员对象
	 * @return 返回受影响的行数
	 */
	public boolean addAdmin(Admin admin){
		boolean flag = false;
		if(dao.insertAdmin(admin)>0){
			flag = true;
		}
		return flag;
	}
	
	
	/**
	 * 修改管理员信息
	 * @param admin 管理员对象
	 * @return 返回受影响的行数
	 */
	public boolean replaceAdminInfo(Admin admin){
		boolean flag = false;
		if(dao.updateAdminInfo(admin)>0){
			flag = true;
		}
		return flag;
	}
	
	/**
	 * 分页查询管理员信息
	 * @return 返回集合对象
	 */
	public List<Admin> queryAdminAllInfoLike(String adminname ,PageUtil page){
		return dao.selectAdminAllInfoLike(adminname, page);
	}
	
	
	/**
	 * 分页查询管理员信息条数
	 * @return 记录条数
	 */
	public int queryAdminAllInfoByNameCount(String adminname){
		return dao.selectAdminAllInfoByNameCount(adminname);
	}
	
	
	/**
	 * 根据管理员编号删除管理员信息
	 * @return 返回受影响的行数
	 */
	public boolean removeAdminInfo(int adminid){
		boolean flag = false;
		if(dao.deleteAdminInfo(adminid)>0){
			flag = true;
		}
		return flag;
	}
}
