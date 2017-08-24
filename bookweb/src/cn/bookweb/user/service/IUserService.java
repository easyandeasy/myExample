package cn.bookweb.user.service;

import java.util.List;

import cn.bookweb.address.entity.Address;
import cn.bookweb.page.util.PageUtil;
import cn.bookweb.user.entity.User;

/**
 * 业务逻辑层
 * @author tang
 *
 */
public interface IUserService {

	/**
	 * 查询用户所有信息
	 * @return 返回集合对象
	 */
	public List<User> queryAllInfo();
	
	/**
	 * 模糊查询用户所有信息
	 * @return 返回集合对象
	 */
	public List<User> queryUserInfoLike(String uname,PageUtil page);
	
	/**
	 * 模糊查询用户条数
	 * @return 查询信息条数
	 */
	public int queryUserInfoCount(String uname);
	
	/**
	 * 根据状态模糊查询用户所有信息
	 * @return 返回集合对象
	 */
	public List<User> queryUserInfoLikeByUstatus(int status,PageUtil page);
	
	/**
	 * 根据状态模糊查询用户条数
	 * @return 查询信息条数
	 */
	public int queryUserInfoCountByUstatus(int status);
	
	/**
	 * 查询 aid地址的信息
	 * @return 地址对象
	 */
	public Address queryAddressByAid(int aid);
	

	/**
	 * 判断用户是否登录
	 * @return 返回查询的用户是否存在，如果存在就返回 true,否则不存在返回false
	 */
	public boolean queryLogin(User user);
	
	/**
	 * 用户注册
	 * @return 返回是否注册成功，成功返回true，不成功返回false
	 */
	public boolean addRegister(User user);
	
	/**
	 * 用户忘记密码
	 * @return 返回重置密码是否成功，成功返回true，不成功返回false
	 */
	public boolean replaceForget(User user);
	
	/**
	 * 查询用户名是否被占用
	 * @param user 用户对象
	 * @return 返回查询结果 为true 则表示已经被注册 否则返回flase;
	 */
	public boolean queryUserName(User user);
	
	/**
	 * 查询邮箱是否被注册
	 * @param user 用户对象
	 * @return 返回查询结果 为true 则表示已经被注册 否则返回flase;
	 */
	public boolean queryUserEmail(User user);
	
	/**
	 * 用户找回密码 更改密码
	 * @return 返回一个boolean值 如果查询结果为1 则为true
	 */
	public boolean updateForgetPass(User user,String upwd);
	
	/**
	 * 根据用户账号查找用户昵称
	 * @param user
	 * @return
	 */
	public String queryUserUnickName(User user);
	
	
	/**
	 * 根据用户编号修改用户信息
	 * @param uid 用户编号
	 * @return 返回受影响的行数
	 */
	public boolean replaceUserInfoByUid(User u);
	
	
	/**
	 * 根据用户id删除用户 
	 * @param uid 用户编号
	 * @return 返回受影响的行数
	 */
	public boolean removeUserInfo(int uid);
	
	/**
	 * 根据用户昵称查询用户id
	 * @param unickName 用户昵称
	 * @return 返回查询结果
	 */
	public int queryUserId(String unickName);
	
	/**
	 * 根据用户名查询用户id
	 * @return 返回查询id
	 */
	public int queryUserNameId(User user);
}
