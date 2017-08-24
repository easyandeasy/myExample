package com.test;

import java.lang.reflect.Field;



public class Test {
	
	public int a ;
	private String s;
	
	/**
	 * 无参构造方法
	 */
	public Test(){
		System.out.println("无参");
	}
	
	/**
	 * 带一个参数构造方法
	 * @param str
	 */
	public Test(String str){
		System.out.println("有参"+str);
	}
	
	/**
	 * 带两个参数构造方法
	 * @param i
	 * @param str
	 */
	public Test(int i ,String str){
		System.out.println(i+"\t"+str);
	}
	
	private Test(String i ,String str){
		System.out.println(i+"\t"+str);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//实例化无参的构造方法对象
		/*try {
			Class cls = Class.forName("com.test.Test");
			//方法一
			//Test test = (Test)cls.newInstance();
			//方法二
			Test test = (Test)cls.getConstructor(new Class[]{}).newInstance(new Object[]{});
			test.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		//实例化有参的构造方法对象
		/*try {
			Class cls = Class.forName("com.test.Test");
			//一个参数
			//Test test = (Test)cls.getConstructor(String.class).newInstance("abc");
			
			//两个参数
			Test test = (Test)cls.getConstructor(int.class,String.class).newInstance(123,"abc");
			test.show();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		
		// 访问信息的常用方法操作
		try {
			Class cls = Class.forName("com.test.Test");
			Test t = (Test)cls.newInstance();
			/*//获取所有 public 构造方法
			Constructor[] constr = cls.getConstructors();
			//获取所有  构造方法
			//Constructor[] constr = cls.getDeclaredConstructors();
			for (Constructor c : constr) {
				System.out.println(c);
			}*/
			
			/*//获取当前所有 public 方法 包括父类的方法
			//Method[] method = cls.getMethods();
			//获取当前类所有 方法
			Method[] method = cls.getDeclaredMethods();
			for (Method method2 : method) {
				System.out.println(method2);
			}*/
			
			
			/*//获取所有 public 属性
			//Field[] field = cls.getFields();
			//获取所有 属性
			Field[] field = cls.getDeclaredFields();
			for (Field field2 : field) {
				System.out.println(field2);
			}*/
			
			/*//操纵 无参，没有返回值的方法 
			Method method = cls.getMethod("show");
			method.invoke(cls.newInstance());
			
			//操纵有参，有返回值的方法
			Method method1 = cls.getMethod("show", String.class);
			String s = (String)method1.invoke(cls.newInstance(), "hello");
			System.out.println(s);*/
			
			
			//属性操作
			Field field = cls.getField("a");
			field.set(t,5);
			System.out.println(field.get(t));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public void show(){
		System.out.println("show");
	}
	
	public String show(String s){
		System.out.println("show\t" + s);
		return s;
	}
	
	private void run(){
		System.out.println("私有方法");
	}

}
