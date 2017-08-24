package cn.Animal.entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Students {

	public static void main(String[] args){
		
		HashMap<String,String> map = new HashMap<String,String>();
		Scanner in = new Scanner(System.in);
		//循环输入5个学生姓名和学号
		for(int i = 0;i<5;i++){
			System.out.print("请输入第"+(i+1)+"个学生姓名：");
			String name = in.next();
			System.out.print("请输入第"+(i+1)+"个学生学号：");
			String id = in.next();
			map.put(id, name);
		}
		
		System.out.println("---------------"+map.size()+"人的信息如下------------------");
		System.out.println("学号\t姓名");
		
		Set keys = map.keySet();	//取出所有key的集合
		Iterator it = keys.iterator();//获取Iterator对象
		while(it.hasNext()){
			String key = (String)it.next();//取出key
			String names = (String)map.get(key);//根据key取出对应的值
			System.out.println(key+"\t"+names);
		}
			
	}
}
