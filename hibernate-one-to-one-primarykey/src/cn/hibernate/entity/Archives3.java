package cn.hibernate.entity;

public class Archives3 {

	private Integer aid;
	private String aname;
	private String anum;
	private User3 user;
	
	public String getAnum() {
		return anum;
	}
	public void setAnum(String anum) {
		this.anum = anum;
	}
	public User3 getUser() {
		return user;
	}
	public void setUser(User3 user) {
		this.user = user;
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public Archives3(String aname, String anum) {
		super();
		this.aname = aname;
		this.anum = anum;
	}
	public Archives3() {
	}
	@Override
	public String toString() {
		return "Archives [aid=" + aid + ", aname=" + aname + ", anum=" + anum + ", user=" + user + "]";
	}
}
