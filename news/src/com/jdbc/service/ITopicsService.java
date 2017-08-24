package com.jdbc.service;

import java.util.List;
import java.util.Map;

import com.jdbc.entity.Topic;

/**
 * ����ҵ��ӿ���
 * @author tang
 *
 */
public interface ITopicsService {

	/**
	 * ��ȡ��������
	 * @return ����
	 */
	public List<Topic> selectAllTopics();
	
	
	/**
	 * ��������
	 * @param topic ���󼯺�
	 * @return ������Ӱ�������
	 */
	public int replaceTopic(Map<String,String> topic);
	
	
	/**
	 * �������ֲ�������
	 * @param name ��������
	 * @return ����Topic����
	 */
	public Topic queryTopicByName(String name);
	
	
	/**
	 * �������
	 * @param name ��������
	 * @return ������Ӱ�������
	 */
	public int insertTopic(String name);
	
	
	/**
	 * ͨ��tidɾ������
	 * @param tid ������
	 * @return ������Ӱ�������
	 */
	public boolean removeTopic(String tid);
}
