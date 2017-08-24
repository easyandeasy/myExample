package cn.ssh.service;

import java.util.List;

import cn.ssh.beans.Description;

public interface IDescriptionService {

	List<Description> findAll();

	void delete(Long id);

	cn.ssh.beans.Description getById(Long id);

	void update(Description description);

	void addDescription(Description model);

}
