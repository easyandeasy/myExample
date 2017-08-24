package cn.bookweb.book.serviceimpl;

import java.util.List;

import cn.bookweb.basedao.BaseDao;
import cn.bookweb.book.dao.IBookDao;
import cn.bookweb.book.daoimpl.BookDaoImpl;
import cn.bookweb.book.entity.Book;
import cn.bookweb.book.service.IBookService;
import cn.bookweb.page.util.PageUtil;

/**
 * 图书业务逻辑层实现类
 * @author tang
 *
 */
public class BookServiceImpl extends BaseDao implements IBookService  {

	IBookDao dao = new BookDaoImpl();
	/**
	 * 查询图书所有信息
	 * @return 返回集合对象
	 */
	public List<Book> queryBookAllInfo(){
		return dao.selectBookAllInfo();
	}
	

	/**
	 * 根据id查询图书信息
	 * @return 返回集合对象
	 */
	public List<Book> queryBookByTid(String tid,PageUtil pages){
		return dao.selectBookByTidSQL(tid,pages);
	}
	
	
	/**
	 * 根据bid查询 单本图书信息
	 * @return 返回集合对象
	 */
	public Book queryBookByBid(int bid){
		Book update = new Book();
		for(Book b : dao.selectBookByBidSQL(bid)){
			update = b;
		}
		return update;
	}
	
	
	/**
	 * 查询所属类型的图书记录数
	 * @param tid 所属类型编号
	 * @return 返回查询到的记录数
	 */
	public int queryBookCount(String tid){
		return dao.selectBookCountSQL(tid);
	}
	
	
	/**
	 * 添加图书
	 * @param book 图书对象
	 * @return 判断是否添加图书成功。为true成功，否则不成功
	 */
	public boolean addBookInfo(Book book){
		boolean flag = false;
		if(dao.insertBookInfo(book)>0){
			flag = true;
		}
		return flag;
	}
	
	
	/**
	 * 模糊查询图书
	 * @param bname 图书名称
	 * @param now 当前页
	 * @return 集合对象
	 */
	public List<Book> queryBookInfoLike(String bname){
		return dao.selectBookInfoLike(bname);
	}
	
	
	/**
	 * 模糊分页查询图书
	 * @param bname 图书名称
	 * @param now 当前页
	 * @return 集合对象
	 */
	public List<Book> queryBookInfoPage(String bname,PageUtil page){
		return dao.selectBookInfoPage(bname, page);
	}
	
	
	/**
	 * 查询图书名称总记录数
	 * @return 查询的记录数
	 * @param tid 所属类型的 编号
	 */
	public int queryBookCountByBname(String bname){
		return dao.selectBookCountByBnameSQL(bname);
	}
	
	
	/**
	 * 查询精品图书信息，查询今日促销图书
	 * @return
	 */
	public List<Book> selectBooksend(Book book){
		return dao.selectBooksend(book);
	}
	
	
	/**
	 * 根据bid 删除图书信息
	 * @param bid 图书id
	 * @return 返回受影响的行数
	 */
	public boolean removeBookInfo(int bid){
		boolean flag = false;
		if(dao.deleteBookInfoSQL(bid)>0){
			flag = true;
		}
		return flag;
	}
	
	/**
	 * 根据bid修改图书信息
	 * @param bid 图书id
	 * @return 返回受影响的行数
	 */
	public boolean replaceBookInfo(Book book){
		boolean flag = false;
		if(dao.updateBookInfoSQL(book)>0){
			flag = true;
		}
		return flag;
	}
	
	
	/**
	 * 根据bid修改上下架
	 * @param bid 图书id
	 * @return 返回受影响的行数
	 */
	public boolean replaceBookHlframeSQL(int hlframe,int bid){
		boolean flag = false;
		if(dao.updateBookHlframeSQL(hlframe,bid)>0){
			flag = true;
		}
		return flag;
	}
	
	 /**
	  * 查询图书所有信息 并且分页显示
	  * @param pages
	  * @return 返回数据集合
	  */ 
	public List<Book> queryAllOrderBook(PageUtil pages,String bigtid){
		return dao.selectAllOrderBook(pages,bigtid);
	}
}
