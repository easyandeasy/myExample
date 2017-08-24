package cn.springmvc.beans;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Student {
	
	@NotNull(message="姓名不能为空")
	@Size(min=3,max=6,message="姓名长度应在{min}-{max}个字符")
	private String name;
	@Min(value=0,message="成绩不能大小于{value}")
	@Max(value=10,message="成绩不能大于{value}")
	private double score;
	@NotNull(message="电话不能为空")
	@Pattern(regexp="^1[34578]\\d{9}$",message="电话格式 不正确!")
	private String mobile;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + ", mobile=" + mobile + "]";
	}
}
