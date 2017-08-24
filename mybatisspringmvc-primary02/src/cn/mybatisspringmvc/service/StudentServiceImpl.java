package cn.mybatisspringmvc.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import cn.mybatisspringmvc.beans.Student;
import cn.mybatisspringmvc.dao.IStudentDao;
import cn.mybatisspringmvc.utils.MybatisUtil;

public class StudentServiceImpl implements IStudentService {

	private SqlSession session = MybatisUtil.getSqlSession();// 鑾峰彇session瀵硅薄
	private IStudentDao dao = session.getMapper(IStudentDao.class);// 鑾峰彇鍔ㄦ�Student浠ｇ悊瀵硅薄锛堟暟鎹闂眰瀵硅薄锛�
/*
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
*/
	/**
	 * 鏌ヨ鎵�湁Student淇℃伅
	 */
	public List<Student> queryStudentInfo() {
		return dao.selectStudentInfo();
	}
	
	/**
	 * 娣诲姞瀛︾敓淇℃伅
	 */
	public boolean addStudentInfo(Student stu) {
		int count = dao.insertStudentInfo(stu);
		session.commit();
		return count > 0 ? true : false;
	}

	public boolean addUpdateInfo(Student stu) {
		int count = dao.updateStudentInfo(stu);
		session.commit();
		return count > 0 ? true : false;
	}

	public List<Student> queryStudentInfoPage(Map map) {
		return dao.selectStudentInfoPage(map);
	}

	public int queryStudentInfoCount() {
		return dao.selectStudentInfoCount();
	}

/*	
 	@Test
	public void test() {
		Student stu = new Student("灏忓崕",new Date(),"C002","澶╄矾");
		int count = dao.insertStudentInfo(stu);
		System.out.println(count);
		System.out.println(stu.getId());
		session.commit();
	}
*/
}
