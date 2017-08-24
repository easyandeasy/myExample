package cn.printer.entity;

/**
 * 喷墨打印机类
 * @author tang
 *
 */
public class InkperPrinter extends Printer {

	/**
	 * 重写父类 print()方法
	 */
	public void print(){
		System.out.println("喷墨打印机........");
	}
}
