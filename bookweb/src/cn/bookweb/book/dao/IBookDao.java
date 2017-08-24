package cn.bookweb.book.dao;

import java.util.List;

import cn.bookweb.book.entity.Book;
import cn.bookweb.page.util.PageUtil;

/**
 * 图书数据访问层
 * @author tang
 *
 */
public interface IBookDao {
	
	/**
	 * 查询图书所有信息
	 * @return 返回集合对象
	 */
	public List<Book> selectBookAllInfo();

	/**
	 * 根据id查询图书
	 * @return 返回集合对象
	 */
	public List<Book> selectBookByTidSQL(String tid,PageUtil pages);
	
	
	/**
	 * 根据id分页查询图书
	 * @return 返回集合对象
	 */
	public List<Book> selectBookInfoPage(String bname,PageUtil pages);
	
	

	
	
	/**
	 * 根据bid查询 单本图书信息
	 * @return 返回集合对象
	 */
	public List<Book> selectBookByBidSQL(int bid);
	
	/**
	 * 查询图书总记录数
	 * @return 查询的记录数
	 * @param tid 所属类型的 编号
	 */
	public int selectBookCountSQL(String tid);
	
	
	/**
	 * 查询图书名称总记录数
	 * @return 查询的记录数
	 * @param tid 所属类型的 编号
	 */
	public int selectBookCountByBnameSQL(String bname);
	
	

	
	/**
	 * 添加图书
	 * @param book 图书对象
	 * @return
	 */
	public int insertBookInfo(Book book);
	
	
	/**
	 * 模糊查询图书
	 * @param bname 图书名称
	 * @return 集合对象
	 */
	public List<Book> selectBookInfoLike(String bname);
	
	/**
	 * 查询精品图书信息，查询今日促销图书
	 * @return
	 */
	public List<Book> selectBooksend(Book book);
	
	
	/**
	 * 根据bid 删除图书信息
	 * @param bid 图书id
	 * @return 返回受影响的行数
	 */
	public int deleteBookInfoSQL(int bid);
	
	/**
	 * 根据bid修改图书信息
	 * @param bid 图书id
	 * @return 返回受影响的行数
	 */
	public int updateBookInfoSQL(Book book);
	
	/**
	 * 根据bid修改上下架
	 * @param bid 图书id
	 * @return 返回受影响的行数
	 */
	public int updateBookHlframeSQL(int hlframe,int bid);
	
	/**
	 * 根据分页查询所有图书信息
	 * @param pages
	 * @return
	 */
	public List<Book> selectAllOrderBook(PageUtil pages,String bigtid);
	
	/**
	 * 根据图书id查询图书详情信息
	 * @return 返回一个集合
	 */
	public List<Book> selectBookDacktionInfo(Book book);
	
}
