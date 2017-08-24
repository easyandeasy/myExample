package com.jdbc.topicsdaoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jdbc.baseDao.BaseDao;
import com.jdbc.entity.Topic;
import com.jdbc.topicsdao.ITopicsDao;

/**
 * 数据访问层 实现为
 * @author tang
 *
 */
public class TopicsDaoImpl extends BaseDao implements ITopicsDao {

	/**
	 * 获取所有主题
	 * @return 集合
	 */
	public List<Topic> getAllTopics(){
		List<Topic> list = new ArrayList();
		
		String sql = "SELECT tid,tname FROM topic ";
		
		rs = executeQuerySQL(sql,null);
		
		try {
			while(rs.next()){
				Topic topic = new Topic();
				topic.setTid(rs.getInt("tid"));
				topic.setTname(rs.getString("tname"));
				list.add(topic);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		
		return list;
	}
	
	/**
	 * 更新主题
	 * @param topic 对象集合
	 * @return 返回受影响的行数
	 */
	public int updateTopic(Map<String,String> topic){
		int row = 0;
		String sql = "update topic set tname=? where tid=?";
		Object[] obj = {topic.get("tname"),topic.get("tid")};
		row = executeUpdateSQL(sql, obj);
		closeAllSQL();
		return row;
	}
	
	/**
	 * 根据名字查找主题
	 * @param name 主题名称
	 * @return 返回Topic对象
	 */
	public Topic findTopicByName(String name){
		Topic topic = null;
		String sql ="select tid,tname from topic where tname=?";
		Object[] obj = {name};
		rs = executeQuerySQL(sql, obj);
		try {
			while(rs.next()){
				topic = new Topic();
				topic.setTid(rs.getInt("tid"));
				topic.setTname(rs.getString("tname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return topic;
	}
	
	/**
	 * 添加主题
	 * @param name 主题名称
	 * @return 返回受影响的行数
	 */
	public int addTopic(String name){
		int row = 0;
		String sql = "insert into topic(tname) values(?)";
		Object[] obj = {name};
		row = executeUpdateSQL(sql, obj);
		closeAllSQL();
		return row;
	}
	
	/**
	 * 通过tid删除主题
	 * @param tid 主题编号
	 * @return 返回受影响的行数
	 */
	public int deleteTopic(int tid){
		int row = 0;
		String sql = "delete from topic where tid=?";
		Object[] obj = {tid};
		row = executeUpdateSQL(sql, obj);
		closeAllSQL();
		return row;
	}
}
