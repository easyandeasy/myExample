package cn.spring.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import cn.spring.service.IBuyStockService;

public class BuyStockTest {

	private IBuyStockService service;

	@Before
	public void before() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = (IBuyStockService) ac.getBean("buyStockService");
	}	
	
	@Test
	public void testOpen() {
		service.doFirst();
		System.out.println("=======================================");
		System.out.println(service.doSecond());
		System.out.println("=======================================");
		System.out.println(service.doThird());
		System.out.println("=======================================");
	}
	
}


