package cn.bookweb.order.entity;

import cn.bookweb.book.entity.Book;

/**
 * 订单详细表
 * @author Happy
 *
 */
public class OrderInfo {
	
	private int orderinfoid;//订单详细序号
	private String onumber;//订单详细编号
	private Book book;//所关联的Book
	private Order order;//所属的订单
	private int num;//图书数量
	private String icontext;//图书详细描述
	private String imagesmall;//小图路径
	
	public String getImagesmall() {
		return imagesmall;
	}
	public void setImagesmall(String imagesmall) {
		this.imagesmall = imagesmall;
	}
	public int getOrderinfoid() {
		return orderinfoid;
	}
	public void setOrderinfoid(int orderinfoid) {
		this.orderinfoid = orderinfoid;
	}
	public String getOnumber() {
		return onumber;
	}
	public void setOnumber(String onumber) {
		this.onumber = onumber;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getIcontext() {
		return icontext;
	}
	public void setIcontext(String icontext) {
		this.icontext = icontext;
	}
	
}
