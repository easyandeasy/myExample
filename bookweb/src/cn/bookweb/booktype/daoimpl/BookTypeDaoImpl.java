package cn.bookweb.booktype.daoimpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bookweb.basedao.BaseDao;
import cn.bookweb.book.entity.Book;
import cn.bookweb.booktype.dao.IBookTypeDao;
import cn.bookweb.booktype.entity.BookType;
import cn.bookweb.page.util.PageUtil;

/**
 * 图书类型数据访问层的实现类
 * @author tang
 *
 */
public class BookTypeDaoImpl extends BaseDao implements IBookTypeDao {
	
	/**
	 * 查询图书类型所有信息
	 * @return 返回集合对象
	 */
	public List<BookType> selectBookTypeAllInfo(){
		List<BookType> list = new ArrayList<BookType>();
		String sql = "select * from booktype";
		rs = executeQuerySQL(sql, null);
		try {
			while(rs.next()){
				BookType book = new BookType();
				book.setOrderby(rs.getInt("orderby"));
				book.setPid(rs.getString("pid"));
				book.setTcontext(rs.getString("tcontext"));
				book.setTid(rs.getString("tid"));
				book.setTname(rs.getString("tname"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return list;
	}
	
	/**
	 * 查询图书类型分页信息
	 * @return 返回集合对象
	 */
	public List<BookType> selectBookTypeAllPageInfo(PageUtil page){
		List<BookType> list = new ArrayList<BookType>();
		String sql = "select * from booktype limit ?,?";
		Object[] obj = {(page.getNow()-1)*page.getPageSize(),page.getPageSize()};
		rs = executeQuerySQL(sql, obj);
		try {
			while(rs.next()){
				BookType book = new BookType();
				book.setOrderby(rs.getInt("orderby"));
				book.setPid(rs.getString("pid"));
				book.setTcontext(rs.getString("tcontext"));
				book.setTid(rs.getString("tid"));
				book.setTname(rs.getString("tname"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return list;
	}
	
	
	
	/**
	 * 根据pid图书信息
	 * @param pid 大类编号
	 * @return 返回集合对象
	 */
	public List<BookType> selectBookByPidSQL(int pid,PageUtil page){
		List<BookType> list = new ArrayList<BookType>();
		String sql = "select tid,tname,pid,tcontext,orderby from booktype where pid=?";// limit ?,?
		Object[] obj = {pid};//,(page.getNow()-1)*page.getPageSize(),page.getPageSize()
		rs = executeQuerySQL(sql, obj);
		try {
			while(rs.next()){
				BookType book = new BookType();
				book.setOrderby(rs.getInt("orderby"));
				book.setPid(rs.getString("pid"));
				book.setTcontext(rs.getString("tcontext"));
				book.setTid(rs.getString("tid"));
				book.setTname(rs.getString("tname"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return list;
	}
	
	
	/**
	 * 根据分类型名称查询图书类型信息条数
	 * @return 信息条数
	 */
	public int selectBookTypeByPidCount(String pid){
		int row = 0;
		String sql = "select count(*) from booktype where pid=?";
		Object[] obj = {pid};
		rs = executeQuerySQL(sql, obj);
		try {
			while(rs.next()){
				row = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return row;
	}
	
	/**
	 * 根据类型名称分页查询图书类型信息条数
	 * @return 信息条数
	 */
	public int selectBookTypeCount(String tname){
		int row = 0;
		String sql = "select count(*) from booktype where tname=?";
		Object[] obj = {tname};
		rs = executeQuerySQL(sql, obj);
		try {
			while(rs.next()){
				row = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return row;
	}
	
	
	/**
	 * 根据类型名称分页查询图书类型信息
	 * @return 返回集合对象
	 */
	public List<BookType> selectBookTypeByTnameInfo(String tname,PageUtil page){
		List<BookType> list = new ArrayList<BookType>();
		String sql = "select tid,tname,pid,tcontext,orderby from booktype where tname like concat('%',?,'%')"; //limit ?,?
		Object[] obj = {tname};//,(page.getNow()-1)*page.getPageSize(),page.getPageSize()
		rs = executeQuerySQL(sql, obj);
		try {
			while(rs.next()){
				BookType book = new BookType();
				book.setOrderby(rs.getInt("orderby"));
				book.setPid(rs.getString("pid"));
				book.setTcontext(rs.getString("tcontext"));
				book.setTid(rs.getString("tid"));
				book.setTname(rs.getString("tname"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return list;
	}
	
	
	/**
	 * 添加一、二级类型
	 * @param type 类型对象
	 * @return 返回受影响的行数
	 */
	public int insertBookTypeSQL(BookType type){
		int row = 0;
		String sql = "insert into booktype(tid,tname,pid,tcontext) values (?,?,?,?)";
		Object[] obj = {type.getTid(),type.getTname(),type.getPid(),type.getTcontext()};
		row = executeUpdateSQL(sql, obj);
		closeAllSQL();
		return row;
	}
	
	
	/**
	 * 根据tid删除一、二级类型
	 * @param tid 类型编号
	 * @return 返回受影响的行数
	 */
	public int deleteBookTypeSQL(String tid){
		int row = 0;
		String sql = "delete from booktype where tid=?";
		Object[] obj = {tid};
		row = executeUpdateSQL(sql, obj);
		closeAllSQL();
		return row;
	}
	
	
	/**
	 * 根据类型对象进行修改
	 * @param type 类型对象
	 * @return 返回受影响的行数
	 */
	public int updateBookTypeSQL(BookType type){
		int row = 0;
		String sql = "update booktype set tname=?,pid=?,tcontext=? where tid=?";
		Object[] obj = {type.getTname(),type.getPid(),type.getTcontext(),type.getTid()};
		row = executeUpdateSQL(sql, obj);
		closeAllSQL();
		return row;
	}
	
	
	/**
	 * 根据类型对象进行修改
	 * @param type 类型对象
	 * @return 返回受影响的行数
	 */
	public int updateBookTypeByTnameSQL(BookType type){
		int row = 0;
		String sql = "update booktype set tid=? where tname=?";
		Object[] obj = {type.getTid(),type.getTname()};
		row = executeUpdateSQL(sql, obj);
		closeAllSQL();
		return row;
	}
}
