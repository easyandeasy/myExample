package com.jdbc.topicsdaoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.baseDao.BaseDao;
import com.jdbc.entity.News;
import com.jdbc.newsdao.INewsDao;

/**
 * 新闻内容：实现类
 * @author tang
 *
 */
public class NewsDaoImpl extends BaseDao implements INewsDao {

	/**
	 * 获取所有新闻信息
	 * @return
	 */
	public List<News> getAllnews(){
		List<News> list = new ArrayList();
		String sql = "SELECT nid,topic.tid,tname,ntitle,nauthor,ntime,ncontext FROM tnews inner join topic on tnews.tid=topic.tid";
		Object[] obj = {};
		rs = executeQuerySQL(sql, obj);
		try {
			while(rs.next()){
				News news = new News();
				news.setNid(rs.getInt("nid"));
				news.setNtitle(rs.getString("ntitle"));
				news.setNauthor(rs.getString("nauthor"));
				news.setNtime(rs.getDate("ntime").toString());
				news.setNcontext(rs.getString("ncontext"));
				news.setTid(rs.getInt("topic.tid"));
				news.setTname(rs.getString("tname"));
				list.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return list;
	}
	
	
	/**
	 * 获取主题下的所有的新闻
	 * @param tid
	 * @return
	 */
	public List<News> getAllnewsByTid(int tid){
		List<News> list = new ArrayList();
		String sql = "SELECT nid,tnews.tid,tname,ntitle,nauthor,ntime,ncontext FROM topic inner join tnews on tnews.tid=topic.tid where tnews.tid=?";
		Object[] obj = {tid};
		rs = executeQuerySQL(sql, obj);
		try {
			while(rs.next()){
				News news = new News();
				news.setNid(rs.getInt("nid"));
				news.setNtitle(rs.getString("ntitle"));
				news.setNauthor(rs.getString("nauthor"));
				news.setNtime(rs.getDate("ntime").toString());
				news.setNcontext(rs.getString("ncontext"));
				news.setTid(rs.getInt("tnews.tid"));
				news.setTname(rs.getString("tname"));
				list.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return list;
	}
	
	
	
	/**
	 * 获取主题下的所有的新闻
	 * @param tid
	 * @return
	 */
	public List<News> getAllnewsByNid(int tid){
		List<News> list = new ArrayList();
		String sql = "SELECT nid,tnews.tid,tname,ntitle,nauthor,ntime,ncontext FROM topic inner join tnews on tnews.tid=topic.tid where tnews.nid=?";
		Object[] obj = {tid};
		rs = executeQuerySQL(sql, obj);
		try {
			while(rs.next()){
				News news = new News();
				news.setNid(rs.getInt("nid"));
				news.setNtitle(rs.getString("ntitle"));
				news.setNauthor(rs.getString("nauthor"));
				news.setNtime(rs.getDate("ntime").toString());
				news.setNcontext(rs.getString("ncontext"));
				news.setTid(rs.getInt("tnews.tid"));
				news.setTname(rs.getString("tname"));
				list.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return list;
	}
}
