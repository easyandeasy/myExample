package com.jdbc.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.jdbc.entity.News;
import com.jdbc.entity.Topic;
import com.jdbc.util.PageUtil;
import com.jdbc.newsdao.IPageNewsDao;
import com.jdbc.service.IPageService;
import com.jdbc.topicsdaoImpl.PageNewsDaoImpl;

/**
 * 业务逻辑层实现类
 * @author tang
 *
 */
public class PageServiceImpl implements IPageService {

	IPageNewsDao dao = new PageNewsDaoImpl();
	/**
	 * 查询总记录数
	 * @return
	 */
	public int selectTotalCount(int tid){
		return dao.getTotalCount(tid);
	}
	
	
	/**
	 * 查询获得每页新闻集合
	 * @param pageNo 当前页号
	 * @param pageSize 每页显示记录数
	 * @return 返回新闻集合
	 */
	public List<News> selectPageNewsList(int pageNo,int pageSize,int tid){
		return dao.getPageNewsList(pageNo, pageSize, tid);
	}
	
	/**
	 * 查询获得每页新闻集合
	 * @param pageNo 当前页号
	 * @param rowCount 总数据行
	 * @return 返回新闻集合
	 */
	public List<News> selectPageNewsCountList(PageUtil page,int tid){
		List<News> list = new ArrayList();
		list = dao.selectPageNewsCountListSQL(page, tid);
		return list;
	}
	
	
	/**
	 * 查询主题总记录数
	 * @return 
	 */
	public int selectTotalCountTopic(){
		return dao.getTotalCountTopic();
	}
	
	/**
	 * 查询获得每页新闻集合
	 * @param pageNo 当前页号
	 * @param rowCount 总数据行
	 * @return 返回新闻集合
	 */
	public List<Topic> selectPageTopicCountListSQL(PageUtil page){
		return dao.getPageTopicCountListSQL(page);
	}
}
