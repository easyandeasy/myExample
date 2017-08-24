package com.jdbc.entity;

import java.util.List;

/**
 * 分页类
 * @author tang
 *
 */
public class Page {

	
	private int totalPageCount = 1;//总页数
	
	private int pageSize = 0;//页面大小，即每页显示记录数
	
	private int totalCount = 0;//记录总数
	
	private int currPageNo = 1;//当前页号
	
	private List<News> newsList;//每页新闻集合
	
	
	/**
	 * 无参构造方法
	 */
	public Page() {}

	/**
	 * 有参构造方法
	 * @param totalPageCount 总页数
	 * @param pageSize 每页显示记录数
	 * @param totalCount 记录总数 
	 * @param currPageNo 当前页号
	 * @param newsList 每页新闻集合
	 */
	public Page(int totalPageCount, int pageSize, int totalCount,int currPageNo, List<News> newsList) {
		this.totalPageCount = totalPageCount;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.currPageNo = currPageNo;
		this.newsList = newsList;
	}

	/**
	 * 读取总页数
	 * @return 返回总页数
	 */
	public int getTotalPageCount() {
		return totalPageCount;
	}

	/**
	 * 指定总页数
	 * @param totalPageCount 总页数
	 */
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	/**
	 * 读取每页显示记录数
	 * @return 返回每页显示记录数
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 指定每页显示记录数
	 * @param pageSize 第页显示记录数
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 读取记录总数
	 * @return 返回记录总数
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * 指定记录总数
	 * @param totalCount 记录总数
	 */
	public void setTotalCount(int totalCount) {
		if(totalCount>0){
			this.totalCount = totalCount;
			//计算总页数
			totalPageCount = totalCount%pageSize==0?(this.totalCount/pageSize):(this.totalCount/pageSize+1);
		}
	}

	/**
	 * 读取当前页号
	 * @return 返回当前页号
	 */
	public int getCurrPageNo() {
		return currPageNo;
	}

	/**
	 * 指定当前页号
	 * @param currPageNo 当前页号
	 */
	public void setCurrPageNo(int currPageNo) {
		this.currPageNo = currPageNo;
	}

	/**
	 * 读取新闻集合
	 * @return 返回新闻集合
	 */
	public List<News> getNewsList() {
		return newsList;
	}

	/**
	 * 指定每页新闻集合
	 * @param newsList 新闻集合
	 */
	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}
	
}
