package cn.book.daoimpl;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import cn.book.basedao.BaseDao;
import cn.book.dao.IBookDao;
import cn.book.entity.Book;
import cn.book.entity.PageUtil;

/**
 * 图书数据访问层实现类
 * @author tang
 *
 */
public class BookDaoImpl extends BaseDao implements IBookDao {
	

	/**
	 * 查询图书总数
	 * @return 返回记录数
	 */
	public int queryBookCount(){
		int row = 0;
		String sql = "select count(*) from book";
		rs = executeQuerySQL(sql, null);
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
	 * 查询所有图书信息
	 * @return 返回对象集合
	 */
	@Override
	public List<Book> queryAllBook(PageUtil pages){
		List<Book> book = new ArrayList();
		DecimalFormat df  = new DecimalFormat("###.00");
		String sql = "select bid,bname,bprice,image,publishing,pdate,bauthor,isbn,district,discount,discountprice from book limit ?,?";
		Object[] obj = {(pages.getNow()-1)*pages.getPageSize(),pages.getPageSize()};
		rs = executeQuerySQL(sql, obj);
		try {
			while(rs.next()){
				Book b = new Book();
				float f = Float.parseFloat(df.format(rs.getFloat("bprice")));
				b.setBid(rs.getInt("bid"));
				b.setBname(rs.getString("bname"));
				b.setBprice(f);
				b.setBauthor(rs.getString("bauthor"));
				b.setImage(rs.getString("image"));
				b.setIsbn(rs.getString("isbn"));
				b.setPdate(rs.getDate("pdate"));
				b.setPublishing(rs.getString("publishing"));
				b.setDiscount(rs.getDouble("discount"));
				b.setDiscountprice(rs.getFloat("discountprice"));
				b.setDistrict(rs.getString("district"));
				book.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return book;
	}
}
