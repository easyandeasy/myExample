package com.jdbc.newsdao;

import java.util.List;

import com.jdbc.entity.News;
import com.jdbc.topicsdao.ITopicsDao;

/**
 * �������ݣ����ݷ��ʽӿ���
 * @author tang
 *
 */
public interface INewsDao {

	/**
	 * ��ȡ����������Ϣ
	 * @return
	 */
	public List<News> getAllnews();
	
	
	/**
	 * ��ȡ�����µ����е�����
	 * @param tid
	 * @return
	 */
	public List<News> getAllnewsByTid(int tid);
	
	
	/**
	 * ��ȡָ��id�����е�����
	 * @param nid
	 * @return
	 */
	public List<News> getAllnewsByNid(int tid);
}
