package com.jdbc.userdao;

import com.jdbc.entity.Users;

/**
 * �û����ݷ���ʵ����
 * @author tang
 *
 */
public interface IUserDao {

	/**
	 * ��ѯ�û� ��Ϣ
	 * @param user
	 * @return
	 */
	public Users excuteQuerySQl(Users user);
	
	/**
	 * �����û����Ƿ����
	 * @param name �û���
	 * @return ������Ӱ�������
	 */
	public int findByName(String name);
}
