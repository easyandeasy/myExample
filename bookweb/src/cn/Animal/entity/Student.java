package cn.Animal.entity;

/**
 * 学员类
 * @author tang
 *
 */
public class Student {

	private String name;//姓名
	private int age;//年龄
	//无参构造方法
	public Student(){}
	//带参构造方法
	public Student(String name,int age){
		if(age<16){//判断年龄是否小于16
			System.out.println("年龄不符合要求！");
		}else{
			this.age=age;
			this.name=name;
			show();
		}
	}
	
	/**
	 * 自我介绍方法
	 */
	public void show(){
		System.out.println("我的名字是："+this.name+",我"+age+"岁。");
	}
	
	/**
	 * 程序入口main方法
	 * @param args
	 */
	public static void main(String[] args){
		Student stu = new Student("小明",1);
	}
}
