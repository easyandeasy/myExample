package cn.spring.dao;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import cn.spring.beans.Student;
import cn.spring.rowmapper.StudentRowMapper;

/**
 * ��ݷ���ʵ�ֲ�:�̳�Jdbcģ���ࣺJdbcDaoSupport ��jdbcģ���Ƕ���ġ�
 * @author tang
 *
 */
public class StudentDaoImpl extends JdbcDaoSupport implements IStudentDao {

	public List<String> selectStudentByName() {
		String sql = "select name from student";
		return this.getJdbcTemplate().queryForList(sql ,String.class);
	}
	
	public String selectStudentNameById(int id) {
		
		String sql = "select name from student where id=?";
		return this.getJdbcTemplate().queryForObject(sql , String.class,id);
	}
	
	public Student selectStudentById(int id) {
		String sql = "select id,name,age from student where id=?";
		return this.getJdbcTemplate().queryForObject(sql, new StudentRowMapper(),id);
	}
	public List<Student> selectStudentAll() {
		String sql = "select id,name,age from student";
		return this.getJdbcTemplate().query(sql,new StudentRowMapper());
	}

	
	public void insertStudent(Student student) {
		
		String sql = "insert into student(name,age) values(?,?)";
		this.getJdbcTemplate().update(sql , student.getName(),student.getAge());
	}

	public void deleteStudent(Student student) {
		String sql = "delete from student where id=?";
		this.getJdbcTemplate().update(sql,student.getId());
	}

	public void updateeStudent(Student student) {
		String sql = "update student set name=?,age=? where id=?";
		this.getJdbcTemplate().update(sql,student.getName(),student.getAge(),student.getId());
	}

}
