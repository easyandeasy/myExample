package com.jdbc.service;

import com.jdbc.entity.Users;

/**
 * �û�ҵ��ӿ���
 * @author tang
 *
 */
public interface IUserService {

	/**
	 * ��ѯ�û� ��Ϣ
	 * @param user
	 * @return
	 */
	public boolean selectQuerySQl(Users user);
	
	/**
	 * �����û����Ƿ����
	 * @param name �û���
	 * @return ������ڷ���true�����򷵻�false
	 */
	public boolean queryByName(String name);
}
