package com.jdbc.entity;

/**
 * 管理员实体类
 * @author tang
 *
 */
public class Users {

	private int aid;//编号
	private String aname;//用户名
	private String apwd;//密码
	private String acontext;//备注
	private int astatus;//状态
	
	/**
	 * 读取编号
	 * @return 返回编号
	 */
	public int getAid() {
		return aid;
	}
	
	/**
	 * 指定编号
	 * @param aid 参数为编号
	 */
	public void setAid(int aid) {
		this.aid = aid;
	}
	
	/**
	 * 读取用户名
	 * @return 返回用户名
	 */
	public String getAname() {
		return aname;
	}
	
	/**
	 * 指定用户名
	 * @param aname 参数为用户名
	 */
	public void setAname(String aname) {
		this.aname = aname;
	}
	
	/**
	 * 读取密码
	 * @return 返回密码
	 */
	public String getApwd() {
		return apwd;
	}
	
	/**
	 * 指定密码
	 * @param apwd 参数密码
	 */
	public void setApwd(String apwd) {
		this.apwd = apwd;
	}
	
	/**
	 * 读取备注
	 * @return 返回备注
	 */
	public String getAcontext() {
		return acontext;
	}
	
	/**
	 * 指定备注
	 * @param acontext 参数为备注
	 */
	public void setAcontext(String acontext) {
		this.acontext = acontext;
	}
	
	/**
	 * 读取状态
	 * @return 返回状态
	 */
	public int getAstatus() {
		return astatus;
	}
	
	/**
	 * 指定状态
	 * @param astatus 
	 */
	public void setAstatus(int astatus) {
		this.astatus = astatus;
	}
	
	/**
	 * 无参构造方法
	 */
	public Users() {}
	
	/**
	 * 有参构造方法
	 * @param aid
	 * @param aname
	 * @param apwd
	 * @param acontext
	 * @param astatus
	 */
	public Users(int aid, String aname, String apwd, String acontext,
			int astatus) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.apwd = apwd;
		this.acontext = acontext;
		this.astatus = astatus;
	}
	
	
}
