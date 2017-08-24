package cn.mybatis.dao;

import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.mybatis.beans.Users;

public class UserDaoImpl implements IUserDao {

	private SqlSession sqlSession;

	@Override
	public void inserUser(Users users) {
		try {
			//1.鍔犺浇涓婚厤缃枃浠�
			InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
			// 2.鍒涘缓sessionFactory瀵硅薄
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sessionFactory.openSession();
			//4.鐩稿叧鎿嶄綔
			sqlSession.insert("insertUsers", users);
			//鎻愪氦
			sqlSession.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {//鍏抽棴sqlSession鐨勫悓鏃跺氨鏄敤鍥炴粴
				sqlSession.close();
			}
		}
		
	}

}
