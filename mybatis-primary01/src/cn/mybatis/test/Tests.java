package cn.mybatis.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import cn.mybatis.beans.Student;
import cn.mybatis.dao.IStudentDao;

public class Tests {

	IStudentDao dao = new StudentDaoImpl();
	
	//鏌ヨ
	@Test
	public void test01() {
		List<Student> stu = dao.selectStudentInfo();
		for (Student s : stu) {
			System.out.println(s.getId() + "\t" + s.getSname() + "\t" + s.getSbirth() + "\t" + s.getSclass() + "\t" + s.getSaddress());
		}
	}
	
	
	//娣诲姞
	@Test
	public void test02() {
		Student stu = new Student(8,"灏忔槑",new Date(),"C001","");
		boolean flag = dao.insertStudentInfo(stu);
		String str = "娣诲姞澶辫触锛";
		if(flag) {
			str = "娣诲姞鎴愬姛锛�";
			System.out.println(str);
		}
	}
	
	//鍒犻櫎
	@Test
	public void test03() {
		boolean flag = dao.deleteStudentInfo(8);
		String str = "鍒犻櫎澶辫触锛";
		if(flag) {
			str = "鍒犻櫎鎴愬姛锛";
			System.out.println(str);
		}
	}
	
	//淇敼
	@Test
	public void test04() {
		Student stu = new Student();
		stu.setId(1);
		stu.setSname("鏉ㄨ繃");
		boolean flag = dao.updateStudentInfo(stu);
		String str = "淇敼澶辫触锛";
		if(flag) {
			str = "淇敼鎴愬姛锛";
			System.out.println(str);
		}
	}
}
