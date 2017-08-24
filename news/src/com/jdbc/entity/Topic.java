package com.jdbc.entity;

/**
 * Topic ʵ����
 * @author tang
 *
 */
public class Topic {

	private int tid;//������
	private String tname;//��������
	
	/**
	 * ���εĹ��췽��
	 * @param tid ������
	 * @param tname ��������
	 */
	public Topic(int tid, String tname) {
		this.tid = tid;
		this.tname = tname;
	}
	
	/**
	 * �޲ι��췽��
	 */
	public Topic() {}

	/**
	 * ��ȡ������
	 * @return
	 */
	public int getTid() {
		return tid;
	}
	
	/**
	 * ָ��������
	 * @param tid ������
	 */
	public void setTid(int tid) {
		this.tid = tid;
	}
	
	/**
	 * ��ȡ��������
	 * @return
	 */
	public String getTname() {
		return tname;
	}
	
	/**
	 * ָ����������
	 * @param tname ��������
	 */
	public void setTname(String tname) {
		this.tname = tname;
	}
}
