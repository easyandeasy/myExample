package cn.bookweb.orders.entity;

import java.sql.Date;


/**
 * 图书实现类
 * @author tang
 *
 */
public class Orders {

	private int oid;//订单id
	private String onumber;//订单编号
	private String ordertime;//下单时间
	private double total;//合计金额
	private int ostatus;//订单状态  1 未付款，2 未发货，3未收货，4交易成功，5已取消
	private int aid;//收货地址 id
	private int uid;//用户id
	
	private int orderinfoid;//主键
	private String bid;//图书编号
	private String bname;//图书名称
	private float bprice;//图书价格
	private int num;//图书数量
	private String imagesmall;//小图片
	private String icontext;//备注
	
	private String address;//收货地址
	private double priceSum;//小计
	
	

	/**
	 * 获取订单 oid
	 * @return 返回订单 oid
	 */
	public int getOid() {
		return oid;
	}
	
	/**
	 * 指定订单id
	 * @param oid 订单id
	 */
	public void setOid(int oid) {
		this.oid = oid;
	}
	
	/**
	 * 获取订单编号
	 * @return 返回订单 编号
	 */
	public String getOnumber() {
		return onumber;
	}
	
	/**
	 * 指定订单编号
	 * @param onumber 订单编号
	 */
	public void setOnumber(String onumber) {
		this.onumber = onumber;
	}
	
	/**
	 * 获取订单 下单时间
	 * @return 返回订单 下单时间
	 */
	public String getOrdertime() {
		return ordertime;
	}
	
	/**
	 * 指定订单下单时间
	 * @param ordertime 下单时间
	 */
	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}
	
	/**
	 * 获取订单合计金额
	 * @return 返回订单 合计金额
	 */
	public double getTotal() {
		return total;
	}
	
	/**
	 * 指定订单合计金额
	 * @param total 合计金额
	 */
	public void setTotal(double total) {
		this.total = total;
	}
	
	/**
	 * 获取订单状态
	 * @return 返回订单 状态
	 */
	public int getOstatus() {
		return ostatus;
	}
	
	/**
	 * 指定订单状态
	 * @param ostatus 订单状态
	 */
	public void setOstatus(int ostatus) {
		this.ostatus = ostatus;
	}
	
	/**
	 * 获取订单 收货地址id
	 * @return 返回订单 收货地址id
	 */
	public int getAid() {
		return aid;
	}
	

	/**
	 * 指定订单收货地址id
	 * @param aid 收货地址id
	 */
	public void setAid(int aid) {
		this.aid = aid;
	}
	
	/**
	 * 获取订单 用户uid
	 * @return 返回订单 用户uid
	 */
	public int getUid() {
		return uid;
	}
	
	/**
	 * 指定订单用户id
	 * @param uid 用户id
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	

	
	public double getPriceSum() {
		return priceSum;
	}

	public void setPriceSum(double priceSum) {
		this.priceSum = priceSum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIcontext() {
		return icontext;
	}

	public void setIcontext(String icontext) {
		this.icontext = icontext;
	}

	public int getOrderinfoid() {
		return orderinfoid;
	}

	public void setOrderinfoid(int orderinfoid) {
		this.orderinfoid = orderinfoid;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public float getBprice() {
		return bprice;
	}

	public void setBprice(float bprice) {
		this.bprice = bprice;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getImagesmall() {
		return imagesmall;
	}

	public void setImagesmall(String imagesmall) {
		this.imagesmall = imagesmall;
	}

}
