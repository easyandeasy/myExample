package com.jdbc.serviceImpl;

import java.util.List;
import java.util.Map;
import com.jdbc.entity.Topic;
import com.jdbc.service.ITopicsService;
import com.jdbc.topicsdao.ITopicsDao;
import com.jdbc.topicsdaoImpl.TopicsDaoImpl;


/**
 * 新闻业务实现烃
 * @author tang
 *
 */
public class TopicsServiceImpl implements ITopicsService {

	ITopicsDao service = new TopicsDaoImpl();
	/**
	 * 获取所有主题
	 * @return 集合
	 */
	public List<Topic> selectAllTopics(){
		return service.getAllTopics();
	}
	
	
	/**
	 * 更新主题
	 * @param topic 对象集合
	 * @return 返回受影响的行数
	 */
	public int replaceTopic(Map<String,String> topic){
		return service.updateTopic(topic);
	}
	
	
	/**
	 * 根据名字查找主题
	 * @param name 主题名称
	 * @return 返回Topic对象
	 */
	public Topic queryTopicByName(String name){
		return service.findTopicByName(name);
	}
	
	
	/**
	 * 添加主题
	 * @param name 主题名称
	 * @return 返回受影响的行数
	 */
	public int insertTopic(String name){
		return service.addTopic(name);
	}
	
	public static void main(String[] args){
		TopicsServiceImpl t = new TopicsServiceImpl();
		System.out.println(t.removeTopic("22"));
	}
	
	/**
	 * 通过tid删除主题
	 * @param tid 主题编号
	 * @return 返回受影响的行数
	 */
	public boolean removeTopic(String tid){
		return service.deleteTopic(Integer.parseInt(tid))>0?true:false;
	}
}
