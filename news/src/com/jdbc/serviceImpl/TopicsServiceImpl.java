package com.jdbc.serviceImpl;

import java.util.List;
import java.util.Map;
import com.jdbc.entity.Topic;
import com.jdbc.service.ITopicsService;
import com.jdbc.topicsdao.ITopicsDao;
import com.jdbc.topicsdaoImpl.TopicsDaoImpl;


/**
 * ����ҵ��ʵ����
 * @author tang
 *
 */
public class TopicsServiceImpl implements ITopicsService {

	ITopicsDao service = new TopicsDaoImpl();
	/**
	 * ��ȡ��������
	 * @return ����
	 */
	public List<Topic> selectAllTopics(){
		return service.getAllTopics();
	}
	
	
	/**
	 * ��������
	 * @param topic ���󼯺�
	 * @return ������Ӱ�������
	 */
	public int replaceTopic(Map<String,String> topic){
		return service.updateTopic(topic);
	}
	
	
	/**
	 * �������ֲ�������
	 * @param name ��������
	 * @return ����Topic����
	 */
	public Topic queryTopicByName(String name){
		return service.findTopicByName(name);
	}
	
	
	/**
	 * �������
	 * @param name ��������
	 * @return ������Ӱ�������
	 */
	public int insertTopic(String name){
		return service.addTopic(name);
	}
	
	public static void main(String[] args){
		TopicsServiceImpl t = new TopicsServiceImpl();
		System.out.println(t.removeTopic("22"));
	}
	
	/**
	 * ͨ��tidɾ������
	 * @param tid ������
	 * @return ������Ӱ�������
	 */
	public boolean removeTopic(String tid){
		return service.deleteTopic(Integer.parseInt(tid))>0?true:false;
	}
}
