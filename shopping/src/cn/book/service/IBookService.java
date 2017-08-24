package cn.book.service;

import java.util.List;

import cn.book.entity.Book;
import cn.book.entity.PageUtil;

public interface IBookService {
	
	/**
	 * 查询图书总数
	 * @return 返回记录数
	 */
	public int selectBookCount();
	

	/**
	 * 查询所有图书信息
	 * @return 返回对象集合
	 */
	public abstract List<Book> selectAllBook(PageUtil pages);

}