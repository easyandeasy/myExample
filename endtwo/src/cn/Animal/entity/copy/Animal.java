package cn.Animal.entity.copy;

/**
 * 动物精确地、父类
 * @author tang
 *
 */
public abstract class Animal {

	private String name;//动物类型名
	private int age;//动物年龄
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public  void setAge(int age) {
		this.age = age;
	};
	
	/**
	 * 抽象方法
	 */
	public abstract void info();
	
}
