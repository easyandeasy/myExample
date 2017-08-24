package cn.hibernate.entity;

import java.io.Serializable;

public class ScoreId implements Serializable{

	private int stuId;//学生编号
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
	private int subjectId;//科目编号
}
