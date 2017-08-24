package cn.user.service;

/**
 * 业务逻辑层
 * @author tang
 *
 */
public interface IUserService {

	/**
	 * 判断用户是否存在
	 * @return
	 */
	public boolean selectIsUser(String name , String pwd);
	
}
