package com.jdbc.topicsdao;

import java.util.List;
import java.util.Map;
import com.jdbc.entity.Topic;

/**
 * �������⣺���ݷ��ʲ�ӿ���
 * @author tang
 *
 */
public interface ITopicsDao {

	/**
	 * ��ȡ��������
	 * @return ����
	 */
	public List<Topic> getAllTopics();
	
	/**
	 * ��������
	 * @param topic ���󼯺�
	 * @return ������Ӱ�������
	 */
	public int updateTopic(Map<String , String> topic);
	
	/**
	 * �������ֲ�������
	 * @param name ��������
	 * @return ����Topic����
	 */
	public Topic findTopicByName(String name);
	
	/**
	 * �������
	 * @param name ��������
	 * @return ������Ӱ�������
	 */
	public int addTopic(String name);
	
	/**
	 * ͨ��tidɾ������
	 * @param tid ������
	 * @return ������Ӱ�������
	 */
	public int deleteTopic(int tid);
}
