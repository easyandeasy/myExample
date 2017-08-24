package cn.math.random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Random {
	
	/**
	 * 程序入口（main 方法）
	 * @param args
	 */
	public static void main(String[] args){
		
		List list = new ArrayList();//存储随机数的集合
		
		//向集合中存储10个随机数
		for(int i = 0;i<10;i++){
			int random = (int)(Math.random()*200);//生成随机数
			if(!list.contains(random)){//判断是否包含相同的数
				list.add(random);//将随机数添加到集合中
			}
		}
		
		System.out.println("集合中的这些随机数:");
		show(list);
		

		System.out.println("\n乱序排序的结果:");
		Collections.shuffle(list);//调用乱序方法
		show(list);
		
		System.out.println("\n升序排序后的结果:");
		Collections.sort(list);//调用升序方法
		show(list);
		

		System.out.println("\n降序排序的结果:");
		Collections.reverse(list);//调用降序方法
		show(list);
	}
	
	/**
	 * 输出随机数方法
	 * @param list 随机数集合
	 */
	public static void show(List list){
		for (int i = 0;i<list.size();i++) {
			System.out.print(list.get(i) +"\t");
		}
	}
}
