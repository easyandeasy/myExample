package com.jdbc.topicsdaoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jdbc.baseDao.BaseDao;
import com.jdbc.entity.Topic;
import com.jdbc.topicsdao.ITopicsDao;

/**
 * ���ݷ��ʲ� ʵ��Ϊ
 * @author tang
 *
 */
public class TopicsDaoImpl extends BaseDao implements ITopicsDao {

	/**
	 * ��ȡ��������
	 * @return ����
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
	 * ��������
	 * @param topic ���󼯺�
	 * @return ������Ӱ�������
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
	 * �������ֲ�������
	 * @param name ��������
	 * @return ����Topic����
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
	 * �������
	 * @param name ��������
	 * @return ������Ӱ�������
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
	 * ͨ��tidɾ������
	 * @param tid ������
	 * @return ������Ӱ�������
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
