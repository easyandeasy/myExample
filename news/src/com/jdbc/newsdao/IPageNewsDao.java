package com.jdbc.newsdao;

import java.util.List;

import com.jdbc.entity.News;
import com.jdbc.entity.Topic;
import com.jdbc.util.PageUtil;

/**
 * ��ҳ���ݷ��ʽӿ���
 * @author tang
 *
 */
public interface IPageNewsDao {

	/**
	 * ��ѯ�����ܼ�¼��
	 * @return
	 */
	public int getTotalCount(int tid);
	
	/**
	 * ��ѯ���ÿҳ���ż���
	 * @param pageNo ��ǰҳ��
	 * @param rowCount ��������
	 * @return �������ż���
	 */
	public List<News> selectPageNewsCountListSQL(PageUtil page,int tid);
	
	
	/**
	 * ��ѯ�����ܼ�¼��
	 * @return 
	 */
	public int getTotalCountTopic();
	
	/**
	 * ��ѯ���ÿҳ���ż���
	 * @param pageNo ��ǰҳ��
	 * @param rowCount ��������
	 * @return �������ż���
	 */
	public List<Topic> getPageTopicCountListSQL(PageUtil page);

	
	
	/**
	 * ��ѯ���ÿҳ���ż���
	 * @param pageNo ��ǰҳ��
	 * @param pageSize ÿҳ��ʾ��¼��
	 * @return �������ż���
	 */
	public List<News> getPageNewsList(int pageNo,int pageSize,int tid);
	
}
