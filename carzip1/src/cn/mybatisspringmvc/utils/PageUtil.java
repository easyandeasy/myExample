package cn.mybatisspringmvc.utils;

import java.util.ArrayList;
import java.util.List;


/**
 * 分页工具类
 * @author tang
 *
 */
public class PageUtil {

	private int pageSize = 1;//每页显示数据
	private int pageNow = 1;//当前页
	private int pageCount = 1;//总页数
	private int recordCount = 1;//记录总数
	
	/**
	 * 得到开始记录数
	 * @return
	 */
	public int getStartRow() {
		return (pageNow-1)*pageSize+1;
	}
	
	/**
	 * 得到结束记录数
	 * @return
	 */
	public int getEndRow() {
		return pageSize*pageNow;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		pageCount = this.recordCount / this.pageSize;
		if(this.recordCount % this.pageSize != 0) {
			pageCount = this.recordCount / this.pageSize + 1;
		}
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getRecordCount() {
		
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public PageUtil() {
		
	}
	
}

