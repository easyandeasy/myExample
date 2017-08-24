package cn.bookweb.user.entity;

import java.sql.Date;

/**
 * 用户实现类
 * @author tang
 *
 */
public class User {

	private int uid ;//用户id
	private String uname;//用户名
	private String upwd;//密码
	private String unickname;//昵称
	private String uphone;//联系电话
	private String email;//电子邮箱
	private String uidcard;//身份证号
	private int ustatus;//状态  0被封 1正常2未填完详细信息
	private String uindate;//注册时间
	private float money;//用户金额
	
	/**
	 * 获取用户金额
	 * @return 金额
	 */
	public float getMoney() {
		return money;
	}

	/**
	 * 指定用户金额
	 * @param money 金额
	 */
	public void setMoney(float money) {
		this.money = money;
	}

	/**
	 * 无参构造方法
	 */
	public User(){}
	
	/**
	 * 带参构造方法
	 * @param name 用户名 
	 * @param pwd 用户密码
	 */
	public User(String name,String pwd){
		this.uname = name;
		this.upwd = pwd;
	}
	
	/**
	 * 获取用户id
	 * @return 用户id
	 */
	public int getUid() {
		return uid;
	}
	
	/**
	 * 指定用户id
	 * @param uid 用户id
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	/**
	 * 获取用户名
	 * @return 用户名 
	 */
	public String getUname() {
		return uname;
	}
	
	/**
	 * 指定用户名
	 * @param uname 用户名 
	 */
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	/**
	 * 获取用户密码
	 * @return 用户密码
	 */
	public String getUpwd() {
		return upwd;
	}
	
	/**
	 * 指定用户密码
	 * @param upwd 用户密码
	 */
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	
	/**
	 * 获取用户昵称
	 * @return 用户昵称
	 */
	public String getUnickname() {
		return unickname;
	}
	
	/**
	 * 指定用户昵称
	 * @param unickname 用户昵称
	 */
	public void setUnickname(String unickname) {
		this.unickname = unickname;
	}
	
	/**
	 * 获取用户联系电话
	 * @return 联系电话
	 */
	public String getUphone() {
		return uphone;
	}
	
	/**
	 * 指定用户联系电话
	 * @param uphone 联系电话
	 */
	public void setUphone(String uphone) {
		this.uphone = uphone;
	}
	
	/**
	 * 获取用户电子邮箱
	 * @return 电子邮箱
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * 指定用户电子邮箱
	 * @param email 电子邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * 获取用户身份证号
	 * @return 身份证号
	 */
	public String getUidcard() {
		return uidcard;
	}
	
	/**
	 * 指定用户身份证号
	 * @param uidcard 用户身份证号
	 */
	public void setUidcard(String uidcard) {
		this.uidcard = uidcard;
	}
	
	/**
	 * 获取用户状态
	 * @return 用户状态
	 */
	public int getUstatus() {
		return ustatus;
	}
	
	/**
	 * 指定用户状态
	 * @param ustatus 用户状态
	 */
	public void setUstatus(int ustatus) {
		this.ustatus = ustatus;
	}
	
	/**
	 * 获取用户注册时间
	 * @return 用户注册时间
	 */
	public String getUindate() {
		return uindate;
	}
	
	/**
	 * 指定用户注册时间
	 * @param uindate 用户注册时间
	 */
	public void setUindate(String uindate) {
		this.uindate = uindate;
	}
}
