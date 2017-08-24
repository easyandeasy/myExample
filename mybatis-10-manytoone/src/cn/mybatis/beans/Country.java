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
	@Override
	public String toString() {
		return "Country [cid=" + cid + ", cname=" + cname +  "]";
	}
}
