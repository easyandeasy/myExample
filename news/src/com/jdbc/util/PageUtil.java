package com.jdbc.util;

import java.util.ArrayList;
import java.util.List;

import com.jdbc.entity.News;

/**
 * 分页工具类
 * @author tang
 *
 */
public class PageUtil {

	private int first = 1;//首页
	private int back;//上一页
	private int next;//下一页
	private int last;//末页
	
	private int now;//当前页
	private int count;//总页数
	
	private int pageSize = 5;//每页显示数据
	
	List list = new ArrayList();//每页数据集合
	
	
	/**
	 * 构造方法
	 * @param rowNow 当前页
	 * @param rowCount 总页数
	 */
	public PageUtil(int rowNow,int rowCount){
		if(rowNow>1){//判断当前页是否大于1，大于1进行上一页操作
			back = rowNow -1 ;
		}else{
			back = 1;
		}
		
		if(rowCount%pageSize==0){//进行计算总页数，总数据行数%每页显示数据行数，如能整除，取整除后的商，否则取商再+1
			count = rowCount/pageSize;
		}else{
			count = rowCount/pageSize+1;
		}
		
		if(rowNow<count){//判断下一页是否小于总页数，如果小于总页数进行下一页操作，否则还是当前页
			next = rowNow +1;
		}else{
			next = count;
		}
		
		now = rowNow;
		last = count;
	}


	/**
	 * 读取首页
	 * @return 返回首页
	 */
	public int getFirst() {
		return first;
	}


	/**
	 * 指定首页
	 * @param first 首页
	 */
	public void setFirst(int first) {
		this.first = first;
	}


	/**
	 * 读取上一页
	 * @return 返回上一面
	 */
	public int getBack() {
		return back;
	}


	/**
	 * 指定上一页
	 * @param back 上一页
	 */
	public void setBack(int back) {
		this.back = back;
	}


	/**
	 * 读取下一面
	 * @return 返回下一面
	 */
	public int getNext() {
		return next;
	}


	/**
	 * 指定下一页
	 * @param next
	 */
	public void setNext(int next) {
		this.next = next;
	}


	/**
	 * 指定末页
	 * @return 返回末页
	 */
	public int getLast() {
		return last;
	}


	/**
	 * 指定末页
	 * @param last 末页
	 */
	public void setLast(int last) {
		this.last = last;
	}


	/**
	 * 读取当前页
	 * @return 返回当前页
	 */
	public int getNow() {
		return now;
	}


	/**
	 * 指定当前页
	 * @param now 当前页
	 */
	public void setNow(int now) {
		this.now = now;
	}


	/**
	 * 读取总页数
	 * @return 返回页数
	 */
	public int getCount() {
		return count;
	}


	/**
	 * 指定总页数
	 * @param count 总页数
	 */
	public void setCount(int count) {
		this.count = count;
	}


	/**
	 * 读取每页显示数据行
	 * @return 返回每页显示数据行
	 */
	public int getPageSize() {
		return pageSize;
	}


	
	/**
	 * 指定每页显示数据行
	 * @param pageSize 每页显示数据行
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	/**
	 * 读取每页数据对象
	 * @return 集合对象
	 */
	public List getList() {
		return list;
	}


	/**
	 * 指定每页数据集合
	 * @param list 集合对象
	 */
	public void setList(List list) {
		this.list = list;
	}
}
