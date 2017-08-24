package cn.spring.service;

public class BuyStockServiceImpl implements IBuyStockService {

	public void doFirst() {
		System.out.println("执行doFirst()方法");
	}

	public String doSecond() {

		System.out.println("执行doSecond()方法");
		return "abcd";
	}

	public String doThird() {
		//System.out.println("执行doThird()方法" + 3/0);
		System.out.println("执行doThird()方法");
		return "zxcv";
	}
}
