package cn.mybatisspringmvc.dao;

import java.util.List;
import java.util.Map;

import cn.mybatisspringmvc.beans.Student;

public interface IStudentDao {
	
	
	/**
	 * 查询学生信息
	 * @return
	 */
	public List<Student> selectStudentInfo();

	/**
	 * 添加学生信息
	 * @param stu
	 * @return
	 */
	public int insertStudentInfo(Student stu);

	/**
	 * 删除学生信息
	 * @param i
	 * @return
	 */
	public boolean deleteStudentInfo(int i);
	
	/**
	 * 修改学生信息
	 * @param stu
	 * @return
	 */
	int updateStudentInfo(Student stu);

	/**
	 * 分页查询学生信息
	 * @return
	 */
	public List<Student> selectStudentInfoPage(Map map);

	
	/**
	 * 查询学生总人数
	 * @return
	 */
	public int selectStudentInfoCount();

}
