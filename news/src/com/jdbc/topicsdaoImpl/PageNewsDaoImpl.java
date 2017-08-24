package com.jdbc.topicsdaoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.baseDao.BaseDao;
import com.jdbc.entity.News;
import com.jdbc.entity.Topic;
import com.jdbc.util.PageUtil;
import com.jdbc.newsdao.IPageNewsDao;

/**
 * 分类数据访问实现类
 * @author tang
 *
 */
public class PageNewsDaoImpl extends BaseDao implements IPageNewsDao {
	
	/**
	 * 查询总记录数
	 * @return
	 */
	public int getTotalCount(int tid){
		int row = 0;
		String sql = "SELECT COUNT(nid) FROM tnews WHERE tid=?";
		Object[] obj = {tid};
		rs = executeQuerySQL(sql, obj);
		try {
			if(rs != null){
				while(rs.next()){
					row = rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return row;
		
	}
	
	
	/**
	 * 查询获得每页新闻集合
	 * @param pageNo 当前页号
	 * @param pageSize 每页显示记录数
	 * @return 返回新闻集合
	 */
	public List<News> getPageNewsList(int pageNo,int pageSize,int tid){
		List<News> list = new ArrayList();
		String sql = "SELECT nid,topic.tid,tname,ntitle,nauthor,ntime,ncontext FROM tnews inner join topic on tnews.tid=topic.tid where tnews.tid=? order by ntime desc limit ?,?";
		Object[] obj = {tid,(pageNo-1)*pageSize,pageSize};
		rs = executeQuerySQL(sql, obj);
		try {
			while(rs.next()){
				News n = new News();
				n.setNid(rs.getInt("nid"));
				n.setNtitle(rs.getString("ntitle"));
				n.setNauthor(rs.getString("nauthor"));
				n.setNtime(rs.getDate("ntime").toString());
				n.setNcontext(rs.getString("ncontext"));
				n.setTid(rs.getInt("tid"));
				n.setTname(rs.getString("tname"));
				list.add(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return list;
	}
	
	
	
	/**
	 * 查询获得每页新闻集合
	 * @param pageNo 当前页号
	 * @param rowCount 总数据行
	 * @return 返回新闻集合
	 */
	public List<News> selectPageNewsCountListSQL(PageUtil page,int tid){
		List<News> list = new ArrayList();
		
		String sql = "SELECT nid,topic.tid,tname,ntitle,nauthor,ntime,ncontext FROM tnews inner join topic on tnews.tid=topic.tid where tnews.tid=? order by ntime desc limit ?,?";
		Object[] obj = {tid,(page.getNow()-1)*page.getPageSize(),page.getPageSize()};
		rs = executeQuerySQL(sql, obj);
		try {	
			while(rs.next()){
				News n = new News();
				n.setNid(rs.getInt("nid"));
				n.setNtitle(rs.getString("ntitle"));
				n.setNauthor(rs.getString("nauthor"));
				n.setNtime(rs.getDate("ntime").toString());
				n.setNcontext(rs.getString("ncontext"));
				n.setTid(rs.getInt("tid"));
				n.setTname(rs.getString("tname"));
				list.add(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return list;
	}
	
	
	
	/**
	 * 查询主题总记录数
	 * @return 
	 */
	public int getTotalCountTopic(){
		int row = 0;
		String sql = "SELECT COUNT(tid) FROM topic";
		rs = executeQuerySQL(sql, null);
		try {
			if(rs != null){
				while(rs.next()){
					row = rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return row;
	}
	
	/**
	 * 查询获得每页新闻集合
	 * @param pageNo 当前页号
	 * @param rowCount 总数据行
	 * @return 返回新闻集合
	 */
	public List<Topic> getPageTopicCountListSQL(PageUtil page){
		List<Topic> list = new ArrayList();
		
		String sql = "SELECT tid,tname FROM topic limit ?,?";
		Object[] obj = {(page.getNow()-1)*page.getPageSize(),page.getPageSize()};
		rs = executeQuerySQL(sql, obj);
		try {
			while(rs.next()){
				Topic t = new Topic();
				t.setTid(rs.getInt("tid"));
				t.setTname(rs.getString("tname"));
				list.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeAllSQL();
		}
		return list;
	}
}
