package cn.bookweb.booktype.dao;

import java.util.List;

import cn.bookweb.book.entity.Book;
import cn.bookweb.booktype.entity.BookType;
import cn.bookweb.page.util.PageUtil;

/**
 * 图书类型数据访问层
 * @author tang
 *
 */
public interface IBookTypeDao {
	
	/**
	 * 查询图书类型所有信息
	 * @return 返回集合对象
	 */
	public List<BookType> selectBookTypeAllInfo();
	
	/**
	 * 查询图书类型分页信息
	 * @return 返回集合对象
	 */
	public List<BookType> selectBookTypeAllPageInfo(PageUtil page);
	
	
	/**
	 * 根据类型名称分页查询图书类型信息条数
	 * @return 信息条数
	 */
	public int selectBookTypeCount(String tname);
	
	
	/**
	 * 根据pid图书信息
	 * @param pid 大类编号
	 * @return 返回集合对象
	 */
	public List<BookType> selectBookByPidSQL(int pid,PageUtil page);
	
	/**
	 * 根据分类型名称查询图书类型信息条数
	 * @return 信息条数
	 */
	public int selectBookTypeByPidCount(String pid);
	
	
	/**
	 * 根据类型名称分页查询图书类型信息
	 * @return 返回集合对象
	 */
	public List<BookType> selectBookTypeByTnameInfo(String tname,PageUtil page);
	
	
	/**
	 * 添加一、二级类型
	 * @param type 类型对象
	 * @return 返回受影响的行数
	 */
	public int insertBookTypeSQL(BookType type);
	
	
	/**
	 * 根据tid删除一、二级类型
	 * @param tid 类型编号
	 * @return 返回受影响的行数
	 */
	public int deleteBookTypeSQL(String tid);
	
	
	/**
	 * 根据类型对象进行修改
	 * @param type 类型对象
	 * @return 返回受影响的行数
	 */
	public int updateBookTypeSQL(BookType type);
	
	
	/**
	 * 根据类型对象进行修改
	 * @param type 类型对象
	 * @return 返回受影响的行数
	 */
	public int updateBookTypeByTnameSQL(BookType type);
}
