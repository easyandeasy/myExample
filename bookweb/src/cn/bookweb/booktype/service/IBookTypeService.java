package cn.bookweb.booktype.service;

import java.util.List;

import cn.bookweb.booktype.entity.BookType;
import cn.bookweb.page.util.PageUtil;

/**
 * 图书类型业务逻辑层
 * @author tang
 *
 */
public interface IBookTypeService {

	/**
	 * 查询图书类型所有信息
	 * @return 返回集合对象
	 */
	public List<BookType> queryBookTypeAllInfo();
	
	/**
	 * 查询图书类型分页信息
	 * @return 返回集合对象
	 */
	public List<BookType> queryBookTypeAllPageInfo(PageUtil page);
	
	
	/**
	 * 根据类型名称分页查询图书类型信息条数
	 * @return 信息条数
	 */
	public int queryBookTypeCount(String tname);
	
	
	/**
	 * 根据pid图书信息
	 * @param pid 大类编号
	 * @return 返回集合对象
	 */
	public List<BookType> queryBookByPidSQL(int pid,PageUtil page);
	
	
	/**
	 * 根据分类型名称查询图书类型信息条数
	 * @return 信息条数
	 */
	public int queryBookTypeByPidCount(String pid);
	
	/**
	 * 根据类型名称分页查询图书类型信息
	 * @return 返回集合对象
	 */
	public List<BookType> queryBookTypeByTnameInfo(String tname,PageUtil page);
	
	/**
	 * 添加一、二级类型
	 * @param type 类型对象
	 * @return 返回为true添加成功，为false添加失败
	 */
	public boolean addBookType(BookType type);
	
	
	/**
	 * 根据tid删除一、二级类型
	 * @param tid 类型编号
	 * @return 返回为true添加成功，为false添加失败
	 */
	public boolean removeBookType(String tid);
	
	
	/**
	 * 根据类型对象进行修改
	 * @param type 类型对象
	 * @return 返回为true添加成功，为false添加失败
	 */
	public boolean replaceBookType(BookType type);
	
	
	/**
	 * 根据类型对象进行修改
	 * @param type 类型对象
	 * @return 返回受影响的行数
	 */
	public boolean replaceBookTypeByTname(BookType type);
}
