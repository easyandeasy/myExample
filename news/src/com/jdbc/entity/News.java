package com.jdbc.entity;

import java.sql.Date;

public class News extends Topic {

	private int nid;//新闻编号
	private String ntitle;//新闻标题
	private String nauthor;//新闻作者
	private String ntime;//新闻时间
	private String ncontext;//新闻内容
	private String str;//截取后的字符串
	
	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	/**
	 * 无参构造方法
	 */
	public News() {}
	
	/**
	 * 带参构造方法
	 * @param nid 新闻编号
	 * @param ntitle 新闻标题
	 * @param nauthor 新闻作者
	 * @param ntime 新闻时间
	 * @param ncontext 新闻内容
	 */
	public News(int nid, String ntitle, String nauthor, String ntime,
			String ncontext) {
		super();
		this.nid = nid;
		this.ntitle = ntitle;
		this.nauthor = nauthor;
		this.ntime = ntime;
		this.ncontext = ncontext;
	}
	
	/**
	 * 读取新闻编号
	 * @return
	 */
	public int getNid() {
		return nid;
	}
	

	/**
	 * 指定新闻编号
	 * @param nid 新闻编号
	 */
	public void setNid(int nid) {
		this.nid = nid;
	}
	
	/**
	 * 读取新闻标题
	 * @return
	 */
	public String getNtitle() {
		return ntitle;
	}
	
	/**
	 * 指定新闻标题
	 * @param ntitle 新闻标题
	 */
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	
	/**
	 * 读取新闻作者
	 * @return
	 */
	public String getNauthor() {
		return nauthor;
	}
	
	/**
	 * 指定新闻作者
	 * @param nauthor 新闻作者
	 */
	public void setNauthor(String nauthor) {
		this.nauthor = nauthor;
	}
	
	/**
	 * 读取新闻时间
	 * @return
	 */
	public String getNtime() {
		return ntime;
	}
	
	/**
	 * 指定新闻时间
	 * @param ntime 新闻时间
	 */
	public void setNtime(String ntime) {
		this.ntime = ntime;
	}
	
	/**
	 * 读取新闻内容
	 * @return
	 */
	public String getNcontext() {
		return ncontext;
	}
	
	/**
	 * 指定新闻内容
	 * @param ncontext 新闻内容
	 */
	public void setNcontext(String ncontext) {
		this.ncontext = ncontext;
	}
}
