package com.jdbc.serviceImpl;

import java.util.List;

import com.jdbc.entity.News;
import com.jdbc.newsdao.INewsDao;
import com.jdbc.service.INewsService;
import com.jdbc.topicsdaoImpl.NewsDaoImpl;

/**
 * ����ҵ��ʵ����
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
	 * ��ȡ����������Ϣ
	 * @return
	 */
	public List<News> selectAllnews(){
		return dao.getAllnews();
	}
	
	/**
	 * ��ȡ�����µ����е�����
	 * @param tid
	 * @return
	 */
	public List<News> selectAllnewsByTid(String tid){
		return dao.getAllnewsByTid(Integer.parseInt(tid));
	}
	
	/**
	 * ��ȡָ��id�����е�����
	 * @param nid
	 * @return
	 */
	public List<News> selectAllnewsByNid(String tid){
		return dao.getAllnewsByNid(Integer.parseInt(tid));
	}
}
