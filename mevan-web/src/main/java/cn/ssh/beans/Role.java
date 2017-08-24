package cn.ssh.beans;

import java.util.Set;

public class Role {

	private Long id;
	private String name;//名称
	private String description;//备注
	
	private Set<User> user;//本类与User类是多对多关系
	
	public Set<User> getUser() {
		return user;
	}
	public void setUser(Set<User> user) {
		this.user = user;
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
