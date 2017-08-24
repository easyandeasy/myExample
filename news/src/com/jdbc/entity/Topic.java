package com.jdbc.entity;

/**
 * Topic 实体类
 * @author tang
 *
 */
public class Topic {

	private int tid;//主题编号
	private String tname;//主题名称
	
	/**
	 * 带参的构造方法
	 * @param tid 主题编号
	 * @param tname 主题名称
	 */
	public Topic(int tid, String tname) {
		this.tid = tid;
		this.tname = tname;
	}
	
	/**
	 * 无参构造方法
	 */
	public Topic() {}

	/**
	 * 读取主题编号
	 * @return
	 */
	public int getTid() {
		return tid;
	}
	
	/**
	 * 指定主题编号
	 * @param tid 主题编号
	 */
	public void setTid(int tid) {
		this.tid = tid;
	}
	
	/**
	 * 读取主题名称
	 * @return
	 */
	public String getTname() {
		return tname;
	}
	
	/**
	 * 指定主题名称
	 * @param tname 主题名称
	 */
	public void setTname(String tname) {
		this.tname = tname;
	}
}
