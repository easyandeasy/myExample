package cn.mybatis.beans;

/**
 * 用户实体类
 * @author tang
 *
 */
public class Users {

	private Integer id;
	private String name;
	private int age;
	private double score;
	
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Users() {
	}
	public Users(String name, int age, double score) {
		this.name = name;
		this.age = age;
		this.score = score;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age
				+ ", score=" + score + "]";
	}
}
