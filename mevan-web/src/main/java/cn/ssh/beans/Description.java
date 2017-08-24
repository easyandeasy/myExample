package cn.ssh.beans;

import java.util.Set;

public class Description {

	private Long id;
	private String name;//名称
	private String description;//备注
	
	//自关联
	private Description parent;//父级
	private Set<Description> children;//子级
	
	private Set<User> user;//本类与User是一对多关系
	
	public Set<User> getUser() {
		return user;
	}
	public void setUser(Set<User> user) {
		this.user = user;
	}
	public Description getParent() {
		return parent;
	}
	public void setParent(Description parent) {
		this.parent = parent;
	}
	public Set<Description> getChildren() {
		return children;
	}
	public void setChildren(Set<Description> children) {
		this.children = children;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
