package com.jdbc.newsdao;

import java.util.List;

import com.jdbc.entity.News;
import com.jdbc.entity.Topic;
import com.jdbc.util.PageUtil;

/**
 * 分页数据访问接口类
 * @author tang
 *
 */
public interface IPageNewsDao {

	/**
	 * 查询新闻总记录数
	 * @return
	 */
	public int getTotalCount(int tid);
	
	/**
	 * 查询获得每页新闻集合
	 * @param pageNo 当前页号
	 * @param rowCount 总数据行
	 * @return 返回新闻集合
	 */
	public List<News> selectPageNewsCountListSQL(PageUtil page,int tid);
	
	
	/**
	 * 查询主题总记录数
	 * @return 
	 */
	public int getTotalCountTopic();
	
	/**
	 * 查询获得每页新闻集合
	 * @param pageNo 当前页号
	 * @param rowCount 总数据行
	 * @return 返回新闻集合
	 */
	public List<Topic> getPageTopicCountListSQL(PageUtil page);

	
	
	/**
	 * 查询获得每页新闻集合
	 * @param pageNo 当前页号
	 * @param pageSize 每页显示记录数
	 * @return 返回新闻集合
	 */
	public List<News> getPageNewsList(int pageNo,int pageSize,int tid);
	
}
