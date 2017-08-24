package cn.book.serviceimpl;

import java.util.List;

import cn.book.dao.IBookDao;
import cn.book.daoimpl.BookDaoImpl;
import cn.book.entity.Book;
import cn.book.entity.PageUtil;
import cn.book.service.IBookService;

/**
 * 图书业务逻辑层
 * @author tang
 *
 */
public class BookServiceImpl implements IBookService {

	IBookDao dao = new BookDaoImpl();
	
	/**
	 * 查询图书总数
	 * @return 返回记录数
	 */
	public int selectBookCount(){
		return dao.queryBookCount();
	}
	
	/**
	 * 查询所有图书信息
	 * @return 返回对象集合
	 */
	@Override
	public  List<Book> selectAllBook(PageUtil pages){
		
		return dao.queryAllBook(pages);
	}
}
