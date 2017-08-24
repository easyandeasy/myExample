package com.jdbc.service;

import java.util.List;
import java.util.Map;

import com.jdbc.entity.Topic;

/**
 * 主题业务接口类
 * @author tang
 *
 */
public interface ITopicsService {

	/**
	 * 获取所有主题
	 * @return 集合
	 */
	public List<Topic> selectAllTopics();
	
	
	/**
	 * 更新主题
	 * @param topic 对象集合
	 * @return 返回受影响的行数
	 */
	public int replaceTopic(Map<String,String> topic);
	
	
	/**
	 * 根据名字查找主题
	 * @param name 主题名称
	 * @return 返回Topic对象
	 */
	public Topic queryTopicByName(String name);
	
	
	/**
	 * 添加主题
	 * @param name 主题名称
	 * @return 返回受影响的行数
	 */
	public int insertTopic(String name);
	
	
	/**
	 * 通过tid删除主题
	 * @param tid 主题编号
	 * @return 返回受影响的行数
	 */
	public boolean removeTopic(String tid);
}
