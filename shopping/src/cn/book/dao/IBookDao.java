package cn.book.dao;

import java.util.List;

import cn.book.entity.Book;
import cn.book.entity.PageUtil;

/**
 * 数据访问层接口类
 * @author tang
 *
 */
public interface IBookDao {

	/**
	 * 查询图书总数
	 * @return 返回记录数
	 */
	public int queryBookCount();
	
	/**
	 * 查询所有图书信息
	 * @return 返回对象集合
	 */
	public abstract List<Book> queryAllBook(PageUtil pages);

}