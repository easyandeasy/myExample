package cn.bookweb.book.buycar.service;

import java.util.List;

import cn.bookweb.order.entity.*;
import cn.bookweb.orders.entity.Orders;

import cn.bookweb.address.entity.Address;
import cn.bookweb.book.buycar.entity.Buycar;
import cn.bookweb.book.entity.Book;
import cn.bookweb.user.entity.User;

/**
 * 用户购物车业务逻辑层接口
 * @author Happy
 *
 */
public interface BuycarService {
	/**
	 * 用户加入购物车方法
	 * @param comm 生成随机字符串
	 * @param buycarCount 加入购物车的数量
	 * @param book 图书id
	 * @param user 用户id
	 * @return 返回插入结果
	 */
	public void addUserBookBuycar(String uuid,int buycarCount,Book book,User user);
	
	/**
	 * 查询对应用户的购物车条目
	 * @param user 用户
	 * @return 返回查询结果集
	 */
	public List<Buycar> queryUserBookBuycar(User user,List<Buycar> list);
	
	/**
	 * 根据用户查询用户购物车总数量
	 * @param user 用户
	 * @return 返回查询行数
	 */
	public int queryUserBookCountBuycar(int uid);
	
	/**
	 * 查询用户添加购物车是否有相同的书，如果有相同的书则数量加1
	 * @param user 用户
	 * @return 受影响的行数
	 */
	public int queryUseBookRowCountBuycar(int bid,int uid);
	
	/**
	 * 如果用户存在该书则增加书数量
	 * @param uid
	 * @param bid
	 */
	public int replaceUserBookBuycar(int uuid,int bid,int uid);
	
	/**
	 * 查询当前用户当前加入购物车书的数量
	 * @param uid 用户id
	 * @param bid 图书id
	 * @return 返回查询结果
	 */
	public int queryUserBookBuycarNumbertity(int bid,int uid);
	
	/**
	 * 根据编号查询用户是否存在收获地址
	 * @param uid 用户id
	 * @return 返回查询结果集
	 */
	public List<Address> queryUserAddress(int uid);
	
	/**
	 * 提交订单 插入数据库
	 * @param onumber 订单号
	 * @param ordertime 下单时间
	 * @param total  金额
	 * @param ostatus 下单后的状态
	 * @param aid 用户收获地址
	 * @param uid 用户会员
	 * @return 返回查询结果
	 */
	public boolean addUserSubmitOrderBook(Order order,String uuid,List<Buycar> list);
	
	/**
	 * 根据用户选择的地址获取该地址的id
	 * @param uid 用户id
	 * @param address 地址名
	 * @return 返回查询结果
	 */
	public int queryUserAidAddress(int uid,String address);
	
	/**
	 * 删除用户购物车信息
	 * @param uid
	 */
	public void removeUserBuycarBook(int uid);
	
	/**
	 * 根据用户查询订单
	 * @param uid 用户id
	 * @return 返回查询结果
	 */
	public List<Order> queryUserOrderAllInfo(int uid);
	
	/**
	 * 查询用户每个订单下所有的订单条目
	 * @param order
	 * @return
	 */
	public List<OrderInfo> queryUserMyOrdersumInfo(int uid);
	
	/**
	 * 删除当前用户的购物车
	 * @param uid 用户id
	 * @param bid 用户选择的图书id
	 * @return 返回执行结果
	 */
	public int removeMyBuycar(int uid,int bid);
	
	/**
	 * 查询当前用户订单列表
	 * @param uid
	 * @return
	 */
	public List<Order> queryOrderAndImageSamll(int uid);
	
	/**
	 * 查询订单详细
	 * @return
	 */
	public List<Orders> queryOrerInfoAllInfo(int uid,String onumber,int aid);
	
	/**
	 * 更改订单状态
	 * @param ostatus 状态id
	 * @param onumber 订单号
	 */
	public void replaceOrderInfo(int ostatus,String onumber,int uid);
}
