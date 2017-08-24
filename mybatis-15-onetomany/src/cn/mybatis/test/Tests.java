package cn.mybatis.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import cn.mybatis.beans.Classs;
import cn.mybatis.beans.Student;
import cn.mybatis.service.IStudentService;
import cn.mybatis.service.StudentServiceImpl;

public class Tests {

	IStudentService service = new StudentServiceImpl();
	
	/**
	 * 查询学生所有信息
	 */
	@Test			
	public void test01() {
		List<Student> list = service.queryStudent();
		for (Student stu : list) {
			System.out.println(stu.getSname());
		}
	}
	
	/**
	 * 查询学生和班级所有信息
	 */
	@Test			
	public void test02() {
		List<Student> list = service.queryStudentClass();
		for (Student stu : list) {
			System.out.println(stu.getSname() + "\t" + stu.getCls().getCname());
		}
	}
	
	/**
	 * 使用 Map 查询学生和班级所有信息
	 */
	@Test			
	public void test03() {
		List<Map> list = service.queryStudentClassMap();
		for (Map stu : list) {
			System.out.println(stu);
			System.out.println(stu.get("SNAME"));//oracle中的字段是大写的,所以访问key的时候也是大写访问
		}
	}
	
	
	/**
	 * 使用一对多 查询学生和班级所有信息
	 */
	@Test			
	public void test04() {
		List<Classs> list = service.queryClassStudent();
		for (Classs c : list) {
			List<Student> stu = c.getStu();
			System.out.println(c.getCname());
			for (Student s : stu) {
				System.out.println("--------" + s.getSname());
			}
		}
	}
}
