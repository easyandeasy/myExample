package cn.Animal.entity;

/**
 * 测试类
 * @author tang
 *
 */
public class Test {

	/**
	 * 程序入口
	 * @param args
	 */
	public static void main(String[] args){
		Fish fish = new Fish("鱼","5斤重",5);//实例化鱼类
		fish.info();//调用父类方法
		Bird bird = new Bird("鸟","红色",4);//实例化鸟类
		bird.info();//调用父类方法
	}
}
