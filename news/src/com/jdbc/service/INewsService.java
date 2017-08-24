package com.jdbc.service;

import java.util.List;
import com.jdbc.entity.News;

/**
 * 新闻业务接口类
 * @author tang
 *
 */
public interface INewsService {

	/**
	 * 获取所有新闻信息
	 * @return
	 */
	public List<News> selectAllnews();
	
	/**
	 * 获取主题下的所有的新闻
	 * @param tid
	 * @return
	 */
	public List<News> selectAllnewsByTid(String tid);
	
	/**
	 * 获取指定id的所有的新闻
	 * @param nid
	 * @return
	 */
	public List<News> selectAllnewsByNid(String tid);
}
