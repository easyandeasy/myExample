package cn.hibernate.entity;

public class User3 {

	private Integer uid;
	private String uname;
	private String upwd;
	private Archives3 archives;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
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
	public Archives3 getArchives() {
		return archives;
	}
	public void setArchives(Archives3 archives) {
		this.archives = archives;
	}
	public User3(String uname, String upwd) {
		this.uname = uname;
		this.upwd = upwd;
	}
	public User3() {
		super();
	}
	@Override
	public String toString() {
		return "User2 [uid=" + uid + ", uname=" + uname + ", upwd=" + upwd + ", archives=" + archives + "]";
	}
}
