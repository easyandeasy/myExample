package cn.bookweb.order.daoimpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bookweb.basedao.BaseDao;
import cn.bookweb.order.dao.IOrderDao;
import cn.bookweb.orders.entity.Orders;
import cn.bookweb.page.util.PageUtil;

/**
 * 订单数据访问层的实现类
 * @author tang
 *
 */
public class OrderDaoImpl extends BaseDao implements IOrderDao {
	
	/**
	 * 查询订单表 和 订单详情表的所有信息
	 * @return 返回订单的所有信息集合
	 */
	public List<Orders> selectOrderInfoSQL(int ostatus,PageUtil page){
		List<Orders> list = new ArrayList<Orders>();
		String sql = "select * from orderinfo as i left join orders as o on o.onumber=i.onumber where o.ostatus=? limit ?,?";
		Object[] obj = {ostatus,(page.getNow()-1)*page.getPageSize(),page.getPageSize()};
		rs = executeQuerySQL(sql, obj);
		try {
			while(rs.next()){
				Orders orders = new Orders();
				orders.setOrderinfoid(rs.getInt("orderinfoid"));
				orders.setOnumber(rs.getString("onumber"));
				orders.setBid(rs.getString("bid"));
				orders.setBname(rs.getString("bname"));
				orders.setBprice(rs.getFloat("bprice"));
				orders.setNum(rs.getInt("num"));
				orders.setImagesmall(rs.getString("imagesmall"));
				orders.setIcontext(rs.getString("icontext"));//,ordertime,total,ostatus,aid,uid
				
				orders.setOrdertime(rs.getString("ordertime"));
				orders.setTotal(rs.getDouble("total"));
				orders.setOstatus(rs.getInt("ostatus"));
				orders.setAid(rs.getInt("aid"));
				orders.setUid(rs.getInt("uid"));
				orders.setOid(rs.getInt("oid"));
				list.add(orders);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return list;
	}
	
	/**
	 * 查询订单表 和 订单详情表的所有信息
	 * @return 返回订单的所有信息集合
	 */
	public List<Orders> selectOrderInfoAllSQL(PageUtil page){
		List<Orders> list = new ArrayList<Orders>();
		String sql = "select * from orderinfo as i left join orders as o on o.onumber=i.onumber limit ?,?";
		Object[] obj = {(page.getNow()-1)*page.getPageSize(),page.getPageSize()};
		rs = executeQuerySQL(sql, obj);
		try {
			while(rs.next()){
				Orders orders = new Orders();
				orders.setOrderinfoid(rs.getInt("orderinfoid"));
				orders.setOnumber(rs.getString("onumber"));
				orders.setBid(rs.getString("bid"));
				orders.setBname(rs.getString("bname"));
				orders.setBprice(rs.getFloat("bprice"));
				orders.setNum(rs.getInt("num"));
				orders.setImagesmall(rs.getString("imagesmall"));
				orders.setIcontext(rs.getString("icontext"));//,ordertime,total,ostatus,aid,uid
				
				orders.setOrdertime(rs.getString("ordertime"));
				orders.setTotal(rs.getDouble("total"));
				orders.setOstatus(rs.getInt("ostatus"));
				orders.setAid(rs.getInt("aid"));
				orders.setUid(rs.getInt("uid"));
				orders.setOid(rs.getInt("oid"));
				list.add(orders);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return list;
	}
	
	/**
	 * 查询订单表 和 订单详情表的所有信息条数
	 * @return 返回订单的所有信息条数
	 */
	public int selectOrderInfoCountSQL(int ostatus){
		int row = 0;
		String sqls = " where o.ostatus=?";
		if(ostatus==0){
			sqls = "";
		}
		String sql = "select count(*) from orderinfo as i left join orders as o on o.onumber=i.onumber"+sqls;
		Object[] obj = {ostatus};
		if(ostatus==0){
			obj = null;
		}
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
	 * 根据订单编号修改订单状态
	 * @return 返回受影响的行数
	 */
	public int updateOrderInfostatusSQL(int statu ,String onumber){
		int row = 0;
		String sql = "update orders set ostatus=? where onumber=?";
		Object[] obj = {statu,onumber};
		row = executeUpdateSQL(sql, obj);
		closeAllSQL();
		return row;
	}
	
	
	/**
	 * 根据订单编号进行模糊查询订单信息
	 * @return 返回订单的信息集合
	 */
	public List<Orders> selectOrderInfoByLikeSQL(String onumber,PageUtil page){
		List<Orders> list = new ArrayList<Orders>();
		String sql = "select * from orderinfo as i left join orders as o on o.onumber=i.onumber where o.onumber like concat('%',?,'%') limit ?,?";
		Object[] obj = {onumber,(page.getNow()-1)*page.getPageSize(),page.getPageSize()};
		rs = executeQuerySQL(sql, obj);
		try {
			while(rs.next()){
				Orders orders = new Orders();
				orders.setOrderinfoid(rs.getInt("orderinfoid"));
				orders.setOnumber(rs.getString("onumber"));
				orders.setBid(rs.getString("bid"));
				orders.setBname(rs.getString("bname"));
				orders.setBprice(rs.getFloat("bprice"));
				orders.setNum(rs.getInt("num"));
				orders.setImagesmall(rs.getString("imagesmall"));
				orders.setIcontext(rs.getString("icontext"));//,ordertime,total,ostatus,aid,uid
				
				orders.setOrdertime(rs.getString("ordertime"));
				orders.setTotal(rs.getDouble("total"));
				orders.setOstatus(rs.getInt("ostatus"));
				orders.setAid(rs.getInt("aid"));
				orders.setUid(rs.getInt("uid"));
				orders.setOid(rs.getInt("oid"));
				list.add(orders);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return list;
	}
	
	
	
	/**
	 * 根据订单编号查询有多少条数订单信息
	 * @return 订单信息条数
	 */
	public int selectOrderInfoByLikeCountSQL(String onumber){
		int row = 0;
		String sql = "select count(*) from orderinfo as i left join orders as o on o.onumber=i.onumber where o.onumber like concat('%',?,'%')";
		Object[] obj = {onumber};
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
}
