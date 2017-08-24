package cn.book.service;

import java.util.List;

import cn.book.entity.Book;
import cn.book.entity.PageUtil;

public interface IBookService {
	
	/**
	 * ��ѯͼ������
	 * @return ���ؼ�¼��
	 */
	public int selectBookCount();
	

	/**
	 * ��ѯ����ͼ����Ϣ
	 * @return ���ض��󼯺�
	 */
	public abstract List<Book> selectAllBook(PageUtil pages);

}