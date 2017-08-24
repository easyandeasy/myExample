package cn.printer.entity;

/**
 * 测试类
 * @author tang
 *
 */
public class TestPrinter {

	/**
	 * main方法，程序入口
	 * @param args
	 */
	public static void main(String[] args){
		Printer print = new DotMatrixPrinter();//实例化针式打印机
		print.print();//调用父类print()方法
		Printer print2 = new InkperPrinter();//实例化喷墨打印机
		print2.print();//调用父类print()方法
		//添加的 激光打印机 
		Printer laster = new LasterPrinter();//实例化 激光打印机
		laster.print();//调用父类print()方法
		
		
		//System.out.println(laster instanceof LasterPrinter);
		//System.out.println(laster instanceof Printer);
		//System.out.println(laster instanceof Object);
		//System.out.println(laster instanceof System);

	}
}
