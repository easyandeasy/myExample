package com.jdbc.service;

import java.util.List;

import com.jdbc.entity.News;
import com.jdbc.entity.Topic;
import com.jdbc.util.PageUtil;

/**
 * 业务逻辑层接口类
 * @author tang
 *
 */
public interface IPageService {

	/**
	 * 查询总记录数
	 * @return
	 */
	public int selectTotalCount(int tid);
	
	
	/**
	 * 查询获得每页新闻集合
	 * @param pageNo 当前页号
	 * @param pageSize 每页显示记录数
	 * @return 返回新闻集合
	 */
	public List<News> selectPageNewsList(int pageNo,int pageSize,int tid);
	
	/**
	 * 查询获得每页新闻集合
	 * @param pageNo 当前页号
	 * @param rowCount 总数据行
	 * @return 返回新闻集合
	 */
	public List<News> selectPageNewsCountList(PageUtil page,int tid);
	
	/**
	 * 查询主题总记录数
	 * @return 
	 */
	public int selectTotalCountTopic();
	
	/**
	 * 查询获得每页新闻集合
	 * @param pageNo 当前页号
	 * @param rowCount 总数据行
	 * @return 返回新闻集合
	 */
	public List<Topic> selectPageTopicCountListSQL(PageUtil page);
}
