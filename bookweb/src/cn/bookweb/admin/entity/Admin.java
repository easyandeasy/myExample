package cn.bookweb.admin.entity;

/**
 * 管理员实现类
 * @author tang
 *
 */
public class Admin {

	private int adminid; //管理员编号
	private String adminname;//管理员帐号
	private String adminpwd;//管理密码
	private String adminidcard;//身份证号

	private String admincontext;//备注
	
	public String getAdminidcard() {
		return adminidcard;
	}
	
	public void setAdminidcard(String adminidcard) {
		this.adminidcard = adminidcard;
	}
	/**
	 * 获取管理员编号
	 * @return 返回编号
	 */
	public int getAdminid() {
		return adminid;
	}
	
	/**
	 * 指定管理员编号
	 * @param adminid 管理员编号
	 */
	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}
	
	/**
	 * 获取管理员帐号
	 * @return 返回帐号
	 */
	public String getAdminname() {
		return adminname;
	}
	
	/**
	 * 指定管理员帐号
	 * @param adminname 管理员帐号
	 */
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	
	/**
	 * 获取管理员密码
	 * @return 密码
	 */
	public String getAdminpwd() {
		return adminpwd;
	}
	
	/**
	 * 指定管理员密码
	 * @param adminpwd 密码
	 */
	public void setAdminpwd(String adminpwd) {
		this.adminpwd = adminpwd;
	}
	
	/**
	 * 获取备注
	 * @return 返回备注
	 */
	public String getAdmincontext() {
		return admincontext;
	}
	
	/**
	 * 指定备注
	 * @param acontext 备注
	 */
	public void setAdmincontext(String admincontext) {
		this.admincontext = admincontext;
	}
	
	
}
