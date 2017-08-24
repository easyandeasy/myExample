package com.jdbc.topicsdao;

import java.util.List;
import java.util.Map;
import com.jdbc.entity.Topic;

/**
 * 新闻主题：数据访问层接口类
 * @author tang
 *
 */
public interface ITopicsDao {

	/**
	 * 获取所有主题
	 * @return 集合
	 */
	public List<Topic> getAllTopics();
	
	/**
	 * 更新主题
	 * @param topic 对象集合
	 * @return 返回受影响的行数
	 */
	public int updateTopic(Map<String , String> topic);
	
	/**
	 * 根据名字查找主题
	 * @param name 主题名称
	 * @return 返回Topic对象
	 */
	public Topic findTopicByName(String name);
	
	/**
	 * 添加主题
	 * @param name 主题名称
	 * @return 返回受影响的行数
	 */
	public int addTopic(String name);
	
	/**
	 * 通过tid删除主题
	 * @param tid 主题编号
	 * @return 返回受影响的行数
	 */
	public int deleteTopic(int tid);
}
