package cn.bookweb.user.entity;

/**
 * 用户状态类
 * @author tang
 *
 */
public class UserStatus {

	private int sid ;//状态编号
	private String sname;//状态名称
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
}
