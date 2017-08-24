package cn.bookweb.order.dao;

import java.util.List;

import cn.bookweb.orders.entity.Orders;
import cn.bookweb.page.util.PageUtil;
import cn.bookweb.user.entity.User;

/**
 * 订单数据访问层
 * @author tang
 *
 */
public interface IOrderDao {
	
	/**
	 * 查询订单表 和 订单详情表的指定类型信息
	 * @return 返回订单的所有信息集合
	 */
	public List<Orders> selectOrderInfoSQL(int ostatus,PageUtil page);
	

	
	/**
	 * 查询订单表 和 订单详情表的所有信息
	 * @return 返回订单的所有信息集合
	 */
	public List<Orders> selectOrderInfoAllSQL(PageUtil page);
	
	/**
	 * 查询订单表 和 订单详情表的所有信息条数
	 * @return 返回订单的所有信息条数
	 */
	public int selectOrderInfoCountSQL(int ostatus);
	
	/**
	 * 根据订单编号修改订单状态
	 * @return 返回受影响的行数
	 */
	public int updateOrderInfostatusSQL(int statu ,String onumber);
	
	
	/**
	 * 根据订单编号进行模糊查询订单信息
	 * @return 返回订单的信息集合
	 */
	public List<Orders> selectOrderInfoByLikeSQL(String onumber,PageUtil page);
	
	/**
	 * 根据订单编号查询有多少条数订单信息
	 * @return 订单信息条数
	 */
	public int selectOrderInfoByLikeCountSQL(String onumber);
}
