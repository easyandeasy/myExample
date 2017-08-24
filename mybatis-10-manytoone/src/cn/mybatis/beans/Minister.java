package cn.mybatis.beans;

/**
 * 用户实体类
 * @author tang
 *
 */
public class Minister {

	private Integer mid;
	private String mname;
	//关联属性
	private Country country;
	
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	public Minister(String mname) {
		this.mname = mname;
	}
	public Minister() {
	}
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	@Override
	public String toString() {
		return "Minister [mid=" + mid + ", mname=" + mname + ", country=" + country + "]";
	}
}
