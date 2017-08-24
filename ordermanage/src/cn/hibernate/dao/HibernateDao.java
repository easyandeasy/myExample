package cn.hibernate.dao;

import org.hibernate.Session;

import cn.hibernate.util.HibernateUtils;

/**
 * hibernatedao类
 * @author tang
 *
 */
public class HibernateDao {

	/**
	 * 获取session
	 * @return
	 */
	public Session getSession() {
		return HibernateUtils.getSession();
	}
	
	/**
	 * 获取关闭session
	 */
	public void closeSession() {
		HibernateUtils.closeSession();
	}
}
