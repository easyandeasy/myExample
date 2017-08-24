package cn.Animal.entity.copy;

/**
 * 鸟类
 * @author tang
 *
 */
public class Bird extends Animal {
	
	private String color;
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * 有参构造方法
	 * @param name 动物名称
	 * @param color 动物颜色
	 * @param age 动物年龄
	 */
	public Bird(String name,String color,int age){
		super.setName(name);
		this.color = color;
		super.setAge(age);
	}

	/**
	 * 无参构造方法
	 */
	public Bird(){}

	/**
	 * 继承次类抽象方法
	 */
	public void info(){
		System.out.println("我是一只"+this.color+"的"+super.getName()+"!今年"+super.getAge()+"了。");
	}
}
