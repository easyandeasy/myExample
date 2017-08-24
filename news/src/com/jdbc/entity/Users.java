package com.jdbc.entity;

/**
 * ����Աʵ����
 * @author tang
 *
 */
public class Users {

	private int aid;//���
	private String aname;//�û���
	private String apwd;//����
	private String acontext;//��ע
	private int astatus;//״̬
	
	/**
	 * ��ȡ���
	 * @return ���ر��
	 */
	public int getAid() {
		return aid;
	}
	
	/**
	 * ָ�����
	 * @param aid ����Ϊ���
	 */
	public void setAid(int aid) {
		this.aid = aid;
	}
	
	/**
	 * ��ȡ�û���
	 * @return �����û���
	 */
	public String getAname() {
		return aname;
	}
	
	/**
	 * ָ���û���
	 * @param aname ����Ϊ�û���
	 */
	public void setAname(String aname) {
		this.aname = aname;
	}
	
	/**
	 * ��ȡ����
	 * @return ��������
	 */
	public String getApwd() {
		return apwd;
	}
	
	/**
	 * ָ������
	 * @param apwd ��������
	 */
	public void setApwd(String apwd) {
		this.apwd = apwd;
	}
	
	/**
	 * ��ȡ��ע
	 * @return ���ر�ע
	 */
	public String getAcontext() {
		return acontext;
	}
	
	/**
	 * ָ����ע
	 * @param acontext ����Ϊ��ע
	 */
	public void setAcontext(String acontext) {
		this.acontext = acontext;
	}
	
	/**
	 * ��ȡ״̬
	 * @return ����״̬
	 */
	public int getAstatus() {
		return astatus;
	}
	
	/**
	 * ָ��״̬
	 * @param astatus 
	 */
	public void setAstatus(int astatus) {
		this.astatus = astatus;
	}
	
	/**
	 * �޲ι��췽��
	 */
	public Users() {}
	
	/**
	 * �вι��췽��
	 * @param aid
	 * @param aname
	 * @param apwd
	 * @param acontext
	 * @param astatus
	 */
	public Users(int aid, String aname, String apwd, String acontext,
			int astatus) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.apwd = apwd;
		this.acontext = acontext;
		this.astatus = astatus;
	}
	
	
}
