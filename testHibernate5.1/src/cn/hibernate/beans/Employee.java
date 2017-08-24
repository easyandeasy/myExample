package cn.hibernate.beans;

import java.util.HashSet;
import java.util.Set;

/**
 * 员工表
 * 
 * @author tang
 *
 */
public class Employee {

	private Integer eid;
	private String ename;
	private Set<Project> proSet = new HashSet<Project>();

	public Set<Project> getProSet() {
		return proSet;
	}

	public void setProSet(Set<Project> proSet) {
		this.proSet = proSet;
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Employee(String ename) {
		this.ename = ename;
	}

	public Employee() {
		super();
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + "]";
	}

}
