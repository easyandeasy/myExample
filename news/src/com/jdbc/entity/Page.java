package com.jdbc.entity;

import java.util.List;

/**
 * ��ҳ��
 * @author tang
 *
 */
public class Page {

	
	private int totalPageCount = 1;//��ҳ��
	
	private int pageSize = 0;//ҳ���С����ÿҳ��ʾ��¼��
	
	private int totalCount = 0;//��¼����
	
	private int currPageNo = 1;//��ǰҳ��
	
	private List<News> newsList;//ÿҳ���ż���
	
	
	/**
	 * �޲ι��췽��
	 */
	public Page() {}

	/**
	 * �вι��췽��
	 * @param totalPageCount ��ҳ��
	 * @param pageSize ÿҳ��ʾ��¼��
	 * @param totalCount ��¼���� 
	 * @param currPageNo ��ǰҳ��
	 * @param newsList ÿҳ���ż���
	 */
	public Page(int totalPageCount, int pageSize, int totalCount,int currPageNo, List<News> newsList) {
		this.totalPageCount = totalPageCount;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.currPageNo = currPageNo;
		this.newsList = newsList;
	}

	/**
	 * ��ȡ��ҳ��
	 * @return ������ҳ��
	 */
	public int getTotalPageCount() {
		return totalPageCount;
	}

	/**
	 * ָ����ҳ��
	 * @param totalPageCount ��ҳ��
	 */
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	/**
	 * ��ȡÿҳ��ʾ��¼��
	 * @return ����ÿҳ��ʾ��¼��
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * ָ��ÿҳ��ʾ��¼��
	 * @param pageSize ��ҳ��ʾ��¼��
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * ��ȡ��¼����
	 * @return ���ؼ�¼����
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * ָ����¼����
	 * @param totalCount ��¼����
	 */
	public void setTotalCount(int totalCount) {
		if(totalCount>0){
			this.totalCount = totalCount;
			//������ҳ��
			totalPageCount = totalCount%pageSize==0?(this.totalCount/pageSize):(this.totalCount/pageSize+1);
		}
	}

	/**
	 * ��ȡ��ǰҳ��
	 * @return ���ص�ǰҳ��
	 */
	public int getCurrPageNo() {
		return currPageNo;
	}

	/**
	 * ָ����ǰҳ��
	 * @param currPageNo ��ǰҳ��
	 */
	public void setCurrPageNo(int currPageNo) {
		this.currPageNo = currPageNo;
	}

	/**
	 * ��ȡ���ż���
	 * @return �������ż���
	 */
	public List<News> getNewsList() {
		return newsList;
	}

	/**
	 * ָ��ÿҳ���ż���
	 * @param newsList ���ż���
	 */
	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}
	
}
