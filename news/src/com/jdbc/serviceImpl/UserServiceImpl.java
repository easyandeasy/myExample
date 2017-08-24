package com.jdbc.serviceImpl;

import com.jdbc.entity.Users;
import com.jdbc.service.IUserService;
import com.jdbc.topicsdaoImpl.UserDaoImpl;
import com.jdbc.userdao.IUserDao;

/**
 * �û�ҵ��ʵ������
 * @author tang
 *
 */
public class UserServiceImpl implements IUserService{

	IUserDao dao = new UserDaoImpl(); 
	/**
	 * ��ѯ�û� ��Ϣ
	 * @param user
	 * @return
	 */
	public boolean selectQuerySQl(Users user){
		boolean flag = false;
		Users users = dao.excuteQuerySQl(user);
		if(users==null)return flag;
		if(users.getApwd().equals(user.getApwd())){
			flag = true;
		}
		return flag;
	}
	
	/**
	 * �����û����Ƿ����
	 * @param name �û���
	 * @return ������ڷ���true�����򷵻�false
	 */
	public boolean queryByName(String name){
		return dao.findByName(name)>0?true:false;
	}
}
