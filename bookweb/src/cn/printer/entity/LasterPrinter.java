package cn.printer.entity;

	/**
	 * 激光打印机类
	 * @author tang
	 *
	 */
	public class LasterPrinter extends Printer {
	
		/**
		 * 重写父类打印方法
		 */
		public void print(){
			System.out.println("激光打印..........");
		}
	}
