package cn.bookweb.user.serviceimpl;

import java.util.List;

import cn.bookweb.address.entity.Address;
import cn.bookweb.basedao.BaseDao;
import cn.bookweb.page.util.PageUtil;
import cn.bookweb.user.dao.IUserDao;
import cn.bookweb.user.daoimpl.UserDaoImpl;
import cn.bookweb.user.entity.User;
import cn.bookweb.user.service.IUserService;

/**
 * 业务逻辑层实现类
 * @author tang
 *
 */
public class UserServiceImpl extends BaseDao implements IUserService  {

	//创建用户数据访问层实体
	private IUserDao userDao= new UserDaoImpl();
	
	/**
	 * 查询用户所有信息
	 * @return 返回集合对象
	 */
	public List<User> queryAllInfo(){
		return userDao.selectAllInfo();
	}
	
	
	/**
	 * 模糊查询用户所有信息
	 * @return 返回集合对象
	 */
	public List<User> queryUserInfoLike(String uname,PageUtil page){
		return userDao.selectUserInfoLike(uname, page);
	}
	
	/**
	 * 模糊查询用户条数
	 * @return 查询信息条数
	 */
	public int queryUserInfoCount(String uname){
		return userDao.selectUserInfoCount(uname);
	}
	
	/**
	 * 根据状态模糊查询用户所有信息
	 * @return 返回集合对象
	 */
	public List<User> queryUserInfoLikeByUstatus(int status,PageUtil page){
		return userDao.selectUserInfoLikeByUstatus(status, page);
	}
	
	/**
	 * 根据状态模糊查询用户条数
	 * @return 查询信息条数
	 */
	public int queryUserInfoCountByUstatus(int status){
		return userDao.selectUserInfoCountByUstatus(status);
	}
	
	/**
	 * 查询 aid地址的信息
	 * @return 地址对象
	 */
	public Address queryAddressByAid(int aid){
		return userDao.selectAddressByAid(aid);
	}
	

	/**
	 * 判断用户是否登录
	 * @return 返回查询的用户是否存在，如果存在就返回 true,否则不存在返回false
	 */
	public boolean queryLogin(User user){
		return userDao.selectLoginSQL(user)==1;
	}
	
	/**
	 * 用户注册
	 * @return 返回一个boolean值 如果数据层返回的结果为1 则返回true，否则返回false
	 */
	public boolean addRegister(User user){
		return userDao.insertRegisterSQL(user);
	}
	
	/**
	 * 用户忘记密码
	 * @return 返回重置密码是否成功，成功返回true，不成功返回false
	 */
	public boolean replaceForget(User user){
		return userDao.updateForgetSQL(user);
	}
	
	/**
	 * 查询用户名是否被占用
	 * @param user 用户对象
	 * @return 返回查询结果 为true 则表示已经被注册 否则返回flase;
	 */
	public boolean queryUserName(User user){
		return userDao.selectUserName(user);
	}
	
	/**
	 * 查询邮箱是否被注册
	 * @param user 用户对象
	 * @return 返回查询结果 为true 则表示已经被注册 否则返回flase;
	 */
	public boolean queryUserEmail(User user){
		return userDao.selectUserEmail(user);
	}
	
	/**
	 * 用户找回密码 更改密码
	 * @return 返回一个boolean值 如果查询结果为1 则为true
	 */
	public boolean updateForgetPass(User user,String upwd){
		return userDao.updateForgetPass(user,upwd);
	}
	
	/**
	 * 根据用户账号查找用户昵称
	 * @param user
	 * @return
	 */
	public String queryUserUnickName(User user){
		return userDao.selectUserunickName(user);
	}
	
	
	/**
	 * 根据用户编号修改用户信息
	 * @param uid 用户编号
	 * @return 返回受影响的行数
	 */
	public boolean replaceUserInfoByUid(User u){
		boolean flag = false;
		if(userDao.updateUserInfoByUid(u)>0){
			flag = true;
		}
		return flag;
	}
	
	/**
	 * 根据用户id删除用户 
	 * @param uid 用户编号
	 * @return 返回受影响的行数
	 */
	public boolean removeUserInfo(int uid){
		boolean flag = false;
		if(userDao.deleteUserInfo(uid)>0){
			flag = true;
		}
		return flag;
	}
	
	/**
	 * 根据用户昵称查询用户id
	 * @param unickName 用户昵称
	 * @return 返回查询结果
	 */
	public int queryUserId(String unickName){
		return userDao.selectUserId(unickName);
	}
	
	/**
	 * 根据用户名查询用户id
	 * @return 返回查询id
	 */
	public int queryUserNameId(User user){
		return userDao.selectUserNameId(user);
	}
}
