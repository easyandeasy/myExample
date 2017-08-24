package cn.bookweb.user.dao;

import java.util.List;

import cn.bookweb.address.entity.Address;
import cn.bookweb.page.util.PageUtil;
import cn.bookweb.user.entity.User;

/**
 * 用户数据访问层
 * @author tang
 *
 */
public interface IUserDao {
	
	/**
	 * 查询用户所有信息
	 * @return 返回集合对象
	 */
	public List<User> selectAllInfo();
	
	/**
	 * 模糊查询用户所有信息
	 * @return 返回集合对象
	 */
	public List<User> selectUserInfoLike(String uname,PageUtil page);
	
	/**
	 * 模糊查询用户条数
	 * @return 查询信息条数
	 */
	public int selectUserInfoCount(String uname);
	
	/**
	 * 根据状态模糊查询用户所有信息
	 * @return 返回集合对象
	 */
	public List<User> selectUserInfoLikeByUstatus(int status,PageUtil page);
	
	/**
	 * 根据状态模糊查询用户条数
	 * @return 查询信息条数
	 */
	public int selectUserInfoCountByUstatus(int status);
	
	/**
	 * 查询 aid地址的信息
	 * @return 地址对象
	 */
	public Address selectAddressByAid(int aid);

	/**
	 * 用户登录
	 * @return 返回查询的用户是否存在，如果存在就返回1,否则不存在
	 */
	public int selectLoginSQL(User user);
	
	/**
	 * 用户注册
	 * @return 返回受影响的行数 如果等于1则 为true
	 */
	public boolean insertRegisterSQL(User user);
	
	/**
	 * 用户忘记密码
	 * @return 返回受影响的行数 如果为1则表示验证通过
	 */
	public boolean updateForgetSQL(User user);
	
	/**
	 * 查询用户名是否存在
	 * @return 返回一个boolean值 如果查询结果为1 则为true
	 */
	public boolean selectUserName(User user);
	
	/**
	 * 查询用户名是否存在
	 * @return 返回一个boolean值 如果查询结果为1 则为true
	 */
	public boolean selectUserEmail(User user);
	
	/**
	 * 用户找回密码 更改密码
	 * @return 返回一个boolean值 如果查询结果为1 则为true
	 */
	public boolean updateForgetPass(User user,String upwd);
	
	/**
	 * 根据用户id获取用户昵称
	 * @param user
	 * @return
	 */
	public String selectUserunickName(User user);
	
	/**
	 * 根据用户编号修改用户信息
	 * @param uid 用户编号
	 * @return 返回受影响的行数
	 */
	public int updateUserInfoByUid(User u);
	
	/**
	 * 根据用户id删除用户 
	 * @param uid 用户编号
	 * @return 返回受影响的行数
	 */
	public int deleteUserInfo(int uid);
	
	/**
	 * 根据用户昵称查询用户id
	 * @param unickName 用户昵称
	 * @return 返回查询结果
	 */
	public int selectUserId(String unickName);
	
	/**
	 * 根据用户名查询用户id
	 * @return 返回查询id
	 */
	public int selectUserNameId(User user);
}
