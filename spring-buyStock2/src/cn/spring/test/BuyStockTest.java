package cn.spring.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.spring.exception.BuyStockException;
import cn.spring.service.IBuyStockService;

public class BuyStockTest {

	private IBuyStockService service;

	@Before
	public void before() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = (IBuyStockService) ac.getBean("serviceProxy");
	}	
	
	@Test
	public void testOpen() {
		service.openAccount("李四" ,10000);
		service.openStock("地地地地", 0);
	}
	@Test
	public void testBuyStock() throws BuyStockException{
		service.buyStock("李四", 2000, "地地地地", 5);
	}
}


