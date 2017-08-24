package cn.Animal.entity;


/**
 * 鱼类
 * @author tang
 *
 */
public class Fish extends Animal {
	
	
	private String type;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 无参构造方法
	 */
	public Fish(){}
	
	/**
	 * 有参构造方法
	 * @param name 动物名称
	 * @param color 动物颜色
	 * @param age 动物年龄
	 */
	public Fish(String name,String type,int age){
		super.setName(name);
		this.type = type;
		super.setAge(age);
	}
	

	
	
	/**
	 * 继承次类抽象方法
	 */
	public void info(){
		System.out.println("我是一只"+this.type+"的"+super.getName()+"!今年"+super.getAge()+"了。");
	}
}
