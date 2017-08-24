package cn.user.dao;

import java.util.List;

import cn.book.entity.User;

/**
 * �û����ݷ��ʲ�
 * @author tang
 *
 */
public interface IUserDao {

	/**
	 * ��ѯ�û��Ƿ����
	 * @return
	 */
	public int queryIsUser(String name , String pwd );
	
	/**
	 * ��ѯ�û�������Ϣ
	 * @return
	 */
	public List<User> queryUserAllInfo();
}
