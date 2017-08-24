package cn.bookweb.booktype.serviceimpl;

import java.util.List;

import cn.bookweb.basedao.BaseDao;
import cn.bookweb.booktype.dao.IBookTypeDao;
import cn.bookweb.booktype.daoimpl.BookTypeDaoImpl;
import cn.bookweb.booktype.entity.BookType;
import cn.bookweb.booktype.service.IBookTypeService;
import cn.bookweb.page.util.PageUtil;

/**
 * 图书业务逻辑层实现类
 * @author tang
 *
 */
public class BookTypeServiceImpl extends BaseDao implements IBookTypeService  {

	IBookTypeDao dao = new BookTypeDaoImpl();
	/**
	 * 查询图书类型所有信息
	 * @return 返回集合对象
	 */
	public List<BookType> queryBookTypeAllInfo(){
		return dao.selectBookTypeAllInfo();
	}
	
	/**
	 * 查询图书类型分页信息
	 * @return 返回集合对象
	 */
	public List<BookType> queryBookTypeAllPageInfo(PageUtil page){
		return dao.selectBookTypeAllPageInfo(page);
	}
	
	/**
	 * 根据pid图书信息
	 * @param pid 大类编号
	 * @return 返回集合对象
	 */
	public List<BookType> queryBookByPidSQL(int pid,PageUtil page){
		return dao.selectBookByPidSQL(pid, page);
	}
	
	
	/**
	 * 根据分类型名称查询图书类型信息条数
	 * @return 信息条数
	 */
	public int queryBookTypeByPidCount(String pid){
		return dao.selectBookTypeByPidCount(pid);
	}
	
	/**
	 * 根据类型名称分页查询图书类型信息条数
	 * @return 信息条数
	 */
	public int queryBookTypeCount(String tname){
		return dao.selectBookTypeCount(tname);
	}
	
	/**
	 * 根据类型名称分页查询图书类型信息
	 * @return 返回集合对象
	 */
	public List<BookType> queryBookTypeByTnameInfo(String tname,PageUtil page){
		return dao.selectBookTypeByTnameInfo(tname, page);
	}
	
	
	
	/**
	 * 添加一、二级类型
	 * @param type 类型对象
	 * @return 返回为true添加成功，为false添加失败
	 */
	public boolean addBookType(BookType type){
		boolean flag = false;
		if(dao.insertBookTypeSQL(type)>0){
			flag = true;
		}
		return flag;
	}
	
	
	/**
	 * 根据tid删除一、二级类型
	 * @param tid 类型编号
	 * @return 返回为true添加成功，为false添加失败
	 */
	public boolean removeBookType(String tid){
		boolean flag = false;
		if(dao.deleteBookTypeSQL(tid)>0){
			flag = true;
		}
		return flag;
	}
	
	
	/**
	 * 根据类型对象进行修改
	 * @param type 类型对象
	 * @return 返回受影响的行数
	 */
	public boolean replaceBookType(BookType type){
		boolean flag = false;
		if(dao.updateBookTypeSQL(type)>0){
			flag = true;
		}
		return flag;
	}
	
	/**
	 * 根据类型对象进行修改
	 * @param type 类型对象
	 * @return 返回受影响的行数
	 */
	public boolean replaceBookTypeByTname(BookType type){
		boolean flag = false;
		if(dao.updateBookTypeByTnameSQL(type)>0){
			flag = true;
		}
		return flag;
	}
}
