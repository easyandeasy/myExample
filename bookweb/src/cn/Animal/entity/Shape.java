package cn.Animal.entity;

/**
 * 形状类
 * @author tang
 *
 */
public abstract class Shape {

	/**
	 * 抽象方法
	 */
	public abstract void draw();
	
	
	public void draw(Shape sh){
		sh.draw();
	}
}
