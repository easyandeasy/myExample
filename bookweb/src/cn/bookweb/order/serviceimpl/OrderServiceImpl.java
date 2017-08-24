package cn.bookweb.order.serviceimpl;

import java.util.List;

import cn.bookweb.basedao.BaseDao;
import cn.bookweb.order.dao.IOrderDao;
import cn.bookweb.order.daoimpl.OrderDaoImpl;
import cn.bookweb.order.service.IOrderService;
import cn.bookweb.orders.entity.Orders;
import cn.bookweb.page.util.PageUtil;

/**
 * 图书订单业务逻辑层实现类
 * @author tang
 *
 */
public class OrderServiceImpl extends BaseDao implements IOrderService  {

	IOrderDao dao = new OrderDaoImpl();
	/**
	 * 查询订单表 和 订单详情表的所有信息
	 * @return 返回订单的所有信息集合
	 */
	public List<Orders> queryOrderInfoSQL(int ostatus,PageUtil page){
		return dao.selectOrderInfoSQL(ostatus,page);
	}
	
	/**
	 * 查询订单表 和 订单详情表的所有信息
	 * @return 返回订单的所有信息集合
	 */
	public List<Orders> queryOrderInfoAllSQL(PageUtil page){
		return dao.selectOrderInfoAllSQL(page);
	}
	
	
	/**
	 * 查询订单表 和 订单详情表的所有信息条数
	 * @return 返回订单的所有信息条数
	 */
	public int queryOrderInfoCountSQL(int ostatus){
		return dao.selectOrderInfoCountSQL(ostatus);
	}
	
	
	/**
	 * 根据订单编号修改订单状态
	 * @return 返回受影响的行数
	 */
	public boolean replaceOrderInfostatusSQL(int statu ,String onumber){
		boolean flag = false;
		if(dao.updateOrderInfostatusSQL(statu,onumber)>0){
			flag = true;
		}
		return flag;
	}
	
	
	/**
	 * 根据订单编号进行模糊查询订单信息
	 * @return 返回订单的信息集合
	 */
	public List<Orders> queryOrderInfoByLikeSQL(String onumber,PageUtil page){
		return dao.selectOrderInfoByLikeSQL(onumber, page);
	}
	
	
	/**
	 * 根据订单编号查询有多少条数订单信息
	 * @return 订单信息条数
	 */
	public int queryOrderInfoByLikeCountSQL(String onumber){
		return dao.selectOrderInfoByLikeCountSQL(onumber);
	}
}
