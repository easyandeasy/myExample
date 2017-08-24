package cn.bookweb.book.daoimpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bookweb.basedao.BaseDao;
import cn.bookweb.book.dao.IBookDao;
import cn.bookweb.book.entity.Book;
import cn.bookweb.page.util.PageUtil;

/**
 * 管理员数据访问层的实现类
 * @author tang
 *
 */
public class BookDaoImpl extends BaseDao implements IBookDao {
	
	/**
	 * 查询图书所有信息
	 * @return 返回集合对象
	 */
	public List<Book> selectBookAllInfo(){
		List<Book> list = new ArrayList<Book>();
		String sql = "select bid,bname,author,price,currPrice,discount,press,publishtime,edition,pageNum,wordNum,printtime,booksize,paper,tid,imagebig,imagesmall,stock,hlframe,bigtid from book";	
		return queryBookInfo(sql, null, list);
	}
	


	/**
	 * 根据id查询图书
	 * @return 返回集合对象
	 */
	public List<Book> selectBookByTidSQL(String tid,PageUtil pages){
		List<Book> list = new ArrayList<Book>();
		String sql = "select bid,bname,author,price,currPrice,discount,press,publishtime,edition,pageNum,wordNum,printtime,booksize,paper,tid,imagebig,imagesmall,stock,hlframe,bigtid from book where tid=? limit ?,?";
		Object[] obj = {tid,(pages.getNow()-1)*pages.getPageSize(),pages.getPageSize()};
		return queryBookInfo(sql, obj, list);
	}
	
	
	/**
	 * 根据bid查询 单本图书信息
	 * @return 返回集合对象
	 */
	public List<Book> selectBookByBidSQL(int bid){
		List<Book> list = new ArrayList<Book>();
		String sql = "select bid,bname,author,price,currPrice,discount,press,publishtime,edition,pageNum,wordNum,printtime,booksize,paper,tid,imagebig,imagesmall,stock,hlframe,bigtid from book where bid=?";
		Object[] obj = {bid};
		return queryBookInfo(sql, obj, list);
	}
	
	
	/**
	 * 查询图书总记录数
	 * @return 查询的记录数
	 * @param tid 所属类型的 编号
	 */
	public int selectBookCountSQL(String tid){
		int row = 0;
		String sql = "select count(*) from book where tid=?";
		Object[] obj = {tid};
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
	 * 添加图书
	 * @param book 图书对象
	 * @return
	 */
	public int insertBookInfo(Book book){
		int row = 0;
		String sql = "insert into book(bname,author,price,currPrice,discount,press,publishtime,edition,pageNum,wordNum,printtime,booksize,paper,tid,imagebig,imagesmall,stock) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] obj = {book.getBname(),book.getAuthor(),book.getPrice(),book.getCurrprice(),book.getDiscount(),book.getPress(),book.getPublishtime(),book.getEdition(),book.getPagenum(),book.getWordnum(),book.getPrinttime(),book.getBooksize(),book.getPaper(),book.getTid(),book.getImagebig(),book.getImagesmall(),book.getStock()};
		row = executeUpdateSQL(sql, obj);
		closeAllSQL();
		return row;
	}
	
	
	
	/**
	 * 模糊查询图书
	 * @param bname 图书名称
	 * @return 集合对象
	 */
	public List<Book> selectBookInfoLike(String bname){
		List<Book> list = new ArrayList<Book>();
		String sql = "select bid,bname,author,price,currPrice,discount,press,publishtime,edition,pageNum,wordNum,printtime,booksize,paper,tid,imagebig,imagesmall,stock,hlframe,bigtid from book where bname like concat('%',?,'%')";
		Object[] obj = {bname};
		
		return queryBookInfo(sql, obj, list);
	}
	
	
	
	/**
	 * 根据id分页查询图书
	 * @return 返回集合对象
	 */
	public List<Book> selectBookInfoPage(String bname,PageUtil pages){
		List<Book> list = new ArrayList<Book>();
		String sql = "select bid,bname,author,price,currPrice,discount,press,publishtime,edition,pageNum,wordNum,printtime,booksize,paper,tid,imagebig,imagesmall,stock,hlframe,bigtid from book where bname like concat('%',?,'%') limit ?,?";
		Object[] obj = {bname,(pages.getNow()-1)*pages.getPageSize(),pages.getPageSize()};
		return queryBookInfo(sql, obj, list);
	}
	
	
	
	/**
	 * 查询图书名称总记录数
	 * @return 查询的记录数
	 * @param tid 所属类型的 编号
	 */
	public int selectBookCountByBnameSQL(String bname){
		int row = 0;
		String sql = "select count(*) from book where bname like concat('%',?,'%')";
		Object[] obj = {bname};
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
	 * 查询精品图书信息，查询今日促销图书
	 * @return
	 */
	public List<Book> selectBooksend(Book book){
		List<Book> list = new ArrayList<Book>();
		String sql = "select bid,bname,author,price,currPrice,discount,press,publishtime," +
				"edition,pageNum,wordNum,printtime,booksize,paper,tid,imagebig,imagesmall,stock,hlframe,bigtid from book limit 0,60";
		return queryBookInfo(sql, null, list);
	}
	
	
	/**
	 * 根据bid 删除图书信息
	 * @param bid 图书id
	 * @return 返回受影响的行数
	 */
	public int deleteBookInfoSQL(int bid){
		int row = 0;
		String sql = "delete from book where bid=?";
		Object[] obj = {bid};
		row = executeUpdateSQL(sql, obj);	
		closeAllSQL();
		return row;
	}
	
	/**
	 * 根据bid修改图书信息
	 * @param bid 图书id
	 * @return 返回受影响的行数
	 */
	public int updateBookInfoSQL(Book book){
		int row = 0;
		String sql = "update book set bname=?,author=?,price=?,currPrice=?,discount=?,press=?,publishtime=?,edition=?,pageNum=?,wordNum=?,printtime=?,booksize=?,paper=?,tid=?,imagebig=?,imagesmall=?,stock=?,bigtid=? where bid=?";
		Object[] obj = {book.getBname(),book.getAuthor(),book.getPrice(),book.getCurrprice(),book.getDiscount(),book.getPress(),book.getPublishtime(),book.getEdition(),book.getPagenum(),book.getWordnum(),book.getPrinttime(),book.getBooksize(),book.getPaper(),book.getTid(),book.getImagebig(),book.getImagesmall(),book.getStock(),book.getBigtid(),book.getBid()};
		row = executeUpdateSQL(sql, obj);	
		closeAllSQL();
		return row;
	}
	
	/**
	 * 根据bid修改上下架
	 * @param bid 图书id
	 * @return 返回受影响的行数
	 */
	public int updateBookHlframeSQL(int hlframe,int bid){
		int row = 0;
		String sql = "update book set hlframe=? where bid=?";
		Object[] obj = {hlframe,bid};
		row = executeUpdateSQL(sql, obj);	
		closeAllSQL();
		return row;
	}
	
	/**
	 * 根据分页查询所有图书信息
	 * @param pages
	 * @return
	 */
	public List<Book> selectAllOrderBook(PageUtil pages,String bigtid){
		List<Book> list = new ArrayList<Book>();
		String sql = "select bid,bname,author,price,currPrice,discount,press,publishtime,edition,pageNum,wordNum,printtime,booksize,paper,tid,imagebig,imagesmall,stock,hlframe,bigtid from book where bigtid=? limit ?,?";
		Object[] obj = {bigtid,(pages.getNext()-1)*pages.getPageSize(),pages.getPageSize()};
		list = queryBookInfo(sql,obj,list);
		return list;
	}
	
	/**
	 * 根据图书id查询图书详情信息
	 * @return 返回一个集合
	 */
	public List<Book> selectBookDacktionInfo(Book book){
		String sql="select bid,bname,author,price,currPrice,discount,press,publishtime," +
				"edition,pageNum,wordNum,printtime,booksize,paper,tid,imagebig,imagesmall,stock,hlframe,bigtid from book where bid=?";
		Object[] obj={book.getBid()};
		List<Book> list = new ArrayList<Book>();
		list=queryBookInfo(sql,obj,list);
		return list;
	}
	
	/**
	 * 查询图书信息
	 * @param sql sql语句
	 * @param obj 参数数组
	 * @param list 存储图书信息集合 
	 * @return 返回图书集合
	 */
	public List<Book> queryBookInfo(String sql,Object[] obj ,List<Book> list){
		
		rs = executeQuerySQL(sql, obj);
		try {
			while(rs.next()){
				Book b = new Book();
				b.setBid(rs.getInt("bid"));
				b.setBname(rs.getString("bname"));
				b.setAuthor(rs.getString("author"));
				b.setPrice(rs.getDouble("price"));
				b.setCurrprice(rs.getDouble("currprice"));
				b.setDiscount(rs.getDouble("discount"));
				b.setPress(rs.getString("press"));
				b.setPublishtime(rs.getString("publishtime"));
				b.setEdition(rs.getInt("edition"));
				b.setPagenum(rs.getInt("pagenum"));
				b.setWordnum(rs.getInt("wordnum"));
				b.setPrinttime(rs.getString("printtime"));
				b.setBooksize(rs.getInt("booksize"));
				b.setPaper(rs.getString("paper"));
				b.setTid(rs.getString("tid"));
				b.setImagebig(rs.getString("imagebig"));
				b.setImagesmall(rs.getString("imagesmall"));
				b.setStock(rs.getInt("stock"));
				b.setHlframe(rs.getInt("hlframe"));
				b.setBigtid(rs.getString("bigtid"));
				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		
		return list;
	}
}
