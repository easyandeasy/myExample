package cn.mybatisspringmvc.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {

	private static SqlSessionFactory sessionFactory;

	public static SqlSession getSqlSession() {
		try {
			//1.加载主配置文件
			InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
			if (sessionFactory == null) {
				sessionFactory = new SqlSessionFactoryBuilder()
						.build(inputStream);
			}
			return sessionFactory.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
//	public static void main(String[] args) {
//		System.out.println(getSqlSession());
//	}
}
