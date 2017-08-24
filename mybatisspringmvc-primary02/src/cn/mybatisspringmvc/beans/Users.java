package cn.mybatisspringmvc.beans;

public class Users {

	private Integer u_id;
	private String uname;
	private String upwd;
	private String telephone;
	private String realname;
	private Integer isadmin;
	public Integer getU_id() {
		return u_id;
	}
	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public Integer getIsadmin() {
		return isadmin;
	}
	public void setIsadmin(Integer isadmin) {
		this.isadmin = isadmin;
	}
	public Users() {
	}
	public Users(Integer u_id, String uname, String upwd, String telephone, String realname, Integer isadmin) {
		this.u_id = u_id;
		this.uname = uname;
		this.upwd = upwd;
		this.telephone = telephone;
		this.realname = realname;
		this.isadmin = isadmin;
	}
}
