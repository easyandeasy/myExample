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
 * ҵ���߼���ʵ����
 * @author tang
 *
 */
public class PageServiceImpl implements IPageService {

	IPageNewsDao dao = new PageNewsDaoImpl();
	/**
	 * ��ѯ�ܼ�¼��
	 * @return
	 */
	public int selectTotalCount(int tid){
		return dao.getTotalCount(tid);
	}
	
	
	/**
	 * ��ѯ���ÿҳ���ż���
	 * @param pageNo ��ǰҳ��
	 * @param pageSize ÿҳ��ʾ��¼��
	 * @return �������ż���
	 */
	public List<News> selectPageNewsList(int pageNo,int pageSize,int tid){
		return dao.getPageNewsList(pageNo, pageSize, tid);
	}
	
	/**
	 * ��ѯ���ÿҳ���ż���
	 * @param pageNo ��ǰҳ��
	 * @param rowCount ��������
	 * @return �������ż���
	 */
	public List<News> selectPageNewsCountList(PageUtil page,int tid){
		List<News> list = new ArrayList();
		list = dao.selectPageNewsCountListSQL(page, tid);
		return list;
	}
	
	
	/**
	 * ��ѯ�����ܼ�¼��
	 * @return 
	 */
	public int selectTotalCountTopic(){
		return dao.getTotalCountTopic();
	}
	
	/**
	 * ��ѯ���ÿҳ���ż���
	 * @param pageNo ��ǰҳ��
	 * @param rowCount ��������
	 * @return �������ż���
	 */
	public List<Topic> selectPageTopicCountListSQL(PageUtil page){
		return dao.getPageTopicCountListSQL(page);
	}
}
