package cn.Animal.entity.copy;

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
		Fish fish = new Fish("鸟","红色",4);
		fish.info();
		Bird bird = new Bird("鱼","5斤重",5);
		bird.info();
	}
}
