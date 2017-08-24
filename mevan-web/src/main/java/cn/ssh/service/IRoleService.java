package cn.ssh.service;

import java.util.List;

import cn.ssh.beans.Role;

/**
 * 提取出公共的方法接口
 * @author tang
 *
 * @param <T>
 */
public interface IRoleService {

	List<Role> findAll();

	void delete(Long id);

	void addUser(Role role);

	Role getById(Long id);

	void update(Role role);
	
	
}
