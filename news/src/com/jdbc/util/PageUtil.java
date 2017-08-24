package com.jdbc.util;

import java.util.ArrayList;
import java.util.List;

import com.jdbc.entity.News;

/**
 * ��ҳ������
 * @author tang
 *
 */
public class PageUtil {

	private int first = 1;//��ҳ
	private int back;//��һҳ
	private int next;//��һҳ
	private int last;//ĩҳ
	
	private int now;//��ǰҳ
	private int count;//��ҳ��
	
	private int pageSize = 5;//ÿҳ��ʾ����
	
	List list = new ArrayList();//ÿҳ���ݼ���
	
	
	/**
	 * ���췽��
	 * @param rowNow ��ǰҳ
	 * @param rowCount ��ҳ��
	 */
	public PageUtil(int rowNow,int rowCount){
		if(rowNow>1){//�жϵ�ǰҳ�Ƿ����1������1������һҳ����
			back = rowNow -1 ;
		}else{
			back = 1;
		}
		
		if(rowCount%pageSize==0){//���м�����ҳ��������������%ÿҳ��ʾ��������������������ȡ��������̣�����ȡ����+1
			count = rowCount/pageSize;
		}else{
			count = rowCount/pageSize+1;
		}
		
		if(rowNow<count){//�ж���һҳ�Ƿ�С����ҳ�������С����ҳ��������һҳ�����������ǵ�ǰҳ
			next = rowNow +1;
		}else{
			next = count;
		}
		
		now = rowNow;
		last = count;
	}


	/**
	 * ��ȡ��ҳ
	 * @return ������ҳ
	 */
	public int getFirst() {
		return first;
	}


	/**
	 * ָ����ҳ
	 * @param first ��ҳ
	 */
	public void setFirst(int first) {
		this.first = first;
	}


	/**
	 * ��ȡ��һҳ
	 * @return ������һ��
	 */
	public int getBack() {
		return back;
	}


	/**
	 * ָ����һҳ
	 * @param back ��һҳ
	 */
	public void setBack(int back) {
		this.back = back;
	}


	/**
	 * ��ȡ��һ��
	 * @return ������һ��
	 */
	public int getNext() {
		return next;
	}


	/**
	 * ָ����һҳ
	 * @param next
	 */
	public void setNext(int next) {
		this.next = next;
	}


	/**
	 * ָ��ĩҳ
	 * @return ����ĩҳ
	 */
	public int getLast() {
		return last;
	}


	/**
	 * ָ��ĩҳ
	 * @param last ĩҳ
	 */
	public void setLast(int last) {
		this.last = last;
	}


	/**
	 * ��ȡ��ǰҳ
	 * @return ���ص�ǰҳ
	 */
	public int getNow() {
		return now;
	}


	/**
	 * ָ����ǰҳ
	 * @param now ��ǰҳ
	 */
	public void setNow(int now) {
		this.now = now;
	}


	/**
	 * ��ȡ��ҳ��
	 * @return ����ҳ��
	 */
	public int getCount() {
		return count;
	}


	/**
	 * ָ����ҳ��
	 * @param count ��ҳ��
	 */
	public void setCount(int count) {
		this.count = count;
	}


	/**
	 * ��ȡÿҳ��ʾ������
	 * @return ����ÿҳ��ʾ������
	 */
	public int getPageSize() {
		return pageSize;
	}


	
	/**
	 * ָ��ÿҳ��ʾ������
	 * @param pageSize ÿҳ��ʾ������
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	/**
	 * ��ȡÿҳ���ݶ���
	 * @return ���϶���
	 */
	public List getList() {
		return list;
	}


	/**
	 * ָ��ÿҳ���ݼ���
	 * @param list ���϶���
	 */
	public void setList(List list) {
		this.list = list;
	}
}
