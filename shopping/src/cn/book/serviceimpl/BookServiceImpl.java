package cn.book.serviceimpl;

import java.util.List;

import cn.book.dao.IBookDao;
import cn.book.daoimpl.BookDaoImpl;
import cn.book.entity.Book;
import cn.book.entity.PageUtil;
import cn.book.service.IBookService;

/**
 * ͼ��ҵ���߼���
 * @author tang
 *
 */
public class BookServiceImpl implements IBookService {

	IBookDao dao = new BookDaoImpl();
	
	/**
	 * ��ѯͼ������
	 * @return ���ؼ�¼��
	 */
	public int selectBookCount(){
		return dao.queryBookCount();
	}
	
	/**
	 * ��ѯ����ͼ����Ϣ
	 * @return ���ض��󼯺�
	 */
	@Override
	public  List<Book> selectAllBook(PageUtil pages){
		
		return dao.queryAllBook(pages);
	}
}
