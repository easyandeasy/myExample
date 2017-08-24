package cn.book.dao;

import java.util.List;

import cn.book.entity.Book;
import cn.book.entity.PageUtil;

/**
 * ���ݷ��ʲ�ӿ���
 * @author tang
 *
 */
public interface IBookDao {

	/**
	 * ��ѯͼ������
	 * @return ���ؼ�¼��
	 */
	public int queryBookCount();
	
	/**
	 * ��ѯ����ͼ����Ϣ
	 * @return ���ض��󼯺�
	 */
	public abstract List<Book> queryAllBook(PageUtil pages);

}