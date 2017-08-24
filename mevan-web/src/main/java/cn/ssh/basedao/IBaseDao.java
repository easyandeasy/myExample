package cn.ssh.basedao;

import java.util.List;

/**
 * 提取出公共的方法接口
 * @author tang
 *
 * @param <T>
 */
public interface IBaseDao<T> {
	
	/**
	 * 根据id进行删除
	 * @param id
	 */
	void delete(Long id);
	
	/**
	 * 查询所有信息
	 * @return
	 */
	List<T> findAll();
	
	/**
	 * 根据id查询信息
	 * @param id
	 * @return
	 */
	T getById(Long id);
	
	/**
	 * 根据多个id进行查询信息
	 * @param id
	 * @return
	 */
	List<T> getByIds(Long[] ids);
	
	
	/**
	 * 保存信息
	 * @param entity
	 */
	void save(T entity);
	
	/**
	 * 修改信息
	 * @param entity
	 * @return
	 */
	void update(T entity);
}
