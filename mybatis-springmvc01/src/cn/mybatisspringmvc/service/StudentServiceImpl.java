package cn.mybatisspringmvc.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;

import cn.mybatisspringmvc.beans.Student;
import cn.mybatisspringmvc.dao.IStudentDao;
import cn.mybatisspringmvc.utils.MybatisUtil;

public class StudentServiceImpl implements IStudentService {

	private IStudentDao dao;//瀹氫箟鏁版嵁璁块棶灞傛帴鍙ｅ璞�
	private SqlSession session;//瀹氫箟session瀵硅薄

	@Before
	public void before() {
		session = MybatisUtil.getSqlSession();// 鑾峰彇session瀵硅薄
		dao = session.getMapper(IStudentDao.class);// 鑾峰彇鍔ㄦ�Student浠ｇ悊瀵硅薄锛堟暟鎹闂眰瀵硅薄锛�
	}

	@After
	public void after() {
		if(session != null) {//鍒ゆ柇sesion鏄惁鎵撳紑锛屼负true锛屽氨鍏抽棴session
			session.close();
		}
	}

	/**
	 * 鏌ヨ鎵�湁Student淇℃伅
	 */
	public List<Student> queryStudentInfo() {
		List<Student> stu = dao.selectStudentInfo();
		return stu;
	}

}
