package cn.printer.entity;

/**
 * 针式打印机
 * @author tang
 *
 */
public class DotMatrixPrinter extends Printer {

	/**
	 * 重写父类 print()方法
	 */
	public void print(){
		System.out.println("针式打印机........");
	}
}
