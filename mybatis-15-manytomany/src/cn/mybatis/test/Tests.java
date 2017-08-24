package cn.mybatis.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import cn.mybatis.beans.Sourse;
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
	 * 使用一对多 查询学生和成绩所有信息
	 */
	@Test			
	public void test04() {
		List<Student> list = service.queryStudentStuSourse();
		for (Student stu : list) {
			List<Sourse> sourses = stu.getSourses();

			for (Sourse sourse : sourses) {
				System.out.print("\t" + sourse.getSoursename()  + "\t");
			}
			if(sourses.size()>0) {
				System.out.println( stu.getId() + "\t" + stu.getSname() );
			}
		}
	}
	/**
	 * 使用 map 查询学生和成绩所有信息
	 */
	@Test			
	public void test05() {
		List<Map> map = service.queryStudentSourseMap();
		for (Map map2 : map) {
			System.out.println(map2);
		}
		
	}
	
	
	
	
	
	
	
	
}
