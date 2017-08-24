package cn.bookweb.booktype.entity;

import java.sql.Date;

/**
 * 图书实现类
 * @author tang
 *
 */
public class BookType {

	private int orderby;//主键
	private String tid;//图书类型id
	private String tname;//图书分类名称
	private String pid;//相对本表的tid进行分类
	private String tcontext;//备注
	
	/**
	 * 获取图书id
	 * @return 图书id
	 */
	public int getOrderby() {
		return orderby;
	}
	/**
	 * 指定图书id
	 * @param orderby 图书id
	 */
	public void setOrderby(int orderby) {
		this.orderby = orderby;
	}
	
	/**
	 * 获取图书编号
	 * @return 图书编号
	 */
	public String getTid() {
		return tid;
	}
	
	/**
	 * 指定图书编号
	 * @param tid 图书编号
	 */
	public void setTid(String tid) {
		this.tid = tid;
	}
	
	/**
	 * 获取图书分类名称
	 * @return
	 */
	public String getTname() {
		return tname;
	}
	
	/**
	 * 指定图书分类名称
	 * @param tname 图书分类名称
	 */
	public void setTname(String tname) {
		this.tname = tname;
	}
	
	/**
	 * 获取分类id
	 * @return 分类id
	 */
	public String getPid() {
		return pid;
	}
	
	/**
	 * 指定分类id
	 * @param pid 分类id
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}
	
	/**
	 * 获取备注
	 * @return 备注
	 */
	public String getTcontext() {
		return tcontext;
	}
	
	/**
	 * 指定备注
	 * @param tcontext 备注
	 */
	public void setTcontext(String tcontext) {
		this.tcontext = tcontext;
	}
	
	
	
}
