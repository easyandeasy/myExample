package cn.hibernate.entity;

/**
 * 成绩类
 * @author tang
 *
 */
public class Score {
	private int id;
	private int stuId;//学生编号
	private int subjectId;//科目编号
	private double result;//成绩
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
}
