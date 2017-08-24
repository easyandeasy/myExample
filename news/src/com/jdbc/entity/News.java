package com.jdbc.entity;

import java.sql.Date;

public class News extends Topic {

	private int nid;//���ű��
	private String ntitle;//���ű���
	private String nauthor;//��������
	private String ntime;//����ʱ��
	private String ncontext;//��������
	private String str;//��ȡ����ַ���
	
	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	/**
	 * �޲ι��췽��
	 */
	public News() {}
	
	/**
	 * ���ι��췽��
	 * @param nid ���ű��
	 * @param ntitle ���ű���
	 * @param nauthor ��������
	 * @param ntime ����ʱ��
	 * @param ncontext ��������
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
	 * ��ȡ���ű��
	 * @return
	 */
	public int getNid() {
		return nid;
	}
	

	/**
	 * ָ�����ű��
	 * @param nid ���ű��
	 */
	public void setNid(int nid) {
		this.nid = nid;
	}
	
	/**
	 * ��ȡ���ű���
	 * @return
	 */
	public String getNtitle() {
		return ntitle;
	}
	
	/**
	 * ָ�����ű���
	 * @param ntitle ���ű���
	 */
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	
	/**
	 * ��ȡ��������
	 * @return
	 */
	public String getNauthor() {
		return nauthor;
	}
	
	/**
	 * ָ����������
	 * @param nauthor ��������
	 */
	public void setNauthor(String nauthor) {
		this.nauthor = nauthor;
	}
	
	/**
	 * ��ȡ����ʱ��
	 * @return
	 */
	public String getNtime() {
		return ntime;
	}
	
	/**
	 * ָ������ʱ��
	 * @param ntime ����ʱ��
	 */
	public void setNtime(String ntime) {
		this.ntime = ntime;
	}
	
	/**
	 * ��ȡ��������
	 * @return
	 */
	public String getNcontext() {
		return ncontext;
	}
	
	/**
	 * ָ����������
	 * @param ncontext ��������
	 */
	public void setNcontext(String ncontext) {
		this.ncontext = ncontext;
	}
}
