package cn.bookweb.order.service;

import java.util.List;

import cn.bookweb.orders.entity.Orders;
import cn.bookweb.page.util.PageUtil;

/**
 * 订单业务逻辑层
 * @author tang
 *
 */
public interface IOrderService {

	/**
	 * 查询订单表 和 订单详情表的所有信息
	 * @return 返回订单的所有信息集合
	 */
	public List<Orders> queryOrderInfoSQL(int ostatus,PageUtil page);
	
	/**
	 * 查询订单表 和 订单详情表的所有信息
	 * @return 返回订单的所有信息集合
	 */
	public List<Orders> queryOrderInfoAllSQL(PageUtil page);
	
	/**
	 * 查询订单表 和 订单详情表的所有信息条数
	 * @return 返回订单的所有信息条数
	 */
	public int queryOrderInfoCountSQL(int ostatus);
	
	/**
	 * 根据订单编号修改订单状态
	 * @return 返回受影响的行数
	 */
	public boolean replaceOrderInfostatusSQL(int statu ,String onumber);
	
	
	/**
	 * 根据订单编号进行模糊查询订单信息
	 * @return 返回订单的信息集合
	 */
	public List<Orders> queryOrderInfoByLikeSQL(String onumber,PageUtil page);
	
	/**
	 * 根据订单编号查询有多少条数订单信息
	 * @return 订单信息条数
	 */
	public int queryOrderInfoByLikeCountSQL(String onumber);
}
