package com.jdbc.newsdao;

import java.util.List;

import com.jdbc.entity.News;
import com.jdbc.topicsdao.ITopicsDao;

/**
 * 新闻内容：数据访问接口类
 * @author tang
 *
 */
public interface INewsDao {

	/**
	 * 获取所有新闻信息
	 * @return
	 */
	public List<News> getAllnews();
	
	
	/**
	 * 获取主题下的所有的新闻
	 * @param tid
	 * @return
	 */
	public List<News> getAllnewsByTid(int tid);
	
	
	/**
	 * 获取指定id的所有的新闻
	 * @param nid
	 * @return
	 */
	public List<News> getAllnewsByNid(int tid);
}
