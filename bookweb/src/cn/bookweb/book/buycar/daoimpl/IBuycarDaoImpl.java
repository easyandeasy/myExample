package cn.bookweb.book.buycar.daoimpl;

import java.util.ArrayList;
import java.util.List;

import cn.bookweb.address.entity.Address;
import cn.bookweb.basedao.BaseDao;
import cn.bookweb.book.buycar.dao.BuycarDao;
import cn.bookweb.book.buycar.entity.Buycar;
import cn.bookweb.book.entity.Book;
import cn.bookweb.order.entity.Order;
import cn.bookweb.order.entity.OrderInfo;
import cn.bookweb.orders.entity.Orders;
import cn.bookweb.user.entity.User;

/**
 * 购物车数据访问实现类
 * @author Happy
 *
 */
public class IBuycarDaoImpl extends BaseDao implements BuycarDao{
	/**
	 * 用户加入购物车方法
	 * @param comm 生成随机字符串
	 * @param buycarCount 加入购物车的数量
	 * @param book 图书id
	 * @param user 用户id
	 * @return 返回插入结果
	 */
	public void InsertUserBookBuycar(String uuid,int buycarCount,Book book,User user){
		String sql="INSERT INTO cartitem(spid,numbertity,bid,uid) VALUE(?,?,?,?)";
		Object[] obj={uuid,buycarCount,book.getBid(),user.getUid()};
		executeUpdateSQL(sql, obj);
		closeAllSQL();
	}

	/**
	 * 查询对应用户的购物车条目
	 * @param user 用户
	 * @return 返回查询结果集
	 */
	public List<Buycar> selectUserBookBuycar(User user,List<Buycar> list){
		list = new ArrayList<Buycar>();
		String sql="SELECT b.bname,b.price,b.imagesmall,c.numbertity,c.bid,c.uid FROM cartitem c INNER JOIN book b ON b.bid=c.bid INNER JOIN USER u ON u.uid=c.uid WHERE u.uid=?";
		Object[] obj={user.getUid()};
		rs=executeQuerySQL(sql, obj);
		try{
			while(rs.next()){
				Buycar buycar = new Buycar();
				buycar.setBname(rs.getString("b.bname"));
				buycar.setImagesmall(rs.getString("b.imagesmall"));
				buycar.setPrice(rs.getDouble("b.price"));
				buycar.setNumbertity(rs.getString("c.numbertity"));
				buycar.setBid(rs.getInt("c.bid"));
				buycar.setUid(rs.getInt("c.uid"));
				list.add(buycar);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return list;
	}

	/**
	 * 根据用户查询用户购物车总数量
	 * @param user 用户
	 * @return 返回查询行数
	 */
	public int selectUserBookCountBuycar(int uid){
		String sql="SELECT COUNT(1) FROM cartitem c INNER JOIN USER u ON u.uid=c.uid WHERE u.uid=?";
		Object[] obj={uid};
		int row=0;
		rs=executeQuerySQL(sql,obj);
		try{
			while(rs.next()){
				row = rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return row;
	}

	/**
	 * 查询用户添加购物车是否有相同的书，如果有相同的书则数量加1
	 * @param user 用户
	 * @return 返回查询的图书id
	 */
	public int selectUseBookRowCountBuycar(int bid,int uid){
		String sql="SELECT bid FROM cartitem WHERE bid=? AND uid=?";
		Object[] obj={bid,uid};
		rs=executeQuerySQL(sql,obj);
		int row =0;
		try{
			while(rs.next()){
				row = rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return row;
	}

	/**
	 * 如果用户存在该书则增加书数量
	 * @param uid
	 * @param bid
	 */
	public int updateUserBookBuycar(int uuid,int bid,int uid){
		String sql="UPDATE cartitem SET numbertity=? WHERE bid=? AND uid=?";
		Object[] obj={uuid,bid,uid};
		int row=0;
		row=executeUpdateSQL(sql,obj);
		closeAllSQL();
		return row;
	}

	/**
	 * 查询当前用户当前加入购物车书的数量
	 * @return
	 */
	public int selectUserBookBuycarNumbertity(int bid,int uid){
		String sql="SELECT numbertity FROM cartitem c " +
				"INNER JOIN book b ON c.bid=b.bid " +
				"INNER JOIN USER u ON u.uid=c.uid WHERE b.bid=? AND u.uid=?";
		Object[] obj={bid,uid};
		rs=executeQuerySQL(sql, obj);
		int row = 0;
		try{
			while(rs.next()){
				row = rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return row;
	}

	/**
	 * 根据编号查询用户是否存在收获地址
	 * @param uid 用户id
	 * @return 返回查询结果集
	 */
	public List<Address> selectUserAddress(int uid){
		String sql="SELECT s.address FROM address s WHERE uid =?";
		Object[] obj={uid};
		List<Address> list= new ArrayList<Address>();
		rs=executeQuerySQL(sql, obj);
		try{
			while(rs.next()){
				Address address = new Address();
				address.setAddress(rs.getString("s.address"));
				list.add(address);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return list;
	}

	/**
	 * 提交订单 (插入订单表)
	 * @param onumber 订单号
	 * @param ordertime 下单时间
	 * @param total  金额
	 * @param ostatus 下单后的状态
	 * @param aid 用户收获地址
	 * @param uid 用户会员
	 * @return 返回查询结果
	 */
	public boolean insertUserSubmitOrderBook(Order order,String uuid,List<Buycar> list){
		int row = 0;
		int rows = 0;
		/**
		 * 1.生成订单
		 */
		String sql="INSERT INTO orders(onumber,ordertime,total,ostatus,aid,uid) VALUE(?,?,?,?,?,?)";
		Object[] obj={order.getOnumber(),order.getOrdertime(),order.getTotal(),order.getOstatus(),order.getAid(),order.getUid()};
		rows=executeUpdateSQL(sql,obj);
		closeAllSQL();

		/**
		 * 2.获取当生成订单的订单编号
		 */
		sql="SELECT onumber FROM orders WHERE onumber=?";
		Object[] objs={uuid};
		rs=executeQuerySQL(sql,objs);
		String onumber="";
		try{
			while(rs.next()){
				onumber=rs.getString("onumber");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}

		/**
		 * 3.获取到当前订单下的所有图书条目
		 */
		sql="INSERT INTO orderinfo(onumber,bid,bname,bprice,num,imagesmall) VALUE(?,?,?,?,?,?)";
		int len = list.size();
		if(len!=0){
			for(Buycar buycar:list){
				Object[] objst={onumber,buycar.getBid(),buycar.getBname(),buycar.getPrice(),buycar.getNumbertity(),buycar.getImagesmall()};
				row=executeUpdateSQL(sql,objst);
				closeAllSQL();
			}
		}
		closeAllSQL();
		return row!=0&&rows!=0;
	}

	/**
	 * 根据用户选择的地址获取该地址的id
	 * @param uid 用户id
	 * @param address 地址名
	 * @return 返回查询结果
	 */
	public int selectUserAidAddress(int uid,String address){
		String sql="SELECT a.aid FROM address a INNER JOIN USER u ON u.uid=a.uid WHERE u.uid=? AND a.address=?";
		Object[] obj={uid,address};
		rs=executeQuerySQL(sql, obj);
		int row = 0;
		try{
			while(rs.next()){
				row = rs.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return row;
	}
	
	/**
	 * 删除用户购物车信息
	 * @param uid
	 */
	public void deleteUserBuycarBook(int uid){
		String sql="DELETE FROM cartitem  WHERE uid=?";
		Object[] obj={uid};
		executeUpdateSQL(sql, obj);
		closeAllSQL();
	}
	
	/**
	 * 根据用户查询订单
	 * @param uid 用户id
	 * @return 返回查询结果
	 */
	public List<Order> selectUserOrderAllInfo(int uid){
		List<Order> orderList = new ArrayList<Order>();
		String sql="SELECT o.onumber,o.ordertime,o.ostatus,o.total FROM orders o INNER JOIN USER  u ON u.uid=o.uid WHERE u.uid=? ORDER BY ordertime DESC";
		Object[] obj={uid};
		rs=executeQuerySQL(sql,obj);
		try{
			while(rs.next()){
				Order order = new Order();
				order.setOnumber(rs.getString("o.onumber"));
				order.setOrdertime(rs.getString("o.ordertime"));
				order.setOstatus(rs.getInt("o.ostatus"));
				order.setTotal(rs.getDouble("o.total"));
				orderList.add(order);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return orderList;
	}
	
	/**
	 * 查询用户每个订单下所有的订单条目
	 * @param order
	 * @return
	 */
	public List<OrderInfo> selectUserMyOrdersumInfo(int uid){
		String sql="SELECT d.imagesmall,d.onumber FROM orderinfo d INNER JOIN orders  s ON s.onumber=d.onumber WHERE s.uid=?";
		List<OrderInfo> listOrderInfo = new ArrayList<OrderInfo>();
		Object[] obj = {uid};
		rs=executeQuerySQL(sql, obj);
		try{
			while(rs.next()){
				OrderInfo orderInfo = new OrderInfo();
				orderInfo.setImagesmall(rs.getString("d.imagesmall"));
				orderInfo.setOnumber(rs.getString("d.onumber"));
				listOrderInfo.add(orderInfo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		
		return listOrderInfo;
	}
	
	public List<OrderInfo> selectUserMyorderAll(int uid){
		//返回这个集合
		List<OrderInfo> myListOrderInfo = new ArrayList<OrderInfo>();
		
		/*
		 * 1.先获得当前用户所有订单
		 */
		String sql="SELECT o.onumber,o.ordertime,o.ostatus,o.total FROM orders o INNER JOIN USER  u ON u.uid=o.uid WHERE u.uid=? ORDER BY ordertime DESC";
		List<Order> orderList = new ArrayList<Order>();
		Object[] obj={uid};
		rs=executeQuerySQL(sql,obj);
		try{
			while(rs.next()){
				Order orders = new Order();
				orders.setOnumber(rs.getString("o.onumber"));
				orders.setOrdertime(rs.getString("o.ordertime"));
				orders.setOstatus(rs.getInt("o.ostatus"));
				orders.setTotal(rs.getDouble("o.total"));
				orderList.add(orders);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		
		/*
		 * 2.获取当前用户订单详细表所有订单
		 */
		sql="SELECT d.onumber FROM orderinfo d INNER JOIN orders  s ON s.onumber=d.onumber WHERE s.uid=?";
		List<OrderInfo> listOrderInfo = new ArrayList<OrderInfo>();
		Object[] obj1 = {uid};
		rs=executeQuerySQL(sql, obj1);
		try{
			while(rs.next()){
				OrderInfo orderInfo = new OrderInfo();
				orderInfo.setOnumber(rs.getString("d.onumber"));
				listOrderInfo.add(orderInfo);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		
		/*
		 * 3.获取当前用户订单的条目
		 * 循环输出当前用户所有订单
		 */
		for(int i=0;i<orderList.size();i++){
			Object[] obj2= new Object[orderList.size()];
			Order myorder = (Order)orderList.get(i);
			for(int j=0;j<listOrderInfo.size();i++){
				OrderInfo myOrderInfo =(OrderInfo)listOrderInfo.get(j);
				if(myorder.getOnumber().equals(myOrderInfo.getOnumber())){
					obj2[i]=myorder.getOnumber();
				}
			}
			sql="SELECT f.imagesmall FROM orders o INNER JOIN orderinfo f ON o.onumber=f.onumber WHERE o.onumber=?";
			rs=executeQuerySQL(sql, obj2);
			try{
				while(rs.next()){
					OrderInfo myOrderInfos = new OrderInfo();
					myOrderInfos.setImagesmall("f.imagesmall");
					myListOrderInfo.add(myOrderInfos);
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				closeAllSQL();
			}
		}
		return myListOrderInfo;
	}
	
	/**
	 * 删除当前用户的购物车
	 * @param uid 用户id
	 * @param bid 用户选择的图书id
	 * @return 返回执行结果
	 */
	public int deleteUserMyBuycar(int uid,int bid){
		int row = 0;
		String sql="DELETE FROM cartitem WHERE uid=? AND bid=?";
		Object[] obj={uid,bid};
		row = executeUpdateSQL(sql, obj);
		closeAllSQL();
		return row;
	}
	
	/**
	 * 查询订单详细
	 * @return
	 */
	public List<Orders> selectOrerInfoAllInfo(int uid,String onumber,int aid){
		List<Orders> list = new ArrayList<Orders>();
		String sql="SELECT r.onumber,r.ordertime,s.address,r.total,f.bname,f.imagesmall," +
				"f.bprice,f.num,(f.bprice*f.num) AS orderToral FROM " +
				"orders r INNER JOIN orderinfo f ON f.onumber=r.onumber " +
				"INNER JOIN address s ON s.uid=r.uid WHERE r.uid=? AND " +
				"r.onumber=? AND s.aid=?";
		Object[] obj={uid,onumber,aid};
		rs=executeQuerySQL(sql, obj);
		try{
			while(rs.next()){
				Orders order = new Orders();
				order.setOnumber(rs.getString("r.onumber"));
				order.setBname(rs.getString("f.bname"));
				order.setOrdertime(rs.getString("r.ordertime"));
				order.setImagesmall(rs.getString("f.imagesmall"));
				order.setAddress(rs.getString("s.address"));
				order.setBprice(rs.getFloat("f.bprice"));
				order.setNum(rs.getInt("f.num"));
				order.setTotal(rs.getDouble("r.total"));
				order.setPriceSum(rs.getDouble("orderToral"));
				list.add(order);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return list;
	}
	
	/**
	 * 更改订单状态
	 * @param ostatus 状态id
	 * @param onumber 订单号
	 */
	public void updateOrderInfo(int ostatus,String onumber,int uid){
		String sql="UPDATE orders SET ostatus = ? WHERE onumber=? and uid=?" ;
		Object[] obj={ostatus,onumber,uid};
		executeUpdateSQL(sql, obj);
		closeAllSQL();
	}
}
