package cn.mybatis.beans;

import java.util.Set;

/**
 * 用户实体类
 * @author tang
 *
 */
public class Country {

	private Integer cid;
	private String cname;
	private Set<Minister> ministers;
	
	
	public Country(String cname) {
		super();
		this.cname = cname;
	}
	public Country() {
		super();
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Set<Minister> getMinisters() {
		return ministers;
	}
	public void setMinisters(Set<Minister> ministers) {
		this.ministers = ministers;
	}
	@Override
	public String toString() {
		return "Country [cid=" + cid + ", cname=" + cname + ", ministers=" + ministers + "]";
	}
}
