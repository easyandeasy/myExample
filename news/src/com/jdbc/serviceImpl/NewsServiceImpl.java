package com.jdbc.serviceImpl;

import java.util.List;

import com.jdbc.entity.News;
import com.jdbc.newsdao.INewsDao;
import com.jdbc.service.INewsService;
import com.jdbc.topicsdaoImpl.NewsDaoImpl;

/**
 * 新闻业务实现类
 * @author tang
 *
 */
public class NewsServiceImpl implements INewsService {

	INewsDao dao = new NewsDaoImpl();
	
	
	/*public static void main(String[] args){
		NewsServiceImpl i = new NewsServiceImpl();
		for(News s  : i.selectAllnewsByTid("3")){
			System.out.println(s.getNtitle() + "  " + s.getNtime());
		}
	}*/
	/**
	 * 获取所有新闻信息
	 * @return
	 */
	public List<News> selectAllnews(){
		return dao.getAllnews();
	}
	
	/**
	 * 获取主题下的所有的新闻
	 * @param tid
	 * @return
	 */
	public List<News> selectAllnewsByTid(String tid){
		return dao.getAllnewsByTid(Integer.parseInt(tid));
	}
	
	/**
	 * 获取指定id的所有的新闻
	 * @param nid
	 * @return
	 */
	public List<News> selectAllnewsByNid(String tid){
		return dao.getAllnewsByNid(Integer.parseInt(tid));
	}
}
