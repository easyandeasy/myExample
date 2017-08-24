package cn.mybatisspringmvc.service;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;

import cn.mybatisspringmvc.beans.Users;
import cn.mybatisspringmvc.dao.IUsersDao;
import cn.mybatisspringmvc.utils.MybatisUtil;

public class UsersServiceImpl implements IUsersService {

	private IUsersDao dao;//瀹氫箟鏁版嵁璁块棶灞傛帴鍙ｅ璞�
	private SqlSession session;//瀹氫箟session瀵硅薄

	@Before
	public void before() {
		session = MybatisUtil.getSqlSession();// 鑾峰彇session瀵硅薄
		dao = session.getMapper(IUsersDao.class);// 鑾峰彇鍔ㄦ�Users浠ｇ悊瀵硅薄锛堟暟鎹闂眰瀵硅薄锛�
	}

	@After
	public void after() {
		if(session != null) {//鍒ゆ柇sesion鏄惁鎵撳紑锛屼负true锛屽氨鍏抽棴session
			session.close();
		}
	}

	public boolean isLogin(Users user) {
		int uid = dao.isLogin(user);
		return uid > 0 ? true : false;
	}

}
