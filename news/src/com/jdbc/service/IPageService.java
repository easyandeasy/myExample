package com.jdbc.service;

import java.util.List;

import com.jdbc.entity.News;
import com.jdbc.entity.Topic;
import com.jdbc.util.PageUtil;

/**
 * ҵ���߼���ӿ���
 * @author tang
 *
 */
public interface IPageService {

	/**
	 * ��ѯ�ܼ�¼��
	 * @return
	 */
	public int selectTotalCount(int tid);
	
	
	/**
	 * ��ѯ���ÿҳ���ż���
	 * @param pageNo ��ǰҳ��
	 * @param pageSize ÿҳ��ʾ��¼��
	 * @return �������ż���
	 */
	public List<News> selectPageNewsList(int pageNo,int pageSize,int tid);
	
	/**
	 * ��ѯ���ÿҳ���ż���
	 * @param pageNo ��ǰҳ��
	 * @param rowCount ��������
	 * @return �������ż���
	 */
	public List<News> selectPageNewsCountList(PageUtil page,int tid);
	
	/**
	 * ��ѯ�����ܼ�¼��
	 * @return 
	 */
	public int selectTotalCountTopic();
	
	/**
	 * ��ѯ���ÿҳ���ż���
	 * @param pageNo ��ǰҳ��
	 * @param rowCount ��������
	 * @return �������ż���
	 */
	public List<Topic> selectPageTopicCountListSQL(PageUtil page);
}
