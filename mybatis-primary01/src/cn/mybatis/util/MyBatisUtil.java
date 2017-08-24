package cn.mybatis.util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * MyBatis工具类
 * @author tang
 *
 */
public class MyBatisUtil {

	private static String resource = "myBatisconfig.xml";
	private static InputStream is;
	private static SqlSession session;
	private static SqlSessionFactory sessionFactory;
	
	static {
		try {
			is = Resources.getResourceAsStream(resource);
			sessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		if(sessionFactory == null) {
			try {
				is = Resources.getResourceAsStream(resource);
				sessionFactory = new SqlSessionFactoryBuilder().build(is);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
	
	
	public static SqlSession getSession() {
		return getSqlSessionFactory().openSession();
	}
	
	
	public static void closeSession() {
		if(session != null) {
			session.close();
		}
	}
	
	public static void main(String[] args) {
		System.out.println(getSession());
	}
}
