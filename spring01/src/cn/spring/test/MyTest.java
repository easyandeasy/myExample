package cn.spring.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import cn.spring.beans.HelloSpring;

public class MyTest {

	public static void main(String[] args) {
		//第一种实现方式 （常用方式，默认就是加载src下的配置文件）
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//第二种实现方式 （要指定配置文件在src目录下）
//		FileSystemXmlApplicationContext applicationContext = new FileSystemXmlApplicationContext("src/applicationContext.xml");
		HelloSpring hello = (HelloSpring) applicationContext.getBean("hello");
		hello.print();
	}
}
