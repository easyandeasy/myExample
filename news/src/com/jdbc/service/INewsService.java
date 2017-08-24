package com.jdbc.service;

import java.util.List;
import com.jdbc.entity.News;

/**
 * ����ҵ��ӿ���
 * @author tang
 *
 */
public interface INewsService {

	/**
	 * ��ȡ����������Ϣ
	 * @return
	 */
	public List<News> selectAllnews();
	
	/**
	 * ��ȡ�����µ����е�����
	 * @param tid
	 * @return
	 */
	public List<News> selectAllnewsByTid(String tid);
	
	/**
	 * ��ȡָ��id�����е�����
	 * @param nid
	 * @return
	 */
	public List<News> selectAllnewsByNid(String tid);
}
